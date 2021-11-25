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
import ClayForm from '@clayui/form';
import ClayModal from '@clayui/modal';
import ClayProgressBar from '@clayui/progress-bar';
import PropTypes from 'prop-types';
import React from 'react';

import ImportPoller from './ImportPoller';

const ImportModal = ({
	closeModal,
	fieldsMap,
	formDataQuerySelector,
	formSubmitURL,
	observer,
}) => {
	const {errorMessage, loading, percentage, ready} = ImportPoller(
		fieldsMap,
		formDataQuerySelector,
		formSubmitURL
	);

	return (
		<ClayModal observer={observer} size="md">
			<ClayModal.Header>
				{Liferay.Language.get('save-as-template')}
			</ClayModal.Header>

			<ClayModal.Body>
				<ClayForm.Group className={errorMessage ? 'has-error' : ''}>
					<div
						className="progress-container"
						data-percentage={percentage}
						data-title={
							ready
								? Liferay.Language.get('completed')
								: Liferay.Language.get('in-progress')
						}
					>
						<ClayProgressBar
							value={percentage}
							warn={!!errorMessage}
						/>
					</div>

					{errorMessage && (
						<ClayForm.FeedbackGroup>
							<ClayForm.FeedbackItem>
								<ClayForm.FeedbackIndicator symbol="exclamation-full" />

								{errorMessage}
							</ClayForm.FeedbackItem>
						</ClayForm.FeedbackGroup>
					)}
				</ClayForm.Group>
			</ClayModal.Body>

			<ClayModal.Footer
				last={
					<ClayButton.Group spaced>
						<ClayButton
							displayType="secondary"
							onClick={closeModal}
						>
							{Liferay.Language.get('cancel')}
						</ClayButton>

						<ClayButton
							disabled={loading}
							displayType="primary"
							onClick={closeModal}
							type="submit"
						>
							{loading && (
								<span className="inline-item inline-item-before">
									<span
										aria-hidden="true"
										className="loading-animation"
									></span>
								</span>
							)}

							{Liferay.Language.get('done')}
						</ClayButton>
					</ClayButton.Group>
				}
			/>
		</ClayModal>
	);
};

ImportModal.propTypes = {
	closeModal: PropTypes.func.isRequired,
	fieldsMap: PropTypes.object.isRequired,
	fileToUpload: PropTypes.object.isRequired,
	formSubmitURL: PropTypes.string.isRequired,
	observer: PropTypes.object,
};

export default ImportModal;
