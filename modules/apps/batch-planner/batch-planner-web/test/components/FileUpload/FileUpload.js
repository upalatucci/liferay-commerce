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

import FileUpload from '../../../src/main/resources/META-INF/resources/js/FileUpload';

const fileContents = 'file contents';
const file = new Blob([fileContents], {type: 'text/plain'});
const readAsText = jest.fn();
let dummyFileReader;

function mockFileReader(addEventListener) {
	dummyFileReader = {
		addEventListener,
		loaded: false,
		readAsText,
		result: fileContents,
	};
	window.FileReader = jest.fn(() => dummyFileReader);
}

describe('FileUpload', () => {
	beforeEach(() => {
		jest.clearAllMocks();
	});

	afterEach(cleanup);

	it('must read the file on input change', async () => {
		mockFileReader(
			jest.fn((_, evtHandler) => {
				evtHandler({loaded: 50, total: 100});
			})
		);

		const {getByRole, getByText} = render(
			<FileUpload portletNamespace="test" />
		);

		act(() => {
			fireEvent.change(getByRole('textbox'), {target: {files: [file]}});
		});

		await wait(() => {
			getByText(Liferay.Language.get('file-upload'));
		});

		expect(dummyFileReader.readAsText).toBeCalled();
	});

	it('must loading primary button on reading file', async () => {
		mockFileReader(
			jest.fn((eventType, evtHandler) => {
				if (eventType === 'progress') {
					evtHandler({loaded: 50, total: 100});
				}
			})
		);

		const {getByRole, getByText} = render(
			<FileUpload portletNamespace="test" />
		);

		act(() => {
			fireEvent.change(getByRole('textbox'), {target: {files: [file]}});
		});

		await wait(() => {
			getByText(Liferay.Language.get('file-upload'));
		});

		expect(getByText(Liferay.Language.get('done'))).toBeDisabled();
	});

	it('must enable button and fire file-schema event on file process ended', async () => {
		mockFileReader(
			jest.fn((eventType, evtHandler) => {
				if (eventType === 'load') {
					evtHandler();
				}
			})
		);

		const mockFileShemaListener = jest.fn();
		Liferay.on('file-schema', mockFileShemaListener);

		const {getByRole, getByText} = render(
			<FileUpload portletNamespace="test" />
		);

		act(() => {
			fireEvent.change(getByRole('textbox'), {target: {files: [file]}});
		});

		await wait(() => {
			getByText(Liferay.Language.get('file-upload'));
		});

		expect(getByText(Liferay.Language.get('done'))).not.toBeDisabled();
		expect(mockFileShemaListener).toBeCalled();
	});
});
