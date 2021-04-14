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

import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppBuilderModuleField. This utility wraps
 * <code>com.liferay.app.builder.it.service.impl.AppBuilderModuleFieldLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marco Leo
 * @see AppBuilderModuleFieldLocalService
 * @generated
 */
public class AppBuilderModuleFieldLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.app.builder.it.service.impl.AppBuilderModuleFieldLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AppBuilderModuleField addAppBuilderModuleField(
		AppBuilderModuleField appBuilderModuleField) {

		return getService().addAppBuilderModuleField(appBuilderModuleField);
	}

	public static AppBuilderModuleField addAppBuilderModuleField(
			long userId, String name, String label, String type,
			String typeSettings, boolean nullable)
		throws PortalException {

		return getService().addAppBuilderModuleField(
			userId, name, label, type, typeSettings, nullable);
	}

	/**
	 * Creates a new app builder module field with the primary key. Does not add the app builder module field to the database.
	 *
	 * @param appBuilderModuleFieldId the primary key for the new app builder module field
	 * @return the new app builder module field
	 */
	public static AppBuilderModuleField createAppBuilderModuleField(
		long appBuilderModuleFieldId) {

		return getService().createAppBuilderModuleField(
			appBuilderModuleFieldId);
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
	 * Deletes the app builder module field from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleField the app builder module field
	 * @return the app builder module field that was removed
	 */
	public static AppBuilderModuleField deleteAppBuilderModuleField(
		AppBuilderModuleField appBuilderModuleField) {

		return getService().deleteAppBuilderModuleField(appBuilderModuleField);
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
	public static AppBuilderModuleField deleteAppBuilderModuleField(
			long appBuilderModuleFieldId)
		throws PortalException {

		return getService().deleteAppBuilderModuleField(
			appBuilderModuleFieldId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleFieldModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.it.model.impl.AppBuilderModuleFieldModelImpl</code>.
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

	public static AppBuilderModuleField fetchAppBuilderModuleField(
		long appBuilderModuleFieldId) {

		return getService().fetchAppBuilderModuleField(appBuilderModuleFieldId);
	}

	/**
	 * Returns the app builder module field with the matching UUID and company.
	 *
	 * @param uuid the app builder module field's UUID
	 * @param companyId the primary key of the company
	 * @return the matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField
		fetchAppBuilderModuleFieldByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().fetchAppBuilderModuleFieldByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the app builder module field with the primary key.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field
	 * @throws PortalException if a app builder module field with the primary key could not be found
	 */
	public static AppBuilderModuleField getAppBuilderModuleField(
			long appBuilderModuleFieldId)
		throws PortalException {

		return getService().getAppBuilderModuleField(appBuilderModuleFieldId);
	}

	/**
	 * Returns the app builder module field with the matching UUID and company.
	 *
	 * @param uuid the app builder module field's UUID
	 * @param companyId the primary key of the company
	 * @return the matching app builder module field
	 * @throws PortalException if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField
			getAppBuilderModuleFieldByUuidAndCompanyId(
				String uuid, long companyId)
		throws PortalException {

		return getService().getAppBuilderModuleFieldByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<AppBuilderModuleField> getAppBuilderModuleFields(
		int start, int end) {

		return getService().getAppBuilderModuleFields(start, end);
	}

	public static List<AppBuilderModuleField> getAppBuilderModuleFields(
		long appBuilderModuleId, int start, int end) {

		return getService().getAppBuilderModuleFields(
			appBuilderModuleId, start, end);
	}

	/**
	 * Returns the number of app builder module fields.
	 *
	 * @return the number of app builder module fields
	 */
	public static int getAppBuilderModuleFieldsCount() {
		return getService().getAppBuilderModuleFieldsCount();
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
	 * Updates the app builder module field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppBuilderModuleFieldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appBuilderModuleField the app builder module field
	 * @return the app builder module field that was updated
	 */
	public static AppBuilderModuleField updateAppBuilderModuleField(
		AppBuilderModuleField appBuilderModuleField) {

		return getService().updateAppBuilderModuleField(appBuilderModuleField);
	}

	public static AppBuilderModuleFieldLocalService getService() {
		return _service;
	}

	private static volatile AppBuilderModuleFieldLocalService _service;

}