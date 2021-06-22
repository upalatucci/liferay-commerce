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

package com.liferay.object.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.object.exception.NoSuchDefinitionException;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.persistence.ObjectDefinitionPersistence;
import com.liferay.object.service.persistence.ObjectDefinitionUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.AssertUtils;
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
public class ObjectDefinitionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.object.service"));

	@Before
	public void setUp() {
		_persistence = ObjectDefinitionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ObjectDefinition> iterator = _objectDefinitions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ObjectDefinition objectDefinition = _persistence.create(pk);

		Assert.assertNotNull(objectDefinition);

		Assert.assertEquals(objectDefinition.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ObjectDefinition newObjectDefinition = addObjectDefinition();

		_persistence.remove(newObjectDefinition);

		ObjectDefinition existingObjectDefinition =
			_persistence.fetchByPrimaryKey(newObjectDefinition.getPrimaryKey());

		Assert.assertNull(existingObjectDefinition);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addObjectDefinition();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ObjectDefinition newObjectDefinition = _persistence.create(pk);

		newObjectDefinition.setMvccVersion(RandomTestUtil.nextLong());

		newObjectDefinition.setUuid(RandomTestUtil.randomString());

		newObjectDefinition.setCompanyId(RandomTestUtil.nextLong());

		newObjectDefinition.setUserId(RandomTestUtil.nextLong());

		newObjectDefinition.setUserName(RandomTestUtil.randomString());

		newObjectDefinition.setCreateDate(RandomTestUtil.nextDate());

		newObjectDefinition.setModifiedDate(RandomTestUtil.nextDate());

		newObjectDefinition.setName(RandomTestUtil.randomString());

		newObjectDefinition.setSystem(RandomTestUtil.randomBoolean());

		newObjectDefinition.setVersion(RandomTestUtil.nextDouble());

		_objectDefinitions.add(_persistence.update(newObjectDefinition));

		ObjectDefinition existingObjectDefinition =
			_persistence.findByPrimaryKey(newObjectDefinition.getPrimaryKey());

		Assert.assertEquals(
			existingObjectDefinition.getMvccVersion(),
			newObjectDefinition.getMvccVersion());
		Assert.assertEquals(
			existingObjectDefinition.getUuid(), newObjectDefinition.getUuid());
		Assert.assertEquals(
			existingObjectDefinition.getObjectDefinitionId(),
			newObjectDefinition.getObjectDefinitionId());
		Assert.assertEquals(
			existingObjectDefinition.getCompanyId(),
			newObjectDefinition.getCompanyId());
		Assert.assertEquals(
			existingObjectDefinition.getUserId(),
			newObjectDefinition.getUserId());
		Assert.assertEquals(
			existingObjectDefinition.getUserName(),
			newObjectDefinition.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingObjectDefinition.getCreateDate()),
			Time.getShortTimestamp(newObjectDefinition.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingObjectDefinition.getModifiedDate()),
			Time.getShortTimestamp(newObjectDefinition.getModifiedDate()));
		Assert.assertEquals(
			existingObjectDefinition.getName(), newObjectDefinition.getName());
		Assert.assertEquals(
			existingObjectDefinition.isSystem(),
			newObjectDefinition.isSystem());
		AssertUtils.assertEquals(
			existingObjectDefinition.getVersion(),
			newObjectDefinition.getVersion());
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
	public void testCountByC_N() throws Exception {
		_persistence.countByC_N(RandomTestUtil.nextLong(), "");

		_persistence.countByC_N(0L, "null");

		_persistence.countByC_N(0L, (String)null);
	}

	@Test
	public void testCountByC_N_V() throws Exception {
		_persistence.countByC_N_V(
			RandomTestUtil.nextLong(), "", RandomTestUtil.nextDouble());

		_persistence.countByC_N_V(0L, "null", 0D);

		_persistence.countByC_N_V(0L, (String)null, 0D);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ObjectDefinition newObjectDefinition = addObjectDefinition();

		ObjectDefinition existingObjectDefinition =
			_persistence.findByPrimaryKey(newObjectDefinition.getPrimaryKey());

		Assert.assertEquals(existingObjectDefinition, newObjectDefinition);
	}

	@Test(expected = NoSuchDefinitionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ObjectDefinition> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ObjectDefinition", "mvccVersion", true, "uuid", true,
			"objectDefinitionId", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true, "name",
			true, "system", true, "version", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ObjectDefinition newObjectDefinition = addObjectDefinition();

		ObjectDefinition existingObjectDefinition =
			_persistence.fetchByPrimaryKey(newObjectDefinition.getPrimaryKey());

		Assert.assertEquals(existingObjectDefinition, newObjectDefinition);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ObjectDefinition missingObjectDefinition =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingObjectDefinition);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ObjectDefinition newObjectDefinition1 = addObjectDefinition();
		ObjectDefinition newObjectDefinition2 = addObjectDefinition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newObjectDefinition1.getPrimaryKey());
		primaryKeys.add(newObjectDefinition2.getPrimaryKey());

		Map<Serializable, ObjectDefinition> objectDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, objectDefinitions.size());
		Assert.assertEquals(
			newObjectDefinition1,
			objectDefinitions.get(newObjectDefinition1.getPrimaryKey()));
		Assert.assertEquals(
			newObjectDefinition2,
			objectDefinitions.get(newObjectDefinition2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ObjectDefinition> objectDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(objectDefinitions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ObjectDefinition newObjectDefinition = addObjectDefinition();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newObjectDefinition.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ObjectDefinition> objectDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, objectDefinitions.size());
		Assert.assertEquals(
			newObjectDefinition,
			objectDefinitions.get(newObjectDefinition.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ObjectDefinition> objectDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(objectDefinitions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ObjectDefinition newObjectDefinition = addObjectDefinition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newObjectDefinition.getPrimaryKey());

		Map<Serializable, ObjectDefinition> objectDefinitions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, objectDefinitions.size());
		Assert.assertEquals(
			newObjectDefinition,
			objectDefinitions.get(newObjectDefinition.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ObjectDefinitionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ObjectDefinition>() {

				@Override
				public void performAction(ObjectDefinition objectDefinition) {
					Assert.assertNotNull(objectDefinition);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ObjectDefinition newObjectDefinition = addObjectDefinition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ObjectDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"objectDefinitionId",
				newObjectDefinition.getObjectDefinitionId()));

		List<ObjectDefinition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ObjectDefinition existingObjectDefinition = result.get(0);

		Assert.assertEquals(existingObjectDefinition, newObjectDefinition);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ObjectDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"objectDefinitionId", RandomTestUtil.nextLong()));

		List<ObjectDefinition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ObjectDefinition newObjectDefinition = addObjectDefinition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ObjectDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("objectDefinitionId"));

		Object newObjectDefinitionId =
			newObjectDefinition.getObjectDefinitionId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"objectDefinitionId", new Object[] {newObjectDefinitionId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingObjectDefinitionId = result.get(0);

		Assert.assertEquals(existingObjectDefinitionId, newObjectDefinitionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ObjectDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("objectDefinitionId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"objectDefinitionId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ObjectDefinition newObjectDefinition = addObjectDefinition();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newObjectDefinition.getPrimaryKey()));
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

		ObjectDefinition newObjectDefinition = addObjectDefinition();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ObjectDefinition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"objectDefinitionId",
				newObjectDefinition.getObjectDefinitionId()));

		List<ObjectDefinition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(ObjectDefinition objectDefinition) {
		Assert.assertEquals(
			Long.valueOf(objectDefinition.getCompanyId()),
			ReflectionTestUtil.<Long>invoke(
				objectDefinition, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "companyId"));
		Assert.assertEquals(
			objectDefinition.getName(),
			ReflectionTestUtil.invoke(
				objectDefinition, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
		AssertUtils.assertEquals(
			objectDefinition.getVersion(),
			ReflectionTestUtil.<Double>invoke(
				objectDefinition, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "version"));
	}

	protected ObjectDefinition addObjectDefinition() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ObjectDefinition objectDefinition = _persistence.create(pk);

		objectDefinition.setMvccVersion(RandomTestUtil.nextLong());

		objectDefinition.setUuid(RandomTestUtil.randomString());

		objectDefinition.setCompanyId(RandomTestUtil.nextLong());

		objectDefinition.setUserId(RandomTestUtil.nextLong());

		objectDefinition.setUserName(RandomTestUtil.randomString());

		objectDefinition.setCreateDate(RandomTestUtil.nextDate());

		objectDefinition.setModifiedDate(RandomTestUtil.nextDate());

		objectDefinition.setName(RandomTestUtil.randomString());

		objectDefinition.setSystem(RandomTestUtil.randomBoolean());

		objectDefinition.setVersion(RandomTestUtil.nextDouble());

		_objectDefinitions.add(_persistence.update(objectDefinition));

		return objectDefinition;
	}

	private List<ObjectDefinition> _objectDefinitions =
		new ArrayList<ObjectDefinition>();
	private ObjectDefinitionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}