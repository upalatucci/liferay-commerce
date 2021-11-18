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

import ClayLink from '@clayui/link';
import PropTypes from 'prop-types';
import React, {useCallback, useEffect, useState} from 'react';

import SaveTemplate from '../SaveTemplate';
import getFieldsFromSchema from '../getFieldsFromSchema';
import ImportMappingItem from './ImportMappingItem';
import ImportSubmit from './ImportSubmit';

function ImportForm({
	backUrl,
	formDataQuerySelector,
	formImportURL,
	formSaveAsTemplateURL,
	portletNamespace,
}) {
	const [disable, setDisable] = useState(true);
	const [fileFields, updateFileFields] = useState();
	const [selectableDBFields, updateSelectableDBFields] = useState();

	const onFieldChange = useCallback(
		(selectedItem, prevSelectedItem) => {
			const newSelectableDBFields = selectableDBFields.filter(
				(f) => f.value !== selectedItem.value
			);

			if (prevSelectedItem) {
				newSelectableDBFields.push(prevSelectedItem);
			}

			updateSelectableDBFields(newSelectableDBFields);
		},
		[selectableDBFields]
	);

	useEffect(() => {
		function handleSchemaUpdated(event) {
			const newSchema = event.schema;
			if (newSchema) {
				const [newFileFields, newDBFields] = getFieldsFromSchema(
					newSchema
				);
				updateFileFields(newFileFields);
				updateSelectableDBFields(newDBFields);
				setDisable(false);
			}
		}

		Liferay.on('schema-selected', handleSchemaUpdated);

		return () => Liferay.detach('schema-selected', handleSchemaUpdated);
	}, []);

	return (
		<>
			{fileFields && (
				<div className="card import-mapping-table">
					<h4 className="card-header">
						{Liferay.Language.get('import-mappings')}
					</h4>

					<div className="card-body">
						<div className="lfr-form-content">
							<div className="autofit-section">
								{fileFields?.map((field) => (
									<ImportMappingItem
										field={field}
										key={field.label}
										onChange={onFieldChange}
										selectableFields={selectableDBFields}
									/>
								))}
							</div>
						</div>
					</div>
				</div>
			)}
			<div className="mt-4" id="formButtons">
				<div className="sheet-footer">
					<ClayLink className="btn btn-secondary" href={backUrl}>
						{Liferay.Language.get('cancel')}
					</ClayLink>

					<span>
						<SaveTemplate
							formDataQuerySelector={formDataQuerySelector}
							formSaveAsTemplateURL={formSaveAsTemplateURL}
							portletNamespace={portletNamespace}
						/>
					</span>

					<ImportSubmit
						disabled={disable}
						formImportDataQuerySelector={formDataQuerySelector}
						formImportURL={formImportURL}
						portletNamespace={portletNamespace}
					/>
				</div>
			</div>
		</>
	);
}

ImportForm.propTypes = {
	backUrl: PropTypes.string.isRequired,
	formDataQuerySelector: PropTypes.string.isRequired,
	formImportURL: PropTypes.string.isRequired,
	formSaveAsTemplateURL: PropTypes.string.isRequired,
	portletNamespace: PropTypes.string.isRequired,
};

export default ImportForm;
