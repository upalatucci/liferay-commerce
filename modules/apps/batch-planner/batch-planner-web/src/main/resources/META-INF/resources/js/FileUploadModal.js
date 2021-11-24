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
import {useIsMounted} from '@liferay/frontend-js-react-web';
import PropTypes from 'prop-types';
import React, {useEffect, useState} from 'react';

const FileUploadModal = ({closeModal, observer}) => {
	const [percentage, setPercentage] = useState(0);
	const isMounted = useIsMounted();
	const [errorMessage, setErrorMessage] = useState();
	const [loadingResponse, setLoadingResponse] = useState(false);

	useEffect(() => {
		async function uploadFile() {
			setLoadingResponse(true);
			try {
				const saveTemplateResponse = {qualcosa: 'ciao'};

				if (isMounted()) {
					if (saveTemplateResponse.error) {
						setLoadingResponse(false);
						setErrorMessage(saveTemplateResponse.error);
					}
					else {
						setPercentage(100);
					}
				}
			}
			catch (error) {
				setErrorMessage(Liferay.Language.get('unexpected-error'));
			}
			finally {
				setLoadingResponse(false);
			}
		}

		uploadFile();
	}, [isMounted]);

	return (
		<ClayModal observer={observer} size="md">
			<ClayModal.Header>
				{Liferay.Language.get('file-upload')}
			</ClayModal.Header>

			<ClayModal.Body>
				<ClayForm.Group className={errorMessage ? 'has-error' : ''}>
					<div
						className="progress-container"
						data-percentage={percentage}
						data-title={
							percentage === 100
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
							disabled={loadingResponse}
							displayType="primary"
							onClick={closeModal}
							type="button"
						>
							{loadingResponse && (
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

FileUploadModal.propTypes = {
	closeModal: PropTypes.func.isRequired,
	fileToUpload: PropTypes.object.isRequired,
	observer: PropTypes.object,
};

export default FileUploadModal;
