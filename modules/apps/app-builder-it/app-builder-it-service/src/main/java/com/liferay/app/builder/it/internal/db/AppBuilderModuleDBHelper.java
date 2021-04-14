package com.liferay.app.builder.it.internal.db;

import com.liferay.app.builder.it.internal.dao.AppBuilderModuleTableFactory;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.app.builder.it.service.AppBuilderModuleFieldLocalService;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LoggingTimer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = AppBuilderModuleDBHelper.class)
public class AppBuilderModuleDBHelper {

	public void createTable(AppBuilderModule appBuilderModule)
		throws Exception {

		String sql = _generateCreateTableSQLScript(appBuilderModule);

		try (LoggingTimer loggingTimer = new LoggingTimer(
				appBuilderModule.getDbTableName())) {

			DB db = DBManagerUtil.getDB();

			db.runSQLTemplateString(sql, true);
		}
		catch (Exception e) {
			_log.error(
				"Error creating table: " + appBuilderModule.getDbTableName(),
				e);

			throw e;
		}
	}

	public void dropTable(String dbTableName) throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			DB db = DBManagerUtil.getDB();

			db.runSQLTemplateString(
				"drop table if exists \"" + dbTableName + "\";", true);
		}
		catch (Exception e) {
			_log.error("Error deleting table: " + dbTableName, e);

			throw new Exception(
				"Impossible to delete table: " + dbTableName, e);
		}
	}

	private String _generateCreateTableSQLScript(
		AppBuilderModule appBuilderModule) {

		List<AppBuilderModuleField> appBuilderModuleFields =
			_appBuilderModuleFieldLocalService.getAppBuilderModuleFields(
				appBuilderModule.getAppBuilderModuleId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		StringBundler sb = new StringBundler();

		//TODO Create PrimaryKey index too
		sb.append("create table " + appBuilderModule.getDbTableName() + " (");
		sb.append(
			appBuilderModule.getDbTablePKColumnName() +
				" LONG not null primary key");

		Iterator<AppBuilderModuleField> iterator =
			appBuilderModuleFields.iterator();

		while (iterator.hasNext()) {
			AppBuilderModuleField appBuilderModuleField = iterator.next();

			sb.append(appBuilderModuleField.getDbColumnName());
			sb.append(" ");
			sb.append(_sqlColumnTypeMap.get(appBuilderModuleField.getType()));

			if (appBuilderModuleField.isNullable()) {
				if (ArrayUtil.contains(
						_NULLABLE_TYPES, appBuilderModuleField.getType())) {

					sb.append(" null");
				}
			}
			else {
				sb.append(" not null");
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append(");");

		return sb.toString();
	}

	private static final String[] _NULLABLE_TYPES = {
		"Blob", "Date", "String", "Timestamp"
	};

	private static final Log _log = LogFactoryUtil.getLog(
		AppBuilderModuleDBHelper.class);

	//TODO Add support to VARCHAR  size, store size in type settings?

	private static final Map<String, String> _sqlColumnTypeMap =
		HashMapBuilder.put(
			"BigDecimal", "DECIMAL(30, 16)"
		).put(
			"Blob", "BLOB"
		).put(
			"Boolean", "BOOLEAN"
		).put(
			"Date", "DATE"
		).put(
			"Double", "DOUBLE"
		).put(
			"Float", "FLOAT"
		).put(
			"Integer", "INTEGER"
		).put(
			"Long", "LONG"
		).put(
			"String", "VARCHAR(75)"
		).put(
			"Timestamp", "TIMESTAMP"
		).build();

	@Reference
	private AppBuilderModuleFieldLocalService
		_appBuilderModuleFieldLocalService;

	@Reference
	private AppBuilderModuleTableFactory _appBuilderModuleTableFactory;

}