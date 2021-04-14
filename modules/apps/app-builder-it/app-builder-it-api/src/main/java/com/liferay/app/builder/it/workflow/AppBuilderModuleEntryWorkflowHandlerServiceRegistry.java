package com.liferay.app.builder.it.workflow;

import com.liferay.app.builder.it.model.AppBuilderModule;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface AppBuilderModuleEntryWorkflowHandlerServiceRegistry {

	public void registerAppBuilderModuleEntryWorkflowHandler(
		AppBuilderModule appBuilderModule);

	public void unregisterAppBuilderModuleEntryWorkflowHandler(
		AppBuilderModule appBuilderModule);

}