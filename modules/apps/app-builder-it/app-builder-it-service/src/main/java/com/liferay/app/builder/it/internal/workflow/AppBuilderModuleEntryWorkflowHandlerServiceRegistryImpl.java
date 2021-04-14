package com.liferay.app.builder.it.internal.workflow;

import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.service.AppBuilderModuleEntryLocalService;
import com.liferay.app.builder.it.service.AppBuilderModuleLocalService;
import com.liferay.app.builder.it.workflow.AppBuilderModuleEntryWorkflowHandlerServiceRegistry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = AppBuilderModuleEntryWorkflowHandlerServiceRegistry.class
)
public class AppBuilderModuleEntryWorkflowHandlerServiceRegistryImpl
	implements AppBuilderModuleEntryWorkflowHandlerServiceRegistry {

	@Override
	public void registerAppBuilderModuleEntryWorkflowHandler(
		AppBuilderModule appBuilderModule) {

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_registerAppBuilderModuleDAO(
			bundle.getBundleContext(), appBuilderModule);
	}

	@Override
	public void unregisterAppBuilderModuleEntryWorkflowHandler(
		AppBuilderModule appBuilderModule) {

		ServiceRegistration<WorkflowHandler> serviceRegistration =
			_serviceRegistrationMap.get(
				appBuilderModule.getAppBuilderModuleId());

		if (serviceRegistration != null) {
			serviceRegistration.unregister();
		}

		_serviceRegistrationMap.remove(
			appBuilderModule.getAppBuilderModuleId());
	}

	@Deactivate
	protected void deactivate() {
		Set<Long> keySet = _serviceRegistrationMap.keySet();

		Iterator<Long> iterator = keySet.iterator();

		while (iterator.hasNext()) {
			Long key = iterator.next();

			ServiceRegistration<WorkflowHandler> serviceRegistration =
				_serviceRegistrationMap.get(key);

			if (serviceRegistration != null) {
				serviceRegistration.unregister();
			}

			iterator.remove();
		}
	}

	private void _registerAppBuilderModuleDAO(
		BundleContext bundleContext, AppBuilderModule appBuilderModule) {

		Dictionary<String, Object> dictionary = new HashMapDictionary<>();

		dictionary.put("model.class.name", appBuilderModule.getDbTableName());

		ServiceRegistration<WorkflowHandler>
			workflowHandlerServiceRegistration = bundleContext.registerService(
				WorkflowHandler.class,
				new AppBuilderModuleEntryWorkflowHandler(
					_appBuilderModuleLocalService,
					_appBuilderModuleEntryLocalService,
					appBuilderModule.getAppBuilderModuleId(),
					appBuilderModule.getDbTableName()),
				dictionary);

		_serviceRegistrationMap.put(
			appBuilderModule.getAppBuilderModuleId(),
			workflowHandlerServiceRegistration);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AppBuilderModuleEntryWorkflowHandlerServiceRegistryImpl.class);

	@Reference
	private AppBuilderModuleEntryLocalService
		_appBuilderModuleEntryLocalService;

	@Reference
	private AppBuilderModuleLocalService _appBuilderModuleLocalService;

	private volatile Map<Long, ServiceRegistration<WorkflowHandler>>
		_serviceRegistrationMap = new HashMap<>();

}