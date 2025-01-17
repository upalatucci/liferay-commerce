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

package com.liferay.password.policies.admin.web.internal.search;

import com.liferay.password.policies.admin.constants.PasswordPoliciesAdminPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.portlet.SearchOrderByUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.comparator.PasswordPolicyDescriptionComparator;
import com.liferay.portal.kernel.util.comparator.PasswordPolicyNameComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Scott Lee
 */
public class PasswordPolicySearch extends SearchContainer<PasswordPolicy> {

	public static final String EMPTY_RESULTS_MESSAGE =
		"no-password-policies-were-found";

	public static List<String> headerNames = new ArrayList<String>() {
		{
			add("name");
			add("description");
		}
	};
	public static Map<String, String> orderableHeaders = HashMapBuilder.put(
		"description", "description"
	).put(
		"name", "name"
	).build();

	public PasswordPolicySearch(
		PortletRequest portletRequest, PortletURL iteratorURL) {

		super(
			portletRequest, new PasswordPolicyDisplayTerms(portletRequest),
			new PasswordPolicyDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		PasswordPolicyDisplayTerms displayTerms =
			(PasswordPolicyDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
			PasswordPolicyDisplayTerms.NAME, displayTerms.getName());

		try {
			setOrderableHeaders(orderableHeaders);

			String orderByCol = SearchOrderByUtil.getOrderByCol(
				portletRequest,
				PasswordPoliciesAdminPortletKeys.PASSWORD_POLICIES_ADMIN,
				"password-policies-order-by-col", "name");

			setOrderByCol(orderByCol);

			String orderByType = SearchOrderByUtil.getOrderByType(
				portletRequest,
				PasswordPoliciesAdminPortletKeys.PASSWORD_POLICIES_ADMIN,
				"password-policies-order-by-type", "asc");

			setOrderByComparator(getOrderByComparator(orderByCol, orderByType));
			setOrderByType(orderByType);
		}
		catch (Exception exception) {
			_log.error(
				"Unable to initialize password policy search", exception);
		}
	}

	protected OrderByComparator<PasswordPolicy> getOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<PasswordPolicy> orderByComparator = null;

		if (orderByCol.equals("name")) {
			orderByComparator = new PasswordPolicyNameComparator(orderByAsc);
		}
		else if (orderByCol.equals("description")) {
			orderByComparator = new PasswordPolicyDescriptionComparator(
				orderByAsc);
		}
		else {
			orderByComparator = new PasswordPolicyNameComparator(orderByAsc);
		}

		return orderByComparator;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PasswordPolicySearch.class);

}