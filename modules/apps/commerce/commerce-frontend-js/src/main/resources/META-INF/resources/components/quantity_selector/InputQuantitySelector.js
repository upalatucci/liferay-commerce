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

import {ClayInput} from '@clayui/form';
import React, {useCallback, useEffect, useMemo, useState} from 'react';

import QuantityControls from './utils/index';

function InputQuantitySelector({
	maxQuantity,
	minQuantity,
	multipleQuantity,
	onUpdate,
	quantity: startingQuantity,
	...props
}) {
	const quantityControls = useMemo(
		() =>
			new QuantityControls({
				maxQuantity,
				minQuantity,
				multipleQuantity,
			}),
		[maxQuantity, minQuantity, multipleQuantity]
	);

	const [selectedQuantity, setSelectedQuantity] = useState(
		Math.max(startingQuantity, quantityControls.min)
	);

	useEffect(() => {
		if (onUpdate) {
			onUpdate(selectedQuantity);
		}
	}, [onUpdate, selectedQuantity]);

	const onChange = useCallback(
		({target}) => {
			const parsedValue = parseInt(target.value, 10);
			const newQuantity = quantityControls.getLowerBound(
				parsedValue > quantityControls.max
					? quantityControls.max
					: parsedValue
			);

			setSelectedQuantity(newQuantity);
		},
		[quantityControls, setSelectedQuantity]
	);

	return (
		<ClayInput
			{...props}
			{...quantityControls.getConfiguration()}
			onChange={onChange}
			type="number"
			value={selectedQuantity.toString()}
		/>
	);
}

export default InputQuantitySelector;
