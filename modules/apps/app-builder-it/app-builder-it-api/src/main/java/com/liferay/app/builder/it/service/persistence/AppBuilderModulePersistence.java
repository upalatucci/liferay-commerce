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

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleException;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the app builder module service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModuleUtil
 * @generated
 */
@ProviderType
public interface AppBuilderModulePersistence
	extends BasePersistence<AppBuilderModule> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppBuilderModuleUtil} to access the app builder module persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the app builder modules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching app builder modules
	 */
	public java.util.List<AppBuilderModule> findByUuid(String uuid);

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
	public java.util.List<AppBuilderModule> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AppBuilderModule> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

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
	public java.util.List<AppBuilderModule> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public AppBuilderModule findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public AppBuilderModule fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public AppBuilderModule findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public AppBuilderModule fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

	/**
	 * Returns the app builder modules before and after the current app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param appBuilderModuleId the primary key of the current app builder module
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public AppBuilderModule[] findByUuid_PrevAndNext(
			long appBuilderModuleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Removes all the app builder modules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of app builder modules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching app builder modules
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching app builder modules
	 */
	public java.util.List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

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
	public java.util.List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public AppBuilderModule findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public AppBuilderModule fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public AppBuilderModule findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public AppBuilderModule fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

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
	public AppBuilderModule[] findByUuid_C_PrevAndNext(
			long appBuilderModuleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Removes all the app builder modules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching app builder modules
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the app builder modules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching app builder modules
	 */
	public java.util.List<AppBuilderModule> findByCompanyId(long companyId);

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
	public java.util.List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

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
	public java.util.List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public AppBuilderModule findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Returns the first app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public AppBuilderModule fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

	/**
	 * Returns the last app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	public AppBuilderModule findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Returns the last app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	public AppBuilderModule fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

	/**
	 * Returns the app builder modules before and after the current app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param appBuilderModuleId the primary key of the current app builder module
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public AppBuilderModule[] findByCompanyId_PrevAndNext(
			long appBuilderModuleId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
				orderByComparator)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Removes all the app builder modules where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of app builder modules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching app builder modules
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Caches the app builder module in the entity cache if it is enabled.
	 *
	 * @param appBuilderModule the app builder module
	 */
	public void cacheResult(AppBuilderModule appBuilderModule);

	/**
	 * Caches the app builder modules in the entity cache if it is enabled.
	 *
	 * @param appBuilderModules the app builder modules
	 */
	public void cacheResult(java.util.List<AppBuilderModule> appBuilderModules);

	/**
	 * Creates a new app builder module with the primary key. Does not add the app builder module to the database.
	 *
	 * @param appBuilderModuleId the primary key for the new app builder module
	 * @return the new app builder module
	 */
	public AppBuilderModule create(long appBuilderModuleId);

	/**
	 * Removes the app builder module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module that was removed
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public AppBuilderModule remove(long appBuilderModuleId)
		throws NoSuchAppBuilderModuleException;

	public AppBuilderModule updateImpl(AppBuilderModule appBuilderModule);

	/**
	 * Returns the app builder module with the primary key or throws a <code>NoSuchAppBuilderModuleException</code> if it could not be found.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	public AppBuilderModule findByPrimaryKey(long appBuilderModuleId)
		throws NoSuchAppBuilderModuleException;

	/**
	 * Returns the app builder module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module, or <code>null</code> if a app builder module with the primary key could not be found
	 */
	public AppBuilderModule fetchByPrimaryKey(long appBuilderModuleId);

	/**
	 * Returns all the app builder modules.
	 *
	 * @return the app builder modules
	 */
	public java.util.List<AppBuilderModule> findAll();

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
	public java.util.List<AppBuilderModule> findAll(int start, int end);

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
	public java.util.List<AppBuilderModule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator);

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
	public java.util.List<AppBuilderModule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the app builder modules from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of app builder modules.
	 *
	 * @return the number of app builder modules
	 */
	public int countAll();

}