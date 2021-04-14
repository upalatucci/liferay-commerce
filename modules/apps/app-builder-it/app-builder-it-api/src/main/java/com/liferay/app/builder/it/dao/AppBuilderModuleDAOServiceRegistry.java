package com.liferay.app.builder.it.dao;

import com.liferay.app.builder.it.model.AppBuilderModule;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface AppBuilderModuleDAOServiceRegistry {

	public AppBuilderModuleDAO getAppBuilderModuleDAO(
		AppBuilderModule appBuilderModule);

	public void registerAppBuilderModuleDAO(AppBuilderModule appBuilderModule);

	public void unregisterAppBuilderModuleDAO(
		AppBuilderModule appBuilderModule);

}