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

package com.liferay.app.builder.it.headless.internal.jaxrs.exception.mapper;

import com.liferay.app.builder.it.exception.NoSuchAppBuilderModuleException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author Marco Leo
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.Marco)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.Marco.NoSuchDataDefinitionExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class NoSuchAppBuilderModuleExceptionMapper
	extends BaseExceptionMapper<NoSuchAppBuilderModuleException> {

	@Override
	protected Problem getProblem(
		NoSuchAppBuilderModuleException noSuchAppBuilderModuleException) {

		return new Problem(
			Response.Status.NOT_FOUND,
			StringUtil.replace(
				noSuchAppBuilderModuleException.getMessage(), "AppBuilderModule",
				"Module"));
	}

}