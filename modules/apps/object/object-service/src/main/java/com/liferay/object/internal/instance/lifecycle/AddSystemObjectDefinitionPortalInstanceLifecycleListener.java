/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.object.internal.instance.lifecycle;

import com.liferay.object.deployer.SystemObjectDefinitionDeployer;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Marco Leo
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class AddSystemObjectDefinitionPortalInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) {
		for (SystemObjectDefinitionDeployer systemObjectDefinitionDeployer :
				_systemObjectDefinitionDeployers) {

			try {
				ObjectDefinition objectDefinition =
					_objectDefinitionLocalService.fetchObjectDefinitionByC_N_V(
						company.getCompanyId(),
						systemObjectDefinitionDeployer.getName(),
						systemObjectDefinitionDeployer.getVersion());

				if (objectDefinition == null) {
					_objectDefinitionLocalService.addObjectDefinition(
						0, systemObjectDefinitionDeployer.getName(),
						systemObjectDefinitionDeployer.getObjectFields(), true);
				}
				else {
					_objectDefinitionLocalService.updateObjectDefinition(
						0, objectDefinition.getObjectDefinitionId(),
						systemObjectDefinitionDeployer.getObjectFields(),
						systemObjectDefinitionDeployer.getVersion());
				}
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	protected void addSystemObjectDefinitionDeployer(
			SystemObjectDefinitionDeployer systemObjectDefinitionDeployer)
		throws Exception {

		_systemObjectDefinitionDeployers.add(systemObjectDefinitionDeployer);
	}

	protected void removeSystemObjectDefinitionDeployer(
		SystemObjectDefinitionDeployer systemObjectDefinitionDeployer) {

		_systemObjectDefinitionDeployers.remove(systemObjectDefinitionDeployer);
	}

	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;

	private final List<SystemObjectDefinitionDeployer>
		_systemObjectDefinitionDeployers = new CopyOnWriteArrayList<>();

}