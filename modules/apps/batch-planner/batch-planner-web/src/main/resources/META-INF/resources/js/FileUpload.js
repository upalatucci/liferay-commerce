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

import ClayForm, {ClayInput} from '@clayui/form';
import {useIsMounted} from '@liferay/frontend-js-react-web';
import React, {useCallback, useState} from 'react';

import {parseCSV} from './FileParsers';

function FileUpload({portletNamespace}) {
	const isMounted = useIsMounted();
	const [errorMessage, setErrorMessage] = useState();

	const onFileChange = useCallback(
		(event) => {
			const fileToInspect = event?.target?.files[0];
			if (!fileToInspect) {
				return;
			}

			const onComplete = (schema) => {
				if (isMounted()) {
					Liferay.fire('file-schema', {
						schema,
					});
				}
			};

			const onError = () => {
				if (isMounted()) {
					setErrorMessage(Liferay.Language.get('unexpected-error'));
				}
			};

			return parseCSV({
				file: fileToInspect,
				onComplete,
				onError,
			});
		},
		[isMounted]
	);

	const inputNameId = `${portletNamespace}-import-file`;

	return (
		<span>
			<ClayForm.Group className={errorMessage ? 'has-error' : ''}>
				<label htmlFor={inputNameId}>
					{Liferay.Language.get('file')}
				</label>

				<ClayInput
					accept=".csv"
					id={inputNameId}
					name={inputNameId}
					onChange={onFileChange}
					type="file"
				/>

				{errorMessage && (
					<ClayForm.FeedbackGroup>
						<ClayForm.FeedbackItem>
							<ClayForm.FeedbackIndicator symbol="exclamation-full" />

							{errorMessage}
						</ClayForm.FeedbackItem>
					</ClayForm.FeedbackGroup>
				)}
			</ClayForm.Group>
		</span>
	);
}

export default FileUpload;
