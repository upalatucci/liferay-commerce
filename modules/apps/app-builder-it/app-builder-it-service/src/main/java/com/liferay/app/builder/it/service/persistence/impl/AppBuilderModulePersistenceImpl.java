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

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleException;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleTable;
import com.liferay.app.builder.it.model.impl.AppBuilderModuleImpl;
import com.liferay.app.builder.it.model.impl.AppBuilderModuleModelImpl;
import com.liferay.app.builder.it.service.persistence.AppBuilderModulePersistence;
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
 * The persistence implementation for the app builder module service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marco Leo
 * @generated
 */
@Component(service = {AppBuilderModulePersistence.class, BasePersistence.class})
public class AppBuilderModulePersistenceImpl
	extends BasePersistenceImpl<AppBuilderModule>
	implements AppBuilderModulePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppBuilderModuleUtil</code> to access the app builder module persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppBuilderModuleImpl.class.getName();

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
	 * Returns all the app builder modules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching app builder modules
	 */
	@Override
	public List<AppBuilderModule> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AppBuilderModule> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AppBuilderModule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AppBuilderModule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator,
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

		List<AppBuilderModule> list = null;

		if (useFinderCache) {
			list = (List<AppBuilderModule>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AppBuilderModule appBuilderModule : list) {
					if (!uuid.equals(appBuilderModule.getUuid())) {
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

			sb.append(_SQL_SELECT_APPBUILDERMODULE_WHERE);

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
				sb.append(AppBuilderModuleModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppBuilderModule>)QueryUtil.list(
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
	 * Returns the first app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule findByUuid_First(
			String uuid, OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		AppBuilderModule appBuilderModule = fetchByUuid_First(
			uuid, orderByComparator);

		if (appBuilderModule != null) {
			return appBuilderModule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppBuilderModuleException(sb.toString());
	}

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule fetchByUuid_First(
		String uuid, OrderByComparator<AppBuilderModule> orderByComparator) {

		List<AppBuilderModule> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule findByUuid_Last(
			String uuid, OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		AppBuilderModule appBuilderModule = fetchByUuid_Last(
			uuid, orderByComparator);

		if (appBuilderModule != null) {
			return appBuilderModule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppBuilderModuleException(sb.toString());
	}

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule fetchByUuid_Last(
		String uuid, OrderByComparator<AppBuilderModule> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AppBuilderModule> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AppBuilderModule[] findByUuid_PrevAndNext(
			long appBuilderModuleId, String uuid,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		uuid = Objects.toString(uuid, "");

		AppBuilderModule appBuilderModule = findByPrimaryKey(
			appBuilderModuleId);

		Session session = null;

		try {
			session = openSession();

			AppBuilderModule[] array = new AppBuilderModuleImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appBuilderModule, uuid, orderByComparator, true);

			array[1] = appBuilderModule;

			array[2] = getByUuid_PrevAndNext(
				session, appBuilderModule, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppBuilderModule getByUuid_PrevAndNext(
		Session session, AppBuilderModule appBuilderModule, String uuid,
		OrderByComparator<AppBuilderModule> orderByComparator,
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

		sb.append(_SQL_SELECT_APPBUILDERMODULE_WHERE);

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
			sb.append(AppBuilderModuleModelImpl.ORDER_BY_JPQL);
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
						appBuilderModule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppBuilderModule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app builder modules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AppBuilderModule appBuilderModule :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appBuilderModule);
		}
	}

	/**
	 * Returns the number of app builder modules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching app builder modules
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPBUILDERMODULE_WHERE);

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
		"appBuilderModule.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appBuilderModule.uuid IS NULL OR appBuilderModule.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching app builder modules
	 */
	@Override
	public List<AppBuilderModule> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<AppBuilderModule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator,
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

		List<AppBuilderModule> list = null;

		if (useFinderCache) {
			list = (List<AppBuilderModule>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AppBuilderModule appBuilderModule : list) {
					if (!uuid.equals(appBuilderModule.getUuid()) ||
						(companyId != appBuilderModule.getCompanyId())) {

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

			sb.append(_SQL_SELECT_APPBUILDERMODULE_WHERE);

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
				sb.append(AppBuilderModuleModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppBuilderModule>)QueryUtil.list(
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
	 * Returns the first app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		AppBuilderModule appBuilderModule = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (appBuilderModule != null) {
			return appBuilderModule;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppBuilderModuleException(sb.toString());
	}

	/**
	 * Returns the first app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		List<AppBuilderModule> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AppBuilderModule findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		AppBuilderModule appBuilderModule = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (appBuilderModule != null) {
			return appBuilderModule;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppBuilderModuleException(sb.toString());
	}

	/**
	 * Returns the last app builder module in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AppBuilderModule> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AppBuilderModule[] findByUuid_C_PrevAndNext(
			long appBuilderModuleId, String uuid, long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		uuid = Objects.toString(uuid, "");

		AppBuilderModule appBuilderModule = findByPrimaryKey(
			appBuilderModuleId);

		Session session = null;

		try {
			session = openSession();

			AppBuilderModule[] array = new AppBuilderModuleImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appBuilderModule, uuid, companyId, orderByComparator,
				true);

			array[1] = appBuilderModule;

			array[2] = getByUuid_C_PrevAndNext(
				session, appBuilderModule, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppBuilderModule getByUuid_C_PrevAndNext(
		Session session, AppBuilderModule appBuilderModule, String uuid,
		long companyId, OrderByComparator<AppBuilderModule> orderByComparator,
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

		sb.append(_SQL_SELECT_APPBUILDERMODULE_WHERE);

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
			sb.append(AppBuilderModuleModelImpl.ORDER_BY_JPQL);
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
						appBuilderModule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppBuilderModule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app builder modules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AppBuilderModule appBuilderModule :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appBuilderModule);
		}
	}

	/**
	 * Returns the number of app builder modules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching app builder modules
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPBUILDERMODULE_WHERE);

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
		"appBuilderModule.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appBuilderModule.uuid IS NULL OR appBuilderModule.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appBuilderModule.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the app builder modules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching app builder modules
	 */
	@Override
	public List<AppBuilderModule> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<AppBuilderModule> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<AppBuilderModule> list = null;

		if (useFinderCache) {
			list = (List<AppBuilderModule>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AppBuilderModule appBuilderModule : list) {
					if (companyId != appBuilderModule.getCompanyId()) {
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

			sb.append(_SQL_SELECT_APPBUILDERMODULE_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppBuilderModuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<AppBuilderModule>)QueryUtil.list(
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
	 * Returns the first app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule findByCompanyId_First(
			long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		AppBuilderModule appBuilderModule = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (appBuilderModule != null) {
			return appBuilderModule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppBuilderModuleException(sb.toString());
	}

	/**
	 * Returns the first app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule fetchByCompanyId_First(
		long companyId, OrderByComparator<AppBuilderModule> orderByComparator) {

		List<AppBuilderModule> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module
	 * @throws NoSuchAppBuilderModuleException if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule findByCompanyId_Last(
			long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		AppBuilderModule appBuilderModule = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (appBuilderModule != null) {
			return appBuilderModule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppBuilderModuleException(sb.toString());
	}

	/**
	 * Returns the last app builder module in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app builder module, or <code>null</code> if a matching app builder module could not be found
	 */
	@Override
	public AppBuilderModule fetchByCompanyId_Last(
		long companyId, OrderByComparator<AppBuilderModule> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<AppBuilderModule> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AppBuilderModule[] findByCompanyId_PrevAndNext(
			long appBuilderModuleId, long companyId,
			OrderByComparator<AppBuilderModule> orderByComparator)
		throws NoSuchAppBuilderModuleException {

		AppBuilderModule appBuilderModule = findByPrimaryKey(
			appBuilderModuleId);

		Session session = null;

		try {
			session = openSession();

			AppBuilderModule[] array = new AppBuilderModuleImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, appBuilderModule, companyId, orderByComparator, true);

			array[1] = appBuilderModule;

			array[2] = getByCompanyId_PrevAndNext(
				session, appBuilderModule, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppBuilderModule getByCompanyId_PrevAndNext(
		Session session, AppBuilderModule appBuilderModule, long companyId,
		OrderByComparator<AppBuilderModule> orderByComparator,
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

		sb.append(_SQL_SELECT_APPBUILDERMODULE_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			sb.append(AppBuilderModuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appBuilderModule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppBuilderModule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app builder modules where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (AppBuilderModule appBuilderModule :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appBuilderModule);
		}
	}

	/**
	 * Returns the number of app builder modules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching app builder modules
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPBUILDERMODULE_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"appBuilderModule.companyId = ?";

	public AppBuilderModulePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AppBuilderModule.class);

		setModelImplClass(AppBuilderModuleImpl.class);
		setModelPKClass(long.class);

		setTable(AppBuilderModuleTable.INSTANCE);
	}

	/**
	 * Caches the app builder module in the entity cache if it is enabled.
	 *
	 * @param appBuilderModule the app builder module
	 */
	@Override
	public void cacheResult(AppBuilderModule appBuilderModule) {
		entityCache.putResult(
			AppBuilderModuleImpl.class, appBuilderModule.getPrimaryKey(),
			appBuilderModule);
	}

	/**
	 * Caches the app builder modules in the entity cache if it is enabled.
	 *
	 * @param appBuilderModules the app builder modules
	 */
	@Override
	public void cacheResult(List<AppBuilderModule> appBuilderModules) {
		for (AppBuilderModule appBuilderModule : appBuilderModules) {
			if (entityCache.getResult(
					AppBuilderModuleImpl.class,
					appBuilderModule.getPrimaryKey()) == null) {

				cacheResult(appBuilderModule);
			}
		}
	}

	/**
	 * Clears the cache for all app builder modules.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppBuilderModuleImpl.class);

		finderCache.clearCache(AppBuilderModuleImpl.class);
	}

	/**
	 * Clears the cache for the app builder module.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppBuilderModule appBuilderModule) {
		entityCache.removeResult(AppBuilderModuleImpl.class, appBuilderModule);
	}

	@Override
	public void clearCache(List<AppBuilderModule> appBuilderModules) {
		for (AppBuilderModule appBuilderModule : appBuilderModules) {
			entityCache.removeResult(
				AppBuilderModuleImpl.class, appBuilderModule);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppBuilderModuleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AppBuilderModuleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new app builder module with the primary key. Does not add the app builder module to the database.
	 *
	 * @param appBuilderModuleId the primary key for the new app builder module
	 * @return the new app builder module
	 */
	@Override
	public AppBuilderModule create(long appBuilderModuleId) {
		AppBuilderModule appBuilderModule = new AppBuilderModuleImpl();

		appBuilderModule.setNew(true);
		appBuilderModule.setPrimaryKey(appBuilderModuleId);

		String uuid = PortalUUIDUtil.generate();

		appBuilderModule.setUuid(uuid);

		appBuilderModule.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appBuilderModule;
	}

	/**
	 * Removes the app builder module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module that was removed
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	@Override
	public AppBuilderModule remove(long appBuilderModuleId)
		throws NoSuchAppBuilderModuleException {

		return remove((Serializable)appBuilderModuleId);
	}

	/**
	 * Removes the app builder module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the app builder module
	 * @return the app builder module that was removed
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	@Override
	public AppBuilderModule remove(Serializable primaryKey)
		throws NoSuchAppBuilderModuleException {

		Session session = null;

		try {
			session = openSession();

			AppBuilderModule appBuilderModule = (AppBuilderModule)session.get(
				AppBuilderModuleImpl.class, primaryKey);

			if (appBuilderModule == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppBuilderModuleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appBuilderModule);
		}
		catch (NoSuchAppBuilderModuleException noSuchEntityException) {
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
	protected AppBuilderModule removeImpl(AppBuilderModule appBuilderModule) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appBuilderModule)) {
				appBuilderModule = (AppBuilderModule)session.get(
					AppBuilderModuleImpl.class,
					appBuilderModule.getPrimaryKeyObj());
			}

			if (appBuilderModule != null) {
				session.delete(appBuilderModule);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appBuilderModule != null) {
			clearCache(appBuilderModule);
		}

		return appBuilderModule;
	}

	@Override
	public AppBuilderModule updateImpl(AppBuilderModule appBuilderModule) {
		boolean isNew = appBuilderModule.isNew();

		if (!(appBuilderModule instanceof AppBuilderModuleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appBuilderModule.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appBuilderModule);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appBuilderModule proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppBuilderModule implementation " +
					appBuilderModule.getClass());
		}

		AppBuilderModuleModelImpl appBuilderModuleModelImpl =
			(AppBuilderModuleModelImpl)appBuilderModule;

		if (Validator.isNull(appBuilderModule.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appBuilderModule.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (appBuilderModule.getCreateDate() == null)) {
			if (serviceContext == null) {
				appBuilderModule.setCreateDate(now);
			}
			else {
				appBuilderModule.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!appBuilderModuleModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appBuilderModule.setModifiedDate(now);
			}
			else {
				appBuilderModule.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appBuilderModule);
			}
			else {
				appBuilderModule = (AppBuilderModule)session.merge(
					appBuilderModule);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppBuilderModuleImpl.class, appBuilderModuleModelImpl, false, true);

		if (isNew) {
			appBuilderModule.setNew(false);
		}

		appBuilderModule.resetOriginalValues();

		return appBuilderModule;
	}

	/**
	 * Returns the app builder module with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the app builder module
	 * @return the app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	@Override
	public AppBuilderModule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppBuilderModuleException {

		AppBuilderModule appBuilderModule = fetchByPrimaryKey(primaryKey);

		if (appBuilderModule == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppBuilderModuleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appBuilderModule;
	}

	/**
	 * Returns the app builder module with the primary key or throws a <code>NoSuchAppBuilderModuleException</code> if it could not be found.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module
	 * @throws NoSuchAppBuilderModuleException if a app builder module with the primary key could not be found
	 */
	@Override
	public AppBuilderModule findByPrimaryKey(long appBuilderModuleId)
		throws NoSuchAppBuilderModuleException {

		return findByPrimaryKey((Serializable)appBuilderModuleId);
	}

	/**
	 * Returns the app builder module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appBuilderModuleId the primary key of the app builder module
	 * @return the app builder module, or <code>null</code> if a app builder module with the primary key could not be found
	 */
	@Override
	public AppBuilderModule fetchByPrimaryKey(long appBuilderModuleId) {
		return fetchByPrimaryKey((Serializable)appBuilderModuleId);
	}

	/**
	 * Returns all the app builder modules.
	 *
	 * @return the app builder modules
	 */
	@Override
	public List<AppBuilderModule> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AppBuilderModule> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AppBuilderModule> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AppBuilderModule> findAll(
		int start, int end,
		OrderByComparator<AppBuilderModule> orderByComparator,
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

		List<AppBuilderModule> list = null;

		if (useFinderCache) {
			list = (List<AppBuilderModule>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPBUILDERMODULE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPBUILDERMODULE;

				sql = sql.concat(AppBuilderModuleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppBuilderModule>)QueryUtil.list(
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
	 * Removes all the app builder modules from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppBuilderModule appBuilderModule : findAll()) {
			remove(appBuilderModule);
		}
	}

	/**
	 * Returns the number of app builder modules.
	 *
	 * @return the number of app builder modules
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPBUILDERMODULE);

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
		return "appBuilderModuleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPBUILDERMODULE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppBuilderModuleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the app builder module persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AppBuilderModuleModelArgumentsResolver(),
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

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId"}, true);

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			true);

		_finderPathCountByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AppBuilderModuleImpl.class.getName());

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

	private static final String _SQL_SELECT_APPBUILDERMODULE =
		"SELECT appBuilderModule FROM AppBuilderModule appBuilderModule";

	private static final String _SQL_SELECT_APPBUILDERMODULE_WHERE =
		"SELECT appBuilderModule FROM AppBuilderModule appBuilderModule WHERE ";

	private static final String _SQL_COUNT_APPBUILDERMODULE =
		"SELECT COUNT(appBuilderModule) FROM AppBuilderModule appBuilderModule";

	private static final String _SQL_COUNT_APPBUILDERMODULE_WHERE =
		"SELECT COUNT(appBuilderModule) FROM AppBuilderModule appBuilderModule WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appBuilderModule.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppBuilderModule exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppBuilderModule exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppBuilderModulePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AppBuilderModuleModelArgumentsResolver
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

			AppBuilderModuleModelImpl appBuilderModuleModelImpl =
				(AppBuilderModuleModelImpl)baseModel;

			long columnBitmask = appBuilderModuleModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					appBuilderModuleModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						appBuilderModuleModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					appBuilderModuleModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return AppBuilderModuleImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return AppBuilderModuleTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			AppBuilderModuleModelImpl appBuilderModuleModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						appBuilderModuleModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = appBuilderModuleModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}