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

package com.liferay.app.builder.it.internal.display.context;

import com.liferay.app.builder.it.constants.ModulePortletKeys;
import com.liferay.app.builder.it.internal.display.context.util.AppBuilderModuleRequestHelper;
import com.liferay.frontend.taglib.clay.data.set.servlet.taglib.util.ClayDataSetActionDropdownItem;
import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marco Leo
 */
public class AppBuilderModuleAdminDisplayContext {

	public AppBuilderModuleAdminDisplayContext(HttpServletRequest httpServletRequest) {

		_appBuilderModuleRequestHelper = new AppBuilderModuleRequestHelper(
			httpServletRequest);
	}

	public String getDataSetDisplaykey(){
		return _appBuilderModuleRequestHelper.getPortletId();
	}

	public String getModuleName(){
		String portletId = _appBuilderModuleRequestHelper.getPortletId();

		return portletId.replaceAll(ModulePortletKeys.MODULE_ADMIN_PREFIX, "");
	}

	public String getApiUrl(){
		return "/o/apps/v1.0/" + getModuleName();
	}

	public List<ClayDataSetActionDropdownItem>
			getClayDataSetActionDropdownItems()
		throws PortalException {

		List<ClayDataSetActionDropdownItem> clayDataSetActionDropdownItems =
			new ArrayList<>();

		//TODO Implement based on permissions

		/*
		clayDataSetActionDropdownItems.add(
			new ClayDataSetActionDropdownItem(
				PortletURLBuilder.create(
					PortletProviderUtil.getPortletURL(
						_commerceOrderRequestHelper.getRequest(),
						CommerceOrder.class.getName(),
						PortletProvider.Action.MANAGE)
				).setMVCRenderCommandName(
					"/commerce_order/edit_commerce_order"
				).setParameter(
					"commerceOrderId", "{id}"
				).buildString(),
				"view", "view",
				LanguageUtil.get(
					_commerceOrderRequestHelper.getRequest(), "view"),
				"get", null, null));

		clayDataSetActionDropdownItems.add(
			new ClayDataSetActionDropdownItem(
				"/o/headless-commerce-admin-order/v1.0/orders/{id}", "trash",
				"delete",
				LanguageUtil.get(
					_commerceOrderRequestHelper.getRequest(), "delete"),
				"delete", "delete", "async"));


		 */
		return clayDataSetActionDropdownItems;
	}

	private final AppBuilderModuleRequestHelper _appBuilderModuleRequestHelper;

}