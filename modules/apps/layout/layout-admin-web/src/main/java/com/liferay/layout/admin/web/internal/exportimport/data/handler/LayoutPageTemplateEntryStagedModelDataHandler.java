/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.layout.admin.web.internal.exportimport.data.handler;

import com.liferay.asset.display.page.model.AssetDisplayPageEntry;
import com.liferay.asset.display.page.service.AssetDisplayPageEntryLocalService;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.exportimport.data.handler.base.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.staged.model.repository.StagedModelRepository;
import com.liferay.layout.page.template.model.LayoutPageTemplateCollection;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.layout.page.template.service.LayoutPageTemplateCollectionLocalService;
import com.liferay.layout.page.template.service.LayoutPageTemplateEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutPrototype;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutPrototypeLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = StagedModelDataHandler.class)
public class LayoutPageTemplateEntryStagedModelDataHandler
	extends BaseStagedModelDataHandler<LayoutPageTemplateEntry> {

	public static final String[] CLASS_NAMES = {
		LayoutPageTemplateEntry.class.getName()
	};

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(
		LayoutPageTemplateEntry layoutPageTemplateEntry) {

		return layoutPageTemplateEntry.getName();
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext,
			LayoutPageTemplateEntry layoutPageTemplateEntry)
		throws Exception {

		LayoutPageTemplateCollection layoutPageTemplateCollection =
			_layoutPageTemplateCollectionLocalService.
				fetchLayoutPageTemplateCollection(
					layoutPageTemplateEntry.
						getLayoutPageTemplateCollectionId());

		if (layoutPageTemplateCollection != null) {
			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, layoutPageTemplateEntry,
				layoutPageTemplateCollection,
				PortletDataContext.REFERENCE_TYPE_PARENT);
		}

		DDMStructure ddmStructure = _ddmStructureLocalService.fetchStructure(
			layoutPageTemplateEntry.getClassTypeId());

		if (ddmStructure != null) {
			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, layoutPageTemplateEntry, ddmStructure,
				PortletDataContext.REFERENCE_TYPE_DEPENDENCY);
		}

		_exportAssetDisplayPages(portletDataContext, layoutPageTemplateEntry);

		if (layoutPageTemplateEntry.getLayoutPrototypeId() > 0) {
			LayoutPrototype layoutPrototype =
				_layoutPrototypeLocalService.getLayoutPrototype(
					layoutPageTemplateEntry.getLayoutPrototypeId());

			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, layoutPageTemplateEntry, layoutPrototype,
				PortletDataContext.REFERENCE_TYPE_DEPENDENCY);
		}

		Layout layout = _layoutLocalService.fetchLayout(
			layoutPageTemplateEntry.getPlid());

		if (layout != null) {
			Layout draftLayout = _layoutLocalService.fetchLayout(
				_portal.getClassNameId(Layout.class), layout.getPlid());

			if (draftLayout != null) {
				StagedModelDataHandlerUtil.exportReferenceStagedModel(
					portletDataContext, layoutPageTemplateEntry, draftLayout,
					PortletDataContext.REFERENCE_TYPE_DEPENDENCY);
			}

			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, layoutPageTemplateEntry, layout,
				PortletDataContext.REFERENCE_TYPE_DEPENDENCY);
		}

		Element entryElement = portletDataContext.getExportDataElement(
			layoutPageTemplateEntry);

		long defaultUserId = _userLocalService.getDefaultUserId(
			layoutPageTemplateEntry.getCompanyId());

		if (defaultUserId == layoutPageTemplateEntry.getUserId()) {
			entryElement.addAttribute("preloaded", "true");
		}

		portletDataContext.addClassedModel(
			entryElement,
			ExportImportPathUtil.getModelPath(layoutPageTemplateEntry),
			layoutPageTemplateEntry);
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, Element referenceElement)
		throws PortletDataException {

		importMissingGroupReference(portletDataContext, referenceElement);

		String uuid = referenceElement.attributeValue("uuid");

		Map<Long, Long> groupIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				Group.class);

		long groupId = GetterUtil.getLong(
			referenceElement.attributeValue("group-id"));

		groupId = MapUtil.getLong(groupIds, groupId);

		long layoutPageTemplateEntryId = GetterUtil.getLong(
			referenceElement.attributeValue("class-pk"));
		String name = GetterUtil.getString(
			referenceElement.attributeValue("name"));
		boolean preloaded = GetterUtil.getBoolean(
			referenceElement.attributeValue("preloaded"));

		LayoutPageTemplateEntry existingLayoutPageTemplateEntry = null;

		if (!preloaded) {
			existingLayoutPageTemplateEntry = fetchMissingReference(
				uuid, groupId);
		}
		else {
			existingLayoutPageTemplateEntry = fetchExistingTemplate(
				uuid, groupId, name, 0L, preloaded);
		}

		if (existingLayoutPageTemplateEntry == null) {
			return;
		}

		Map<Long, Long> layoutPageTemplateEntryIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				LayoutPageTemplateEntry.class);

		layoutPageTemplateEntryIds.put(
			layoutPageTemplateEntryId,
			existingLayoutPageTemplateEntry.getLayoutPageTemplateEntryId());
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, String uuid, long groupId,
			long layoutPageTemplateEntryId)
		throws Exception {

		LayoutPageTemplateEntry existingLayoutPageTemplateEntry =
			fetchMissingReference(uuid, groupId);

		if (existingLayoutPageTemplateEntry == null) {
			return;
		}

		Map<Long, Long> layoutPageTemplateEntryIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				LayoutPageTemplateEntry.class);

		layoutPageTemplateEntryIds.put(
			layoutPageTemplateEntryId,
			existingLayoutPageTemplateEntry.getLayoutPageTemplateEntryId());
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext,
			LayoutPageTemplateEntry layoutPageTemplateEntry)
		throws Exception {

		StagedModelDataHandlerUtil.importReferenceStagedModel(
			portletDataContext, layoutPageTemplateEntry,
			LayoutPageTemplateCollection.class,
			layoutPageTemplateEntry.getLayoutPageTemplateCollectionId());

		Map<Long, Long> layoutPageTemplateCollectionIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				LayoutPageTemplateCollection.class);

		long layoutPageTemplateCollectionId = MapUtil.getLong(
			layoutPageTemplateCollectionIds,
			layoutPageTemplateEntry.getLayoutPageTemplateCollectionId(),
			layoutPageTemplateEntry.getLayoutPageTemplateCollectionId());

		long classTypeId = layoutPageTemplateEntry.getClassTypeId();

		if (classTypeId > 0) {
			StagedModelDataHandlerUtil.importReferenceStagedModel(
				portletDataContext, layoutPageTemplateEntry, DDMStructure.class,
				Long.valueOf(classTypeId));

			Map<Long, Long> structureIds =
				(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
					DDMStructure.class);

			classTypeId = MapUtil.getLong(
				structureIds, classTypeId, classTypeId);
		}

		Map<Long, Long> plids =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				Layout.class);

		long plid = MapUtil.getLong(
			plids, layoutPageTemplateEntry.getPlid(),
			layoutPageTemplateEntry.getPlid());

		LayoutPageTemplateEntry importedLayoutPageTemplateEntry =
			(LayoutPageTemplateEntry)layoutPageTemplateEntry.clone();

		importedLayoutPageTemplateEntry.setGroupId(
			portletDataContext.getScopeGroupId());
		importedLayoutPageTemplateEntry.setLayoutPageTemplateCollectionId(
			layoutPageTemplateCollectionId);
		importedLayoutPageTemplateEntry.setClassTypeId(classTypeId);
		importedLayoutPageTemplateEntry.setPlid(plid);

		Element layoutPrototypeElement =
			portletDataContext.getReferenceDataElement(
				layoutPageTemplateEntry, LayoutPrototype.class,
				layoutPageTemplateEntry.getLayoutPrototypeId());

		LayoutPrototype layoutPrototype = null;

		if (layoutPrototypeElement != null) {
			String layoutPrototypePath = layoutPrototypeElement.attributeValue(
				"path");

			layoutPrototype =
				(LayoutPrototype)portletDataContext.getZipEntryAsObject(
					layoutPrototypePath);

			StagedModelDataHandlerUtil.importStagedModel(
				portletDataContext, layoutPrototype);

			Map<Long, Long> layoutPrototypeIds =
				(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
					LayoutPrototype.class);

			long layoutPrototypeId = MapUtil.getLong(
				layoutPrototypeIds,
				layoutPageTemplateEntry.getLayoutPrototypeId(),
				layoutPageTemplateEntry.getLayoutPrototypeId());

			importedLayoutPageTemplateEntry.setLayoutPrototypeId(
				layoutPrototypeId);
		}

		boolean isNew = false;

		if (portletDataContext.isDataStrategyMirror()) {
			Element element =
				portletDataContext.getImportDataStagedModelElement(
					layoutPageTemplateEntry);

			boolean preloaded = GetterUtil.getBoolean(
				element.attributeValue("preloaded"));

			LayoutPageTemplateEntry existingLayoutPageTemplateEntry =
				fetchExistingTemplate(
					layoutPageTemplateEntry.getUuid(),
					portletDataContext.getScopeGroupId(),
					layoutPageTemplateEntry.getName(), plid, preloaded);

			if (existingLayoutPageTemplateEntry == null) {
				isNew = true;

				importedLayoutPageTemplateEntry = _addStagedModel(
					portletDataContext, importedLayoutPageTemplateEntry);
			}
			else {
				importedLayoutPageTemplateEntry.setLayoutPageTemplateEntryId(
					existingLayoutPageTemplateEntry.
						getLayoutPageTemplateEntryId());

				importedLayoutPageTemplateEntry =
					_stagedModelRepository.updateStagedModel(
						portletDataContext, importedLayoutPageTemplateEntry);
			}
		}
		else {
			isNew = true;

			importedLayoutPageTemplateEntry = _addStagedModel(
				portletDataContext, importedLayoutPageTemplateEntry);
		}

		_validateLayoutPrototype(
			portletDataContext, layoutPageTemplateEntry,
			importedLayoutPageTemplateEntry, layoutPrototype, isNew);

		_importAssetDisplayPages(
			portletDataContext, layoutPageTemplateEntry,
			importedLayoutPageTemplateEntry);

		portletDataContext.importClassedModel(
			layoutPageTemplateEntry, importedLayoutPageTemplateEntry);
	}

	protected LayoutPageTemplateEntry fetchExistingTemplate(
		String uuid, long groupId, String name, long plid, boolean preloaded) {

		LayoutPageTemplateEntry existingTemplate = null;

		if (!preloaded) {
			existingTemplate =
				_stagedModelRepository.fetchStagedModelByUuidAndGroupId(
					uuid, groupId);
		}
		else if (plid > 0) {
			existingTemplate =
				_layoutPageTemplateEntryLocalService.
					fetchLayoutPageTemplateEntryByPlid(plid);
		}

		if ((existingTemplate == null) && preloaded) {
			existingTemplate =
				_layoutPageTemplateEntryLocalService.
					fetchLayoutPageTemplateEntry(groupId, name);
		}

		return existingTemplate;
	}

	@Override
	protected StagedModelRepository<LayoutPageTemplateEntry>
		getStagedModelRepository() {

		return _stagedModelRepository;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private LayoutPageTemplateEntry _addStagedModel(
			PortletDataContext portletDataContext,
			LayoutPageTemplateEntry layoutPageTemplateEntry)
		throws PortalException {

		if (layoutPageTemplateEntry.isDefaultTemplate()) {
			LayoutPageTemplateEntry defaultLayoutPageTemplateEntry =
				_layoutPageTemplateEntryLocalService.
					fetchDefaultLayoutPageTemplateEntry(
						layoutPageTemplateEntry.getGroupId(),
						layoutPageTemplateEntry.getClassNameId(),
						layoutPageTemplateEntry.getClassTypeId());

			if (defaultLayoutPageTemplateEntry != null) {
				layoutPageTemplateEntry.setDefaultTemplate(false);
			}
		}

		return _stagedModelRepository.addStagedModel(
			portletDataContext, layoutPageTemplateEntry);
	}

	private void _exportAssetDisplayPages(
			PortletDataContext portletDataContext,
			LayoutPageTemplateEntry layoutPageTemplateEntry)
		throws PortletDataException {

		List<AssetDisplayPageEntry> assetDisplayPageEntries =
			_assetDisplayPageEntryLocalService.
				getAssetDisplayPageEntriesByLayoutPageTemplateEntryId(
					layoutPageTemplateEntry.getLayoutPageTemplateEntryId());

		for (AssetDisplayPageEntry assetDisplayPageEntry :
				assetDisplayPageEntries) {

			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, layoutPageTemplateEntry,
				assetDisplayPageEntry,
				PortletDataContext.REFERENCE_TYPE_DEPENDENCY);
		}
	}

	private void _importAssetDisplayPages(
			PortletDataContext portletDataContext,
			LayoutPageTemplateEntry layoutPageTemplateEntry,
			LayoutPageTemplateEntry importedLayoutPageTemplateEntry)
		throws PortletDataException {

		List<Element> assetDisplayPageEntryElements =
			portletDataContext.getReferenceDataElements(
				layoutPageTemplateEntry, AssetDisplayPageEntry.class);

		for (Element assetDisplayPageEntryElement :
				assetDisplayPageEntryElements) {

			String path = assetDisplayPageEntryElement.attributeValue("path");

			AssetDisplayPageEntry assetDisplayPageEntry =
				(AssetDisplayPageEntry)portletDataContext.getZipEntryAsObject(
					path);

			StagedModelDataHandlerUtil.importStagedModel(
				portletDataContext, assetDisplayPageEntry);

			Map<Long, Long> assetDisplayPageEntries =
				(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
					AssetDisplayPageEntry.class);

			long assetDisplayPageEntryId = MapUtil.getLong(
				assetDisplayPageEntries,
				assetDisplayPageEntry.getAssetDisplayPageEntryId(),
				assetDisplayPageEntry.getAssetDisplayPageEntryId());

			AssetDisplayPageEntry existingAssetDisplayPageEntry =
				_assetDisplayPageEntryLocalService.fetchAssetDisplayPageEntry(
					assetDisplayPageEntryId);

			if (existingAssetDisplayPageEntry != null) {
				existingAssetDisplayPageEntry.setLayoutPageTemplateEntryId(
					importedLayoutPageTemplateEntry.
						getLayoutPageTemplateEntryId());
				existingAssetDisplayPageEntry.setPlid(
					importedLayoutPageTemplateEntry.getPlid());

				_assetDisplayPageEntryLocalService.updateAssetDisplayPageEntry(
					existingAssetDisplayPageEntry);
			}
		}
	}

	private void _validateLayoutPrototype(
			PortletDataContext portletDataContext,
			LayoutPageTemplateEntry layoutPageTemplateEntry,
			LayoutPageTemplateEntry importedLayoutPageTemplateEntry,
			LayoutPrototype layoutPrototype, boolean isNew)
		throws PortalException {

		if (isNew && !ExportImportThreadLocal.isStagingInProcess() &&
			(layoutPrototype != null)) {

			LayoutPrototype existingLayoutPrototype =
				_layoutPrototypeLocalService.
					getLayoutPrototypeByUuidAndCompanyId(
						layoutPrototype.getUuid(),
						portletDataContext.getCompanyId());

			if (existingLayoutPrototype != null) {
				LayoutPageTemplateEntry existingLayoutPageTemplateEntry =
					_layoutPageTemplateEntryLocalService.
						fetchFirstLayoutPageTemplateEntry(
							existingLayoutPrototype.getLayoutPrototypeId());

				if ((existingLayoutPageTemplateEntry != null) &&
					(existingLayoutPageTemplateEntry.
						getLayoutPageTemplateEntryId() !=
							importedLayoutPageTemplateEntry.
								getLayoutPageTemplateEntryId())) {

					StringBundler sb = new StringBundler(9);

					sb.append("LayoutPageTemplate with ");
					sb.append("layoutPageTemplateEntryId ");
					sb.append(
						layoutPageTemplateEntry.getLayoutPageTemplateEntryId());
					sb.append(" can not be imported because a ");
					sb.append("LayoutPrototype with uuid ");
					sb.append(layoutPrototype.getUuid());
					sb.append(" and companyId ");
					sb.append(portletDataContext.getCompanyId());
					sb.append(" already exists");

					throw new UnsupportedOperationException(sb.toString());
				}
			}
		}
	}

	@Reference
	private AssetDisplayPageEntryLocalService
		_assetDisplayPageEntryLocalService;

	@Reference
	private DDMStructureLocalService _ddmStructureLocalService;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private LayoutPageTemplateCollectionLocalService
		_layoutPageTemplateCollectionLocalService;

	@Reference
	private LayoutPageTemplateEntryLocalService
		_layoutPageTemplateEntryLocalService;

	@Reference
	private LayoutPrototypeLocalService _layoutPrototypeLocalService;

	@Reference
	private Portal _portal;

	@Reference(
		target = "(model.class.name=com.liferay.layout.page.template.model.LayoutPageTemplateEntry)",
		unbind = "-"
	)
	private StagedModelRepository<LayoutPageTemplateEntry>
		_stagedModelRepository;

	private UserLocalService _userLocalService;

}