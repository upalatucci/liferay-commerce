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

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleEntryException;
import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.app.builder.it.service.AppBuilderModuleEntryLocalServiceUtil;
import com.liferay.app.builder.it.service.persistence.AppBuilderModuleEntryPersistence;
import com.liferay.app.builder.it.service.persistence.AppBuilderModuleEntryUtil;
import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
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
public class AppBuilderModuleEntryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.app.builder.it.service"));

	@Before
	public void setUp() {
		_persistence = AppBuilderModuleEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AppBuilderModuleEntry> iterator =
			_appBuilderModuleEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModuleEntry appBuilderModuleEntry = _persistence.create(pk);

		Assert.assertNotNull(appBuilderModuleEntry);

		Assert.assertEquals(appBuilderModuleEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		_persistence.remove(newAppBuilderModuleEntry);

		AppBuilderModuleEntry existingAppBuilderModuleEntry =
			_persistence.fetchByPrimaryKey(
				newAppBuilderModuleEntry.getPrimaryKey());

		Assert.assertNull(existingAppBuilderModuleEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAppBuilderModuleEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModuleEntry newAppBuilderModuleEntry = _persistence.create(
			pk);

		newAppBuilderModuleEntry.setUuid(RandomTestUtil.randomString());

		newAppBuilderModuleEntry.setGroupId(RandomTestUtil.nextLong());

		newAppBuilderModuleEntry.setCompanyId(RandomTestUtil.nextLong());

		newAppBuilderModuleEntry.setUserId(RandomTestUtil.nextLong());

		newAppBuilderModuleEntry.setUserName(RandomTestUtil.randomString());

		newAppBuilderModuleEntry.setCreateDate(RandomTestUtil.nextDate());

		newAppBuilderModuleEntry.setModifiedDate(RandomTestUtil.nextDate());

		newAppBuilderModuleEntry.setAppBuilderModuleId(
			RandomTestUtil.nextLong());

		newAppBuilderModuleEntry.setLastPublishDate(RandomTestUtil.nextDate());

		newAppBuilderModuleEntry.setStatus(RandomTestUtil.nextInt());

		newAppBuilderModuleEntry.setStatusByUserId(RandomTestUtil.nextLong());

		newAppBuilderModuleEntry.setStatusByUserName(
			RandomTestUtil.randomString());

		newAppBuilderModuleEntry.setStatusDate(RandomTestUtil.nextDate());

		_appBuilderModuleEntries.add(
			_persistence.update(newAppBuilderModuleEntry));

		AppBuilderModuleEntry existingAppBuilderModuleEntry =
			_persistence.findByPrimaryKey(
				newAppBuilderModuleEntry.getPrimaryKey());

		Assert.assertEquals(
			existingAppBuilderModuleEntry.getUuid(),
			newAppBuilderModuleEntry.getUuid());
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getAppBuilderModuleEntryId(),
			newAppBuilderModuleEntry.getAppBuilderModuleEntryId());
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getGroupId(),
			newAppBuilderModuleEntry.getGroupId());
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getCompanyId(),
			newAppBuilderModuleEntry.getCompanyId());
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getUserId(),
			newAppBuilderModuleEntry.getUserId());
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getUserName(),
			newAppBuilderModuleEntry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAppBuilderModuleEntry.getCreateDate()),
			Time.getShortTimestamp(newAppBuilderModuleEntry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAppBuilderModuleEntry.getModifiedDate()),
			Time.getShortTimestamp(newAppBuilderModuleEntry.getModifiedDate()));
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getAppBuilderModuleId(),
			newAppBuilderModuleEntry.getAppBuilderModuleId());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAppBuilderModuleEntry.getLastPublishDate()),
			Time.getShortTimestamp(
				newAppBuilderModuleEntry.getLastPublishDate()));
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getStatus(),
			newAppBuilderModuleEntry.getStatus());
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getStatusByUserId(),
			newAppBuilderModuleEntry.getStatusByUserId());
		Assert.assertEquals(
			existingAppBuilderModuleEntry.getStatusByUserName(),
			newAppBuilderModuleEntry.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAppBuilderModuleEntry.getStatusDate()),
			Time.getShortTimestamp(newAppBuilderModuleEntry.getStatusDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		AppBuilderModuleEntry existingAppBuilderModuleEntry =
			_persistence.findByPrimaryKey(
				newAppBuilderModuleEntry.getPrimaryKey());

		Assert.assertEquals(
			existingAppBuilderModuleEntry, newAppBuilderModuleEntry);
	}

	@Test(expected = NoSuchAppBuilderModuleEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AppBuilderModuleEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AppBuilderModuleEntry", "uuid", true, "appBuilderModuleEntryId",
			true, "groupId", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true,
			"appBuilderModuleId", true, "lastPublishDate", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		AppBuilderModuleEntry existingAppBuilderModuleEntry =
			_persistence.fetchByPrimaryKey(
				newAppBuilderModuleEntry.getPrimaryKey());

		Assert.assertEquals(
			existingAppBuilderModuleEntry, newAppBuilderModuleEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModuleEntry missingAppBuilderModuleEntry =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAppBuilderModuleEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AppBuilderModuleEntry newAppBuilderModuleEntry1 =
			addAppBuilderModuleEntry();
		AppBuilderModuleEntry newAppBuilderModuleEntry2 =
			addAppBuilderModuleEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModuleEntry1.getPrimaryKey());
		primaryKeys.add(newAppBuilderModuleEntry2.getPrimaryKey());

		Map<Serializable, AppBuilderModuleEntry> appBuilderModuleEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, appBuilderModuleEntries.size());
		Assert.assertEquals(
			newAppBuilderModuleEntry1,
			appBuilderModuleEntries.get(
				newAppBuilderModuleEntry1.getPrimaryKey()));
		Assert.assertEquals(
			newAppBuilderModuleEntry2,
			appBuilderModuleEntries.get(
				newAppBuilderModuleEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AppBuilderModuleEntry> appBuilderModuleEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appBuilderModuleEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModuleEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AppBuilderModuleEntry> appBuilderModuleEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appBuilderModuleEntries.size());
		Assert.assertEquals(
			newAppBuilderModuleEntry,
			appBuilderModuleEntries.get(
				newAppBuilderModuleEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AppBuilderModuleEntry> appBuilderModuleEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appBuilderModuleEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModuleEntry.getPrimaryKey());

		Map<Serializable, AppBuilderModuleEntry> appBuilderModuleEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appBuilderModuleEntries.size());
		Assert.assertEquals(
			newAppBuilderModuleEntry,
			appBuilderModuleEntries.get(
				newAppBuilderModuleEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AppBuilderModuleEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<AppBuilderModuleEntry>() {

				@Override
				public void performAction(
					AppBuilderModuleEntry appBuilderModuleEntry) {

					Assert.assertNotNull(appBuilderModuleEntry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appBuilderModuleEntryId",
				newAppBuilderModuleEntry.getAppBuilderModuleEntryId()));

		List<AppBuilderModuleEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AppBuilderModuleEntry existingAppBuilderModuleEntry = result.get(0);

		Assert.assertEquals(
			existingAppBuilderModuleEntry, newAppBuilderModuleEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appBuilderModuleEntryId", RandomTestUtil.nextLong()));

		List<AppBuilderModuleEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appBuilderModuleEntryId"));

		Object newAppBuilderModuleEntryId =
			newAppBuilderModuleEntry.getAppBuilderModuleEntryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appBuilderModuleEntryId",
				new Object[] {newAppBuilderModuleEntryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAppBuilderModuleEntryId = result.get(0);

		Assert.assertEquals(
			existingAppBuilderModuleEntryId, newAppBuilderModuleEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appBuilderModuleEntryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appBuilderModuleEntryId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newAppBuilderModuleEntry.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		AppBuilderModuleEntry newAppBuilderModuleEntry =
			addAppBuilderModuleEntry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appBuilderModuleEntryId",
				newAppBuilderModuleEntry.getAppBuilderModuleEntryId()));

		List<AppBuilderModuleEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		Assert.assertEquals(
			appBuilderModuleEntry.getUuid(),
			ReflectionTestUtil.invoke(
				appBuilderModuleEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(appBuilderModuleEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				appBuilderModuleEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected AppBuilderModuleEntry addAppBuilderModuleEntry()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		AppBuilderModuleEntry appBuilderModuleEntry = _persistence.create(pk);

		appBuilderModuleEntry.setUuid(RandomTestUtil.randomString());

		appBuilderModuleEntry.setGroupId(RandomTestUtil.nextLong());

		appBuilderModuleEntry.setCompanyId(RandomTestUtil.nextLong());

		appBuilderModuleEntry.setUserId(RandomTestUtil.nextLong());

		appBuilderModuleEntry.setUserName(RandomTestUtil.randomString());

		appBuilderModuleEntry.setCreateDate(RandomTestUtil.nextDate());

		appBuilderModuleEntry.setModifiedDate(RandomTestUtil.nextDate());

		appBuilderModuleEntry.setAppBuilderModuleId(RandomTestUtil.nextLong());

		appBuilderModuleEntry.setLastPublishDate(RandomTestUtil.nextDate());

		appBuilderModuleEntry.setStatus(RandomTestUtil.nextInt());

		appBuilderModuleEntry.setStatusByUserId(RandomTestUtil.nextLong());

		appBuilderModuleEntry.setStatusByUserName(
			RandomTestUtil.randomString());

		appBuilderModuleEntry.setStatusDate(RandomTestUtil.nextDate());

		_appBuilderModuleEntries.add(
			_persistence.update(appBuilderModuleEntry));

		return appBuilderModuleEntry;
	}

	private List<AppBuilderModuleEntry> _appBuilderModuleEntries =
		new ArrayList<AppBuilderModuleEntry>();
	private AppBuilderModuleEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}