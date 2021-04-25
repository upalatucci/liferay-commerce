<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page
	import="com.liferay.app.builder.it.internal.display.context.AppBuilderModuleAdminDisplayContext" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %><%--
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
--%>

<%@ include file="init.jsp" %>

<%
AppBuilderModuleAdminDisplayContext appBuilderModuleAdminDisplayContext = (AppBuilderModuleAdminDisplayContext)request.getAttribute(
	WebKeys.PORTLET_DISPLAY_CONTEXT);

// TODO This is quite all the implementations we will need in the jsp for the lists
// Super Nice

%>

<clay:headless-data-set-display
	apiURL="<%= appBuilderModuleAdminDisplayContext.getApiUrl() %>"
	clayDataSetActionDropdownItems="<%= appBuilderModuleAdminDisplayContext.getClayDataSetActionDropdownItems() %>"
	formId="fm"
	id="<%= appBuilderModuleAdminDisplayContext.getDataSetDisplaykey() %>"
	itemsPerPage="<%= 20 %>"
	namespace="<%= liferayPortletResponse.getNamespace() %>"
	pageNumber="<%= 1 %>"
	portletURL="<%= liferayPortletResponse.createRenderURL() %>"
	style="fluid"
/>