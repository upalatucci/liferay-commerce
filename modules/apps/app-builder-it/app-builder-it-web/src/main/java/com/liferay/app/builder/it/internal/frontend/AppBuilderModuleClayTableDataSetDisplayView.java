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

package com.liferay.app.builder.it.internal.frontend;

import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.frontend.taglib.clay.data.set.view.table.BaseTableClayDataSetDisplayView;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchema;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchemaBuilder;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchemaBuilderFactory;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchemaField;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

/**
 * @author Marco Leo
 */
public class AppBuilderModuleClayTableDataSetDisplayView
	extends BaseTableClayDataSetDisplayView {

	public AppBuilderModuleClayTableDataSetDisplayView(
		AppBuilderModule appBuilderModule,
		List<AppBuilderModuleField> appBuilderModuleFields,
		ClayTableSchemaBuilderFactory clayTableSchemaBuilderFactory){

		_clayTableSchemaBuilderFactory = clayTableSchemaBuilderFactory;

		_clayTableSchema = _buildClayTableSchema(appBuilderModule, appBuilderModuleFields);

	}

	private ClayTableSchema _clayTableSchema;

	private ClayTableSchema _buildClayTableSchema(AppBuilderModule appBuilderModule, List<AppBuilderModuleField> appBuilderModuleFields){
		ClayTableSchemaBuilder clayTableSchemaBuilder =
			_clayTableSchemaBuilderFactory.create();

		ClayTableSchemaField id =
			clayTableSchemaBuilder.addClayTableSchemaField(
				"id", "id");

		id.setContentRenderer("actionLink");

		for(AppBuilderModuleField appBuilderModuleField: appBuilderModuleFields){

			//TODO we should decide the render based on the field type?
			// or we hve to make it configurable to the user and have a valid extension point?
			// IF front End infra allow webhooks registration of those views and renders
			// we cann allow th euser to customize the views without need to deploy code NICE!!

			clayTableSchemaBuilder.addClayTableSchemaField(appBuilderModuleField.getDbColumnName(), appBuilderModule.getLabel());
		}

		return clayTableSchemaBuilder.build();
	}

	@Override
	public ClayTableSchema getClayTableSchema() {
		return _clayTableSchema;
	}

	private ClayTableSchemaBuilderFactory _clayTableSchemaBuilderFactory;

}