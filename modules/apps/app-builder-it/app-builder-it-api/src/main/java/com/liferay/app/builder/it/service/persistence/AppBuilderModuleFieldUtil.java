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

package com.liferay.app.builder.it.service.persistence;

import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the app builder module field service. This utility wraps <code>com.liferay.app.builder.it.service.persistence.impl.AppBuilderModuleFieldPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModuleFieldPersistence
 * @generated
 */
public class AppBuilderModuleFieldUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AppBuilderModuleField appBuilderModuleField) {
		getPersistence().clearCache(appBuilderModuleField);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AppBuilderModuleField> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppBuilderModuleField> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppBuilderModuleField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppBuilderModuleField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppBuilderModuleField update(
		AppBuilderModuleField appBuilderModuleField) {

		return getPersistence().update(appBuilderModuleField);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppBuilderModuleField update(
		AppBuilderModuleField appBuilderModuleField,
		ServiceContext serviceContext) {

		return getPersistence().update(appBuilderModuleField, serviceContext);
	}

	/**
	 * Returns all the app builder module fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the app builder module fields where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @return the range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the app builder module fields where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder module fields where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField findByUuid_First(
			String uuid,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField fetchByUuid_First(
		String uuid,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField findByUuid_Last(
			String uuid,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the app builder module fields before and after the current app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param appBuilderModuleFieldId the primary key of the current app builder module field
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public static AppBuilderModuleField[] findByUuid_PrevAndNext(
			long appBuilderModuleFieldId, String uuid,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByUuid_PrevAndNext(
			appBuilderModuleFieldId, uuid, orderByComparator);
	}

	/**
	 * Removes all the app builder module fields where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of app builder module fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching app builder module fields
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @return the range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the app builder module fields before and after the current app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appBuilderModuleFieldId the primary key of the current app builder module field
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public static AppBuilderModuleField[] findByUuid_C_PrevAndNext(
			long appBuilderModuleFieldId, String uuid, long companyId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appBuilderModuleFieldId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the app builder module fields where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching app builder module fields
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @return the matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId) {

		return getPersistence().findByAppBuilderModuleId(appBuilderModuleId);
	}

	/**
	 * Returns a range of all the app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @return the range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end) {

		return getPersistence().findByAppBuilderModuleId(
			appBuilderModuleId, start, end);
	}

	/**
	 * Returns an ordered range of all the app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().findByAppBuilderModuleId(
			appBuilderModuleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app builder module fields
	 */
	public static List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAppBuilderModuleId(
			appBuilderModuleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField findByAppBuilderModuleId_First(
			long appBuilderModuleId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByAppBuilderModuleId_First(
			appBuilderModuleId, orderByComparator);
	}

	/**
	 * Returns the first app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField fetchByAppBuilderModuleId_First(
		long appBuilderModuleId,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().fetchByAppBuilderModuleId_First(
			appBuilderModuleId, orderByComparator);
	}

	/**
	 * Returns the last app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField findByAppBuilderModuleId_Last(
			long appBuilderModuleId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByAppBuilderModuleId_Last(
			appBuilderModuleId, orderByComparator);
	}

	/**
	 * Returns the last app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public static AppBuilderModuleField fetchByAppBuilderModuleId_Last(
		long appBuilderModuleId,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().fetchByAppBuilderModuleId_Last(
			appBuilderModuleId, orderByComparator);
	}

	/**
	 * Returns the app builder module fields before and after the current app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleFieldId the primary key of the current app builder module field
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public static AppBuilderModuleField[] findByAppBuilderModuleId_PrevAndNext(
			long appBuilderModuleFieldId, long appBuilderModuleId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByAppBuilderModuleId_PrevAndNext(
			appBuilderModuleFieldId, appBuilderModuleId, orderByComparator);
	}

	/**
	 * Removes all the app builder module fields where appBuilderModuleId = &#63; from the database.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 */
	public static void removeByAppBuilderModuleId(long appBuilderModuleId) {
		getPersistence().removeByAppBuilderModuleId(appBuilderModuleId);
	}

	/**
	 * Returns the number of app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @return the number of matching app builder module fields
	 */
	public static int countByAppBuilderModuleId(long appBuilderModuleId) {
		return getPersistence().countByAppBuilderModuleId(appBuilderModuleId);
	}

	/**
	 * Caches the app builder module field in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleField the app builder module field
	 */
	public static void cacheResult(
		AppBuilderModuleField appBuilderModuleField) {

		getPersistence().cacheResult(appBuilderModuleField);
	}

	/**
	 * Caches the app builder module fields in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleFields the app builder module fields
	 */
	public static void cacheResult(
		List<AppBuilderModuleField> appBuilderModuleFields) {

		getPersistence().cacheResult(appBuilderModuleFields);
	}

	/**
	 * Creates a new app builder module field with the primary key. Does not add the app builder module field to the database.
	 *
	 * @param appBuilderModuleFieldId the primary key for the new app builder module field
	 * @return the new app builder module field
	 */
	public static AppBuilderModuleField create(long appBuilderModuleFieldId) {
		return getPersistence().create(appBuilderModuleFieldId);
	}

	/**
	 * Removes the app builder module field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field that was removed
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public static AppBuilderModuleField remove(long appBuilderModuleFieldId)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().remove(appBuilderModuleFieldId);
	}

	public static AppBuilderModuleField updateImpl(
		AppBuilderModuleField appBuilderModuleField) {

		return getPersistence().updateImpl(appBuilderModuleField);
	}

	/**
	 * Returns the app builder module field with the primary key or throws a <code>NoSuchAppBuilderModuleFieldException</code> if it could not be found.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public static AppBuilderModuleField findByPrimaryKey(
			long appBuilderModuleFieldId)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleFieldException {

		return getPersistence().findByPrimaryKey(appBuilderModuleFieldId);
	}

	/**
	 * Returns the app builder module field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field, or <code>null</code> if a app builder module field with the primary key could not be found
	 */
	public static AppBuilderModuleField fetchByPrimaryKey(
		long appBuilderModuleFieldId) {

		return getPersistence().fetchByPrimaryKey(appBuilderModuleFieldId);
	}

	/**
	 * Returns all the app builder module fields.
	 *
	 * @return the app builder module fields
	 */
	public static List<AppBuilderModuleField> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the app builder module fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @return the range of app builder module fields
	 */
	public static List<AppBuilderModuleField> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the app builder module fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app builder module fields
	 */
	public static List<AppBuilderModuleField> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder module fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder module fields
	 * @param end the upper bound of the range of app builder module fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app builder module fields
	 */
	public static List<AppBuilderModuleField> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the app builder module fields from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of app builder module fields.
	 *
	 * @return the number of app builder module fields
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppBuilderModuleFieldPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AppBuilderModuleFieldPersistence, AppBuilderModuleFieldPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AppBuilderModuleFieldPersistence.class);

		ServiceTracker
			<AppBuilderModuleFieldPersistence, AppBuilderModuleFieldPersistence>
				serviceTracker =
					new ServiceTracker
						<AppBuilderModuleFieldPersistence,
						 AppBuilderModuleFieldPersistence>(
							 bundle.getBundleContext(),
							 AppBuilderModuleFieldPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}