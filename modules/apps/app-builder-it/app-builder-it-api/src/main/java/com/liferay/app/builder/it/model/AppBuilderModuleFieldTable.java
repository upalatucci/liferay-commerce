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

package com.liferay.app.builder.it.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AppBuilderModuleField&quot; database table.
 *
 * @author Marco Leo
 * @see AppBuilderModuleField
 * @generated
 */
public class AppBuilderModuleFieldTable
	extends BaseTable<AppBuilderModuleFieldTable> {

	public static final AppBuilderModuleFieldTable INSTANCE =
		new AppBuilderModuleFieldTable();

	public final Column<AppBuilderModuleFieldTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, Long>
		appBuilderModuleFieldId = createColumn(
			"appBuilderModuleFieldId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppBuilderModuleFieldTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, Long> appBuilderModuleId =
		createColumn(
			"appBuilderModuleId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, String> label =
		createColumn("label", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, String> dbColumnName =
		createColumn(
			"dbColumnName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, String> typeSettings =
		createColumn(
			"typeSettings", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleFieldTable, Boolean> nullable =
		createColumn(
			"nullable", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private AppBuilderModuleFieldTable() {
		super("AppBuilderModuleField", AppBuilderModuleFieldTable::new);
	}

}