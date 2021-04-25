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

package com.liferay.app.builder.it.headless.internal.jaxrs.resource.v1_0;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.app.builder.it.dao.AppBuilderModuleDAO;
import com.liferay.app.builder.it.dao.AppBuilderModuleDAOServiceRegistry;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.app.builder.it.service.AppBuilderModuleEntryLocalService;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalService;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Marco Leo
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/app.properties",
	scope = ServiceScope.PROTOTYPE, service = AppResourceImpl.class
)
@Path("/v1.0")
public class AppResourceImpl {



	//TODO This is just a simple implementation to demonstrate how we can use the data set display
	//In the real implementation I see how we will register an instance of this class for each module
	//To me there is no point to go more in the implementation as Headless team will do a betetr job

	@GET
	@Path("/{moduleName}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Catalog")})
	public Response getModuleEntriesPage(
			@PathParam("moduleName") String moduleName,
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.getAppBuilderModuleByName(
				_company.getCompanyId(), moduleName);

		//TODO here is where we will abstract those implementation in an otgher layer
		//This will allow us to abstract and connect to extenarl source, like Salesforce
		//will send code to show that side

		Page<Map<String, Object>> page = SearchUtil.search(
			Collections.emptyMap(),
			booleanQuery -> {
				BooleanFilter booleanFilter =
					booleanQuery.getPreBooleanFilter();
				booleanFilter.add(
					new TermFilter(
						"appBuilderModuleId", String.valueOf(appBuilderModule.getAppBuilderModuleId())),
					BooleanClauseOccur.MUST);
			},
			filter, AppBuilderModuleEntry.class, search, pagination,
			queryConfig -> queryConfig.setSelectedFieldNames(
				Field.ENTRY_CLASS_PK),
			searchContext -> searchContext.setCompanyId(
				_company.getCompanyId()),
			sorts,
			document -> _toMap(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK))));

		String json = _OBJECT_MAPPER.writeValueAsString(page);

		return Response.ok(
			json, MediaType.APPLICATION_JSON
		).build();

	}

	private Map<String, Object> _toMap(long appBuilderModuleEntryId) throws Exception {

		AppBuilderModuleEntry appBuilderModuleEntry =
			_appBuilderModuleEntryLocalService.getAppBuilderModuleEntry(
				appBuilderModuleEntryId);

		AppBuilderModule appBuilderModule =
			_appBuilderModuleLocalService.getAppBuilderModule(
				appBuilderModuleEntry.getAppBuilderModuleId());

		AppBuilderModuleDAO appBuilderModuleDAO =
			_appBuilderModuleDAOServiceRegistry.getAppBuilderModuleDAO(
				appBuilderModule);

		Optional<JSONObject> jsonObjectOptional =
			appBuilderModuleDAO.get(appBuilderModuleEntryId);

		Map<String, Object> map = new HashMap<>();

		map.put("appBuilderModuleEntry", appBuilderModuleEntry.getAppBuilderModuleEntryId());

		if(jsonObjectOptional.isPresent()){

			JSONObject jsonObject = jsonObjectOptional.get();

			Iterator<String> itr = jsonObject.keys();

			while (itr.hasNext()) {
				String key = itr.next();

				map.put(key, jsonObject.get(key));
			}

		}

		return map;
	}

	@Reference
	private AppBuilderModuleLocalService _appBuilderModuleLocalService;

	@Reference
	private AppBuilderModuleDAOServiceRegistry
		_appBuilderModuleDAOServiceRegistry;

	@Context
	private Company _company;

	@Context
	private User _user;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private AppBuilderModuleEntryLocalService _appBuilderModuleEntryLocalService;

	private static final ObjectMapper _OBJECT_MAPPER = new ObjectMapper() {
		{
			configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
			enable(SerializationFeature.INDENT_OUTPUT);
		}
	};

}