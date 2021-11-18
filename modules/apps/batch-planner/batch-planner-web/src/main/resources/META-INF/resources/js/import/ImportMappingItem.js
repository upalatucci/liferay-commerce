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

import ClayButton from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import ClayForm from '@clayui/form';
import ClayIcon from '@clayui/icon';
import PropTypes from 'prop-types';
import React, {useCallback, useMemo, useState} from 'react';

import ImportMappingDropdownItem, {
	ImportFieldPropType,
} from './ImportMappingDropdownItem';

const ImportMappingItem = ({field, onChange, selectableFields}) => {
	const [searchLabel, setSearchLabel] = useState();
	const [selectedField, setSelectedField] = useState();
	const [dropDownActive, setDropDownActive] = useState(false);

	const [requiredFields, optionalFields] = useMemo(
		() =>
			buildDropdownItemsFromFields(
				selectableFields,
				searchLabel,
				setSelectedField
			),
		[selectableFields, searchLabel, setSelectedField]
	);

	const inputId = `input-field-${field.label}`;

	const onSearchChange = useCallback((event) => {
		setSearchLabel(event.target.value);
	}, []);

	const onDropdownItemClick = useCallback(
		(item) => {
			if (onChange) {
				onChange(item, selectedField);
			}

			setSelectedField(item);
			setDropDownActive(false);
		},
		[onChange, selectedField]
	);

	const selectFirstElement = useCallback(
		(event) => {
			event.preventDefault();

			if (onChange) {
				onChange(firstElement, selectedField);
			}

			const firstElement = requiredFields?.at(0) || optionalFields?.at(0);
			if (firstElement) {
				setSelectedField(firstElement);
				setDropDownActive(false);
			}
		},
		[onChange, optionalFields, requiredFields, selectedField]
	);

	return (
		<ClayForm.Group>
			<label htmlFor={inputId}>{field.label}</label>

			<ClayDropDown
				active={dropDownActive}
				onActiveChange={setDropDownActive}
				tabIndex={-1}
				trigger={
					<ClayButton
						aria-expanded={dropDownActive ? 'true' : 'false'}
						aria-haspopup="listbox"
						className="w-100"
						displayType="secondary"
						id={inputId}
					>
						<span className="align-items-center d-flex justify-content-between">
							<span>{selectedField?.label ?? '\u00A0'}</span>

							<ClayIcon symbol="caret-double" />
						</span>
					</ClayButton>
				}
			>
				<ClayDropDown.Search
					formProps={{onSubmit: selectFirstElement}}
					onChange={onSearchChange}
					placeholder={Liferay.Language.get('search')}
					value={searchLabel}
				/>

				<ClayDropDown.ItemList>
					{requiredFields.length > 0 && (
						<ClayDropDown.Group
							header={Liferay.Language.get('required')}
						>
							<ClayDropDown.Divider />
							{requiredFields.map((item) => (
								<ImportMappingDropdownItem
									item={item}
									key={item.value}
									onClick={onDropdownItemClick}
									selectedItem={selectedField}
								/>
							))}
						</ClayDropDown.Group>
					)}
					{optionalFields.length > 0 && (
						<ClayDropDown.Group
							header={Liferay.Language.get('optional')}
						>
							<ClayDropDown.Divider />
							{optionalFields.map((item) => (
								<ImportMappingDropdownItem
									item={item}
									key={item.value}
									onClick={onDropdownItemClick}
									selectedItem={selectedField}
								/>
							))}
						</ClayDropDown.Group>
					)}
				</ClayDropDown.ItemList>
			</ClayDropDown>
		</ClayForm.Group>
	);
};

const buildDropdownItemsFromFields = (fields, searchLabel, onClickCallback) => {
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

ImportMappingItem.propTypes = {
	field: PropTypes.shape(ImportFieldPropType),
	onChange: PropTypes.func,
	selectableFields: PropTypes.arrayOf(PropTypes.shape(ImportFieldPropType)),
};

export default ImportMappingItem;
