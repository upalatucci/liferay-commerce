package com.liferay.app.builder.it.internal.dao;

import com.liferay.app.builder.it.dao.AppBuilderModuleDAO;
import com.liferay.app.builder.it.dao.AppBuilderModuleDAOServiceRegistry;
import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.app.builder.it.service.AppBuilderModuleFieldLocalService;
import com.liferay.app.builder.it.service.persistence.impl.constants.AppBuilderItPersistenceConstants;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.InlineSQLHelper;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AppBuilderModuleDAOServiceRegistry.class)
public class AppBuilderModuleDAOServiceRegistryImpl
	implements AppBuilderModuleDAOServiceRegistry {

	@Override
	public AppBuilderModuleDAO getAppBuilderModuleDAO(
		AppBuilderModule appBuilderModule) {

		ServiceTrackerCustomizerFactory.ServiceWrapper<AppBuilderModuleDAO>
			commerceHealthStatusServiceWrapper =
				_appBuilderModuleDAORegistryMap.getService(
					appBuilderModule.getDbTableName());

		if (commerceHealthStatusServiceWrapper == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"No commerce health status registered with key " +
						appBuilderModule.getDbTableName());
			}

			return null;
		}

		return commerceHealthStatusServiceWrapper.getService();
	}

	@Override
	public void registerAppBuilderModuleDAO(AppBuilderModule appBuilderModule) {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_registerAppBuilderModuleDAO(
			bundle.getBundleContext(), appBuilderModule);
	}

	@Override
	public void unregisterAppBuilderModuleDAO(
		AppBuilderModule appBuilderModule) {

		ServiceRegistration<AppBuilderModuleDAO> serviceRegistration =
			_serviceRegistrationMap.get(appBuilderModule.getDbTableName());

		if (serviceRegistration != null) {
			serviceRegistration.unregister();
		}

		_serviceRegistrationMap.remove(appBuilderModule.getDbTableName());
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_appBuilderModuleDAORegistryMap =
			ServiceTrackerMapFactory.openSingleValueMap(
				bundleContext, AppBuilderModuleDAO.class,
				"app.builder.it.module.name",
				ServiceTrackerCustomizerFactory.
					<AppBuilderModuleDAO>serviceWrapper(bundleContext));
	}

	@Deactivate
	protected void deactivate() {
		Set<String> keySet = _serviceRegistrationMap.keySet();

		Iterator<String> iterator = keySet.iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();

			ServiceRegistration<AppBuilderModuleDAO> serviceRegistration =
				_serviceRegistrationMap.get(key);

			if (serviceRegistration != null) {
				serviceRegistration.unregister();
			}

			iterator.remove();
		}

		_appBuilderModuleDAORegistryMap.close();
	}

	private void _registerAppBuilderModuleDAO(
		BundleContext bundleContext, AppBuilderModule appBuilderModule) {

		Dictionary<String, Object> dictionary = new HashMapDictionary<>();

		dictionary.put(
			"app.builder.it.module.name", appBuilderModule.getDbTableName());

		ServiceRegistration<AppBuilderModuleDAO>
			appBuilderModuleDAOServiceRegistration =
				bundleContext.registerService(
					AppBuilderModuleDAO.class,
					new AppBuilderModuleDAOImpl(
						_appBuilderModuleTableFactory.initialize(
							appBuilderModule),
						_dataSource, appBuilderModule.isResource(),
						_inlineSQLHelper, _jsonFactory, _sessionFactory),
					dictionary);

		_serviceRegistrationMap.put(
			appBuilderModule.getDbTableName(),
			appBuilderModuleDAOServiceRegistration);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AppBuilderModuleDAOServiceRegistryImpl.class);

	private ServiceTrackerMap
		<String,
		 ServiceTrackerCustomizerFactory.ServiceWrapper<AppBuilderModuleDAO>>
			_appBuilderModuleDAORegistryMap;

	@Reference
	private AppBuilderModuleFieldLocalService
		_appBuilderModuleFieldLocalService;

	@Reference
	private AppBuilderModuleTableFactory _appBuilderModuleTableFactory;

	@Reference(
		target = AppBuilderItPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER
	)
	private DataSource _dataSource;

	@Reference
	private InlineSQLHelper _inlineSQLHelper;

	@Reference
	private JSONFactory _jsonFactory;

	private volatile Map<String, ServiceRegistration<AppBuilderModuleDAO>>
		_serviceRegistrationMap = new HashMap<>();

	@Reference(
		target = AppBuilderItPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER
	)
	private SessionFactory _sessionFactory;

}