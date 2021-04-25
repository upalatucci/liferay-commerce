package com.liferay.app.builder.it.internal.application.list;

import com.liferay.app.builder.it.constants.ModulePortletKeys;
import com.liferay.app.builder.it.dao.AppBuilderModuleDAO;
import com.liferay.app.builder.it.dao.AppBuilderModuleDAOServiceRegistry;
import com.liferay.app.builder.it.internal.frontend.AppBuilderModuleClayTableDataSetDisplayView;
import com.liferay.app.builder.it.internal.portlet.ModuleAdminPortlet;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.app.builder.it.service.AppBuilderModuleFieldLocalService;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalService;
import com.liferay.app.builder.it.workflow.AppBuilderModuleEntryWorkflowHandlerServiceRegistry;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.frontend.taglib.clay.data.set.ClayDataSetDisplayView;
import com.liferay.frontend.taglib.clay.data.set.view.table.ClayTableSchemaBuilderFactory;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component(immediate = true, service = ModuleAdminPanelInitializerImpl.class)
public class ModuleAdminPanelInitializerImpl {

	//TODO Use portal start up event


	@Activate
	protected void activate(BundleContext bundleContext) {
		List<AppBuilderModule> appBuilderModules =
			_appBuilderModuleLocalService.getAppBuilderModules();

		for (AppBuilderModule appBuilderModule : appBuilderModules) {

			List<AppBuilderModuleField> appBuilderModuleFields =
				_appBuilderModuleFieldLocalService.getAppBuilderModuleFields(
					appBuilderModule.getAppBuilderModuleId(), -1, -1);

			Dictionary<String, Object> dictionary = new HashMapDictionary<>();

			dictionary.put("panel.app.order:Integer", "300");

			//TODO  This must be configurable, we should save it in the Object?
			dictionary.put("panel.category.key", PanelCategoryKeys.CONTROL_PANEL_USERS);

			String portletId = ModulePortletKeys.MODULE_ADMIN_PREFIX + appBuilderModule.getName();

			Dictionary<String, Object> dictionary2 = new HashMapDictionary<>();
			dictionary2.put("clay.data.set.display.name", portletId);

			ModuleAdminPortlet moduleAdminPortlet =
				new ModuleAdminPortlet(appBuilderModule.getLabel(), _portal, portletId);

			_serviceRegistrations.computeIfAbsent(
				appBuilderModule.getAppBuilderModuleId(),key -> new ServiceRegistration<?>[] {
					bundleContext.registerService(
						Portlet.class,
						moduleAdminPortlet,
						moduleAdminPortlet.getProperties()),
					bundleContext.registerService(
						PanelApp.class,
						new ModuleAdminPanelAppImpl(
							appBuilderModule.getAppBuilderModuleId(), appBuilderModule.getLabel(), portletId),
						dictionary),
					bundleContext.registerService(
						ClayDataSetDisplayView.class,
						new AppBuilderModuleClayTableDataSetDisplayView(
							appBuilderModule, appBuilderModuleFields,
							_clayTableSchemaBuilderFactory),
						dictionary2)
				});
		}
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistrations.clear();
	}

	@Reference
	private ClayTableSchemaBuilderFactory _clayTableSchemaBuilderFactory;

	@Reference
	private Portal _portal;

	@Reference
	private AppBuilderModuleLocalService _appBuilderModuleLocalService;

	@Reference
	private AppBuilderModuleFieldLocalService _appBuilderModuleFieldLocalService;

	private final Map<Long, ServiceRegistration<?>[]> _serviceRegistrations =
		new ConcurrentHashMap<>();

}