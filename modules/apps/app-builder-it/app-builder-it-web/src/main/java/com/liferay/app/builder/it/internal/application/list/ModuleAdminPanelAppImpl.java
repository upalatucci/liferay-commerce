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

package com.liferay.app.builder.it.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author Marco Leo
 */
public class ModuleAdminPanelAppImpl extends BasePanelApp {

	public ModuleAdminPanelAppImpl(long appBuilderModuleId, String label, String portletId){
		_appBuilderModuleId = appBuilderModuleId;
		_label = label;
		_portletId = portletId;
	}

	@Override
	public String getPortletId(){
		return _portletId;
	}

	@Override
	public String getKey() {
		return String.valueOf(_appBuilderModuleId);
	}

	private long _appBuilderModuleId;
	private String _label;
	private String _portletId;

	@Override
	public String getLabel(Locale locale) {
		return _label;
	}

	@Override
	public PortletURL getPortletURL(
		HttpServletRequest httpServletRequest) throws PortalException {
		PortletURL portletURL = super.getPortletURL(httpServletRequest);

		portletURL.setParameter(
			"appBuilderModuleId", String.valueOf(_appBuilderModuleId));

		return portletURL;
	}

}