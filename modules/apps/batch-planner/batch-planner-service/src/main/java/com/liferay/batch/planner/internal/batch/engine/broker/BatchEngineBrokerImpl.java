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

package com.liferay.batch.planner.internal.batch.engine.broker;

import com.liferay.batch.planner.batch.engine.broker.BatchEngineBroker;
import com.liferay.batch.planner.constants.BatchPlannerLogConstants;
import com.liferay.batch.planner.exception.BatchPlannerMappingExternalFieldNameException;
import com.liferay.batch.planner.internal.jaxrs.uri.EmptyUriInfo;
import com.liferay.batch.planner.model.BatchPlannerMapping;
import com.liferay.batch.planner.model.BatchPlannerMappingModel;
import com.liferay.batch.planner.model.BatchPlannerPlan;
import com.liferay.batch.planner.service.BatchPlannerLogLocalService;
import com.liferay.batch.planner.service.BatchPlannerMappingLocalService;
import com.liferay.batch.planner.service.BatchPlannerPlanLocalService;
import com.liferay.headless.batch.engine.dto.v1_0.ExportTask;
import com.liferay.headless.batch.engine.dto.v1_0.ImportTask;
import com.liferay.headless.batch.engine.resource.v1_0.ExportTaskResource;
import com.liferay.headless.batch.engine.resource.v1_0.ImportTaskResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.io.File;
import java.io.FileInputStream;

import java.net.URI;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Igor Beslic
 */
@Component(service = BatchEngineBroker.class)
public class BatchEngineBrokerImpl implements BatchEngineBroker {

	public void submit(long batchPlannerPlanId) {
		try {
			BatchPlannerPlan batchPlannerPlan =
				_batchPlannerPlanLocalService.getBatchPlannerPlan(
					batchPlannerPlanId);

			if (batchPlannerPlan.isExport()) {
				_submitExportTask(batchPlannerPlan);
			}
			else {
				_submitImportTask(batchPlannerPlan);
			}

			_batchPlannerPlanLocalService.updateActive(
				batchPlannerPlanId, true);
		}
		catch (Exception exception) {
			_log.error(
				"Unable to execute batch planner plan ID " + batchPlannerPlanId,
				exception);
		}
	}

	private String _getFieldNameMappingString(
		List<BatchPlannerMapping> batchPlannerMappings) {

		if (batchPlannerMappings.isEmpty()) {
			throw new IllegalArgumentException(
				"At least one import export mapping entry is expected");
		}

		StringBundler sb = new StringBundler(
			(batchPlannerMappings.size() * 3) - 1);

		Iterator<BatchPlannerMapping> iterator =
			batchPlannerMappings.iterator();

		while (iterator.hasNext()) {
			BatchPlannerMapping batchPlannerMapping = iterator.next();

			sb.append(batchPlannerMapping.getExternalFieldName());

			sb.append(StringPool.EQUAL);
			sb.append(batchPlannerMapping.getInternalFieldName());

			if (iterator.hasNext()) {
				sb.append(StringPool.COMMA);
			}
		}

		return sb.toString();
	}

	private File _getFile(long batchPlannerPlanId) throws Exception {
		BatchPlannerPlan batchPlannerPlan =
			_batchPlannerPlanLocalService.getBatchPlannerPlan(
				batchPlannerPlanId);

		return new File(new URI(batchPlannerPlan.getExternalURL()));
	}

	private String[] _getHeaderNames(
		List<BatchPlannerMapping> batchPlannerMappings,
		UnsafeFunction<BatchPlannerMapping, String, Exception> unsafeFunction) {

		return TransformUtil.transformToArray(
			batchPlannerMappings, unsafeFunction, String.class);
	}

	private void _submitExportTask(BatchPlannerPlan batchPlannerPlan)
		throws Exception {

		_exportTaskResource.setContextCompany(
			_companyLocalService.getCompany(batchPlannerPlan.getCompanyId()));
		_exportTaskResource.setContextUriInfo(
			new EmptyUriInfo(batchPlannerPlan.getTaskItemDelegateName()));
		_exportTaskResource.setContextUser(
			_userLocalService.getUser(batchPlannerPlan.getUserId()));

		List<BatchPlannerMapping> batchPlannerMappings =
			_batchPlannerMappingLocalService.getBatchPlannerMappings(
				batchPlannerPlan.getBatchPlannerPlanId());

		String[] headerNames = _getHeaderNames(
			batchPlannerMappings,
			BatchPlannerMappingModel::getInternalFieldName);

		ExportTask exportTask = _exportTaskResource.postExportTask(
			batchPlannerPlan.getInternalClassName(),
			batchPlannerPlan.getExternalType(), null,
			StringUtil.merge(headerNames, StringPool.COMMA),
			batchPlannerPlan.getTaskItemDelegateName());

		_batchPlannerLogLocalService.addBatchPlannerLog(
			batchPlannerPlan.getUserId(),
			batchPlannerPlan.getBatchPlannerPlanId(),
			String.valueOf(exportTask.getId()), null, null, 0,
			BatchPlannerLogConstants.STATUS_QUEUED);
	}

	private void _submitImportTask(BatchPlannerPlan batchPlannerPlan)
		throws Exception {

		_importTaskResource.setContextCompany(
			_companyLocalService.getCompany(batchPlannerPlan.getCompanyId()));

		_importTaskResource.setContextUriInfo(
			new EmptyUriInfo(batchPlannerPlan.getTaskItemDelegateName()));
		_importTaskResource.setContextUser(
			_userLocalService.getUser(batchPlannerPlan.getUserId()));

		File file = _getFile(batchPlannerPlan.getBatchPlannerPlanId());

		try {
			ImportTask importTask = _importTaskResource.postImportTask(
				batchPlannerPlan.getInternalClassName(), null,
				_getFieldNameMappingString(
					_batchPlannerMappingLocalService.getBatchPlannerMappings(
						batchPlannerPlan.getBatchPlannerPlanId())),
				batchPlannerPlan.getTaskItemDelegateName(),
				MultipartBody.of(
					Collections.singletonMap(
						"file",
						new BinaryFile(
							"text/csv", file.getName(),
							new FileInputStream(file), file.length())),
					null, Collections.emptyMap()));

			_batchPlannerLogLocalService.addBatchPlannerLog(
				batchPlannerPlan.getUserId(),
				batchPlannerPlan.getBatchPlannerPlanId(), null,
<<<<<<< HEAD
				String.valueOf(importTask.getId()), null,
				(int)jsonlFile.length(),
				BatchPlannerLogConstants.STATUS_QUEUED);
=======
				String.valueOf(importTask.getId()), null, (int)file.length(),
				1);
>>>>>>> e208229dd989 (COMMERCE-7143 batch-planner-service - do not transform CSV - just extract metadata for batch engine and pass it)
		}
		finally {
			FileUtil.delete(file);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BatchEngineBrokerImpl.class);

	@Reference
	private BatchPlannerLogLocalService _batchPlannerLogLocalService;

	@Reference
	private BatchPlannerMappingLocalService _batchPlannerMappingLocalService;

	@Reference
	private BatchPlannerPlanLocalService _batchPlannerPlanLocalService;

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private ExportTaskResource _exportTaskResource;

	@Reference
	private ImportTaskResource _importTaskResource;

	@Reference
	private UserLocalService _userLocalService;

}