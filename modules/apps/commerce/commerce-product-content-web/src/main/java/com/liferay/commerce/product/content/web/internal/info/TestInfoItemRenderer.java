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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.info.item.renderer.InfoItemRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * @author Pavel Savinov
 */
@Component(
	property = "service.ranking:Integer=300", service = {InfoItemRenderer.class, TestInfoItemRenderer.class}
)
public class TestInfoItemRenderer
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
			PrintWriter printWriter = httpServletResponse.getWriter();

			printWriter.print(String.valueOf(cProduct.getCProductId()));

			printWriter.flush();
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

}