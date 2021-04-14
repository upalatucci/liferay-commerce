package com.liferay.app.builder.it.internal.dao;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.math.BigDecimal;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AppBuilderDynamicModuleTable
	extends BaseTable<AppBuilderDynamicModuleTable> {

	public AppBuilderDynamicModuleTable(String tableName, String pkColumnName) {
		super(tableName, () -> null);

		_pkColumnName = pkColumnName;

		createColumn(
			pkColumnName, Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	}

	public void addColumn(String name, String type, int flags) {
		createColumn(name, _typeMap.get(type), _sqlTypeMap.get(type), flags);
	}

	public String[] getColumnNames() {
		List<String> columnNames = new ArrayList<>();

		for (Column<AppBuilderDynamicModuleTable, ?> column : getColumns()) {
			columnNames.add(column.getName());
		}

		return ArrayUtil.toStringArray(columnNames);
	}

	public Column getPKColumn() {
		return getColumn(_pkColumnName);
	}

	private static final Map<String, Integer> _sqlTypeMap = HashMapBuilder.put(
		"BigDecimal", Types.DECIMAL
	).put(
		"Blob", Types.BLOB
	).put(
		"Boolean", Types.BOOLEAN
	).put(
		"Date", Types.DATE
	).put(
		"Double", Types.DOUBLE
	).put(
		"Float", Types.FLOAT
	).put(
		"Integer", Types.INTEGER
	).put(
		"Long", Types.BIGINT
	).put(
		"String", Types.VARCHAR
	).put(
		"Timestamp", Types.TIMESTAMP
	).build();
	private static final Map<String, Class<?>> _typeMap =
		HashMapBuilder.<String, Class<?>>put(
			"BigDecimal", BigDecimal.class
		).put(
			"Blob", Blob.class
		).put(
			"Boolean", Boolean.class
		).put(
			"Date", Date.class
		).put(
			"Double", Double.class
		).put(
			"Float", Float.class
		).put(
			"Integer", Integer.class
		).put(
			"Long", Long.class
		).put(
			"String", String.class
		).put(
			"Timestamp", Date.class
		).build();

	private final String _pkColumnName;

}