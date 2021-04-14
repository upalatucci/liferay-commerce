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

import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppBuilderModule. This utility wraps
 * <code>com.liferay.app.builder.it.service.impl.AppBuilderModuleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marco Leo
 * @see AppBuilderModuleLocalService
 * @generated
 */
public class AppBuilderModuleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.app.builder.it.service.impl.AppBuilderModuleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the app builder module to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModule the app builder module
	 * @return the app builder module that was added
	 */
	public static AppBuilderModule addAppBuilderModule(
		AppBuilderModule appBuilderModule) {

		return getService().addAppBuilderModule(appBuilderModule);
	}

	public static AppBuilderModule addAppBuilderModule(
			long userId, String name, String label, boolean active,
			boolean asset, boolean resource)
		throws PortalException {

		return getService().addAppBuilderModule(
			userId, name, label, active, asset, resource);
	}

	/**
	 * Creates a new app builder module with the primary key. Does not add the app builder module to the database.
	 *
	 * @param appBuilderModuleId the primary key for the new app builder module
	 * @return the new app builder module
	 */
	public static AppBuilderModule createAppBuilderModule(
		long appBuilderModuleId) {

		return getService().createAppBuilderModule(appBuilderModuleId);
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
	 * Deletes the app builder module from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModule the app builder module
	 * @return the app builder module that was removed
	 */
	public static AppBuilderModule deleteAppBuilderModule(
		AppBuilderModule appBuilderModule) {

		return getService().deleteAppBuilderModule(appBuilderModule);
	}

	/**
	 * Deletes the app builder module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module that was removed
	 * @throws PortalException if a app builder module with the primary key could not be found
	 */
	public static AppBuilderModule deleteAppBuilderModule(
			long appBuilderModuleId)
		throws PortalException {

		return getService().deleteAppBuilderModule(appBuilderModuleId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleModelImpl</code>.
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

	public static AppBuilderModule fetchAppBuilderModule(
		long appBuilderModuleId) {

		return getService().fetchAppBuilderModule(appBuilderModuleId);
	}

	/**
	 * Returns the app builder module with the matching UUID and company.
	 *
	 * @param uuid the app builder module's UUID
	 * @param companyId the primary key of the company
	 * @return the matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public static AppBuilderModule fetchAppBuilderModuleByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchAppBuilderModuleByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the app builder module with the primary key.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module
	 * @throws PortalException if a app builder module with the primary key could not be found
	 */
	public static AppBuilderModule getAppBuilderModule(long appBuilderModuleId)
		throws PortalException {

		return getService().getAppBuilderModule(appBuilderModuleId);
	}

	/**
	 * Returns the app builder module with the matching UUID and company.
	 *
	 * @param uuid the app builder module's UUID
	 * @param companyId the primary key of the company
	 * @return the matching app builder module
	 * @throws PortalException if a matching app builder module could not be found
	 */
	public static AppBuilderModule getAppBuilderModuleByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getAppBuilderModuleByUuidAndCompanyId(
			uuid, companyId);
	}

	public static List<AppBuilderModule> getAppBuilderModules() {
		return getService().getAppBuilderModules();
	}

	/**
	 * Returns a range of all the app builder modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @return the range of app builder modules
	 */
	public static List<AppBuilderModule> getAppBuilderModules(
		int start, int end) {

		return getService().getAppBuilderModules(start, end);
	}

	/**
	 * Returns the number of app builder modules.
	 *
	 * @return the number of app builder modules
	 */
	public static int getAppBuilderModulesCount() {
		return getService().getAppBuilderModulesCount();
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
	 * Updates the app builder module in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModule the app builder module
	 * @return the app builder module that was updated
	 */
	public static AppBuilderModule updateAppBuilderModule(
		AppBuilderModule appBuilderModule) {

		return getService().updateAppBuilderModule(appBuilderModule);
	}

	public static AppBuilderModuleLocalService getService() {
		return _service;
	}

	private static volatile AppBuilderModuleLocalService _service;

}