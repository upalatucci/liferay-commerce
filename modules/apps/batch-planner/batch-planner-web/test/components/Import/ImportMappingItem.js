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
import {act, cleanup, fireEvent, render} from '@testing-library/react';
import React from 'react';

import ImportMappingItem from '../../../src/main/resources/META-INF/resources/js/import/ImportMappingItem';

const BASE_PROPS = {
	field: {
		label: 'currencyCode',
		value: 'currencyCode',
	},
	selectableFields: [
		{
			label: 'test',
			required: true,
			value: 'test',
		},
		{
			label: 'testSelect',
			value: 'testSelect',
		},
	],
};

describe('ImportMappingItem', () => {
	afterEach(cleanup);

	it('must render', () => {
		render(<ImportMappingItem {...BASE_PROPS} />);
	});

	it('must show dropdown items on select click', () => {
		const {getByLabelText, getByText} = render(
			<ImportMappingItem {...BASE_PROPS} />
		);

		act(() => {
			fireEvent.click(getByLabelText(BASE_PROPS.field.label));
		});

		getByText(BASE_PROPS.selectableFields[0].label);
	});

	it('must select the item when user click on the dropdown item', () => {
		const {getByLabelText, getByText} = render(
			<ImportMappingItem {...BASE_PROPS} />
		);

		act(() => {
			fireEvent.click(getByLabelText(BASE_PROPS.field.label));
		});

		act(() => {
			fireEvent.click(getByText(BASE_PROPS.selectableFields[0].label));
		});

		expect(getByLabelText(BASE_PROPS.field.label).textContent).toBe(
			BASE_PROPS.selectableFields[0].value
		);
	});

	it('must filter elements when search text is provided', () => {
		const {
			getByLabelText,
			getByPlaceholderText,
			getByText,
			queryByText,
		} = render(<ImportMappingItem {...BASE_PROPS} />);

		act(() => {
			fireEvent.click(getByLabelText(BASE_PROPS.field.label));
		});

		act(() => {
			fireEvent.change(
				getByPlaceholderText(Liferay.Language.get('search')),
				{
					target: {value: BASE_PROPS.selectableFields[1].label},
				}
			);
		});

		getByText(BASE_PROPS.selectableFields[1].label);
		expect(queryByText(BASE_PROPS.selectableFields[0].label)).toBeNull();
	});
});
