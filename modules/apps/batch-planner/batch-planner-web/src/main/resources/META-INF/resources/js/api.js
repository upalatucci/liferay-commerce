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

const HEADERS = new Headers({
	'Accept': 'application/json',
	'Accept-Language': Liferay.ThemeDisplay.getBCP47LanguageId(),
	'Content-Type': 'application/json',
});

export const saveTemplateAPI = async (
	url,
	formDataQuerySelector,
	updateData
) => {
	const mainFormData = document.querySelector(formDataQuerySelector);

	Liferay.Util.setFormValues(mainFormData, updateData);

	const formData = new FormData(mainFormData);
	const response = await fetch(url, {
		body: formData,
		headers: HEADERS,
		method: 'POST',
	});

	return await response.json();
};
