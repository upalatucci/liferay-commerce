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
 * Provides a wrapper for {@link AppBuilderModuleEntryLocalService}.
 *
 * @author Marco Leo
 * @see AppBuilderModuleEntryLocalService
 * @generated
 */
public class AppBuilderModuleEntryLocalServiceWrapper
	implements AppBuilderModuleEntryLocalService,
			   ServiceWrapper<AppBuilderModuleEntryLocalService> {

	public AppBuilderModuleEntryLocalServiceWrapper(
		AppBuilderModuleEntryLocalService appBuilderModuleEntryLocalService) {

		_appBuilderModuleEntryLocalService = appBuilderModuleEntryLocalService;
	}

	/**
	 * Adds the app builder module entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleEntry the app builder module entry
	 * @return the app builder module entry that was added
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
		addAppBuilderModuleEntry(
			com.liferay.app.builder.it.model.AppBuilderModuleEntry
				appBuilderModuleEntry) {

		return _appBuilderModuleEntryLocalService.addAppBuilderModuleEntry(
			appBuilderModuleEntry);
	}

	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
			addAppBuilderModuleEntry(
				long appBuilderModuleId, long groupId,
				com.liferay.portal.kernel.json.JSONObject jsonObject,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleEntryLocalService.addAppBuilderModuleEntry(
			appBuilderModuleId, groupId, jsonObject, serviceContext);
	}

	@Override
	public void addEntryResources(
			com.liferay.app.builder.it.model.AppBuilderModuleEntry
				appBuilderModuleEntry)
		throws com.liferay.portal.kernel.exception.PortalException {

		_appBuilderModuleEntryLocalService.addEntryResources(
			appBuilderModuleEntry);
	}

	/**
	 * Creates a new app builder module entry with the primary key. Does not add the app builder module entry to the database.
	 *
	 * @param appBuilderModuleEntryId the primary key for the new app builder module entry
	 * @return the new app builder module entry
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
		createAppBuilderModuleEntry(long appBuilderModuleEntryId) {

		return _appBuilderModuleEntryLocalService.createAppBuilderModuleEntry(
			appBuilderModuleEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the app builder module entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleEntry the app builder module entry
	 * @return the app builder module entry that was removed
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
		deleteAppBuilderModuleEntry(
			com.liferay.app.builder.it.model.AppBuilderModuleEntry
				appBuilderModuleEntry) {

		return _appBuilderModuleEntryLocalService.deleteAppBuilderModuleEntry(
			appBuilderModuleEntry);
	}

	/**
	 * Deletes the app builder module entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry that was removed
	 * @throws PortalException if a app builder module entry with the primary key could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
			deleteAppBuilderModuleEntry(long appBuilderModuleEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleEntryLocalService.deleteAppBuilderModuleEntry(
			appBuilderModuleEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appBuilderModuleEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appBuilderModuleEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _appBuilderModuleEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _appBuilderModuleEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _appBuilderModuleEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _appBuilderModuleEntryLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _appBuilderModuleEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
		fetchAppBuilderModuleEntry(long appBuilderModuleEntryId) {

		return _appBuilderModuleEntryLocalService.fetchAppBuilderModuleEntry(
			appBuilderModuleEntryId);
	}

	/**
	 * Returns the app builder module entry matching the UUID and group.
	 *
	 * @param uuid the app builder module entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
		fetchAppBuilderModuleEntryByUuidAndGroupId(String uuid, long groupId) {

		return _appBuilderModuleEntryLocalService.
			fetchAppBuilderModuleEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appBuilderModuleEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the app builder module entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @return the range of app builder module entries
	 */
	@Override
	public java.util.List
		<com.liferay.app.builder.it.model.AppBuilderModuleEntry>
			getAppBuilderModuleEntries(int start, int end) {

		return _appBuilderModuleEntryLocalService.getAppBuilderModuleEntries(
			start, end);
	}

	/**
	 * Returns all the app builder module entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the app builder module entries
	 * @param companyId the primary key of the company
	 * @return the matching app builder module entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.app.builder.it.model.AppBuilderModuleEntry>
			getAppBuilderModuleEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _appBuilderModuleEntryLocalService.
			getAppBuilderModuleEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of app builder module entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the app builder module entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching app builder module entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.app.builder.it.model.AppBuilderModuleEntry>
			getAppBuilderModuleEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.app.builder.it.model.AppBuilderModuleEntry>
						orderByComparator) {

		return _appBuilderModuleEntryLocalService.
			getAppBuilderModuleEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of app builder module entries.
	 *
	 * @return the number of app builder module entries
	 */
	@Override
	public int getAppBuilderModuleEntriesCount() {
		return _appBuilderModuleEntryLocalService.
			getAppBuilderModuleEntriesCount();
	}

	/**
	 * Returns the app builder module entry with the primary key.
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry
	 * @throws PortalException if a app builder module entry with the primary key could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
			getAppBuilderModuleEntry(long appBuilderModuleEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleEntryLocalService.getAppBuilderModuleEntry(
			appBuilderModuleEntryId);
	}

	/**
	 * Returns the app builder module entry matching the UUID and group.
	 *
	 * @param uuid the app builder module entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching app builder module entry
	 * @throws PortalException if a matching app builder module entry could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
			getAppBuilderModuleEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleEntryLocalService.
			getAppBuilderModuleEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appBuilderModuleEntryLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appBuilderModuleEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appBuilderModuleEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the app builder module entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleEntry the app builder module entry
	 * @return the app builder module entry that was updated
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry
		updateAppBuilderModuleEntry(
			com.liferay.app.builder.it.model.AppBuilderModuleEntry
				appBuilderModuleEntry) {

		return _appBuilderModuleEntryLocalService.updateAppBuilderModuleEntry(
			appBuilderModuleEntry);
	}

	@Override
	public void updateAsset(
			long userId,
			com.liferay.app.builder.it.model.AppBuilderModuleEntry
				appBuilderModuleEntry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_appBuilderModuleEntryLocalService.updateAsset(
			userId, appBuilderModuleEntry, assetCategoryIds, assetTagNames,
			assetLinkEntryIds, priority);
	}

	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleEntry updateStatus(
			long userId, long appBuilderModuleEntryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleEntryLocalService.updateStatus(
			userId, appBuilderModuleEntryId, status, serviceContext,
			workflowContext);
	}

	@Override
	public AppBuilderModuleEntryLocalService getWrappedService() {
		return _appBuilderModuleEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AppBuilderModuleEntryLocalService appBuilderModuleEntryLocalService) {

		_appBuilderModuleEntryLocalService = appBuilderModuleEntryLocalService;
	}

	private AppBuilderModuleEntryLocalService
		_appBuilderModuleEntryLocalService;

}