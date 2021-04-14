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

package com.liferay.app.builder.it.internal.model.listner;

import com.liferay.app.builder.it.dao.AppBuilderModuleDAOServiceRegistry;
import com.liferay.app.builder.it.internal.db.AppBuilderModuleDBHelper;
import com.liferay.app.builder.it.internal.resource.ResourceActionsHelperImpl;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.workflow.AppBuilderModuleEntryWorkflowHandlerServiceRegistry;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(immediate = true, service = ModelListener.class)
public class AppBuilderModuleModelListener
	extends BaseModelListener<AppBuilderModule> {


	//TODO SUPER IMPORTANT Move this registration logic to a message bus, ensure that 2 things:
	//1: DB table creation needs to run just once in the cluster, or add a "IF Exist Logic"
	//2 Service Registration needs to run in all nodes of the cluster


	@Override
	public void onAfterCreate(AppBuilderModule appBuilderModule)
		throws ModelListenerException {
		//TODO put under same transaction the create table, so if something fails, the table is not created

		try {
			_appBuilderModuleDBHelper.createTable(appBuilderModule);
			_appBuilderModuleDAOServiceRegistry.registerAppBuilderModuleDAO(
				appBuilderModule);
			_appBuilderModuleEntryWorkflowHandlerServiceRegistry.
				registerAppBuilderModuleEntryWorkflowHandler(appBuilderModule);

			if (appBuilderModule.isResource()) {
				_resourceActionsHelper.importResourceAction(appBuilderModule);
			}
		}
		catch (Exception e) {
			e.printStackTrace();


			//TODO Think if I want to drop tables or not
			/*_appBuilderModuleDBHelper.dropTable(
				appBuilderModule.getDbTableName());*/


			_appBuilderModuleDAOServiceRegistry.unregisterAppBuilderModuleDAO(
				appBuilderModule);
			_appBuilderModuleEntryWorkflowHandlerServiceRegistry.
				unregisterAppBuilderModuleEntryWorkflowHandler(
					appBuilderModule);

			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onBeforeRemove(AppBuilderModule appBuilderModule) {
		_appBuilderModuleDAOServiceRegistry.unregisterAppBuilderModuleDAO(
			appBuilderModule);

		//TODO I think we should not delete tables

		try {
			_appBuilderModuleDBHelper.dropTable(
				appBuilderModule.getDbTableName());
			_appBuilderModuleEntryWorkflowHandlerServiceRegistry.
				unregisterAppBuilderModuleEntryWorkflowHandler(
					appBuilderModule);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Reference
	private AppBuilderModuleDAOServiceRegistry
		_appBuilderModuleDAOServiceRegistry;

	@Reference
	private AppBuilderModuleDBHelper _appBuilderModuleDBHelper;

	@Reference
	private AppBuilderModuleEntryWorkflowHandlerServiceRegistry
		_appBuilderModuleEntryWorkflowHandlerServiceRegistry;

	@Reference
	private ResourceActionsHelperImpl _resourceActionsHelper;

}