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

import com.liferay.app.builder.it.model.AppBuilderModule;
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
 * The persistence utility for the app builder module service. This utility wraps <code>com.liferay.app.builder.it.service.persistence.impl.AppBuilderModulePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModulePersistence
 * @generated
 */
public class AppBuilderModuleUtil {

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
	public static void clearCache(AppBuilderModule appBuilderModule) {
		getPersistence().clearCache(appBuilderModule);
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
	public static Map<Serializable, AppBuilderModule> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppBuilderModule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppBuilderModule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppBuilderModule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppBuilderModule update(AppBuilderModule appBuilderModule) {
		return getPersistence().update(appBuilderModule);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppBuilderModule update(
		AppBuilderModule appBuilderModule, ServiceContext serviceContext) {

		return getPersistence().update(appBuilderModule, serviceContext);
	}

	/**
	 * Returns all the app builder modules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching app builder modules
	 */
	public static List<AppBuilderModule> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the app builder modules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @return the range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the app builder modules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder modules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public static AppBuilderModule findByUuid_First(
			String uuid, OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public static AppBuilderModule fetchByUuid_First(
		String uuid, OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public static AppBuilderModule findByUuid_Last(
			String uuid, OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public static AppBuilderModule fetchByUuid_Last(
		String uuid, OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the app builder modules before and after the current app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param appBuilderModuleId the primary key of the current app builder module
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public static AppBuilderModule[] findByUuid_PrevAndNext(
			long appBuilderModuleId, String uuid,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByUuid_PrevAndNext(
			appBuilderModuleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the app builder modules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of app builder modules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching app builder modules
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching app builder modules
	 */
	public static List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @return the range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public static AppBuilderModule findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public static AppBuilderModule fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public static AppBuilderModule findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public static AppBuilderModule fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the app builder modules before and after the current app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appBuilderModuleId the primary key of the current app builder module
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public static AppBuilderModule[] findByUuid_C_PrevAndNext(
			long appBuilderModuleId, String uuid, long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appBuilderModuleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the app builder modules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching app builder modules
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the app builder modules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching app builder modules
	 */
	public static List<AppBuilderModule> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the app builder modules where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @return the range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the app builder modules where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder modules where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app builder modules
	 */
	public static List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public static AppBuilderModule findByCompanyId_First(
			long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public static AppBuilderModule fetchByCompanyId_First(
		long companyId, OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public static AppBuilderModule findByCompanyId_Last(
			long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public static AppBuilderModule fetchByCompanyId_Last(
		long companyId, OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the app builder modules before and after the current app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param appBuilderModuleId the primary key of the current app builder module
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public static AppBuilderModule[] findByCompanyId_PrevAndNext(
			long appBuilderModuleId, long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByCompanyId_PrevAndNext(
			appBuilderModuleId, companyId, orderByComparator);
	}

	/**
	 * Removes all the app builder modules where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of app builder modules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching app builder modules
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Caches the app builder module in the entity cache if it is enabled.
	 *
	 * @param appBuilderModule the app builder module
	 */
	public static void cacheResult(AppBuilderModule appBuilderModule) {
		getPersistence().cacheResult(appBuilderModule);
	}

	/**
	 * Caches the app builder modules in the entity cache if it is enabled.
	 *
	 * @param appBuilderModules the app builder modules
	 */
	public static void cacheResult(List<AppBuilderModule> appBuilderModules) {
		getPersistence().cacheResult(appBuilderModules);
	}

	/**
	 * Creates a new app builder module with the primary key. Does not add the app builder module to the database.
	 *
	 * @param appBuilderModuleId the primary key for the new app builder module
	 * @return the new app builder module
	 */
	public static AppBuilderModule create(long appBuilderModuleId) {
		return getPersistence().create(appBuilderModuleId);
	}

	/**
	 * Removes the app builder module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module that was removed
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public static AppBuilderModule remove(long appBuilderModuleId)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().remove(appBuilderModuleId);
	}

	public static AppBuilderModule updateImpl(
		AppBuilderModule appBuilderModule) {

		return getPersistence().updateImpl(appBuilderModule);
	}

	/**
	 * Returns the app builder module with the primary key or throws a <code>NoSuchAppBuilderModuleException</code> if it could not be found.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public static AppBuilderModule findByPrimaryKey(long appBuilderModuleId)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleException {

		return getPersistence().findByPrimaryKey(appBuilderModuleId);
	}

	/**
	 * Returns the app builder module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module, or <code>null</code> if a app builder module with the primary key could not be found
	 */
	public static AppBuilderModule fetchByPrimaryKey(long appBuilderModuleId) {
		return getPersistence().fetchByPrimaryKey(appBuilderModuleId);
	}

	/**
	 * Returns all the app builder modules.
	 *
	 * @return the app builder modules
	 */
	public static List<AppBuilderModule> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the app builder modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @return the range of app builder modules
	 */
	public static List<AppBuilderModule> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the app builder modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app builder modules
	 */
	public static List<AppBuilderModule> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder modules
	 * @param end the upper bound of the range of app builder modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app builder modules
	 */
	public static List<AppBuilderModule> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the app builder modules from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of app builder modules.
	 *
	 * @return the number of app builder modules
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppBuilderModulePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AppBuilderModulePersistence, AppBuilderModulePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AppBuilderModulePersistence.class);

		ServiceTracker<AppBuilderModulePersistence, AppBuilderModulePersistence>
			serviceTracker =
				new ServiceTracker
					<AppBuilderModulePersistence, AppBuilderModulePersistence>(
						bundle.getBundleContext(),
						AppBuilderModulePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}