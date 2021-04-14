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

package com.liferay.app.builder.it.service.test;

import com.liferay.app.builder.it.dao.AppBuilderModuleDAO;
import com.liferay.app.builder.it.dao.AppBuilderModuleDAOServiceRegistry;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.app.builder.it.service.AppBuilderModuleEntryLocalService;
import com.liferay.app.builder.it.service.AppBuilderModuleFieldLocalService;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalService;
import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DataGuard;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Marco Leo
 */
@DataGuard(scope = DataGuard.Scope.METHOD)
@RunWith(Arquillian.class)
public class AppBuilderModuleLocalServiceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_appBuilderModule = _appBuilderModuleLocalService.addAppBuilderModule(
			TestPropsValues.getUserId(), "AppBuilderModuleTest",
			RandomTestUtil.randomString(), true, false, false);
	}

	@Test
	public void testAddAndRemoveAppBuilderModule() throws Exception {
		String moduleName = RandomTestUtil.randomString();

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.addAppBuilderModule(
				TestPropsValues.getUserId(), moduleName, moduleName, true,
				false, false);

		AppBuilderModuleDAO appBuilderModuleDAO =
			_appBuilderModuleDAOServiceRegistry.getAppBuilderModuleDAO(
				appBuilderModule);

		Assert.assertNotNull(appBuilderModuleDAO);

		_appBuilderModuleLocalService.deleteAppBuilderModule(
			appBuilderModule.getAppBuilderModuleId());

		appBuilderModuleDAO =
			_appBuilderModuleDAOServiceRegistry.getAppBuilderModuleDAO(
				appBuilderModule);

		Assert.assertNull(appBuilderModuleDAO);
	}

	@Test
	public void testCreate() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getCompanyId(), TestPropsValues.getGroupId(),
				TestPropsValues.getUserId());

		AppBuilderModuleEntry appBuilderModuleEntry =
			_appBuilderModuleEntryLocalService.addAppBuilderModuleEntry(
				_appBuilderModule.getAppBuilderModuleId(), 0,
				_jsonFactory.createJSONObject(), serviceContext);

		Assert.assertNotNull(appBuilderModuleEntry.getPrimaryKey());
		Assert.assertEquals(
			appBuilderModuleEntry.getUserId(), serviceContext.getUserId());
	}

	@Test
	public void testCreateWithAsset() throws Exception {
		String moduleName = RandomTestUtil.randomString();

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.addAppBuilderModule(
				TestPropsValues.getUserId(), moduleName, moduleName, true, true,
				false);

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getCompanyId(), TestPropsValues.getGroupId(),
				TestPropsValues.getUserId());

		AppBuilderModuleEntry appBuilderModuleEntry =
			_appBuilderModuleEntryLocalService.addAppBuilderModuleEntry(
				appBuilderModule.getAppBuilderModuleId(), 0,
				_jsonFactory.createJSONObject(), serviceContext);

		Assert.assertNotNull(appBuilderModuleEntry.getPrimaryKey());
		Assert.assertEquals(
			appBuilderModuleEntry.getUserId(), serviceContext.getUserId());

		AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(
			appBuilderModule.getDbTableName(),
			appBuilderModuleEntry.getPrimaryKey());

		Assert.assertNotNull(assetEntry);

		_appBuilderModuleLocalService.deleteAppBuilderModule(
			appBuilderModule.getAppBuilderModuleId());
	}

	@Test
	public void testCreateWithResource() throws Exception {
		String moduleName = RandomTestUtil.randomString();

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.addAppBuilderModule(
				TestPropsValues.getUserId(), moduleName, moduleName, true,
				false, true);

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getCompanyId(), TestPropsValues.getGroupId(),
				TestPropsValues.getUserId());

		AppBuilderModuleEntry appBuilderModuleEntry =
			_appBuilderModuleEntryLocalService.addAppBuilderModuleEntry(
				appBuilderModule.getAppBuilderModuleId(), 0,
				_jsonFactory.createJSONObject(), serviceContext);

		Assert.assertNotNull(appBuilderModuleEntry.getPrimaryKey());
		Assert.assertEquals(
			appBuilderModuleEntry.getUserId(), serviceContext.getUserId());

		_appBuilderModuleLocalService.deleteAppBuilderModule(
			appBuilderModule.getAppBuilderModuleId());
	}

	@Test
	public void testRead() throws Exception {
		AppBuilderModuleDAO appBuilderModuleDAO =
			_appBuilderModuleDAOServiceRegistry.getAppBuilderModuleDAO(
				_appBuilderModule);

		appBuilderModuleDAO.getAll(
			TestPropsValues.getCompanyId(), null, -1, -1);
	}

	@DeleteAfterTestRun
	private AppBuilderModule _appBuilderModule;

	@Inject
	private AppBuilderModuleDAOServiceRegistry
		_appBuilderModuleDAOServiceRegistry;

	@Inject
	private AppBuilderModuleEntryLocalService
		_appBuilderModuleEntryLocalService;

	@Inject
	private AppBuilderModuleFieldLocalService
		_appBuilderModuleFieldLocalService;

	@Inject
	private AppBuilderModuleLocalService _appBuilderModuleLocalService;

	@Inject
	private AssetEntryLocalService _assetEntryLocalService;

	@Inject
	private CounterLocalService _counterLocalService;

	@Inject
	private JSONFactory _jsonFactory;

}