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

package com.liferay.commerce.product.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CPInstanceOptionValueRel. This utility wraps
 * <code>com.liferay.commerce.product.service.impl.CPInstanceOptionValueRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marco Leo
 * @see CPInstanceOptionValueRelLocalService
 * @generated
 */
public class CPInstanceOptionValueRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.product.service.impl.CPInstanceOptionValueRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cp instance option value rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CPInstanceOptionValueRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cpInstanceOptionValueRel the cp instance option value rel
	 * @return the cp instance option value rel that was added
	 */
	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
		addCPInstanceOptionValueRel(
			com.liferay.commerce.product.model.CPInstanceOptionValueRel
				cpInstanceOptionValueRel) {

		return getService().addCPInstanceOptionValueRel(
			cpInstanceOptionValueRel);
	}

	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
			addCPInstanceOptionValueRel(
				long groupId, long companyId, long userId,
				long cpDefinitionOptionRelId, long cpDefinitionOptionValueRelId,
				long cpInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCPInstanceOptionValueRel(
			groupId, companyId, userId, cpDefinitionOptionRelId,
			cpDefinitionOptionValueRelId, cpInstanceId);
	}

	/**
	 * Creates a new cp instance option value rel with the primary key. Does not add the cp instance option value rel to the database.
	 *
	 * @param CPInstanceOptionValueRelId the primary key for the new cp instance option value rel
	 * @return the new cp instance option value rel
	 */
	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
		createCPInstanceOptionValueRel(long CPInstanceOptionValueRelId) {

		return getService().createCPInstanceOptionValueRel(
			CPInstanceOptionValueRelId);
	}

	/**
	 * Deletes the cp instance option value rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CPInstanceOptionValueRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cpInstanceOptionValueRel the cp instance option value rel
	 * @return the cp instance option value rel that was removed
	 */
	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
		deleteCPInstanceOptionValueRel(
			com.liferay.commerce.product.model.CPInstanceOptionValueRel
				cpInstanceOptionValueRel) {

		return getService().deleteCPInstanceOptionValueRel(
			cpInstanceOptionValueRel);
	}

	/**
	 * Deletes the cp instance option value rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CPInstanceOptionValueRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param CPInstanceOptionValueRelId the primary key of the cp instance option value rel
	 * @return the cp instance option value rel that was removed
	 * @throws PortalException if a cp instance option value rel with the primary key could not be found
	 */
	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
			deleteCPInstanceOptionValueRel(long CPInstanceOptionValueRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCPInstanceOptionValueRel(
			CPInstanceOptionValueRelId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.product.model.impl.CPInstanceOptionValueRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.product.model.impl.CPInstanceOptionValueRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
		fetchCPInstanceOptionValueRel(long CPInstanceOptionValueRelId) {

		return getService().fetchCPInstanceOptionValueRel(
			CPInstanceOptionValueRelId);
	}

	/**
	 * Returns the cp instance option value rel matching the UUID and group.
	 *
	 * @param uuid the cp instance option value rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cp instance option value rel, or <code>null</code> if a matching cp instance option value rel could not be found
	 */
	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
		fetchCPInstanceOptionValueRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchCPInstanceOptionValueRelByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.liferay.commerce.product.model.CPInstanceOptionValueRel>
			getCPDefinitionCPInstanceOptionValueRels(long cpDefinitionId) {

		return getService().getCPDefinitionCPInstanceOptionValueRels(
			cpDefinitionId);
	}

	public static java.util.List
		<com.liferay.commerce.product.model.CPInstanceOptionValueRel>
			getCPDefinitionOptionRelCPInstanceOptionValueRels(
				long cpDefinitionOptionRelId) {

		return getService().getCPDefinitionOptionRelCPInstanceOptionValueRels(
			cpDefinitionOptionRelId);
	}

	public static java.util.List
		<com.liferay.commerce.product.model.CPInstanceOptionValueRel>
			getCPInstanceCPInstanceOptionValueRels(long cpInstanceId) {

		return getService().getCPInstanceCPInstanceOptionValueRels(
			cpInstanceId);
	}

	public static java.util.List
		<com.liferay.commerce.product.model.CPInstanceOptionValueRel>
			getCPInstanceCPInstanceOptionValueRels(
				long cpDefinitionOptionRelId, long cpInstanceId) {

		return getService().getCPInstanceCPInstanceOptionValueRels(
			cpDefinitionOptionRelId, cpInstanceId);
	}

	/**
	 * Returns the cp instance option value rel with the primary key.
	 *
	 * @param CPInstanceOptionValueRelId the primary key of the cp instance option value rel
	 * @return the cp instance option value rel
	 * @throws PortalException if a cp instance option value rel with the primary key could not be found
	 */
	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
			getCPInstanceOptionValueRel(long CPInstanceOptionValueRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCPInstanceOptionValueRel(
			CPInstanceOptionValueRelId);
	}

	/**
	 * Returns the cp instance option value rel matching the UUID and group.
	 *
	 * @param uuid the cp instance option value rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cp instance option value rel
	 * @throws PortalException if a matching cp instance option value rel could not be found
	 */
	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
			getCPInstanceOptionValueRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCPInstanceOptionValueRelByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the cp instance option value rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.product.model.impl.CPInstanceOptionValueRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cp instance option value rels
	 * @param end the upper bound of the range of cp instance option value rels (not inclusive)
	 * @return the range of cp instance option value rels
	 */
	public static java.util.List
		<com.liferay.commerce.product.model.CPInstanceOptionValueRel>
			getCPInstanceOptionValueRels(int start, int end) {

		return getService().getCPInstanceOptionValueRels(start, end);
	}

	/**
	 * Returns all the cp instance option value rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the cp instance option value rels
	 * @param companyId the primary key of the company
	 * @return the matching cp instance option value rels, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.liferay.commerce.product.model.CPInstanceOptionValueRel>
			getCPInstanceOptionValueRelsByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getCPInstanceOptionValueRelsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of cp instance option value rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the cp instance option value rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cp instance option value rels
	 * @param end the upper bound of the range of cp instance option value rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cp instance option value rels, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.liferay.commerce.product.model.CPInstanceOptionValueRel>
			getCPInstanceOptionValueRelsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.commerce.product.model.
						CPInstanceOptionValueRel> orderByComparator) {

		return getService().getCPInstanceOptionValueRelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cp instance option value rels.
	 *
	 * @return the number of cp instance option value rels
	 */
	public static int getCPInstanceOptionValueRelsCount() {
		return getService().getCPInstanceOptionValueRelsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasCPInstanceCPDefinitionOptionRel(
		long cpDefinitionOptionRelId, long cpInstanceId) {

		return getService().hasCPInstanceCPDefinitionOptionRel(
			cpDefinitionOptionRelId, cpInstanceId);
	}

	public static boolean hasCPInstanceCPDefinitionOptionValueRel(
		long cpDefinitionOptionValueRelId, long cpInstanceId) {

		return getService().hasCPInstanceCPDefinitionOptionValueRel(
			cpDefinitionOptionValueRelId, cpInstanceId);
	}

	public static boolean hasCPInstanceOptionValueRel(long cpInstanceId) {
		return getService().hasCPInstanceOptionValueRel(cpInstanceId);
	}

	public static boolean matchesCPDefinitionOptionRels(
		long cpDefinitionId, long cpInstanceId) {

		return getService().matchesCPDefinitionOptionRels(
			cpDefinitionId, cpInstanceId);
	}

	public static boolean matchesCPInstanceOptionValueRels(
		long cpInstanceId,
		java.util.List
			<com.liferay.commerce.product.model.CPInstanceOptionValueRel>
				cpInstanceOptionValueRels) {

		return getService().matchesCPInstanceOptionValueRels(
			cpInstanceId, cpInstanceOptionValueRels);
	}

	public static boolean matchesCPInstanceOptionValueRels(
		long cpInstanceId,
		java.util.Map<Long, java.util.List<Long>>
			cpDefinitionOptionRelIdsCPDefinitionOptionValueRelIds) {

		return getService().matchesCPInstanceOptionValueRels(
			cpInstanceId,
			cpDefinitionOptionRelIdsCPDefinitionOptionValueRelIds);
	}

	/**
	 * Updates the cp instance option value rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CPInstanceOptionValueRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cpInstanceOptionValueRel the cp instance option value rel
	 * @return the cp instance option value rel that was updated
	 */
	public static com.liferay.commerce.product.model.CPInstanceOptionValueRel
		updateCPInstanceOptionValueRel(
			com.liferay.commerce.product.model.CPInstanceOptionValueRel
				cpInstanceOptionValueRel) {

		return getService().updateCPInstanceOptionValueRel(
			cpInstanceOptionValueRel);
	}

	public static void updateCPInstanceOptionValueRels(
			long groupId, long companyId, long userId, long cpInstanceId,
			java.util.Map<Long, java.util.List<Long>>
				cpDefinitionOptionRelIdCPDefinitionOptionValueRelIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateCPInstanceOptionValueRels(
			groupId, companyId, userId, cpInstanceId,
			cpDefinitionOptionRelIdCPDefinitionOptionValueRelIds);
	}

	public static CPInstanceOptionValueRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CPInstanceOptionValueRelLocalService,
		 CPInstanceOptionValueRelLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CPInstanceOptionValueRelLocalService.class);

		ServiceTracker
			<CPInstanceOptionValueRelLocalService,
			 CPInstanceOptionValueRelLocalService> serviceTracker =
				new ServiceTracker
					<CPInstanceOptionValueRelLocalService,
					 CPInstanceOptionValueRelLocalService>(
						 bundle.getBundleContext(),
						 CPInstanceOptionValueRelLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}