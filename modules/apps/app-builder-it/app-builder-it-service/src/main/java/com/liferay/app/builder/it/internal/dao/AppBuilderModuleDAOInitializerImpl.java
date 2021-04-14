package com.liferay.app.builder.it.internal.dao;

import com.liferay.app.builder.it.dao.AppBuilderModuleDAOServiceRegistry;
import com.liferay.app.builder.it.internal.resource.ResourceActionsHelperImpl;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalService;
import com.liferay.app.builder.it.workflow.AppBuilderModuleEntryWorkflowHandlerServiceRegistry;

import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AppBuilderModuleDAOInitializerImpl.class)
public class AppBuilderModuleDAOInitializerImpl {

	//TODO Use portal start up event




	@Activate
	protected void activate(BundleContext bundleContext) {
		List<AppBuilderModule> appBuilderModules =
			_appBuilderModuleLocalService.getAppBuilderModules();

		for (AppBuilderModule appBuilderModule : appBuilderModules) {
			_appBuilderModuleDAOServiceRegistry.registerAppBuilderModuleDAO(
				appBuilderModule);
			_appBuilderModuleEntryWorkflowHandlerServiceRegistry.
				registerAppBuilderModuleEntryWorkflowHandler(appBuilderModule);

			try {
				_resourceActionsHelper.importResourceAction(appBuilderModule);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Reference
	private AppBuilderModuleDAOServiceRegistry
		_appBuilderModuleDAOServiceRegistry;

	@Reference
	private AppBuilderModuleEntryWorkflowHandlerServiceRegistry
		_appBuilderModuleEntryWorkflowHandlerServiceRegistry;

	@Reference
	private AppBuilderModuleLocalService _appBuilderModuleLocalService;

	@Reference
	private ResourceActionsHelperImpl _resourceActionsHelper;

}