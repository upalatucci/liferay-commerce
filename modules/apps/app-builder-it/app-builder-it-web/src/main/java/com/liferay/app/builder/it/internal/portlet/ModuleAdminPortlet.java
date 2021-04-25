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

package com.liferay.app.builder.it.internal.portlet;

import com.liferay.app.builder.it.constants.ModulePortletKeys;
import com.liferay.app.builder.it.internal.display.context.AppBuilderModuleAdminDisplayContext;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;

/**
 * @author Marco Leo
 */
public class ModuleAdminPortlet extends MVCPortlet {

	public ModuleAdminPortlet(String appName, Portal portal, String portletName){
		_appName = appName;
		_portal = portal;
		_portletName = portletName;
	}

	private String _appName;
	private String _portletName;
	private Portal _portal;

	@Override
	public void render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT,
			new AppBuilderModuleAdminDisplayContext(
				_portal.getHttpServletRequest(renderRequest)));

		super.render(renderRequest, renderResponse);
	}



	public Dictionary<String, Object> getProperties() {

		HashMapDictionary<String, Object> properties =
			new HashMapDictionary<String, Object>() {
				{
					put("com.liferay.portlet.add-default-resource", true);
					put(
						"com.liferay.portlet.display-category",
						"category.hidden");
					put(
						"com.liferay.portlet.header-portlet-css",
						"/css/main.css");
					put("com.liferay.portlet.use-default-template", true);
					put("javax.portlet.display-name", _appName);
					put("javax.portlet.name", _portletName);
					put(
						"javax.portlet.init-param.template-path",
						"/META-INF/resources/");
					put(
						"javax.portlet.init-param.view-template", "/view.jsp" );
					put(
						"javax.portlet.security-role-ref",
						"administrator,guest,power-user,user");
				}
			};

		return properties;
	}

}