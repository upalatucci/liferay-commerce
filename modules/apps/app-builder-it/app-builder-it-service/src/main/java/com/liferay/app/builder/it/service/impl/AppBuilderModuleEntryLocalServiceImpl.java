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

import com.liferay.app.builder.it.dao.AppBuilderModuleDAO;
import com.liferay.app.builder.it.dao.AppBuilderModuleDAOServiceRegistry;
import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleEntryException;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalService;
import com.liferay.app.builder.it.service.base.AppBuilderModuleEntryLocalServiceBaseImpl;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ResourceLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(
	property = "model.class.name=com.liferay.app.builder.it.model.AppBuilderModuleEntry",
	service = AopService.class
)
public class AppBuilderModuleEntryLocalServiceImpl
	extends AppBuilderModuleEntryLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AppBuilderModuleEntry addAppBuilderModuleEntry(
			long appBuilderModuleId, long groupId, JSONObject jsonObject,
			ServiceContext serviceContext)
		throws PortalException {

		User user = _userLocalService.getUser(serviceContext.getUserId());

		Date now = new Date();

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.getAppBuilderModule(
				appBuilderModuleId);

		AppBuilderModuleDAO appBuilderModuleDAO =
			_appBuilderModuleDAOServiceRegistry.getAppBuilderModuleDAO(
				appBuilderModule);

		long appBuilderModuleEntryId = counterLocalService.increment(
			appBuilderModule.getDbTableName());

		jsonObject.put(
			appBuilderModule.getDbTablePKColumnName(),
			(Object)appBuilderModuleEntryId);

		AppBuilderModuleEntry appBuilderModuleEntry =
			appBuilderModuleEntryPersistence.create(appBuilderModuleEntryId);

		appBuilderModuleDAO.save(jsonObject);

		appBuilderModuleEntry.setGroupId(groupId);
		appBuilderModuleEntry.setCompanyId(user.getCompanyId());
		appBuilderModuleEntry.setUserId(user.getUserId());
		appBuilderModuleEntry.setUserName(user.getFullName());
		appBuilderModuleEntry.setAppBuilderModuleId(appBuilderModuleId);
		appBuilderModuleEntry.setStatus(WorkflowConstants.STATUS_DRAFT);
		appBuilderModuleEntry.setStatusByUserId(user.getUserId());
		appBuilderModuleEntry.setStatusDate(
			serviceContext.getModifiedDate(now));
		appBuilderModuleEntry.setExpandoBridgeAttributes(serviceContext);

		appBuilderModuleEntry = appBuilderModuleEntryPersistence.update(
			appBuilderModuleEntry);

		// Resources

		if (appBuilderModule.isResource()) {
			addEntryResources(appBuilderModuleEntry);
		}

		// Asset

		if (appBuilderModule.isAsset()) {
			updateAsset(
				serviceContext.getUserId(), appBuilderModuleEntry,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds(),
				serviceContext.getAssetPriority());
		}

		// Workflow

		return _startWorkflowInstance(
			serviceContext.getUserId(), appBuilderModuleEntry, serviceContext);
	}

	@Override
	public void addEntryResources(AppBuilderModuleEntry appBuilderModuleEntry)
		throws PortalException {

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.getAppBuilderModule(
				appBuilderModuleEntry.getAppBuilderModuleId());

		_resourceLocalService.addResources(
			appBuilderModuleEntry.getCompanyId(),
			appBuilderModuleEntry.getGroupId(),
			appBuilderModuleEntry.getUserId(),
			appBuilderModule.getDbTableName(),
			appBuilderModuleEntry.getPrimaryKey(), false, false, false);
	}

	@Override
	public AppBuilderModuleEntry getAppBuilderModuleEntry(
			long appBuilderModuleEntryId)
		throws PortalException {

		AppBuilderModuleEntry appBuilderModuleEntry =
			appBuilderModuleEntryPersistence.findByPrimaryKey(
				appBuilderModuleEntryId);

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.getAppBuilderModule(
				appBuilderModuleEntry.getAppBuilderModuleId());

		AppBuilderModuleDAO appBuilderModuleDAO =
			_appBuilderModuleDAOServiceRegistry.getAppBuilderModuleDAO(
				appBuilderModule);

		Optional<JSONObject> jsonObject = appBuilderModuleDAO.get(
			appBuilderModuleEntryId);

		if (!jsonObject.isPresent()) {
			throw new NoSuchAppBuilderModuleEntryException();
		}

		return appBuilderModuleEntry;
	}

	@Override
	public void updateAsset(
			long userId, AppBuilderModuleEntry appBuilderModuleEntry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws PortalException {

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.getAppBuilderModule(
				appBuilderModuleEntry.getAppBuilderModuleId());

		boolean visible = false;

		if (appBuilderModuleEntry.isApproved()) {
			visible = true;
		}

		long groupId = appBuilderModuleEntry.getGroupId();

		if (groupId == 0) {
			Company company = _companyLocalService.getCompany(
				appBuilderModuleEntry.getCompanyId());

			groupId = company.getGroupId();
		}

		AssetEntry assetEntry = _assetEntryLocalService.updateEntry(
			userId, groupId, appBuilderModuleEntry.getCreateDate(),
			appBuilderModuleEntry.getModifiedDate(),
			appBuilderModule.getDbTableName(),
			appBuilderModuleEntry.getPrimaryKey(),
			appBuilderModuleEntry.getUuid(), 0, assetCategoryIds, assetTagNames,
			true, visible, null, null, null, null, ContentTypes.TEXT_HTML,
			String.valueOf(appBuilderModuleEntry.getPrimaryKey()),
			String.valueOf(appBuilderModuleEntry.getPrimaryKey()), null, null,
			null, 0, 0, priority);

		_assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(), assetLinkEntryIds,
			AssetLinkConstants.TYPE_RELATED);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AppBuilderModuleEntry updateStatus(
			long userId, long appBuilderModuleEntryId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		AppBuilderModuleEntry appBuilderModuleEntry =
			appBuilderModuleEntryPersistence.findByPrimaryKey(
				appBuilderModuleEntryId);

		// Entry

		User user = _userLocalService.getUser(userId);
		Date now = new Date();

		appBuilderModuleEntry.setStatus(status);
		appBuilderModuleEntry.setStatusByUserId(user.getUserId());
		appBuilderModuleEntry.setStatusByUserName(user.getFullName());
		appBuilderModuleEntry.setStatusDate(
			serviceContext.getModifiedDate(now));

		return appBuilderModuleEntryPersistence.update(appBuilderModuleEntry);
	}

	private AppBuilderModuleEntry _startWorkflowInstance(
			long userId, AppBuilderModuleEntry appBuilderModuleEntry,
			ServiceContext serviceContext)
		throws PortalException {

		long groupId = appBuilderModuleEntry.getGroupId();

		if (groupId == 0) {
			Company company = _companyLocalService.getCompany(
				appBuilderModuleEntry.getCompanyId());

			groupId = company.getGroupId();
		}

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.getAppBuilderModule(
				appBuilderModuleEntry.getAppBuilderModuleId());

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
			appBuilderModuleEntry.getCompanyId(), groupId, userId,
			appBuilderModule.getDbTableName(),
			appBuilderModuleEntry.getPrimaryKey(), appBuilderModuleEntry,
			serviceContext, new HashMap<>());
	}

	@Reference
	private AppBuilderModuleDAOServiceRegistry
		_appBuilderModuleDAOServiceRegistry;

	@Reference
	private AppBuilderModuleLocalService _appBuilderModuleLocalService;

	@Reference
	private AssetEntryLocalService _assetEntryLocalService;

	@Reference
	private AssetLinkLocalService _assetLinkLocalService;

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private ResourceLocalService _resourceLocalService;

	@Reference
	private UserLocalService _userLocalService;

}