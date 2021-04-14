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

import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
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
 * The persistence utility for the app builder module entry service. This utility wraps <code>com.liferay.app.builder.it.service.persistence.impl.AppBuilderModuleEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModuleEntryPersistence
 * @generated
 */
public class AppBuilderModuleEntryUtil {

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
	public static void clearCache(AppBuilderModuleEntry appBuilderModuleEntry) {
		getPersistence().clearCache(appBuilderModuleEntry);
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
	public static Map<Serializable, AppBuilderModuleEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppBuilderModuleEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppBuilderModuleEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppBuilderModuleEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppBuilderModuleEntry update(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		return getPersistence().update(appBuilderModuleEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppBuilderModuleEntry update(
		AppBuilderModuleEntry appBuilderModuleEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(appBuilderModuleEntry, serviceContext);
	}

	/**
	 * Returns all the app builder module entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the app builder module entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @return the range of matching app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the app builder module entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder module entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry findByUuid_First(
			String uuid,
			OrderByComparator<AppBuilderModuleEntry> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry findByUuid_Last(
			String uuid,
			OrderByComparator<AppBuilderModuleEntry> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the app builder module entries before and after the current app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param appBuilderModuleEntryId the primary key of the current app builder module entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a app builder module entry with the primary key could not be found
	 */
	public static AppBuilderModuleEntry[] findByUuid_PrevAndNext(
			long appBuilderModuleEntryId, String uuid,
			OrderByComparator<AppBuilderModuleEntry> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			appBuilderModuleEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the app builder module entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of app builder module entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching app builder module entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the app builder module entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppBuilderModuleEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry findByUUID_G(String uuid, long groupId)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the app builder module entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the app builder module entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the app builder module entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the app builder module entry that was removed
	 */
	public static AppBuilderModuleEntry removeByUUID_G(
			String uuid, long groupId)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of app builder module entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching app builder module entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the app builder module entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the app builder module entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @return the range of matching app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the app builder module entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder module entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModuleEntry> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModuleEntry> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public static AppBuilderModuleEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the app builder module entries before and after the current app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appBuilderModuleEntryId the primary key of the current app builder module entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a app builder module entry with the primary key could not be found
	 */
	public static AppBuilderModuleEntry[] findByUuid_C_PrevAndNext(
			long appBuilderModuleEntryId, String uuid, long companyId,
			OrderByComparator<AppBuilderModuleEntry> orderByComparator)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appBuilderModuleEntryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the app builder module entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of app builder module entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching app builder module entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the app builder module entry in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleEntry the app builder module entry
	 */
	public static void cacheResult(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		getPersistence().cacheResult(appBuilderModuleEntry);
	}

	/**
	 * Caches the app builder module entries in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleEntries the app builder module entries
	 */
	public static void cacheResult(
		List<AppBuilderModuleEntry> appBuilderModuleEntries) {

		getPersistence().cacheResult(appBuilderModuleEntries);
	}

	/**
	 * Creates a new app builder module entry with the primary key. Does not add the app builder module entry to the database.
	 *
	 * @param appBuilderModuleEntryId the primary key for the new app builder module entry
	 * @return the new app builder module entry
	 */
	public static AppBuilderModuleEntry create(long appBuilderModuleEntryId) {
		return getPersistence().create(appBuilderModuleEntryId);
	}

	/**
	 * Removes the app builder module entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry that was removed
	 * @throws NoSuchAppBuilderModuleEntryException if a app builder module entry with the primary key could not be found
	 */
	public static AppBuilderModuleEntry remove(long appBuilderModuleEntryId)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().remove(appBuilderModuleEntryId);
	}

	public static AppBuilderModuleEntry updateImpl(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		return getPersistence().updateImpl(appBuilderModuleEntry);
	}

	/**
	 * Returns the app builder module entry with the primary key or throws a <code>NoSuchAppBuilderModuleEntryException</code> if it could not be found.
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a app builder module entry with the primary key could not be found
	 */
	public static AppBuilderModuleEntry findByPrimaryKey(
			long appBuilderModuleEntryId)
		throws com.liferay.app.builder.it.exception.
			NoSuchAppBuilderModuleEntryException {

		return getPersistence().findByPrimaryKey(appBuilderModuleEntryId);
	}

	/**
	 * Returns the app builder module entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry, or <code>null</code> if a app builder module entry with the primary key could not be found
	 */
	public static AppBuilderModuleEntry fetchByPrimaryKey(
		long appBuilderModuleEntryId) {

		return getPersistence().fetchByPrimaryKey(appBuilderModuleEntryId);
	}

	/**
	 * Returns all the app builder module entries.
	 *
	 * @return the app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the app builder module entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @return the range of app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the app builder module entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app builder module entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppBuilderModuleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder module entries
	 * @param end the upper bound of the range of app builder module entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app builder module entries
	 */
	public static List<AppBuilderModuleEntry> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModuleEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the app builder module entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of app builder module entries.
	 *
	 * @return the number of app builder module entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppBuilderModuleEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AppBuilderModuleEntryPersistence, AppBuilderModuleEntryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AppBuilderModuleEntryPersistence.class);

		ServiceTracker
			<AppBuilderModuleEntryPersistence, AppBuilderModuleEntryPersistence>
				serviceTracker =
					new ServiceTracker
						<AppBuilderModuleEntryPersistence,
						 AppBuilderModuleEntryPersistence>(
							 bundle.getBundleContext(),
							 AppBuilderModuleEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}