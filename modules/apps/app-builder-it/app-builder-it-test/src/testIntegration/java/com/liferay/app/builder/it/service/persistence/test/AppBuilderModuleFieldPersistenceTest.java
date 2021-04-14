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

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleFieldException;
import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.app.builder.it.service.AppBuilderModuleFieldLocalServiceUtil;
import com.liferay.app.builder.it.service.persistence.AppBuilderModuleFieldPersistence;
import com.liferay.app.builder.it.service.persistence.AppBuilderModuleFieldUtil;
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
public class AppBuilderModuleFieldPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.app.builder.it.service"));

	@Before
	public void setUp() {
		_persistence = AppBuilderModuleFieldUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AppBuilderModuleField> iterator =
			_appBuilderModuleFields.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModuleField appBuilderModuleField = _persistence.create(pk);

		Assert.assertNotNull(appBuilderModuleField);

		Assert.assertEquals(appBuilderModuleField.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AppBuilderModuleField newAppBuilderModuleField =
			addAppBuilderModuleField();

		_persistence.remove(newAppBuilderModuleField);

		AppBuilderModuleField existingAppBuilderModuleField =
			_persistence.fetchByPrimaryKey(
				newAppBuilderModuleField.getPrimaryKey());

		Assert.assertNull(existingAppBuilderModuleField);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAppBuilderModuleField();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModuleField newAppBuilderModuleField = _persistence.create(
			pk);

		newAppBuilderModuleField.setUuid(RandomTestUtil.randomString());

		newAppBuilderModuleField.setCompanyId(RandomTestUtil.nextLong());

		newAppBuilderModuleField.setUserId(RandomTestUtil.nextLong());

		newAppBuilderModuleField.setUserName(RandomTestUtil.randomString());

		newAppBuilderModuleField.setCreateDate(RandomTestUtil.nextDate());

		newAppBuilderModuleField.setModifiedDate(RandomTestUtil.nextDate());

		newAppBuilderModuleField.setAppBuilderModuleId(
			RandomTestUtil.nextLong());

		newAppBuilderModuleField.setName(RandomTestUtil.randomString());

		newAppBuilderModuleField.setLabel(RandomTestUtil.randomString());

		newAppBuilderModuleField.setDbColumnName(RandomTestUtil.randomString());

		newAppBuilderModuleField.setType(RandomTestUtil.randomString());

		newAppBuilderModuleField.setTypeSettings(RandomTestUtil.randomString());

		newAppBuilderModuleField.setNullable(RandomTestUtil.randomBoolean());

		_appBuilderModuleFields.add(
			_persistence.update(newAppBuilderModuleField));

		AppBuilderModuleField existingAppBuilderModuleField =
			_persistence.findByPrimaryKey(
				newAppBuilderModuleField.getPrimaryKey());

		Assert.assertEquals(
			existingAppBuilderModuleField.getUuid(),
			newAppBuilderModuleField.getUuid());
		Assert.assertEquals(
			existingAppBuilderModuleField.getAppBuilderModuleFieldId(),
			newAppBuilderModuleField.getAppBuilderModuleFieldId());
		Assert.assertEquals(
			existingAppBuilderModuleField.getCompanyId(),
			newAppBuilderModuleField.getCompanyId());
		Assert.assertEquals(
			existingAppBuilderModuleField.getUserId(),
			newAppBuilderModuleField.getUserId());
		Assert.assertEquals(
			existingAppBuilderModuleField.getUserName(),
			newAppBuilderModuleField.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAppBuilderModuleField.getCreateDate()),
			Time.getShortTimestamp(newAppBuilderModuleField.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAppBuilderModuleField.getModifiedDate()),
			Time.getShortTimestamp(newAppBuilderModuleField.getModifiedDate()));
		Assert.assertEquals(
			existingAppBuilderModuleField.getAppBuilderModuleId(),
			newAppBuilderModuleField.getAppBuilderModuleId());
		Assert.assertEquals(
			existingAppBuilderModuleField.getName(),
			newAppBuilderModuleField.getName());
		Assert.assertEquals(
			existingAppBuilderModuleField.getLabel(),
			newAppBuilderModuleField.getLabel());
		Assert.assertEquals(
			existingAppBuilderModuleField.getDbColumnName(),
			newAppBuilderModuleField.getDbColumnName());
		Assert.assertEquals(
			existingAppBuilderModuleField.getType(),
			newAppBuilderModuleField.getType());
		Assert.assertEquals(
			existingAppBuilderModuleField.getTypeSettings(),
			newAppBuilderModuleField.getTypeSettings());
		Assert.assertEquals(
			existingAppBuilderModuleField.isNullable(),
			newAppBuilderModuleField.isNullable());
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
	public void testCountByAppBuilderModuleId() throws Exception {
		_persistence.countByAppBuilderModuleId(RandomTestUtil.nextLong());

		_persistence.countByAppBuilderModuleId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AppBuilderModuleField newAppBuilderModuleField =
			addAppBuilderModuleField();

		AppBuilderModuleField existingAppBuilderModuleField =
			_persistence.findByPrimaryKey(
				newAppBuilderModuleField.getPrimaryKey());

		Assert.assertEquals(
			existingAppBuilderModuleField, newAppBuilderModuleField);
	}

	@Test(expected = NoSuchAppBuilderModuleFieldException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AppBuilderModuleField> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AppBuilderModuleField", "uuid", true, "appBuilderModuleFieldId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "appBuilderModuleId",
			true, "name", true, "label", true, "dbColumnName", true, "type",
			true, "typeSettings", true, "nullable", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AppBuilderModuleField newAppBuilderModuleField =
			addAppBuilderModuleField();

		AppBuilderModuleField existingAppBuilderModuleField =
			_persistence.fetchByPrimaryKey(
				newAppBuilderModuleField.getPrimaryKey());

		Assert.assertEquals(
			existingAppBuilderModuleField, newAppBuilderModuleField);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AppBuilderModuleField missingAppBuilderModuleField =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAppBuilderModuleField);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AppBuilderModuleField newAppBuilderModuleField1 =
			addAppBuilderModuleField();
		AppBuilderModuleField newAppBuilderModuleField2 =
			addAppBuilderModuleField();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModuleField1.getPrimaryKey());
		primaryKeys.add(newAppBuilderModuleField2.getPrimaryKey());

		Map<Serializable, AppBuilderModuleField> appBuilderModuleFields =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, appBuilderModuleFields.size());
		Assert.assertEquals(
			newAppBuilderModuleField1,
			appBuilderModuleFields.get(
				newAppBuilderModuleField1.getPrimaryKey()));
		Assert.assertEquals(
			newAppBuilderModuleField2,
			appBuilderModuleFields.get(
				newAppBuilderModuleField2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AppBuilderModuleField> appBuilderModuleFields =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appBuilderModuleFields.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AppBuilderModuleField newAppBuilderModuleField =
			addAppBuilderModuleField();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModuleField.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AppBuilderModuleField> appBuilderModuleFields =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appBuilderModuleFields.size());
		Assert.assertEquals(
			newAppBuilderModuleField,
			appBuilderModuleFields.get(
				newAppBuilderModuleField.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AppBuilderModuleField> appBuilderModuleFields =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appBuilderModuleFields.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AppBuilderModuleField newAppBuilderModuleField =
			addAppBuilderModuleField();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppBuilderModuleField.getPrimaryKey());

		Map<Serializable, AppBuilderModuleField> appBuilderModuleFields =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appBuilderModuleFields.size());
		Assert.assertEquals(
			newAppBuilderModuleField,
			appBuilderModuleFields.get(
				newAppBuilderModuleField.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AppBuilderModuleFieldLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<AppBuilderModuleField>() {

				@Override
				public void performAction(
					AppBuilderModuleField appBuilderModuleField) {

					Assert.assertNotNull(appBuilderModuleField);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AppBuilderModuleField newAppBuilderModuleField =
			addAppBuilderModuleField();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleField.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appBuilderModuleFieldId",
				newAppBuilderModuleField.getAppBuilderModuleFieldId()));

		List<AppBuilderModuleField> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AppBuilderModuleField existingAppBuilderModuleField = result.get(0);

		Assert.assertEquals(
			existingAppBuilderModuleField, newAppBuilderModuleField);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleField.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appBuilderModuleFieldId", RandomTestUtil.nextLong()));

		List<AppBuilderModuleField> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AppBuilderModuleField newAppBuilderModuleField =
			addAppBuilderModuleField();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleField.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appBuilderModuleFieldId"));

		Object newAppBuilderModuleFieldId =
			newAppBuilderModuleField.getAppBuilderModuleFieldId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appBuilderModuleFieldId",
				new Object[] {newAppBuilderModuleFieldId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAppBuilderModuleFieldId = result.get(0);

		Assert.assertEquals(
			existingAppBuilderModuleFieldId, newAppBuilderModuleFieldId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AppBuilderModuleField.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appBuilderModuleFieldId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appBuilderModuleFieldId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AppBuilderModuleField addAppBuilderModuleField()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		AppBuilderModuleField appBuilderModuleField = _persistence.create(pk);

		appBuilderModuleField.setUuid(RandomTestUtil.randomString());

		appBuilderModuleField.setCompanyId(RandomTestUtil.nextLong());

		appBuilderModuleField.setUserId(RandomTestUtil.nextLong());

		appBuilderModuleField.setUserName(RandomTestUtil.randomString());

		appBuilderModuleField.setCreateDate(RandomTestUtil.nextDate());

		appBuilderModuleField.setModifiedDate(RandomTestUtil.nextDate());

		appBuilderModuleField.setAppBuilderModuleId(RandomTestUtil.nextLong());

		appBuilderModuleField.setName(RandomTestUtil.randomString());

		appBuilderModuleField.setLabel(RandomTestUtil.randomString());

		appBuilderModuleField.setDbColumnName(RandomTestUtil.randomString());

		appBuilderModuleField.setType(RandomTestUtil.randomString());

		appBuilderModuleField.setTypeSettings(RandomTestUtil.randomString());

		appBuilderModuleField.setNullable(RandomTestUtil.randomBoolean());

		_appBuilderModuleFields.add(_persistence.update(appBuilderModuleField));

		return appBuilderModuleField;
	}

	private List<AppBuilderModuleField> _appBuilderModuleFields =
		new ArrayList<AppBuilderModuleField>();
	private AppBuilderModuleFieldPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}