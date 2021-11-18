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

import PropTypes from 'prop-types';

export const download = (url, filename) => {
	var a = document.createElement('a');
	document.body.appendChild(a);
	a.style.display = 'none';
	a.href = url;
	a.download = filename;
	a.click();
	window.URL.revokeObjectURL(url);
};

export const getFieldsFromSchema = (schema) => {
	const dbFields = [];
	const fileFields = [];

	for (const [label, property] of Object.entries(schema)) {
		if (property.writeOnly || label.startsWith('x-')) {
			continue;
		}

		let value = label;

		if (property.extensions && property.extensions['x-parent-map']) {
			value = property.extensions['x-parent-map'] + '_' + label;
		}

		const field = {label, value};

		fileFields.push(field);
		dbFields.push(field);
	}

	return [fileFields, dbFields];
};

export const buildDropdownItemsFromFields = (
	fields,
	searchLabel,
	onClickCallback
) => {
	const searchedFields = fields?.filter((f) =>
		searchLabel
			? f.label.toLowerCase().includes(searchLabel.toLowerCase())
			: true
	);

	const clickableFields =
		searchedFields?.map((f) => ({
			...f,
			onClick: () => onClickCallback(f),
		})) || [];

	const requiredFields = clickableFields.filter((f) => f.required);
	const optionalFields = clickableFields.filter((f) => !f.required);

	return [requiredFields, optionalFields];
};

export const ImportFieldPropType = {
	label: PropTypes.string.isRequired,
	required: PropTypes.bool,
	value: PropTypes.string.isRequired,
};
