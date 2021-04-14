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
import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.app.builder.it.service.base.AppBuilderModuleFieldLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author Marco Leo
 */
@Component(
	property = "model.class.name=com.liferay.app.builder.it.model.AppBuilderModuleField",
	service = AopService.class
)
public class AppBuilderModuleFieldLocalServiceImpl
	extends AppBuilderModuleFieldLocalServiceBaseImpl {

	@Override
	public AppBuilderModuleField addAppBuilderModuleField(
		long userId, String name, String label, String type,
		String typeSettings, boolean nullable)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long appBuilderModuleFieldId = counterLocalService.increment();

		AppBuilderModuleField appBuilderModuleField = appBuilderModuleFieldPersistence.create(
			appBuilderModuleFieldId);

		appBuilderModuleField.setCompanyId(user.getCompanyId());
		appBuilderModuleField.setUserId(user.getUserId());
		appBuilderModuleField.setUserName(user.getFullName());

		appBuilderModuleField.setName(name);
		appBuilderModuleField.setLabel(label);


		//TODO find a more robust way to create a valid table name
		String dbColumnName = FriendlyURLNormalizerUtil.normalize(name);
		dbColumnName = dbColumnName.replaceAll("-", "_");

		appBuilderModuleField.setDbColumnName("_" + dbColumnName);

		//TODO validate type is a valid and supported type
		appBuilderModuleField.setType(type);
		appBuilderModuleField.setTypeSettings(typeSettings);
		appBuilderModuleField.setNullable(nullable);

		return appBuilderModuleFieldPersistence.update(appBuilderModuleField);
	}

	@Override
	public List<AppBuilderModuleField> getAppBuilderModuleFields(
		long appBuilderModuleId, int start, int end) {

		return appBuilderModuleFieldPersistence.findByAppBuilderModuleId(
			appBuilderModuleId, start, end);
	}

}