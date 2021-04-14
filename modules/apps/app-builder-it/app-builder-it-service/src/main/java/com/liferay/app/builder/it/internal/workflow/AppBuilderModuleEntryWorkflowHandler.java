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

package com.liferay.app.builder.it.internal.workflow;

import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.app.builder.it.service.AppBuilderModuleEntryLocalService;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.util.Locale;
import java.util.Map;

/**
 * @author Marco Leo
 */
public class AppBuilderModuleEntryWorkflowHandler
	extends BaseWorkflowHandler<AppBuilderModuleEntry> {

	public AppBuilderModuleEntryWorkflowHandler(
		AppBuilderModuleLocalService appBuilderModuleLocalService,
		AppBuilderModuleEntryLocalService appBuilderModuleEntryLocalService,
		long appBuilderModuleId, String modelClassName) {

		_appBuilderModuleLocalService = appBuilderModuleLocalService;
		_appBuilderModuleEntryLocalService = appBuilderModuleEntryLocalService;
		_appBuilderModuleId = appBuilderModuleId;
		_modelClassName = modelClassName;
	}

	@Override
	public String getClassName() {
		return _modelClassName;
	}

	@Override
	public String getType(Locale locale) {
		try {
			AppBuilderModule appBuilderModule =
				_appBuilderModuleLocalService.getAppBuilderModule(
					_appBuilderModuleId);

			return appBuilderModule.getLabel(locale);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}

		return getClassName();
	}

	@Override
	public AppBuilderModuleEntry updateStatus(
			int status, Map<String, Serializable> workflowContext)
		throws PortalException {

		long userId = GetterUtil.getLong(
			(String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong(
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext)workflowContext.get(
			"serviceContext");

		return _appBuilderModuleEntryLocalService.updateStatus(
			userId, classPK, status, serviceContext, workflowContext);
	}

	private final AppBuilderModuleEntryLocalService
		_appBuilderModuleEntryLocalService;
	private final long _appBuilderModuleId;
	private final AppBuilderModuleLocalService _appBuilderModuleLocalService;
	private final String _modelClassName;

}