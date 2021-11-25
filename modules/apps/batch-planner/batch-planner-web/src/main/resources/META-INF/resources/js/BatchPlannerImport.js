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

import {fetch} from 'frontend-js-web';

import {
	HEADERS,
	HEADLESS_BATCH_ENGINE_URL,
	PROCESS_COMPLETED,
	PROCESS_FAILED,
} from './constants';

export function getImportTaskStatusURL(taskId) {
	return `${HEADLESS_BATCH_ENGINE_URL}/import-task/${taskId}`;
}

export function getImportFileURL(taskId) {
	return `${HEADLESS_BATCH_ENGINE_URL}/import-task/${taskId}/content`;
}

export async function startImport(
	fieldsMap,
	formDataQuerySelector,
	formSubmitURL
) {
	const mainFormData = document.querySelector(formDataQuerySelector);
	const formData = new FormData(mainFormData);

	console.log(formData);

	const response = await fetch(formSubmitURL, {
		body: formData,
		headers: HEADERS,
		method: 'POST',
	});

	return await response.json();
}

export async function importStatus(exportTaskId) {
	const response = await fetch(getImportTaskStatusURL(exportTaskId), {
		headers: HEADERS,
	});

	return await response.json();
}

export async function getImportStatus({onFail, onProgress, onSuccess, taskId}) {
	try {
		const {
			errorMessage,
			executeStatus,
			processedItemsCount,
			totalItemsCount,
		} = await importStatus(taskId);

		switch (executeStatus) {
			case PROCESS_FAILED:
				onFail(
					errorMessage || Liferay.Language.get('unexpected-error')
				);
				break;
			case PROCESS_COMPLETED:
				onSuccess();
				break;
			default:
				onProgress(
					Math.round((processedItemsCount / totalItemsCount) * 100)
				);
		}
	}
	catch (error) {
		onFail(Liferay.Language.get('unexpected-error'));
	}
}
