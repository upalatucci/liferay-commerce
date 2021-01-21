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

package com.liferay.commerce.product.content.web.internal.info;

import com.liferay.commerce.product.catalog.CPMedia;
import com.liferay.commerce.product.content.util.CPContentHelper;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.info.item.renderer.InfoItemRenderer;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.template.react.renderer.ComponentDescriptor;
import com.liferay.portal.template.react.renderer.ReactRenderer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Pavel Savinov
 */
@Component(
	property = "service.ranking:Integer=300", service = {InfoItemRenderer.class, GalleryInfoItemRenderer.class}
)
public class GalleryInfoItemRenderer
	implements InfoItemRenderer<CProduct> {

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "title");
	}

	@Override
	public void render(
		CProduct cProduct, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		if(cProduct == null){
			return;
		}

		try {
			String componentId =
				_portal.generateRandomKey(httpServletRequest, "product.gallery.info.item.renderer") +
				"GalleryComponent";
			String module = "commerce-frontend-js/components/gallery/Gallery";

			PrintWriter writer = httpServletResponse.getWriter();

			ThemeDisplay themeDisplay =
				(ThemeDisplay)httpServletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			List<CPMedia> images = _cpContentHelper.getImages(
				cProduct.getPublishedCPDefinitionId(), themeDisplay);

			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			for(CPMedia cpMedia: images){
				jsonArray.put(
					JSONUtil.put(
						"thumbnailUrl", cpMedia.getThumbnailUrl()
					).put(
						"title", cpMedia.getTitle()
					).put(
						"url", cpMedia.getUrl()
					));
			}

			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"images", jsonArray
			).build();

			_reactRenderer.renderReact(
				new ComponentDescriptor(module, componentId), data,
				httpServletRequest, writer);
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@Reference
	private CPContentHelper _cpContentHelper;

	@Reference
	private Portal _portal;

	@Reference
	private NPMResolver _npmResolver;

	@Reference
	private ReactRenderer _reactRenderer;

}