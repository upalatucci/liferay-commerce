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
 * Provides a wrapper for {@link AppBuilderModuleFieldLocalService}.
 *
 * @author Marco Leo
 * @see AppBuilderModuleFieldLocalService
 * @generated
 */
public class AppBuilderModuleFieldLocalServiceWrapper
	implements AppBuilderModuleFieldLocalService,
			   ServiceWrapper<AppBuilderModuleFieldLocalService> {

	public AppBuilderModuleFieldLocalServiceWrapper(
		AppBuilderModuleFieldLocalService appBuilderModuleFieldLocalService) {

		_appBuilderModuleFieldLocalService = appBuilderModuleFieldLocalService;
	}

	/**
	 * Adds the app builder module field to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleField the app builder module field
	 * @return the app builder module field that was added
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
		addAppBuilderModuleField(
			com.liferay.app.builder.it.model.AppBuilderModuleField
				appBuilderModuleField) {

		return _appBuilderModuleFieldLocalService.addAppBuilderModuleField(
			appBuilderModuleField);
	}

	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
			addAppBuilderModuleField(
				long userId, String name, String label, String type,
				String typeSettings, boolean nullable)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleFieldLocalService.addAppBuilderModuleField(
			userId, name, label, type, typeSettings, nullable);
	}

	/**
	 * Creates a new app builder module field with the primary key. Does not add the app builder module field to the database.
	 *
	 * @param appBuilderModuleFieldId the primary key for the new app builder module field
	 * @return the new app builder module field
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
		createAppBuilderModuleField(long appBuilderModuleFieldId) {

		return _appBuilderModuleFieldLocalService.createAppBuilderModuleField(
			appBuilderModuleFieldId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleFieldLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the app builder module field from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleField the app builder module field
	 * @return the app builder module field that was removed
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
		deleteAppBuilderModuleField(
			com.liferay.app.builder.it.model.AppBuilderModuleField
				appBuilderModuleField) {

		return _appBuilderModuleFieldLocalService.deleteAppBuilderModuleField(
			appBuilderModuleField);
	}

	/**
	 * Deletes the app builder module field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field that was removed
	 * @throws PortalException if a app builder module field with the primary key could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
			deleteAppBuilderModuleField(long appBuilderModuleFieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleFieldLocalService.deleteAppBuilderModuleField(
			appBuilderModuleFieldId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleFieldLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appBuilderModuleFieldLocalService.dslQuery(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appBuilderModuleFieldLocalService.dynamicQuery();
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

		return _appBuilderModuleFieldLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleFieldModelImpl</code>.
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

		return _appBuilderModuleFieldLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleFieldModelImpl</code>.
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

		return _appBuilderModuleFieldLocalService.dynamicQuery(
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

		return _appBuilderModuleFieldLocalService.dynamicQueryCount(
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

		return _appBuilderModuleFieldLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
		fetchAppBuilderModuleField(long appBuilderModuleFieldId) {

		return _appBuilderModuleFieldLocalService.fetchAppBuilderModuleField(
			appBuilderModuleFieldId);
	}

	/**
	 * Returns the app builder module field with the matching UUID and company.
	 *
	 * @param uuid the app builder module field's UUID
	 * @param companyId the primary key of the company
	 * @return the matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
		fetchAppBuilderModuleFieldByUuidAndCompanyId(
			String uuid, long companyId) {

		return _appBuilderModuleFieldLocalService.
			fetchAppBuilderModuleFieldByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appBuilderModuleFieldLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the app builder module field with the primary key.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field
	 * @throws PortalException if a app builder module field with the primary key could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
			getAppBuilderModuleField(long appBuilderModuleFieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleFieldLocalService.getAppBuilderModuleField(
			appBuilderModuleFieldId);
	}

	/**
	 * Returns the app builder module field with the matching UUID and company.
	 *
	 * @param uuid the app builder module field's UUID
	 * @param companyId the primary key of the company
	 * @return the matching app builder module field
	 * @throws PortalException if a matching app builder module field could not be found
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
			getAppBuilderModuleFieldByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleFieldLocalService.
			getAppBuilderModuleFieldByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the app builder module fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @return the range of app builder module fields
	 */
	@Override
	public java.util.List
		<com.liferay.app.builder.it.model.AppBuilderModuleField>
			getAppBuilderModuleFields(int start, int end) {

		return _appBuilderModuleFieldLocalService.getAppBuilderModuleFields(
			start, end);
	}

	@Override
	public java.util.List
		<com.liferay.app.builder.it.model.AppBuilderModuleField>
			getAppBuilderModuleFields(
				long appBuilderModuleId, int start, int end) {

		return _appBuilderModuleFieldLocalService.getAppBuilderModuleFields(
			appBuilderModuleId, start, end);
	}

	/**
	 * Returns the number of app builder module fields.
	 *
	 * @return the number of app builder module fields
	 */
	@Override
	public int getAppBuilderModuleFieldsCount() {
		return _appBuilderModuleFieldLocalService.
			getAppBuilderModuleFieldsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appBuilderModuleFieldLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appBuilderModuleFieldLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appBuilderModuleFieldLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appBuilderModuleFieldLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the app builder module field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleField the app builder module field
	 * @return the app builder module field that was updated
	 */
	@Override
	public com.liferay.app.builder.it.model.AppBuilderModuleField
		updateAppBuilderModuleField(
			com.liferay.app.builder.it.model.AppBuilderModuleField
				appBuilderModuleField) {

		return _appBuilderModuleFieldLocalService.updateAppBuilderModuleField(
			appBuilderModuleField);
	}

	@Override
	public AppBuilderModuleFieldLocalService getWrappedService() {
		return _appBuilderModuleFieldLocalService;
	}

	@Override
	public void setWrappedService(
		AppBuilderModuleFieldLocalService appBuilderModuleFieldLocalService) {

		_appBuilderModuleFieldLocalService = appBuilderModuleFieldLocalService;
	}

	private AppBuilderModuleFieldLocalService
		_appBuilderModuleFieldLocalService;

}