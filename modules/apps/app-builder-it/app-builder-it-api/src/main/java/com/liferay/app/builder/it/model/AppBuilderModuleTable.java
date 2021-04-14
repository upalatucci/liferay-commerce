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
 * The table class for the &quot;AppBuilderModule&quot; database table.
 *
 * @author Marco Leo
 * @see AppBuilderModule
 * @generated
 */
public class AppBuilderModuleTable extends BaseTable<AppBuilderModuleTable> {

	public static final AppBuilderModuleTable INSTANCE =
		new AppBuilderModuleTable();

	public final Column<AppBuilderModuleTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, Long> appBuilderModuleId =
		createColumn(
			"appBuilderModuleId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppBuilderModuleTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, String> label = createColumn(
		"label", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, String> dbTableName =
		createColumn(
			"dbTableName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, String> dbTablePKColumnName =
		createColumn(
			"dbTablePKColumnName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, String> scope = createColumn(
		"scope", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, String> resourceName =
		createColumn(
			"resourceName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, Boolean> asset = createColumn(
		"asset", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, Boolean> resource = createColumn(
		"resource", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AppBuilderModuleTable, Boolean> expando = createColumn(
		"expando", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private AppBuilderModuleTable() {
		super("AppBuilderModule", AppBuilderModuleTable::new);
	}

}