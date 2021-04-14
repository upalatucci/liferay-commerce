package com.liferay.app.builder.it.internal.dao;

import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.app.builder.it.service.AppBuilderModuleFieldLocalService;
import com.liferay.petra.sql.dsl.Column;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = AppBuilderModuleTableFactory.class)
public class AppBuilderModuleTableFactory {

	public AppBuilderDynamicModuleTable initialize(AppBuilderModule appBuilderModule) {
		AppBuilderDynamicModuleTable
			dynamicTable = new AppBuilderDynamicModuleTable(
			appBuilderModule.getDbTableName(),
			appBuilderModule.getDbTablePKColumnName());

		List<AppBuilderModuleField> appBuilderModuleFields =
			_appBuilderModuleFieldLocalService.getAppBuilderModuleFields(
				appBuilderModule.getAppBuilderModuleId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		for (AppBuilderModuleField appBuilderModuleField :
				appBuilderModuleFields) {

			String appBuilderModuleFieldName = appBuilderModuleField.getName();

			dynamicTable.addColumn(
				appBuilderModuleFieldName, appBuilderModuleField.getType(),
				appBuilderModuleFieldName.equals(
					appBuilderModule.getDbTablePKColumnName()) ?
						Column.FLAG_PRIMARY : Column.FLAG_DEFAULT);
		}

		return dynamicTable;
	}

	@Reference
	private AppBuilderModuleFieldLocalService
		_appBuilderModuleFieldLocalService;

}