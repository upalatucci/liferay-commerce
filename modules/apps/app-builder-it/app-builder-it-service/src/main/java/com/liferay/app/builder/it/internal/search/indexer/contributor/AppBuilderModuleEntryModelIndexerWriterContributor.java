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

package com.liferay.app.builder.it.internal.search.indexer.contributor;

import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.app.builder.it.service.AppBuilderModuleEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.app.builder.it.model.AppBuilderModuleEntry",
	service = ModelIndexerWriterContributor.class
)
public class AppBuilderModuleEntryModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<AppBuilderModuleEntry> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			(AppBuilderModuleEntry blogsEntry) ->
				batchIndexingActionable.addDocuments(
					modelIndexerWriterDocumentHelper.getDocument(blogsEntry)));
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				_appBuilderModuleEntryLocalService.
					getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(AppBuilderModuleEntry blogsEntry) {
		return blogsEntry.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(
		AppBuilderModuleEntry blogsEntry) {

		if (blogsEntry.isApproved() || blogsEntry.isDraft() ||
			blogsEntry.isPending()) {

			return IndexerWriterMode.UPDATE;
		}

		return IndexerWriterMode.DELETE;
	}

	@Reference
	private AppBuilderModuleEntryLocalService
		_appBuilderModuleEntryLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory
		_dynamicQueryBatchIndexingActionableFactory;

}