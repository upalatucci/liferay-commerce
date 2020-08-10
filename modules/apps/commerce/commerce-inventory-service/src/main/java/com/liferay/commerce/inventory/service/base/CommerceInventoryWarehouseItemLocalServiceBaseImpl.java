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

package com.liferay.commerce.inventory.service.base;

import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalService;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryAuditPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryBookedQuantityPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryReplenishmentItemPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehouseFinder;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehouseItemFinder;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehouseItemPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehousePersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce inventory warehouse item local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.inventory.service.impl.CommerceInventoryWarehouseItemLocalServiceImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see com.liferay.commerce.inventory.service.impl.CommerceInventoryWarehouseItemLocalServiceImpl
 * @generated
 */
public abstract class CommerceInventoryWarehouseItemLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CommerceInventoryWarehouseItemLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceInventoryWarehouseItemLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce inventory warehouse item to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceInventoryWarehouseItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceInventoryWarehouseItem the commerce inventory warehouse item
	 * @return the commerce inventory warehouse item that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceInventoryWarehouseItem addCommerceInventoryWarehouseItem(
		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem) {

		commerceInventoryWarehouseItem.setNew(true);

		return commerceInventoryWarehouseItemPersistence.update(
			commerceInventoryWarehouseItem);
	}

	/**
	 * Creates a new commerce inventory warehouse item with the primary key. Does not add the commerce inventory warehouse item to the database.
	 *
	 * @param commerceInventoryWarehouseItemId the primary key for the new commerce inventory warehouse item
	 * @return the new commerce inventory warehouse item
	 */
	@Override
	@Transactional(enabled = false)
	public CommerceInventoryWarehouseItem createCommerceInventoryWarehouseItem(
		long commerceInventoryWarehouseItemId) {

		return commerceInventoryWarehouseItemPersistence.create(
			commerceInventoryWarehouseItemId);
	}

	/**
	 * Deletes the commerce inventory warehouse item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceInventoryWarehouseItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceInventoryWarehouseItemId the primary key of the commerce inventory warehouse item
	 * @return the commerce inventory warehouse item that was removed
	 * @throws PortalException if a commerce inventory warehouse item with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceInventoryWarehouseItem deleteCommerceInventoryWarehouseItem(
			long commerceInventoryWarehouseItemId)
		throws PortalException {

		return commerceInventoryWarehouseItemPersistence.remove(
			commerceInventoryWarehouseItemId);
	}

	/**
	 * Deletes the commerce inventory warehouse item from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceInventoryWarehouseItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceInventoryWarehouseItem the commerce inventory warehouse item
	 * @return the commerce inventory warehouse item that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceInventoryWarehouseItem deleteCommerceInventoryWarehouseItem(
		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem) {

		return commerceInventoryWarehouseItemPersistence.remove(
			commerceInventoryWarehouseItem);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommerceInventoryWarehouseItem.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commerceInventoryWarehouseItemPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commerceInventoryWarehouseItemPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commerceInventoryWarehouseItemPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commerceInventoryWarehouseItemPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return commerceInventoryWarehouseItemPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CommerceInventoryWarehouseItem fetchCommerceInventoryWarehouseItem(
		long commerceInventoryWarehouseItemId) {

		return commerceInventoryWarehouseItemPersistence.fetchByPrimaryKey(
			commerceInventoryWarehouseItemId);
	}

	/**
	 * Returns the commerce inventory warehouse item with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the commerce inventory warehouse item's external reference code
	 * @return the matching commerce inventory warehouse item, or <code>null</code> if a matching commerce inventory warehouse item could not be found
	 */
	@Override
	public CommerceInventoryWarehouseItem
		fetchCommerceInventoryWarehouseItemByReferenceCode(
			long companyId, String externalReferenceCode) {

		return commerceInventoryWarehouseItemPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the commerce inventory warehouse item with the primary key.
	 *
	 * @param commerceInventoryWarehouseItemId the primary key of the commerce inventory warehouse item
	 * @return the commerce inventory warehouse item
	 * @throws PortalException if a commerce inventory warehouse item with the primary key could not be found
	 */
	@Override
	public CommerceInventoryWarehouseItem getCommerceInventoryWarehouseItem(
			long commerceInventoryWarehouseItemId)
		throws PortalException {

		return commerceInventoryWarehouseItemPersistence.findByPrimaryKey(
			commerceInventoryWarehouseItemId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commerceInventoryWarehouseItemLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommerceInventoryWarehouseItem.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceInventoryWarehouseItemId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commerceInventoryWarehouseItemLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CommerceInventoryWarehouseItem.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceInventoryWarehouseItemId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commerceInventoryWarehouseItemLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommerceInventoryWarehouseItem.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceInventoryWarehouseItemId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commerceInventoryWarehouseItemLocalService.
			deleteCommerceInventoryWarehouseItem(
				(CommerceInventoryWarehouseItem)persistedModel);
	}

	public BasePersistence<CommerceInventoryWarehouseItem>
		getBasePersistence() {

		return commerceInventoryWarehouseItemPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceInventoryWarehouseItemPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce inventory warehouse items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.inventory.model.impl.CommerceInventoryWarehouseItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce inventory warehouse items
	 * @param end the upper bound of the range of commerce inventory warehouse items (not inclusive)
	 * @return the range of commerce inventory warehouse items
	 */
	@Override
	public List<CommerceInventoryWarehouseItem>
		getCommerceInventoryWarehouseItems(int start, int end) {

		return commerceInventoryWarehouseItemPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce inventory warehouse items.
	 *
	 * @return the number of commerce inventory warehouse items
	 */
	@Override
	public int getCommerceInventoryWarehouseItemsCount() {
		return commerceInventoryWarehouseItemPersistence.countAll();
	}

	/**
	 * Updates the commerce inventory warehouse item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceInventoryWarehouseItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceInventoryWarehouseItem the commerce inventory warehouse item
	 * @return the commerce inventory warehouse item that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceInventoryWarehouseItem updateCommerceInventoryWarehouseItem(
		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem) {

		return commerceInventoryWarehouseItemPersistence.update(
			commerceInventoryWarehouseItem);
	}

	/**
	 * Returns the commerce inventory audit local service.
	 *
	 * @return the commerce inventory audit local service
	 */
	public
		com.liferay.commerce.inventory.service.
			CommerceInventoryAuditLocalService
				getCommerceInventoryAuditLocalService() {

		return commerceInventoryAuditLocalService;
	}

	/**
	 * Sets the commerce inventory audit local service.
	 *
	 * @param commerceInventoryAuditLocalService the commerce inventory audit local service
	 */
	public void setCommerceInventoryAuditLocalService(
		com.liferay.commerce.inventory.service.
			CommerceInventoryAuditLocalService
				commerceInventoryAuditLocalService) {

		this.commerceInventoryAuditLocalService =
			commerceInventoryAuditLocalService;
	}

	/**
	 * Returns the commerce inventory audit persistence.
	 *
	 * @return the commerce inventory audit persistence
	 */
	public CommerceInventoryAuditPersistence
		getCommerceInventoryAuditPersistence() {

		return commerceInventoryAuditPersistence;
	}

	/**
	 * Sets the commerce inventory audit persistence.
	 *
	 * @param commerceInventoryAuditPersistence the commerce inventory audit persistence
	 */
	public void setCommerceInventoryAuditPersistence(
		CommerceInventoryAuditPersistence commerceInventoryAuditPersistence) {

		this.commerceInventoryAuditPersistence =
			commerceInventoryAuditPersistence;
	}

	/**
	 * Returns the commerce inventory booked quantity local service.
	 *
	 * @return the commerce inventory booked quantity local service
	 */
	public com.liferay.commerce.inventory.service.
		CommerceInventoryBookedQuantityLocalService
			getCommerceInventoryBookedQuantityLocalService() {

		return commerceInventoryBookedQuantityLocalService;
	}

	/**
	 * Sets the commerce inventory booked quantity local service.
	 *
	 * @param commerceInventoryBookedQuantityLocalService the commerce inventory booked quantity local service
	 */
	public void setCommerceInventoryBookedQuantityLocalService(
		com.liferay.commerce.inventory.service.
			CommerceInventoryBookedQuantityLocalService
				commerceInventoryBookedQuantityLocalService) {

		this.commerceInventoryBookedQuantityLocalService =
			commerceInventoryBookedQuantityLocalService;
	}

	/**
	 * Returns the commerce inventory booked quantity persistence.
	 *
	 * @return the commerce inventory booked quantity persistence
	 */
	public CommerceInventoryBookedQuantityPersistence
		getCommerceInventoryBookedQuantityPersistence() {

		return commerceInventoryBookedQuantityPersistence;
	}

	/**
	 * Sets the commerce inventory booked quantity persistence.
	 *
	 * @param commerceInventoryBookedQuantityPersistence the commerce inventory booked quantity persistence
	 */
	public void setCommerceInventoryBookedQuantityPersistence(
		CommerceInventoryBookedQuantityPersistence
			commerceInventoryBookedQuantityPersistence) {

		this.commerceInventoryBookedQuantityPersistence =
			commerceInventoryBookedQuantityPersistence;
	}

	/**
	 * Returns the commerce inventory replenishment item local service.
	 *
	 * @return the commerce inventory replenishment item local service
	 */
	public com.liferay.commerce.inventory.service.
		CommerceInventoryReplenishmentItemLocalService
			getCommerceInventoryReplenishmentItemLocalService() {

		return commerceInventoryReplenishmentItemLocalService;
	}

	/**
	 * Sets the commerce inventory replenishment item local service.
	 *
	 * @param commerceInventoryReplenishmentItemLocalService the commerce inventory replenishment item local service
	 */
	public void setCommerceInventoryReplenishmentItemLocalService(
		com.liferay.commerce.inventory.service.
			CommerceInventoryReplenishmentItemLocalService
				commerceInventoryReplenishmentItemLocalService) {

		this.commerceInventoryReplenishmentItemLocalService =
			commerceInventoryReplenishmentItemLocalService;
	}

	/**
	 * Returns the commerce inventory replenishment item persistence.
	 *
	 * @return the commerce inventory replenishment item persistence
	 */
	public CommerceInventoryReplenishmentItemPersistence
		getCommerceInventoryReplenishmentItemPersistence() {

		return commerceInventoryReplenishmentItemPersistence;
	}

	/**
	 * Sets the commerce inventory replenishment item persistence.
	 *
	 * @param commerceInventoryReplenishmentItemPersistence the commerce inventory replenishment item persistence
	 */
	public void setCommerceInventoryReplenishmentItemPersistence(
		CommerceInventoryReplenishmentItemPersistence
			commerceInventoryReplenishmentItemPersistence) {

		this.commerceInventoryReplenishmentItemPersistence =
			commerceInventoryReplenishmentItemPersistence;
	}

	/**
	 * Returns the commerce inventory warehouse local service.
	 *
	 * @return the commerce inventory warehouse local service
	 */
	public com.liferay.commerce.inventory.service.
		CommerceInventoryWarehouseLocalService
			getCommerceInventoryWarehouseLocalService() {

		return commerceInventoryWarehouseLocalService;
	}

	/**
	 * Sets the commerce inventory warehouse local service.
	 *
	 * @param commerceInventoryWarehouseLocalService the commerce inventory warehouse local service
	 */
	public void setCommerceInventoryWarehouseLocalService(
		com.liferay.commerce.inventory.service.
			CommerceInventoryWarehouseLocalService
				commerceInventoryWarehouseLocalService) {

		this.commerceInventoryWarehouseLocalService =
			commerceInventoryWarehouseLocalService;
	}

	/**
	 * Returns the commerce inventory warehouse persistence.
	 *
	 * @return the commerce inventory warehouse persistence
	 */
	public CommerceInventoryWarehousePersistence
		getCommerceInventoryWarehousePersistence() {

		return commerceInventoryWarehousePersistence;
	}

	/**
	 * Sets the commerce inventory warehouse persistence.
	 *
	 * @param commerceInventoryWarehousePersistence the commerce inventory warehouse persistence
	 */
	public void setCommerceInventoryWarehousePersistence(
		CommerceInventoryWarehousePersistence
			commerceInventoryWarehousePersistence) {

		this.commerceInventoryWarehousePersistence =
			commerceInventoryWarehousePersistence;
	}

	/**
	 * Returns the commerce inventory warehouse finder.
	 *
	 * @return the commerce inventory warehouse finder
	 */
	public CommerceInventoryWarehouseFinder
		getCommerceInventoryWarehouseFinder() {

		return commerceInventoryWarehouseFinder;
	}

	/**
	 * Sets the commerce inventory warehouse finder.
	 *
	 * @param commerceInventoryWarehouseFinder the commerce inventory warehouse finder
	 */
	public void setCommerceInventoryWarehouseFinder(
		CommerceInventoryWarehouseFinder commerceInventoryWarehouseFinder) {

		this.commerceInventoryWarehouseFinder =
			commerceInventoryWarehouseFinder;
	}

	/**
	 * Returns the commerce inventory warehouse item local service.
	 *
	 * @return the commerce inventory warehouse item local service
	 */
	public CommerceInventoryWarehouseItemLocalService
		getCommerceInventoryWarehouseItemLocalService() {

		return commerceInventoryWarehouseItemLocalService;
	}

	/**
	 * Sets the commerce inventory warehouse item local service.
	 *
	 * @param commerceInventoryWarehouseItemLocalService the commerce inventory warehouse item local service
	 */
	public void setCommerceInventoryWarehouseItemLocalService(
		CommerceInventoryWarehouseItemLocalService
			commerceInventoryWarehouseItemLocalService) {

		this.commerceInventoryWarehouseItemLocalService =
			commerceInventoryWarehouseItemLocalService;
	}

	/**
	 * Returns the commerce inventory warehouse item persistence.
	 *
	 * @return the commerce inventory warehouse item persistence
	 */
	public CommerceInventoryWarehouseItemPersistence
		getCommerceInventoryWarehouseItemPersistence() {

		return commerceInventoryWarehouseItemPersistence;
	}

	/**
	 * Sets the commerce inventory warehouse item persistence.
	 *
	 * @param commerceInventoryWarehouseItemPersistence the commerce inventory warehouse item persistence
	 */
	public void setCommerceInventoryWarehouseItemPersistence(
		CommerceInventoryWarehouseItemPersistence
			commerceInventoryWarehouseItemPersistence) {

		this.commerceInventoryWarehouseItemPersistence =
			commerceInventoryWarehouseItemPersistence;
	}

	/**
	 * Returns the commerce inventory warehouse item finder.
	 *
	 * @return the commerce inventory warehouse item finder
	 */
	public CommerceInventoryWarehouseItemFinder
		getCommerceInventoryWarehouseItemFinder() {

		return commerceInventoryWarehouseItemFinder;
	}

	/**
	 * Sets the commerce inventory warehouse item finder.
	 *
	 * @param commerceInventoryWarehouseItemFinder the commerce inventory warehouse item finder
	 */
	public void setCommerceInventoryWarehouseItemFinder(
		CommerceInventoryWarehouseItemFinder
			commerceInventoryWarehouseItemFinder) {

		this.commerceInventoryWarehouseItemFinder =
			commerceInventoryWarehouseItemFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem",
			commerceInventoryWarehouseItemLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceInventoryWarehouseItemLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceInventoryWarehouseItem.class;
	}

	protected String getModelClassName() {
		return CommerceInventoryWarehouseItem.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commerceInventoryWarehouseItemPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@BeanReference(
		type = com.liferay.commerce.inventory.service.CommerceInventoryAuditLocalService.class
	)
	protected
		com.liferay.commerce.inventory.service.
			CommerceInventoryAuditLocalService
				commerceInventoryAuditLocalService;

	@BeanReference(type = CommerceInventoryAuditPersistence.class)
	protected CommerceInventoryAuditPersistence
		commerceInventoryAuditPersistence;

	@BeanReference(
		type = com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityLocalService.class
	)
	protected com.liferay.commerce.inventory.service.
		CommerceInventoryBookedQuantityLocalService
			commerceInventoryBookedQuantityLocalService;

	@BeanReference(type = CommerceInventoryBookedQuantityPersistence.class)
	protected CommerceInventoryBookedQuantityPersistence
		commerceInventoryBookedQuantityPersistence;

	@BeanReference(
		type = com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemLocalService.class
	)
	protected com.liferay.commerce.inventory.service.
		CommerceInventoryReplenishmentItemLocalService
			commerceInventoryReplenishmentItemLocalService;

	@BeanReference(type = CommerceInventoryReplenishmentItemPersistence.class)
	protected CommerceInventoryReplenishmentItemPersistence
		commerceInventoryReplenishmentItemPersistence;

	@BeanReference(
		type = com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalService.class
	)
	protected com.liferay.commerce.inventory.service.
		CommerceInventoryWarehouseLocalService
			commerceInventoryWarehouseLocalService;

	@BeanReference(type = CommerceInventoryWarehousePersistence.class)
	protected CommerceInventoryWarehousePersistence
		commerceInventoryWarehousePersistence;

	@BeanReference(type = CommerceInventoryWarehouseFinder.class)
	protected CommerceInventoryWarehouseFinder commerceInventoryWarehouseFinder;

	@BeanReference(type = CommerceInventoryWarehouseItemLocalService.class)
	protected CommerceInventoryWarehouseItemLocalService
		commerceInventoryWarehouseItemLocalService;

	@BeanReference(type = CommerceInventoryWarehouseItemPersistence.class)
	protected CommerceInventoryWarehouseItemPersistence
		commerceInventoryWarehouseItemPersistence;

	@BeanReference(type = CommerceInventoryWarehouseItemFinder.class)
	protected CommerceInventoryWarehouseItemFinder
		commerceInventoryWarehouseItemFinder;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}