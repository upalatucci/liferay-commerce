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

package com.liferay.commerce.product.asset.categories.web.internal.display.context;

import com.liferay.commerce.frontend.ClayCreationMenu;
import com.liferay.commerce.frontend.ClayCreationMenuActionItem;
import com.liferay.commerce.product.definitions.web.display.context.BaseCPDefinitionsDisplayContext;
import com.liferay.commerce.product.definitions.web.portlet.action.ActionHelper;
import com.liferay.commerce.product.model.CPDisplayLayout;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CPDisplayLayoutService;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.UUIDItemSelectorReturnType;
import com.liferay.layout.item.selector.criterion.LayoutItemSelectorCriterion;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alessio Antonio Rendina
 */
public class CategoryCPDisplayLayoutDisplayContext
	extends BaseCPDefinitionsDisplayContext {

	public CategoryCPDisplayLayoutDisplayContext(
		ActionHelper actionHelper, HttpServletRequest httpServletRequest,
		CommerceChannelLocalService commerceChannelLocalService,
		CPDisplayLayoutService cpDisplayLayoutService,
		GroupLocalService groupLocalService, ItemSelector itemSelector) {

		super(actionHelper, httpServletRequest);

		_commerceChannelLocalService = commerceChannelLocalService;
		_cpDisplayLayoutService = cpDisplayLayoutService;
		_groupLocalService = groupLocalService;
		_itemSelector = itemSelector;
	}

	public String getAddCategoryDisplayPageURL() throws Exception {
		PortletURL portletURL = PortletProviderUtil.getPortletURL(
			httpServletRequest, CommerceChannel.class.getName(),
			PortletProvider.Action.MANAGE);

		portletURL.setParameter(
			"mvcRenderCommandName", "editCategoryDisplayLayout");
		portletURL.setParameter(
			"commerceChannelId", String.valueOf(getCommerceChannelId()));

		portletURL.setWindowState(LiferayWindowState.POP_UP);

		return portletURL.toString();
	}

	public ClayCreationMenu getClayCreationMenu() throws Exception {
		ClayCreationMenu clayCreationMenu = new ClayCreationMenu();

		clayCreationMenu.addClayCreationMenuActionItem(
			getAddCategoryDisplayPageURL(),
			LanguageUtil.get(httpServletRequest, "add-display-layout"),
			ClayCreationMenuActionItem.CLAY_MENU_ACTION_ITEM_TARGET_SIDE_PANEL);

		return clayCreationMenu;
	}

	public CommerceChannel getCommerceChannel() {
		long commerceChannelId = ParamUtil.getLong(
			httpServletRequest, "commerceChannelId");

		return _commerceChannelLocalService.fetchCommerceChannel(
			commerceChannelId);
	}

	public long getCommerceChannelId() {
		CommerceChannel commerceChannel = getCommerceChannel();

		if (commerceChannel == null) {
			return 0;
		}

		return commerceChannel.getCommerceChannelId();
	}

	public CPDisplayLayout getCPDisplayLayout() throws PortalException {
		if (_cpDisplayLayout != null) {
			return _cpDisplayLayout;
		}

		long cpDisplayLayoutId = ParamUtil.getLong(
			cpRequestHelper.getRequest(), "cpDisplayLayoutId");

		_cpDisplayLayout = _cpDisplayLayoutService.fetchCPDisplayLayout(
			cpDisplayLayoutId);

		return _cpDisplayLayout;
	}

	public String getItemSelectorUrl(RenderRequest renderRequest)
		throws PortalException {

		RequestBackedPortletURLFactory requestBackedPortletURLFactory =
			RequestBackedPortletURLFactoryUtil.create(renderRequest);

		LayoutItemSelectorCriterion layoutItemSelectorCriterion =
			new LayoutItemSelectorCriterion();

		layoutItemSelectorCriterion.setShowHiddenPages(true);
		layoutItemSelectorCriterion.setShowPrivatePages(true);
		layoutItemSelectorCriterion.setShowPublicPages(true);

		layoutItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
			Collections.<ItemSelectorReturnType>singletonList(
				new UUIDItemSelectorReturnType()));

		CommerceChannel commerceChannel = getCommerceChannel();

		PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
			requestBackedPortletURLFactory,
			_groupLocalService.getGroup(commerceChannel.getSiteGroupId()),
			commerceChannel.getSiteGroupId(), "selectDisplayPage",
			layoutItemSelectorCriterion);

		return itemSelectorURL.toString();
	}

	public String getLayoutBreadcrumb(Layout layout) throws Exception {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		Locale locale = themeDisplay.getLocale();

		List<Layout> ancestors = layout.getAncestors();

		StringBundler sb = new StringBundler((4 * ancestors.size()) + 5);

		if (layout.isPrivateLayout()) {
			sb.append(LanguageUtil.get(httpServletRequest, "private-pages"));
		}
		else {
			sb.append(LanguageUtil.get(httpServletRequest, "public-pages"));
		}

		sb.append(StringPool.SPACE);
		sb.append(StringPool.GREATER_THAN);
		sb.append(StringPool.SPACE);

		Collections.reverse(ancestors);

		for (Layout ancestor : ancestors) {
			sb.append(HtmlUtil.escape(ancestor.getName(locale)));
			sb.append(StringPool.SPACE);
			sb.append(StringPool.GREATER_THAN);
			sb.append(StringPool.SPACE);
		}

		sb.append(HtmlUtil.escape(layout.getName(locale)));

		return sb.toString();
	}

	public PortletURL getPortletURL() {
		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		String redirect = ParamUtil.getString(httpServletRequest, "redirect");

		if (Validator.isNotNull(redirect)) {
			portletURL.setParameter("redirect", redirect);
		}

		String delta = ParamUtil.getString(httpServletRequest, "delta");

		if (Validator.isNotNull(delta)) {
			portletURL.setParameter("delta", delta);
		}

		String deltaEntry = ParamUtil.getString(
			httpServletRequest, "deltaEntry");

		if (Validator.isNotNull(deltaEntry)) {
			portletURL.setParameter("deltaEntry", deltaEntry);
		}

		String displayStyle = ParamUtil.getString(
			httpServletRequest, "displayStyle");

		if (Validator.isNotNull(displayStyle)) {
			portletURL.setParameter("displayStyle", displayStyle);
		}

		String keywords = ParamUtil.getString(httpServletRequest, "keywords");

		if (Validator.isNotNull(keywords)) {
			portletURL.setParameter("keywords", keywords);
		}

		portletURL.setParameter(
			"commerceChannelId", String.valueOf(getCommerceChannelId()));

		return portletURL;
	}

	private final CommerceChannelLocalService _commerceChannelLocalService;
	private CPDisplayLayout _cpDisplayLayout;
	private final CPDisplayLayoutService _cpDisplayLayoutService;
	private final GroupLocalService _groupLocalService;
	private final ItemSelector _itemSelector;

}