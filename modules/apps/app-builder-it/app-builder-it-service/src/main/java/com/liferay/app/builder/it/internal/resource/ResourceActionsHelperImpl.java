package com.liferay.app.builder.it.internal.resource;

import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.portal.kernel.exception.ResourceActionsException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ResourceActionsHelperImpl.class)
public class ResourceActionsHelperImpl {

	public void importResourceAction(AppBuilderModule appBuilderModule)
		throws DocumentException, IOException, ResourceActionsException {

		String xml = StringUtil.read(
			ResourceActionsHelperImpl.class.getClassLoader(),
			_DEPENDENCIES_PATH + "resource-actions.xml.tpl");

		_resourceActions.populateModelResources(
			SAXReaderUtil.read(
				StringUtil.replace(
					StringUtil.replace(
						xml, "[$RESOURCE_NAME$]",
						appBuilderModule.getResourceName()),
					"[$MODEL_NAME$]", appBuilderModule.getDbTableName())));
	}

	private static final String _DEPENDENCIES_PATH =
		"com/liferay/app/builder/it/internal/resource/dependencies/";

	@Reference
	private ResourceActions _resourceActions;

}