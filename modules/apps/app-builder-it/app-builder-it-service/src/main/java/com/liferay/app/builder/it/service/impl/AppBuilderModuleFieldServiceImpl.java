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

import com.liferay.app.builder.it.service.base.AppBuilderModuleFieldServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the app builder module field remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.app.builder.it.service.AppBuilderModuleFieldService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModuleFieldServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=appbuilderit",
		"json.web.service.context.path=AppBuilderModuleField"
	},
	service = AopService.class
)
public class AppBuilderModuleFieldServiceImpl
	extends AppBuilderModuleFieldServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.app.builder.it.service.AppBuilderModuleFieldServiceUtil</code> to access the app builder module field remote service.
	 */

}