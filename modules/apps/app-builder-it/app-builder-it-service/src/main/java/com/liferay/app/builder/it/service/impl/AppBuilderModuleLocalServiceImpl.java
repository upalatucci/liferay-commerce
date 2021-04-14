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

package com.liferay.app.builder.it.service.impl;

import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.service.base.AppBuilderModuleLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marco Leo
 */
@Component(
	property = "model.class.name=com.liferay.app.builder.it.model.AppBuilderModule",
	service = AopService.class
)
public class AppBuilderModuleLocalServiceImpl
	extends AppBuilderModuleLocalServiceBaseImpl {

	@Override
	public AppBuilderModule addAppBuilderModule(
			long userId, String name, String label, boolean active,
			boolean asset, boolean resource)
		throws PortalException {


		User user = userLocalService.getUser(userId);

		long appBuilderModuleId = counterLocalService.increment();

		AppBuilderModule appBuilderModule = appBuilderModulePersistence.create(
			appBuilderModuleId);

		appBuilderModule.setCompanyId(user.getCompanyId());
		appBuilderModule.setUserId(user.getUserId());
		appBuilderModule.setUserName(user.getFullName());
		appBuilderModule.setActive(active);
		appBuilderModule.setName(name);
		appBuilderModule.setLabel(label);
		appBuilderModule.setAsset(asset);
		appBuilderModule.setResource(resource);

		String dbTableName = FriendlyURLNormalizerUtil.normalize(name);

		//TODO find a more robust way to create a valid table name
		dbTableName = dbTableName.replaceAll("-", "_");

		appBuilderModule.setDbTableName(
			"custom_" + user.getCompanyId() + dbTableName);

		//TODO Maybe we can improve the name convention
		appBuilderModule.setDbTablePKColumnName("id");
		appBuilderModule.setResourceName(
			"custom_" + user.getCompanyId() + "_" + dbTableName);

		return appBuilderModulePersistence.update(appBuilderModule);
	}

	public List<AppBuilderModule> getAppBuilderModules() {
		return appBuilderModulePersistence.findAll();
	}

}