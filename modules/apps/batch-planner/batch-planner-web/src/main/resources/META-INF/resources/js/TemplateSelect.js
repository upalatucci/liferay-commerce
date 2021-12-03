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

import ClayForm, {ClaySelect} from '@clayui/form';
import {fetch, openToast} from 'frontend-js-web';
import PropTypes from 'prop-types';
import React, {useCallback, useEffect, useState} from 'react';

import {
	HEADERS_BATCH_PLANNER_URL,
	HEADLESS_ENDPOINT_POLICY_NAME,
	NULL_TEMPLATE_VALUE,
	TEMPLATE_DIRTY,
	TEMPLATE_SELECTED_EVENT,
} from './constants';

const TemplateSelect = ({
	portletNamespace,
	selectedTemplateClassName,
	selectedTemplateHeadlessEndpoint,
	selectedTemplateMapping,
	templatesOptions,
}) => {
	const [selectedTemplateId, setTemplate] = useState(
		templatesOptions.find((option) => option.selected)?.value
	);

	const handleLoadingTemplateOnStart = useCallback(() => {
		if (
			selectedTemplateMapping &&
			selectedTemplateClassName &&
			selectedTemplateHeadlessEndpoint
		) {
			Liferay.fire(TEMPLATE_SELECTED_EVENT, {
				templateClassName: selectedTemplateClassName,
				templateHeadlessEndpoint: selectedTemplateHeadlessEndpoint,
				templateMapping: selectedTemplateMapping,
			});
		}
	}, [
		selectedTemplateClassName,
		selectedTemplateHeadlessEndpoint,
		selectedTemplateMapping,
	]);

	useEffect(() => {
		function handleTemplateDirty() {
			setTemplate(NULL_TEMPLATE_VALUE);
		}

		Liferay.on(TEMPLATE_DIRTY, handleTemplateDirty);

		document.addEventListener(
			'readystatechange',
			handleLoadingTemplateOnStart
		);

		return () => {
			Liferay.detach(TEMPLATE_DIRTY, handleTemplateDirty);
			document.removeEventListener(
				'readystatechange',
				handleLoadingTemplateOnStart
			);
		};
	}, [handleLoadingTemplateOnStart]);

	const onChange = (event) => {
		const newTemplateId = event.target.value;
		setTemplate(newTemplateId);
		fireTemplateSelectionEvent(newTemplateId);
	};

	const selectId = `${portletNamespace}templateName`;

	return (
		<ClayForm.Group className="form-group-sm">
			<label htmlFor={selectId}>{Liferay.Language.get('template')}</label>

			<ClaySelect
				id={selectId}
				name={selectId}
				onChange={onChange}
				value={selectedTemplateId}
			>
				<ClaySelect.Option key={0} value={NULL_TEMPLATE_VALUE} />

				{templatesOptions.map((option) => (
					<ClaySelect.Option
						key={option.value}
						label={option.label}
						value={option.value}
					/>
				))}
			</ClaySelect>
		</ClayForm.Group>
	);
};

TemplateSelect.propTypes = {
	portletNamespace: PropTypes.string.isRequired,
	selectedTemplateClassName: PropTypes.string,
	selectedTemplateHeadlessEndpoint: PropTypes.string,
	selectedTemplateMapping: PropTypes.object,
	templatesOptions: PropTypes.arrayOf(PropTypes.object),
};

function getMappingFromTemplate(template) {
	const {mappings} = template;

	return mappings.reduce((accumulator, map) => {
		accumulator[map.internalFieldName] = map.externalFieldName;

		return accumulator;
	}, {});
}

async function fireTemplateSelectionEvent(templateId) {
	if (templateId === NULL_TEMPLATE_VALUE) {
		return Liferay.fire(TEMPLATE_SELECTED_EVENT, {
			templateClassName: null,
			templateHeadlessEndpoint: null,
			templateMapping: null,
		});
	}

	const request = await fetch(
		`${HEADERS_BATCH_PLANNER_URL}/plans/${templateId}`
	);

	if (!request.ok) {
		return openToast({
			message: Liferay.Language.get('your-request-has-failed'),
			type: 'danger',
		});
	}

	const template = await request.json();

	const headlessEndpoint = template.policies.find(
		(policy) => policy?.name === HEADLESS_ENDPOINT_POLICY_NAME
	);

	Liferay.fire(TEMPLATE_SELECTED_EVENT, {
		templateClassName: template.internalClassName,
		templateHeadlessEndpoint: headlessEndpoint?.value,
		templateMapping: getMappingFromTemplate(template),
	});
}

export default TemplateSelect;
