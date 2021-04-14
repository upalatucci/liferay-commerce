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

package com.liferay.app.builder.it.service.persistence.test;

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleException;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalServiceUtil;
import com.liferay.app.builder.it.service.persistence.AppBuilderModulePersistence;
import com.liferay.app.builder.it.service.persistence.AppBuilderModuleUtil;
import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AppBuilderModulePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.app.builder.it.service"));

	@Before
	public void setUp() {
		_persistence = AppBuilderModuleUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AppBuilderModule> iterator = _appBuilderModules.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModule appBuilderModule = _persistence.create(pk);

		Assert.assertNotNull(appBuilderModule);

		Assert.assertEquals(appBuilderModule.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AppBuilderModule newAppBuilderModule = addAppBuilderModule();

		_persistence.remove(newAppBuilderModule);

		AppBuilderModule existingAppBuilderModule =
			_persistence.fetchByPrimaryKey(newAppBuilderModule.getPrimaryKey());

		Assert.assertNull(existingAppBuilderModule);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAppBuilderModule();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModule newAppBuilderModule = _persistence.create(pk);

		newAppBuilderModule.setUuid(RandomTestUtil.randomString());

		newAppBuilderModule.setCompanyId(RandomTestUtil.nextLong());

		newAppBuilderModule.setUserId(RandomTestUtil.nextLong());

		newAppBuilderModule.setUserName(RandomTestUtil.randomString());

		newAppBuilderModule.setCreateDate(RandomTestUtil.nextDate());

		newAppBuilderModule.setModifiedDate(RandomTestUtil.nextDate());

		newAppBuilderModule.setActive(RandomTestUtil.randomBoolean());

		newAppBuilderModule.setName(RandomTestUtil.randomString());

		newAppBuilderModule.setLabel(RandomTestUtil.randomString());

		newAppBuilderModule.setDbTableName(RandomTestUtil.randomString());

		newAppBuilderModule.setDbTablePKColumnName(
			RandomTestUtil.randomString());

		newAppBuilderModule.setScope(RandomTestUtil.randomString());

		newAppBuilderModule.setResourceName(RandomTestUtil.randomString());

		newAppBuilderModule.setAsset(RandomTestUtil.randomBoolean());

		newAppBuilderModule.setResource(RandomTestUtil.randomBoolean());

		newAppBuilderModule.setExpando(RandomTestUtil.randomBoolean());

		_appBuilderModules.add(_persistence.update(newAppBuilderModule));

		AppBuilderModule existingAppBuilderModule =
			_persistence.findByPrimaryKey(newAppBuilderModule.getPrimaryKey());

		Assert.assertEquals(
			existingAppBuilderModule.getUuid(), newAppBuilderModule.getUuid());
		Assert.assertEquals(
			existingAppBuilderModule.getAppBuilderModuleId(),
			newAppBuilderModule.getAppBuilderModuleId());
		Assert.assertEquals(
			existingAppBuilderModule.getCompanyId(),
			newAppBuilderModule.getCompanyId());
		Assert.assertEquals(
			existingAppBuilderModule.getUserId(),
			newAppBuilderModule.getUserId());
		Assert.assertEquals(
			existingAppBuilderModule.getUserName(),
			newAppBuilderModule.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAppBuilderModule.getCreateDate()),
			Time.getShortTimestamp(newAppBuilderModule.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAppBuilderModule.getModifiedDate()),
			Time.getShortTimestamp(newAppBuilderModule.getModifiedDate()));
		Assert.assertEquals(
			existingAppBuilderModule.isActive(),
			newAppBuilderModule.isActive());
		Assert.assertEquals(
			existingAppBuilderModule.getName(), newAppBuilderModule.getName());
		Assert.assertEquals(
			existingAppBuilderModule.getLabel(),
			newAppBuilderModule.getLabel());
		Assert.assertEquals(
			existingAppBuilderModule.getDbTableName(),
			newAppBuilderModule.getDbTableName());
		Assert.assertEquals(
			existingAppBuilderModule.getDbTablePKColumnName(),
			newAppBuilderModule.getDbTablePKColumnName());
		Assert.assertEquals(
			existingAppBuilderModule.getScope(),
			newAppBuilderModule.getScope());
		Assert.assertEquals(
			existingAppBuilderModule.getResourceName(),
			newAppBuilderModule.getResourceName());
		Assert.assertEquals(
			existingAppBuilderModule.isAsset(), newAppBuilderModule.isAsset());
		Assert.assertEquals(
			existingAppBuilderModule.isResource(),
			newAppBuilderModule.isResource());
		Assert.assertEquals(
			existingAppBuilderModule.isExpando(),
			newAppBuilderModule.isExpando());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AppBuilderModule newAppBuilderModule = addAppBuilderModule();

		AppBuilderModule existingAppBuilderModule =
			_persistence.findByPrimaryKey(newAppBuilderModule.getPrimaryKey());

		Assert.assertEquals(existingAppBuilderModule, newAppBuilderModule);
	}

	@Test(expected = NoSuchAppBuilderModuleException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AppBuilderModule> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AppBuilderModule", "uuid", true, "appBuilderModuleId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "active", true, "name", true, "label",
			true, "dbTableName", true, "dbTablePKColumnName", true, "scope",
			true, "resourceName", true, "asset", true, "resource", true,
			"expando", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AppBuilderModule newAppBuilderModule = addAppBuilderModule();

		AppBuilderModule existingAppBuilderModule =
			_persistence.fetchByPrimaryKey(newAppBuilderModule.getPrimaryKey());

		Assert.assertEquals(existingAppBuilderModule, newAppBuilderModule);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModule missingAppBuilderModule =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAppBuilderModule);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AppBuilderModule newAppBuilderModule1 = addAppBuilderModule();
		AppBuilderModule newAppBuilderModule2 = addAppBuilderModule();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModule1.getPrimaryKey());
		primaryKeys.add(newAppBuilderModule2.getPrimaryKey());

		Map<Serializable, AppBuilderModule> appBuilderModules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, appBuilderModules.size());
		Assert.assertEquals(
			newAppBuilderModule1,
			appBuilderModules.get(newAppBuilderModule1.getPrimaryKey()));
		Assert.assertEquals(
			newAppBuilderModule2,
			appBuilderModules.get(newAppBuilderModule2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AppBuilderModule> appBuilderModules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appBuilderModules.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AppBuilderModule newAppBuilderModule = addAppBuilderModule();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModule.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AppBuilderModule> appBuilderModules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appBuilderModules.size());
		Assert.assertEquals(
			newAppBuilderModule,
			appBuilderModules.get(newAppBuilderModule.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AppBuilderModule> appBuilderModules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appBuilderModules.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AppBuilderModule newAppBuilderModule = addAppBuilderModule();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModule.getPrimaryKey());

		Map<Serializable, AppBuilderModule> appBuilderModules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appBuilderModules.size());
		Assert.assertEquals(
			newAppBuilderModule,
			appBuilderModules.get(newAppBuilderModule.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AppBuilderModuleLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AppBuilderModule>() {

				@Override
				public void performAction(AppBuilderModule appBuilderModule) {
					Assert.assertNotNull(appBuilderModule);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AppBuilderModule newAppBuilderModule = addAppBuilderModule();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModule.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appBuilderModuleId",
				newAppBuilderModule.getAppBuilderModuleId()));

		List<AppBuilderModule> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AppBuilderModule existingAppBuilderModule = result.get(0);

		Assert.assertEquals(existingAppBuilderModule, newAppBuilderModule);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModule.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appBuilderModuleId", RandomTestUtil.nextLong()));

		List<AppBuilderModule> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AppBuilderModule newAppBuilderModule = addAppBuilderModule();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModule.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appBuilderModuleId"));

		Object newAppBuilderModuleId =
			newAppBuilderModule.getAppBuilderModuleId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appBuilderModuleId", new Object[] {newAppBuilderModuleId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAppBuilderModuleId = result.get(0);

		Assert.assertEquals(existingAppBuilderModuleId, newAppBuilderModuleId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModule.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appBuilderModuleId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appBuilderModuleId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AppBuilderModule addAppBuilderModule() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModule appBuilderModule = _persistence.create(pk);

		appBuilderModule.setUuid(RandomTestUtil.randomString());

		appBuilderModule.setCompanyId(RandomTestUtil.nextLong());

		appBuilderModule.setUserId(RandomTestUtil.nextLong());

		appBuilderModule.setUserName(RandomTestUtil.randomString());

		appBuilderModule.setCreateDate(RandomTestUtil.nextDate());

		appBuilderModule.setModifiedDate(RandomTestUtil.nextDate());

		appBuilderModule.setActive(RandomTestUtil.randomBoolean());

		appBuilderModule.setName(RandomTestUtil.randomString());

		appBuilderModule.setLabel(RandomTestUtil.randomString());

		appBuilderModule.setDbTableName(RandomTestUtil.randomString());

		appBuilderModule.setDbTablePKColumnName(RandomTestUtil.randomString());

		appBuilderModule.setScope(RandomTestUtil.randomString());

		appBuilderModule.setResourceName(RandomTestUtil.randomString());

		appBuilderModule.setAsset(RandomTestUtil.randomBoolean());

		appBuilderModule.setResource(RandomTestUtil.randomBoolean());

		appBuilderModule.setExpando(RandomTestUtil.randomBoolean());

		_appBuilderModules.add(_persistence.update(appBuilderModule));

		return appBuilderModule;
	}

	private List<AppBuilderModule> _appBuilderModules =
		new ArrayList<AppBuilderModule>();
	private AppBuilderModulePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}