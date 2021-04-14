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

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleFieldException;
import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the app builder module field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModuleFieldUtil
 * @generated
 */
@ProviderType
public interface AppBuilderModuleFieldPersistence
	extends BasePersistence<AppBuilderModuleField> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppBuilderModuleFieldUtil} to access the app builder module field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the app builder module fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching app builder module fields
	 */
	public java.util.List<AppBuilderModuleField> findByUuid(String uuid);

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
	public java.util.List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

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
	public java.util.List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

	/**
	 * Returns the app builder module fields before and after the current app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param appBuilderModuleFieldId the primary key of the current app builder module field
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public AppBuilderModuleField[] findByUuid_PrevAndNext(
			long appBuilderModuleFieldId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Removes all the app builder module fields where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of app builder module fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching app builder module fields
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching app builder module fields
	 */
	public java.util.List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

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
	public java.util.List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

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
	public AppBuilderModuleField[] findByUuid_C_PrevAndNext(
			long appBuilderModuleFieldId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Removes all the app builder module fields where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching app builder module fields
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @return the matching app builder module fields
	 */
	public java.util.List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId);

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
	public java.util.List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end);

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
	public java.util.List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

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
	public java.util.List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField findByAppBuilderModuleId_First(
			long appBuilderModuleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Returns the first app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField fetchByAppBuilderModuleId_First(
		long appBuilderModuleId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

	/**
	 * Returns the last app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField findByAppBuilderModuleId_Last(
			long appBuilderModuleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Returns the last app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	public AppBuilderModuleField fetchByAppBuilderModuleId_Last(
		long appBuilderModuleId,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

	/**
	 * Returns the app builder module fields before and after the current app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleFieldId the primary key of the current app builder module field
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public AppBuilderModuleField[] findByAppBuilderModuleId_PrevAndNext(
			long appBuilderModuleFieldId, long appBuilderModuleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Removes all the app builder module fields where appBuilderModuleId = &#63; from the database.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 */
	public void removeByAppBuilderModuleId(long appBuilderModuleId);

	/**
	 * Returns the number of app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @return the number of matching app builder module fields
	 */
	public int countByAppBuilderModuleId(long appBuilderModuleId);

	/**
	 * Caches the app builder module field in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleField the app builder module field
	 */
	public void cacheResult(AppBuilderModuleField appBuilderModuleField);

	/**
	 * Caches the app builder module fields in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleFields the app builder module fields
	 */
	public void cacheResult(
		java.util.List<AppBuilderModuleField> appBuilderModuleFields);

	/**
	 * Creates a new app builder module field with the primary key. Does not add the app builder module field to the database.
	 *
	 * @param appBuilderModuleFieldId the primary key for the new app builder module field
	 * @return the new app builder module field
	 */
	public AppBuilderModuleField create(long appBuilderModuleFieldId);

	/**
	 * Removes the app builder module field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field that was removed
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public AppBuilderModuleField remove(long appBuilderModuleFieldId)
		throws NoSuchAppBuilderModuleFieldException;

	public AppBuilderModuleField updateImpl(
		AppBuilderModuleField appBuilderModuleField);

	/**
	 * Returns the app builder module field with the primary key or throws a <code>NoSuchAppBuilderModuleFieldException</code> if it could not be found.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	public AppBuilderModuleField findByPrimaryKey(long appBuilderModuleFieldId)
		throws NoSuchAppBuilderModuleFieldException;

	/**
	 * Returns the app builder module field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field, or <code>null</code> if a app builder module field with the primary key could not be found
	 */
	public AppBuilderModuleField fetchByPrimaryKey(
		long appBuilderModuleFieldId);

	/**
	 * Returns all the app builder module fields.
	 *
	 * @return the app builder module fields
	 */
	public java.util.List<AppBuilderModuleField> findAll();

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
	public java.util.List<AppBuilderModuleField> findAll(int start, int end);

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
	public java.util.List<AppBuilderModuleField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator);

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
	public java.util.List<AppBuilderModuleField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppBuilderModuleField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the app builder module fields from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of app builder module fields.
	 *
	 * @return the number of app builder module fields
	 */
	public int countAll();

}