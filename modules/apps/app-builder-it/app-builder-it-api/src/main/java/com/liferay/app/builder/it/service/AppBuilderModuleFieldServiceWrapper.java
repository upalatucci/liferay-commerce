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

package com.liferay.app.builder.it.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppBuilderModuleFieldService}.
 *
 * @author Marco Leo
 * @see AppBuilderModuleFieldService
 * @generated
 */
public class AppBuilderModuleFieldServiceWrapper
	implements AppBuilderModuleFieldService,
			   ServiceWrapper<AppBuilderModuleFieldService> {

	public AppBuilderModuleFieldServiceWrapper(
		AppBuilderModuleFieldService appBuilderModuleFieldService) {

		_appBuilderModuleFieldService = appBuilderModuleFieldService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appBuilderModuleFieldService.getOSGiServiceIdentifier();
	}

	@Override
	public AppBuilderModuleFieldService getWrappedService() {
		return _appBuilderModuleFieldService;
	}

	@Override
	public void setWrappedService(
		AppBuilderModuleFieldService appBuilderModuleFieldService) {

		_appBuilderModuleFieldService = appBuilderModuleFieldService;
	}

	private AppBuilderModuleFieldService _appBuilderModuleFieldService;

}