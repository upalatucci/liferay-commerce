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

package com.liferay.commerce.discount.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Marco Leo
 * @generated
 */
@ProviderType
public interface CommerceDiscountCommerceAccountGroupRelFinder {

	public int countByCommerceDiscountId(long commerceDiscountId, String name);

	public int countByCommerceDiscountId(
		long commerceDiscountId, String name, boolean inlineSQLHelper);

	public java.util.List
		<com.liferay.commerce.discount.model.
			CommerceDiscountCommerceAccountGroupRel> findByCommerceDiscountId(
				long commerceDiscountId, String name, int start, int end);

	public java.util.List
		<com.liferay.commerce.discount.model.
			CommerceDiscountCommerceAccountGroupRel> findByCommerceDiscountId(
				long commerceDiscountId, String name, int start, int end,
				boolean inlineSQLHelper);

}