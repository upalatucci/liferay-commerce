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

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleEntryException;
import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the app builder module entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModuleEntryUtil
 * @generated
 */
@ProviderType
public interface AppBuilderModuleEntryPersistence
	extends BasePersistence<AppBuilderModuleEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppBuilderModuleEntryUtil} to access the app builder module entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the app builder module entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching app builder module entries
	 */
	public java.util.List<AppBuilderModuleEntry> findByUuid(String uuid);

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
	public java.util.List<AppBuilderModuleEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AppBuilderModuleEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator);

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
	public java.util.List<AppBuilderModuleEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleEntry> orderByComparator)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Returns the first app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator);

	/**
	 * Returns the last app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleEntry> orderByComparator)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Returns the last app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator);

	/**
	 * Returns the app builder module entries before and after the current app builder module entry in the ordered set where uuid = &#63;.
	 *
	 * @param appBuilderModuleEntryId the primary key of the current app builder module entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a app builder module entry with the primary key could not be found
	 */
	public AppBuilderModuleEntry[] findByUuid_PrevAndNext(
			long appBuilderModuleEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleEntry> orderByComparator)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Removes all the app builder module entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of app builder module entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching app builder module entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the app builder module entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppBuilderModuleEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Returns the app builder module entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the app builder module entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the app builder module entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the app builder module entry that was removed
	 */
	public AppBuilderModuleEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Returns the number of app builder module entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching app builder module entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the app builder module entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching app builder module entries
	 */
	public java.util.List<AppBuilderModuleEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AppBuilderModuleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AppBuilderModuleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator);

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
	public java.util.List<AppBuilderModuleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleEntry> orderByComparator)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Returns the first app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator);

	/**
	 * Returns the last app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleEntry> orderByComparator)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Returns the last app builder module entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module entry, or <code>null</code> if a matching app builder module entry could not be found
	 */
	public AppBuilderModuleEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator);

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
	public AppBuilderModuleEntry[] findByUuid_C_PrevAndNext(
			long appBuilderModuleEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleEntry> orderByComparator)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Removes all the app builder module entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of app builder module entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching app builder module entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the app builder module entry in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleEntry the app builder module entry
	 */
	public void cacheResult(AppBuilderModuleEntry appBuilderModuleEntry);

	/**
	 * Caches the app builder module entries in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleEntries the app builder module entries
	 */
	public void cacheResult(
		java.util.List<AppBuilderModuleEntry> appBuilderModuleEntries);

	/**
	 * Creates a new app builder module entry with the primary key. Does not add the app builder module entry to the database.
	 *
	 * @param appBuilderModuleEntryId the primary key for the new app builder module entry
	 * @return the new app builder module entry
	 */
	public AppBuilderModuleEntry create(long appBuilderModuleEntryId);

	/**
	 * Removes the app builder module entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry that was removed
	 * @throws NoSuchAppBuilderModuleEntryException if a app builder module entry with the primary key could not be found
	 */
	public AppBuilderModuleEntry remove(long appBuilderModuleEntryId)
		throws NoSuchAppBuilderModuleEntryException;

	public AppBuilderModuleEntry updateImpl(
		AppBuilderModuleEntry appBuilderModuleEntry);

	/**
	 * Returns the app builder module entry with the primary key or throws a <code>NoSuchAppBuilderModuleEntryException</code> if it could not be found.
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry
	 * @throws NoSuchAppBuilderModuleEntryException if a app builder module entry with the primary key could not be found
	 */
	public AppBuilderModuleEntry findByPrimaryKey(long appBuilderModuleEntryId)
		throws NoSuchAppBuilderModuleEntryException;

	/**
	 * Returns the app builder module entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appBuilderModuleEntryId the primary key of the app builder module entry
	 * @return the app builder module entry, or <code>null</code> if a app builder module entry with the primary key could not be found
	 */
	public AppBuilderModuleEntry fetchByPrimaryKey(
		long appBuilderModuleEntryId);

	/**
	 * Returns all the app builder module entries.
	 *
	 * @return the app builder module entries
	 */
	public java.util.List<AppBuilderModuleEntry> findAll();

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
	public java.util.List<AppBuilderModuleEntry> findAll(int start, int end);

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
	public java.util.List<AppBuilderModuleEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator);

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
	public java.util.List<AppBuilderModuleEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the app builder module entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of app builder module entries.
	 *
	 * @return the number of app builder module entries
	 */
	public int countAll();

}