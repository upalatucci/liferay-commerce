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

package com.liferay.app.builder.it.service.persistence.impl;

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleFieldException;
import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.app.builder.it.model.AppBuilderModuleFieldTable;
import com.liferay.app.builder.it.model.impl.AppBuilderModuleFieldImpl;
import com.liferay.app.builder.it.model.impl.AppBuilderModuleFieldModelImpl;
import com.liferay.app.builder.it.service.persistence.AppBuilderModuleFieldPersistence;
import com.liferay.app.builder.it.service.persistence.impl.constants.AppBuilderItPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the app builder module field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marco Leo
 * @generated
 */
@Component(
	service = {AppBuilderModuleFieldPersistence.class, BasePersistence.class}
)
public class AppBuilderModuleFieldPersistenceImpl
	extends BasePersistenceImpl<AppBuilderModuleField>
	implements AppBuilderModuleFieldPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppBuilderModuleFieldUtil</code> to access the app builder module field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppBuilderModuleFieldImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the app builder module fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching app builder module fields
	 */
	@Override
	public List<AppBuilderModuleField> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AppBuilderModuleField> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<AppBuilderModuleField> list = null;

		if (useFinderCache) {
			list = (List<AppBuilderModuleField>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AppBuilderModuleField appBuilderModuleField : list) {
					if (!uuid.equals(appBuilderModuleField.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_APPBUILDERMODULEFIELD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppBuilderModuleFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<AppBuilderModuleField>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField findByUuid_First(
			String uuid,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		AppBuilderModuleField appBuilderModuleField = fetchByUuid_First(
			uuid, orderByComparator);

		if (appBuilderModuleField != null) {
			return appBuilderModuleField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppBuilderModuleFieldException(sb.toString());
	}

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField fetchByUuid_First(
		String uuid,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		List<AppBuilderModuleField> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField findByUuid_Last(
			String uuid,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		AppBuilderModuleField appBuilderModuleField = fetchByUuid_Last(
			uuid, orderByComparator);

		if (appBuilderModuleField != null) {
			return appBuilderModuleField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppBuilderModuleFieldException(sb.toString());
	}

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AppBuilderModuleField> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AppBuilderModuleField[] findByUuid_PrevAndNext(
			long appBuilderModuleFieldId, String uuid,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		uuid = Objects.toString(uuid, "");

		AppBuilderModuleField appBuilderModuleField = findByPrimaryKey(
			appBuilderModuleFieldId);

		Session session = null;

		try {
			session = openSession();

			AppBuilderModuleField[] array = new AppBuilderModuleFieldImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appBuilderModuleField, uuid, orderByComparator, true);

			array[1] = appBuilderModuleField;

			array[2] = getByUuid_PrevAndNext(
				session, appBuilderModuleField, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppBuilderModuleField getByUuid_PrevAndNext(
		Session session, AppBuilderModuleField appBuilderModuleField,
		String uuid, OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPBUILDERMODULEFIELD_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AppBuilderModuleFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appBuilderModuleField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppBuilderModuleField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app builder module fields where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AppBuilderModuleField appBuilderModuleField :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appBuilderModuleField);
		}
	}

	/**
	 * Returns the number of app builder module fields where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching app builder module fields
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPBUILDERMODULEFIELD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"appBuilderModuleField.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appBuilderModuleField.uuid IS NULL OR appBuilderModuleField.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching app builder module fields
	 */
	@Override
	public List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<AppBuilderModuleField> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<AppBuilderModuleField> list = null;

		if (useFinderCache) {
			list = (List<AppBuilderModuleField>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AppBuilderModuleField appBuilderModuleField : list) {
					if (!uuid.equals(appBuilderModuleField.getUuid()) ||
						(companyId != appBuilderModuleField.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_APPBUILDERMODULEFIELD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppBuilderModuleFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<AppBuilderModuleField>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public AppBuilderModuleField findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		AppBuilderModuleField appBuilderModuleField = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (appBuilderModuleField != null) {
			return appBuilderModuleField;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppBuilderModuleFieldException(sb.toString());
	}

	/**
	 * Returns the first app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		List<AppBuilderModuleField> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AppBuilderModuleField findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		AppBuilderModuleField appBuilderModuleField = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (appBuilderModuleField != null) {
			return appBuilderModuleField;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppBuilderModuleFieldException(sb.toString());
	}

	/**
	 * Returns the last app builder module field in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AppBuilderModuleField> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AppBuilderModuleField[] findByUuid_C_PrevAndNext(
			long appBuilderModuleFieldId, String uuid, long companyId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		uuid = Objects.toString(uuid, "");

		AppBuilderModuleField appBuilderModuleField = findByPrimaryKey(
			appBuilderModuleFieldId);

		Session session = null;

		try {
			session = openSession();

			AppBuilderModuleField[] array = new AppBuilderModuleFieldImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appBuilderModuleField, uuid, companyId,
				orderByComparator, true);

			array[1] = appBuilderModuleField;

			array[2] = getByUuid_C_PrevAndNext(
				session, appBuilderModuleField, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppBuilderModuleField getByUuid_C_PrevAndNext(
		Session session, AppBuilderModuleField appBuilderModuleField,
		String uuid, long companyId,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_APPBUILDERMODULEFIELD_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AppBuilderModuleFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appBuilderModuleField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppBuilderModuleField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app builder module fields where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AppBuilderModuleField appBuilderModuleField :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appBuilderModuleField);
		}
	}

	/**
	 * Returns the number of app builder module fields where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching app builder module fields
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPBUILDERMODULEFIELD_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"appBuilderModuleField.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appBuilderModuleField.uuid IS NULL OR appBuilderModuleField.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appBuilderModuleField.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByAppBuilderModuleId;
	private FinderPath _finderPathWithoutPaginationFindByAppBuilderModuleId;
	private FinderPath _finderPathCountByAppBuilderModuleId;

	/**
	 * Returns all the app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @return the matching app builder module fields
	 */
	@Override
	public List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId) {

		return findByAppBuilderModuleId(
			appBuilderModuleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end) {

		return findByAppBuilderModuleId(appBuilderModuleId, start, end, null);
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
	@Override
	public List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return findByAppBuilderModuleId(
			appBuilderModuleId, start, end, orderByComparator, true);
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
	@Override
	public List<AppBuilderModuleField> findByAppBuilderModuleId(
		long appBuilderModuleId, int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAppBuilderModuleId;
				finderArgs = new Object[] {appBuilderModuleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAppBuilderModuleId;
			finderArgs = new Object[] {
				appBuilderModuleId, start, end, orderByComparator
			};
		}

		List<AppBuilderModuleField> list = null;

		if (useFinderCache) {
			list = (List<AppBuilderModuleField>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AppBuilderModuleField appBuilderModuleField : list) {
					if (appBuilderModuleId !=
							appBuilderModuleField.getAppBuilderModuleId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_APPBUILDERMODULEFIELD_WHERE);

			sb.append(_FINDER_COLUMN_APPBUILDERMODULEID_APPBUILDERMODULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppBuilderModuleFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appBuilderModuleId);

				list = (List<AppBuilderModuleField>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField findByAppBuilderModuleId_First(
			long appBuilderModuleId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		AppBuilderModuleField appBuilderModuleField =
			fetchByAppBuilderModuleId_First(
				appBuilderModuleId, orderByComparator);

		if (appBuilderModuleField != null) {
			return appBuilderModuleField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appBuilderModuleId=");
		sb.append(appBuilderModuleId);

		sb.append("}");

		throw new NoSuchAppBuilderModuleFieldException(sb.toString());
	}

	/**
	 * Returns the first app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField fetchByAppBuilderModuleId_First(
		long appBuilderModuleId,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		List<AppBuilderModuleField> list = findByAppBuilderModuleId(
			appBuilderModuleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField findByAppBuilderModuleId_Last(
			long appBuilderModuleId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		AppBuilderModuleField appBuilderModuleField =
			fetchByAppBuilderModuleId_Last(
				appBuilderModuleId, orderByComparator);

		if (appBuilderModuleField != null) {
			return appBuilderModuleField;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appBuilderModuleId=");
		sb.append(appBuilderModuleId);

		sb.append("}");

		throw new NoSuchAppBuilderModuleFieldException(sb.toString());
	}

	/**
	 * Returns the last app builder module field in the ordered set where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module field, or <code>null</code> if a matching app builder module field could not be found
	 */
	@Override
	public AppBuilderModuleField fetchByAppBuilderModuleId_Last(
		long appBuilderModuleId,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		int count = countByAppBuilderModuleId(appBuilderModuleId);

		if (count == 0) {
			return null;
		}

		List<AppBuilderModuleField> list = findByAppBuilderModuleId(
			appBuilderModuleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AppBuilderModuleField[] findByAppBuilderModuleId_PrevAndNext(
			long appBuilderModuleFieldId, long appBuilderModuleId,
			OrderByComparator<AppBuilderModuleField> orderByComparator)
		throws NoSuchAppBuilderModuleFieldException {

		AppBuilderModuleField appBuilderModuleField = findByPrimaryKey(
			appBuilderModuleFieldId);

		Session session = null;

		try {
			session = openSession();

			AppBuilderModuleField[] array = new AppBuilderModuleFieldImpl[3];

			array[0] = getByAppBuilderModuleId_PrevAndNext(
				session, appBuilderModuleField, appBuilderModuleId,
				orderByComparator, true);

			array[1] = appBuilderModuleField;

			array[2] = getByAppBuilderModuleId_PrevAndNext(
				session, appBuilderModuleField, appBuilderModuleId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppBuilderModuleField getByAppBuilderModuleId_PrevAndNext(
		Session session, AppBuilderModuleField appBuilderModuleField,
		long appBuilderModuleId,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPBUILDERMODULEFIELD_WHERE);

		sb.append(_FINDER_COLUMN_APPBUILDERMODULEID_APPBUILDERMODULEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AppBuilderModuleFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(appBuilderModuleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appBuilderModuleField)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppBuilderModuleField> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app builder module fields where appBuilderModuleId = &#63; from the database.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 */
	@Override
	public void removeByAppBuilderModuleId(long appBuilderModuleId) {
		for (AppBuilderModuleField appBuilderModuleField :
				findByAppBuilderModuleId(
					appBuilderModuleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appBuilderModuleField);
		}
	}

	/**
	 * Returns the number of app builder module fields where appBuilderModuleId = &#63;.
	 *
	 * @param appBuilderModuleId the app builder module ID
	 * @return the number of matching app builder module fields
	 */
	@Override
	public int countByAppBuilderModuleId(long appBuilderModuleId) {
		FinderPath finderPath = _finderPathCountByAppBuilderModuleId;

		Object[] finderArgs = new Object[] {appBuilderModuleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPBUILDERMODULEFIELD_WHERE);

			sb.append(_FINDER_COLUMN_APPBUILDERMODULEID_APPBUILDERMODULEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appBuilderModuleId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_APPBUILDERMODULEID_APPBUILDERMODULEID_2 =
			"appBuilderModuleField.appBuilderModuleId = ?";

	public AppBuilderModuleFieldPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AppBuilderModuleField.class);

		setModelImplClass(AppBuilderModuleFieldImpl.class);
		setModelPKClass(long.class);

		setTable(AppBuilderModuleFieldTable.INSTANCE);
	}

	/**
	 * Caches the app builder module field in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleField the app builder module field
	 */
	@Override
	public void cacheResult(AppBuilderModuleField appBuilderModuleField) {
		entityCache.putResult(
			AppBuilderModuleFieldImpl.class,
			appBuilderModuleField.getPrimaryKey(), appBuilderModuleField);
	}

	/**
	 * Caches the app builder module fields in the entity cache if it is enabled.
	 *
	 * @param appBuilderModuleFields the app builder module fields
	 */
	@Override
	public void cacheResult(
		List<AppBuilderModuleField> appBuilderModuleFields) {

		for (AppBuilderModuleField appBuilderModuleField :
				appBuilderModuleFields) {

			if (entityCache.getResult(
					AppBuilderModuleFieldImpl.class,
					appBuilderModuleField.getPrimaryKey()) == null) {

				cacheResult(appBuilderModuleField);
			}
		}
	}

	/**
	 * Clears the cache for all app builder module fields.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppBuilderModuleFieldImpl.class);

		finderCache.clearCache(AppBuilderModuleFieldImpl.class);
	}

	/**
	 * Clears the cache for the app builder module field.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppBuilderModuleField appBuilderModuleField) {
		entityCache.removeResult(
			AppBuilderModuleFieldImpl.class, appBuilderModuleField);
	}

	@Override
	public void clearCache(List<AppBuilderModuleField> appBuilderModuleFields) {
		for (AppBuilderModuleField appBuilderModuleField :
				appBuilderModuleFields) {

			entityCache.removeResult(
				AppBuilderModuleFieldImpl.class, appBuilderModuleField);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppBuilderModuleFieldImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AppBuilderModuleFieldImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new app builder module field with the primary key. Does not add the app builder module field to the database.
	 *
	 * @param appBuilderModuleFieldId the primary key for the new app builder module field
	 * @return the new app builder module field
	 */
	@Override
	public AppBuilderModuleField create(long appBuilderModuleFieldId) {
		AppBuilderModuleField appBuilderModuleField =
			new AppBuilderModuleFieldImpl();

		appBuilderModuleField.setNew(true);
		appBuilderModuleField.setPrimaryKey(appBuilderModuleFieldId);

		String uuid = PortalUUIDUtil.generate();

		appBuilderModuleField.setUuid(uuid);

		appBuilderModuleField.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appBuilderModuleField;
	}

	/**
	 * Removes the app builder module field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field that was removed
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	@Override
	public AppBuilderModuleField remove(long appBuilderModuleFieldId)
		throws NoSuchAppBuilderModuleFieldException {

		return remove((Serializable)appBuilderModuleFieldId);
	}

	/**
	 * Removes the app builder module field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the app builder module field
	 * @return the app builder module field that was removed
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	@Override
	public AppBuilderModuleField remove(Serializable primaryKey)
		throws NoSuchAppBuilderModuleFieldException {

		Session session = null;

		try {
			session = openSession();

			AppBuilderModuleField appBuilderModuleField =
				(AppBuilderModuleField)session.get(
					AppBuilderModuleFieldImpl.class, primaryKey);

			if (appBuilderModuleField == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppBuilderModuleFieldException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appBuilderModuleField);
		}
		catch (NoSuchAppBuilderModuleFieldException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AppBuilderModuleField removeImpl(
		AppBuilderModuleField appBuilderModuleField) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appBuilderModuleField)) {
				appBuilderModuleField = (AppBuilderModuleField)session.get(
					AppBuilderModuleFieldImpl.class,
					appBuilderModuleField.getPrimaryKeyObj());
			}

			if (appBuilderModuleField != null) {
				session.delete(appBuilderModuleField);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appBuilderModuleField != null) {
			clearCache(appBuilderModuleField);
		}

		return appBuilderModuleField;
	}

	@Override
	public AppBuilderModuleField updateImpl(
		AppBuilderModuleField appBuilderModuleField) {

		boolean isNew = appBuilderModuleField.isNew();

		if (!(appBuilderModuleField instanceof
				AppBuilderModuleFieldModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appBuilderModuleField.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appBuilderModuleField);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appBuilderModuleField proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppBuilderModuleField implementation " +
					appBuilderModuleField.getClass());
		}

		AppBuilderModuleFieldModelImpl appBuilderModuleFieldModelImpl =
			(AppBuilderModuleFieldModelImpl)appBuilderModuleField;

		if (Validator.isNull(appBuilderModuleField.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appBuilderModuleField.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (appBuilderModuleField.getCreateDate() == null)) {
			if (serviceContext == null) {
				appBuilderModuleField.setCreateDate(now);
			}
			else {
				appBuilderModuleField.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!appBuilderModuleFieldModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appBuilderModuleField.setModifiedDate(now);
			}
			else {
				appBuilderModuleField.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appBuilderModuleField);
			}
			else {
				appBuilderModuleField = (AppBuilderModuleField)session.merge(
					appBuilderModuleField);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppBuilderModuleFieldImpl.class, appBuilderModuleFieldModelImpl,
			false, true);

		if (isNew) {
			appBuilderModuleField.setNew(false);
		}

		appBuilderModuleField.resetOriginalValues();

		return appBuilderModuleField;
	}

	/**
	 * Returns the app builder module field with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the app builder module field
	 * @return the app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	@Override
	public AppBuilderModuleField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppBuilderModuleFieldException {

		AppBuilderModuleField appBuilderModuleField = fetchByPrimaryKey(
			primaryKey);

		if (appBuilderModuleField == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppBuilderModuleFieldException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appBuilderModuleField;
	}

	/**
	 * Returns the app builder module field with the primary key or throws a <code>NoSuchAppBuilderModuleFieldException</code> if it could not be found.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field
	 * @throws NoSuchAppBuilderModuleFieldException if a app builder module field with the primary key could not be found
	 */
	@Override
	public AppBuilderModuleField findByPrimaryKey(long appBuilderModuleFieldId)
		throws NoSuchAppBuilderModuleFieldException {

		return findByPrimaryKey((Serializable)appBuilderModuleFieldId);
	}

	/**
	 * Returns the app builder module field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appBuilderModuleFieldId the primary key of the app builder module field
	 * @return the app builder module field, or <code>null</code> if a app builder module field with the primary key could not be found
	 */
	@Override
	public AppBuilderModuleField fetchByPrimaryKey(
		long appBuilderModuleFieldId) {

		return fetchByPrimaryKey((Serializable)appBuilderModuleFieldId);
	}

	/**
	 * Returns all the app builder module fields.
	 *
	 * @return the app builder module fields
	 */
	@Override
	public List<AppBuilderModuleField> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AppBuilderModuleField> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AppBuilderModuleField> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AppBuilderModuleField> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModuleField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AppBuilderModuleField> list = null;

		if (useFinderCache) {
			list = (List<AppBuilderModuleField>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPBUILDERMODULEFIELD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPBUILDERMODULEFIELD;

				sql = sql.concat(AppBuilderModuleFieldModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppBuilderModuleField>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the app builder module fields from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppBuilderModuleField appBuilderModuleField : findAll()) {
			remove(appBuilderModuleField);
		}
	}

	/**
	 * Returns the number of app builder module fields.
	 *
	 * @return the number of app builder module fields
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_APPBUILDERMODULEFIELD);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "appBuilderModuleFieldId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPBUILDERMODULEFIELD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppBuilderModuleFieldModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the app builder module field persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AppBuilderModuleFieldModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByAppBuilderModuleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppBuilderModuleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"appBuilderModuleId"}, true);

		_finderPathWithoutPaginationFindByAppBuilderModuleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAppBuilderModuleId", new String[] {Long.class.getName()},
			new String[] {"appBuilderModuleId"}, true);

		_finderPathCountByAppBuilderModuleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAppBuilderModuleId", new String[] {Long.class.getName()},
			new String[] {"appBuilderModuleId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AppBuilderModuleFieldImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = AppBuilderItPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AppBuilderItPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AppBuilderItPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_APPBUILDERMODULEFIELD =
		"SELECT appBuilderModuleField FROM AppBuilderModuleField appBuilderModuleField";

	private static final String _SQL_SELECT_APPBUILDERMODULEFIELD_WHERE =
		"SELECT appBuilderModuleField FROM AppBuilderModuleField appBuilderModuleField WHERE ";

	private static final String _SQL_COUNT_APPBUILDERMODULEFIELD =
		"SELECT COUNT(appBuilderModuleField) FROM AppBuilderModuleField appBuilderModuleField";

	private static final String _SQL_COUNT_APPBUILDERMODULEFIELD_WHERE =
		"SELECT COUNT(appBuilderModuleField) FROM AppBuilderModuleField appBuilderModuleField WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"appBuilderModuleField.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppBuilderModuleField exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppBuilderModuleField exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppBuilderModuleFieldPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AppBuilderModuleFieldModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			AppBuilderModuleFieldModelImpl appBuilderModuleFieldModelImpl =
				(AppBuilderModuleFieldModelImpl)baseModel;

			long columnBitmask =
				appBuilderModuleFieldModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					appBuilderModuleFieldModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						appBuilderModuleFieldModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					appBuilderModuleFieldModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return AppBuilderModuleFieldImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return AppBuilderModuleFieldTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			AppBuilderModuleFieldModelImpl appBuilderModuleFieldModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						appBuilderModuleFieldModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						appBuilderModuleFieldModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}