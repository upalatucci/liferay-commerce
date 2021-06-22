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

package com.liferay.commerce.internal.object;

import com.liferay.commerce.model.CommerceOrderTable;
import com.liferay.object.deployer.SystemObjectDefinitionDeployer;
import com.liferay.object.model.ObjectField;
import com.liferay.object.service.ObjectFieldLocalService;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marco Leo
 */
@Component(
	immediate = true,
	service = CommerceOrderSystemObjectDefinitionDeployer.class
)
public class CommerceOrderSystemObjectDefinitionDeployer implements
	SystemObjectDefinitionDeployer {

	public String getName(){
		return CommerceOrderTable.INSTANCE.getTableName();
	}

	public List<ObjectField> getObjectFields() {
		return Arrays.asList(
			_createObjectField(
				CommerceOrderTable.INSTANCE.orderStatus.getName(), "Integer" ),
			_createObjectField(
				CommerceOrderTable.INSTANCE.shippingAmount.getName(), "BigDecimal" )
		);
	}

	public double getVersion() {
		return 0;
	}

	private ObjectField _createObjectField(String name, String type) {

		ObjectField objectField = _objectFieldLocalService.createObjectField(0);

		objectField.setIndexed(false);
		objectField.setIndexedAsKeyword(false);
		objectField.setName(name);
		objectField.setType(type);

		return objectField;
	}

	private ObjectFieldLocalService _objectFieldLocalService;

}