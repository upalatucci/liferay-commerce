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

import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for AppBuilderModuleEntry. This utility wraps
 * <code>com.liferay.app.builder.it.service.impl.AppBuilderModuleEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marco Leo
 * @see AppBuilderModuleEntryLocalService
 * @generated
 */
public class AppBuilderModuleEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.app.builder.it.service.impl.AppBuilderModuleEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AppBuilderModuleEntry addAppBuilderModuleEntry(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		return getService().addAppBuilderModuleEntry(appBuilderModuleEntry);
	}

	public static AppBuilderModuleEntry addAppBuilderModuleEntry(
			long appBuilderModuleId, long groupId,
			com.liferay.portal.kernel.json.JSONObject jsonObject,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAppBuilderModuleEntry(
			appBuilderModuleId, groupId, jsonObject, serviceContext);
	}

	public static void addEntryResources(
			AppBuilderModuleEntry appBuilderModuleEntry)
		throws PortalException {

		getService().addEntryResources(appBuilderModuleEntry);
	}

	/**
	 * Creates a new app builder module entry with the primary key. Does not add the app builder module entry to the database.
	 *
	 * @param appBuilderModuleEntryId the primary key for the new app builder module entry
	 * @return the new app builder module entry
	 */
	public static AppBuilderModuleEntry createAppBuilderModuleEntry(
		long appBuilderModuleEntryId) {

		return getService().createAppBuilderModuleEntry(
			appBuilderModuleEntryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static AppBuilderModuleEntry deleteAppBuilderModuleEntry(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		return getService().deleteAppBuilderModuleEntry(appBuilderModuleEntry);
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
	public static AppBuilderModuleEntry deleteAppBuilderModuleEntry(
			long appBuilderModuleEntryId)
		throws PortalException {

		return getService().deleteAppBuilderModuleEntry(
			appBuilderModuleEntryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AppBuilderModuleEntry fetchAppBuilderModuleEntry(
		long appBuilderModuleEntryId) {

		return getService().fetchAppBuilderModuleEntry(appBuilderModuleEntryId);
	}

	/**
	 * Returns the app builder module entry matching the UUID and group.
	 *
	 * @param uuid the app builder module entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry
		fetchAppBuilderModuleEntryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchAppBuilderModuleEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<AppBuilderModuleEntry> getAppBuilderModuleEntries(
		int start, int end) {

		return getService().getAppBuilderModuleEntries(start, end);
	}

	/**
	 * Returns all the app builder module entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the app builder module entries
	 * @param companyId the primary key of the company
	 * @return the matching app builder module entries, or an empty list if no matches were found
	 */
	public static List<AppBuilderModuleEntry>
		getAppBuilderModuleEntriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getAppBuilderModuleEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<AppBuilderModuleEntry>
		getAppBuilderModuleEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getService().getAppBuilderModuleEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of app builder module entries.
	 *
	 * @return the number of app builder module entries
	 */
	public static int getAppBuilderModuleEntriesCount() {
		return getService().getAppBuilderModuleEntriesCount();
	}

	/**
	 * Returns the app builder module entry with the primary key.
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry
	 * @throws PortalException if a app builder module entry with the primary key could not be found
	 */
	public static AppBuilderModuleEntry getAppBuilderModuleEntry(
			long appBuilderModuleEntryId)
		throws PortalException {

		return getService().getAppBuilderModuleEntry(appBuilderModuleEntryId);
	}

	/**
	 * Returns the app builder module entry matching the UUID and group.
	 *
	 * @param uuid the app builder module entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching app builder module entry
	 * @throws PortalException if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry
			getAppBuilderModuleEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getAppBuilderModuleEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static AppBuilderModuleEntry updateAppBuilderModuleEntry(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		return getService().updateAppBuilderModuleEntry(appBuilderModuleEntry);
	}

	public static void updateAsset(
			long userId, AppBuilderModuleEntry appBuilderModuleEntry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws PortalException {

		getService().updateAsset(
			userId, appBuilderModuleEntry, assetCategoryIds, assetTagNames,
			assetLinkEntryIds, priority);
	}

	public static AppBuilderModuleEntry updateStatus(
			long userId, long appBuilderModuleEntryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, appBuilderModuleEntryId, status, serviceContext,
			workflowContext);
	}

	public static AppBuilderModuleEntryLocalService getService() {
		return _service;
	}

	private static volatile AppBuilderModuleEntryLocalService _service;

}