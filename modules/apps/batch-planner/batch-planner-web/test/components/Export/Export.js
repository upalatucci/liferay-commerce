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

import '@testing-library/jest-dom/extend-expect';
import {
	act,
	cleanup,
	fireEvent,
	render,
	wait,
	waitForElement,
} from '@testing-library/react';
import fetchMock from 'fetch-mock';
import React from 'react';

import {getExportTaskStatusURL} from '../../../src/main/resources/META-INF/resources/js/api';
import {
	EXPORT_PROCESS_COMPLETED,
	EXPORT_PROCESS_FAILED,
	EXPORT_PROCESS_STARTED,
	POLLING_EXPORT_STATUS_TIMEOUT,
} from '../../../src/main/resources/META-INF/resources/js/constants';
import Export from '../../../src/main/resources/META-INF/resources/js/export/Export';

const INPUT_VALUE_TEST = 'test';
const BASE_PROPS = {
	formExportDataQuerySelector: 'form',
	formExportURL: 'https://formUrl.test',
	portletNamespace: 'test',
};

const mockTaskID = 1234;
const testBlobPathname = '/blobtest';
let mockApi;

jest.mock('../../../src/main/resources/META-INF/resources/js/api', () => ({
	...jest.requireActual(
		'../../../src/main/resources/META-INF/resources/js/api'
	),
	getExportFileURL: jest
		.fn()
		.mockResolvedValue('https://blobtest.it/blobtest'),
}));

describe('Export', () => {
	beforeAll(() => {
		const form = document.createElement('form');

		form.innerHTML = `
             <input type="text" value="${INPUT_VALUE_TEST}" />
         `;

		document.body.appendChild(form);
	});

	beforeEach(() => {
		const blob = new Blob(['a', 'b', 'c', 'd']);
		mockApi = fetchMock
			.mock(BASE_PROPS.formExportURL, () => ({
				exportTaskId: mockTaskID,
			}))
			.once(
				`/o/headless-batch-engine/v1.0/export-task/${mockTaskID}/content`,
				{body: blob},
				{sendAsJson: false}
			);
	});

	afterEach(() => {
		fetchMock.restore();
		cleanup();
	});

	it('must render export button', () => {
		const {getByText} = render(<Export {...BASE_PROPS} />);

		expect(getByText(Liferay.Language.get('export'))).toBeInTheDocument();
	});

	it('must show modal when the button is clicked', async () => {
		const {getByText} = render(<Export {...BASE_PROPS} />);

		act(() => {
			fireEvent.click(getByText(Liferay.Language.get('export')));
		});

		const exportButton = await waitForElement(() =>
			getByText(Liferay.Language.get('download'))
		);

		expect(exportButton).toBeInTheDocument();
	});

	it('must show modal with disabled button', async () => {
		const {getByText} = render(<Export {...BASE_PROPS} />);

		act(() => {
			fireEvent.click(getByText(Liferay.Language.get('export')));
		});

		const exportButton = await waitForElement(() =>
			getByText(Liferay.Language.get('download'))
		);
		expect(exportButton).toBeDisabled();
	});

	it('must call export API only one time on mount', async () => {
		const {getByText} = render(<Export {...BASE_PROPS} />);

		act(() => {
			fireEvent.click(getByText(Liferay.Language.get('export')));
		});

		await waitForElement(() => getByText(Liferay.Language.get('download')));

		expect(mockApi.calls(BASE_PROPS.formExportURL).length).toBe(1);
	});

	it('must show the correct progress percentage', async () => {
		jest.useFakeTimers();

		const exportTaskStatusURL = getExportTaskStatusURL(mockTaskID);

		fetchMock.mock(exportTaskStatusURL, () => ({
			body: {
				className:
					'com.liferay.headless.commerce.delivery.catalog.dto.v1_0.Product',
				contentType: 'CSV',
				endTime: null,
				errorMessage: null,
				executeStatus: EXPORT_PROCESS_STARTED,
				id: mockTaskID,
				processedItemsCount: 25,
				startTime: '2021-11-10T10:36:08Z',
				totalItemsCount: 50,
			},
		}));

		const {getByText} = render(<Export {...BASE_PROPS} />);

		act(() => {
			fireEvent.click(getByText(Liferay.Language.get('export')));
		});

		await wait(() => {
			jest.advanceTimersByTime(POLLING_EXPORT_STATUS_TIMEOUT);
			expect(getByText('50%')).toBeInTheDocument();
		});

		jest.runOnlyPendingTimers();
		jest.useRealTimers();
	});

	it('must show the error when execcuteStatus FAILED', async () => {
		jest.useFakeTimers();
		const error = 'some test error';

		const exportTaskStatusURL = getExportTaskStatusURL(mockTaskID);

		fetchMock
			.mock(BASE_PROPS.formExportURL, () => ({
				exportTaskId: mockTaskID,
			}))
			.mock(exportTaskStatusURL, () => ({
				body: {
					className:
						'com.liferay.headless.commerce.delivery.catalog.dto.v1_0.Product',
					contentType: 'CSV',
					endTime: null,
					errorMessage: error,
					executeStatus: EXPORT_PROCESS_FAILED,
					id: mockTaskID,
					processedItemsCount: 25,
					startTime: '2021-11-10T10:36:08Z',
					totalItemsCount: 50,
				},
			}));

		const {getByText} = render(<Export {...BASE_PROPS} />);

		act(() => {
			fireEvent.click(getByText(Liferay.Language.get('export')));
		});

		await wait(() => {
			jest.advanceTimersByTime(POLLING_EXPORT_STATUS_TIMEOUT);
			expect(getByText(error)).toBeInTheDocument();
		});

		jest.runOnlyPendingTimers();
		jest.useRealTimers();
	});

	it('must enable the download link when export task is COMPLETED', async () => {
		jest.useFakeTimers();

		const exportTaskStatusURL = getExportTaskStatusURL(mockTaskID);

		fetchMock.mock(exportTaskStatusURL, () => ({
			body: {
				className:
					'com.liferay.headless.commerce.delivery.catalog.dto.v1_0.Product',
				contentType: 'CSV',
				endTime: null,
				errorMessage: null,
				executeStatus: EXPORT_PROCESS_COMPLETED,
				id: mockTaskID,
				processedItemsCount: 50,
				startTime: '2021-11-10T10:36:08Z',
				totalItemsCount: 50,
			},
		}));

		const {getByRole, getByText} = render(<Export {...BASE_PROPS} />);

		act(() => {
			fireEvent.click(getByText(Liferay.Language.get('export')));
		});

		await wait(() => {
			jest.advanceTimersByTime(POLLING_EXPORT_STATUS_TIMEOUT);
			expect(
				getByRole('link', {name: Liferay.Language.get('download')})
			).not.toBeDisabled();
		});

		jest.runOnlyPendingTimers();
		jest.useRealTimers();
	});

	it('must show progress completed when execureStatus is COMPLETED', async () => {
		jest.useFakeTimers();

		const exportTaskStatusURL = getExportTaskStatusURL(mockTaskID);

		fetchMock
			.mock(BASE_PROPS.formExportURL, () => ({
				exportTaskId: mockTaskID,
			}))
			.mock(exportTaskStatusURL, () => ({
				body: {
					className:
						'com.liferay.headless.commerce.delivery.catalog.dto.v1_0.Product',
					contentType: 'CSV',
					endTime: null,
					errorMessage: null,
					executeStatus: EXPORT_PROCESS_COMPLETED,
					id: mockTaskID,
					processedItemsCount: 50,
					startTime: '2021-11-10T10:36:08Z',
					totalItemsCount: 50,
				},
			}));

		const {getByRole, getByText} = render(<Export {...BASE_PROPS} />);

		act(() => {
			fireEvent.click(getByText(Liferay.Language.get('export')));
		});

		await wait(() => {
			jest.advanceTimersByTime(POLLING_EXPORT_STATUS_TIMEOUT);
			expect(
				getByRole('link', {name: Liferay.Language.get('download')})
					.pathname
			).toBe(testBlobPathname);
		});

		jest.runOnlyPendingTimers();
		jest.useRealTimers();
	});
});
