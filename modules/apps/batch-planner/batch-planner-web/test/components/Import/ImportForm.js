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
import {act, cleanup, render} from '@testing-library/react';
import React from 'react';

import ImportForm from '../../../src/main/resources/META-INF/resources/js/import/ImportForm';

const BASE_PROPS = {
	backUrl: 'https://liferay.com/backurl',
	formDataQuerySelector: 'form',
	formImportURL: 'https://formUrl.test',
	formSaveAsTemplateURL: 'https://formUrl.test/saveTemplateUrl',
	portletNamespace: 'test',
};

const SCHEMA = {
	'currencyCode': {
		type: 'string',
	},
	'externalReferenceCode': {
		type: 'string',
	},
	'id': {
		format: 'int64',
		type: 'integer',
	},
	'name': {
		type: 'string',
	},
	'siteGroupId': {
		format: 'int64',
		type: 'integer',
	},
	'type': {
		type: 'string',
	},
	'x-class-name': {
		default: 'com.liferay.headless.commerce.admin.channel.dto.v1_0.Channel',
		readOnly: true,
		type: 'string',
	},
};

describe('ImportForm', () => {
	afterEach(cleanup);

	it('must render', () => {
		render(<ImportForm {...BASE_PROPS} />);
	});

	it('must show import mapping on schema change', () => {
		const {queryAllByRole} = render(<ImportForm {...BASE_PROPS} />);

		act(() =>
			Liferay.fire('schema-selected', {
				schema: SCHEMA,
			})
		);

		expect(queryAllByRole('listbox')).toHaveLength(
			Object.keys(SCHEMA).length - 1
		);
	});
});
