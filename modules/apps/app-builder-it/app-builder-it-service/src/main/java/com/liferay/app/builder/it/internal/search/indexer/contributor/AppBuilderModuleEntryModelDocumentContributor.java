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

package com.liferay.app.builder.it.internal.search.indexer.contributor;

import com.liferay.app.builder.it.dao.AppBuilderModuleDAO;
import com.liferay.app.builder.it.dao.AppBuilderModuleDAOServiceRegistry;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Date;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.app.builder.it.model.AppBuilderModuleEntry",
	service = ModelDocumentContributor.class
)
public class AppBuilderModuleEntryModelDocumentContributor
	implements ModelDocumentContributor<AppBuilderModuleEntry> {

	@Override
	public void contribute(
		Document document, AppBuilderModuleEntry appBuilderModuleEntry) {

		try {
			AppBuilderModule appBuilderModule =
				_appBuilderModuleLocalService.fetchAppBuilderModule(
					appBuilderModuleEntry.getAppBuilderModuleId());

			AppBuilderModuleDAO appBuilderModuleDAO =
				_appBuilderModuleDAOServiceRegistry.getAppBuilderModuleDAO(
					appBuilderModule);

			document.addKeyword(
				"moduleName", appBuilderModule.getDbTableName());

			//TODO parse teh metadate not the json object
			Optional<JSONObject> jsonObjectOptional = appBuilderModuleDAO.get(
				appBuilderModuleEntry.getAppBuilderModuleEntryId());

			jsonObjectOptional.ifPresent(
				jsonObject -> {
					for (String key : jsonObject.keySet()) {
						Object o = jsonObject.get(key);

						if (o instanceof Number) {
							document.addNumber(key, ((Number)o).longValue());
						}
						else if (o instanceof Date) {
							document.addDate(key, (Date)o);
						}
						else if (o instanceof String) {
							document.addText(key, (String)o);
						}
					}
				});
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
	}

	@Reference
	private AppBuilderModuleDAOServiceRegistry
		_appBuilderModuleDAOServiceRegistry;

	@Reference
	private AppBuilderModuleLocalService _appBuilderModuleLocalService;

}