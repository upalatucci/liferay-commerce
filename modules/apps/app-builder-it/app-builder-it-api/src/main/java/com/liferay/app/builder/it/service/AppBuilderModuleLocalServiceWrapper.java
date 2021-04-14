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
 * Provides a wrapper for {@link AppBuilderModuleLocalService}.
 *
 * @author Marco Leo
 * @see AppBuilderModuleLocalService
 * @generated
 */
public class AppBuilderModuleLocalServiceWrapper
	implements AppBuilderModuleLocalService,
			   ServiceWrapper<AppBuilderModuleLocalService> {

	public AppBuilderModuleLocalServiceWrapper(
		AppBuilderModuleLocalService appBuilderModuleLocalService) {

		_appBuilderModuleLocalService = appBuilderModuleLocalService;
	}

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
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
		addAppBuilderModule(
			com.liferay.app.builder.it.model.AppBuilderModule
				appBuilderModule) {

		return _appBuilderModuleLocalService.addAppBuilderModule(
			appBuilderModule);
	}

	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
			addAppBuilderModule(
				long userId, String name, String label, boolean active,
				boolean asset, boolean resource)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleLocalService.addAppBuilderModule(
			userId, name, label, active, asset, resource);
	}

	/**
	 * Creates a new app builder module with the primary key. Does not add the app builder module to the database.
	 *
	 * @param appBuilderModuleId the primary key for the new app builder module
	 * @return the new app builder module
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
		createAppBuilderModule(long appBuilderModuleId) {

		return _appBuilderModuleLocalService.createAppBuilderModule(
			appBuilderModuleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
		deleteAppBuilderModule(
			com.liferay.app.builder.it.model.AppBuilderModule
				appBuilderModule) {

		return _appBuilderModuleLocalService.deleteAppBuilderModule(
			appBuilderModule);
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
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
			deleteAppBuilderModule(long appBuilderModuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleLocalService.deleteAppBuilderModule(
			appBuilderModuleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appBuilderModuleLocalService.dslQuery(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appBuilderModuleLocalService.dynamicQuery();
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

		return _appBuilderModuleLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _appBuilderModuleLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _appBuilderModuleLocalService.dynamicQuery(
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

		return _appBuilderModuleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appBuilderModuleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
		fetchAppBuilderModule(long appBuilderModuleId) {

		return _appBuilderModuleLocalService.fetchAppBuilderModule(
			appBuilderModuleId);
	}

	/**
	 * Returns the app builder module with the matching UUID and company.
	 *
	 * @param uuid the app builder module's UUID
	 * @param companyId the primary key of the company
	 * @return the matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
		fetchAppBuilderModuleByUuidAndCompanyId(String uuid, long companyId) {

		return _appBuilderModuleLocalService.
			fetchAppBuilderModuleByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appBuilderModuleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the app builder module with the primary key.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module
	 * @throws PortalException if a app builder module with the primary key could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
			getAppBuilderModule(long appBuilderModuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleLocalService.getAppBuilderModule(
			appBuilderModuleId);
	}

	/**
	 * Returns the app builder module with the matching UUID and company.
	 *
	 * @param uuid the app builder module's UUID
	 * @param companyId the primary key of the company
	 * @return the matching app builder module
	 * @throws PortalException if a matching app builder module could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
			getAppBuilderModuleByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleLocalService.
			getAppBuilderModuleByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public java.util.List<com.liferay.app.builder.it.model.AppBuilderModule>
		getAppBuilderModules() {

		return _appBuilderModuleLocalService.getAppBuilderModules();
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
	@Override
	public java.util.List<com.liferay.app.builder.it.model.AppBuilderModule>
		getAppBuilderModules(int start, int end) {

		return _appBuilderModuleLocalService.getAppBuilderModules(start, end);
	}

	/**
	 * Returns the number of app builder modules.
	 *
	 * @return the number of app builder modules
	 */
	@Override
	public int getAppBuilderModulesCount() {
		return _appBuilderModuleLocalService.getAppBuilderModulesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appBuilderModuleLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appBuilderModuleLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appBuilderModuleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModule
		updateAppBuilderModule(
			com.liferay.app.builder.it.model.AppBuilderModule
				appBuilderModule) {

		return _appBuilderModuleLocalService.updateAppBuilderModule(
			appBuilderModule);
	}

	@Override
	public AppBuilderModuleLocalService getWrappedService() {
		return _appBuilderModuleLocalService;
	}

	@Override
	public void setWrappedService(
		AppBuilderModuleLocalService appBuilderModuleLocalService) {

		_appBuilderModuleLocalService = appBuilderModuleLocalService;
	}

	private AppBuilderModuleLocalService _appBuilderModuleLocalService;

}