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

import {useIsMounted} from '@liferay/frontend-js-react-web';
import {useCallback, useEffect, useReducer} from 'react';

import {getImportStatus, startImport} from '../BatchPlannerImport';
import {POLL_INTERVAL} from '../constants';

const ERROR = 'ERROR';
const COMPLETED = 'COMPLETED';
const LOADING = 'LOADING';
const PROGRESS = 'PROGRESS';
const START_POLLING = 'START_POLLING';
const STOP_LOADING = 'DOWNLOADING';

const initialState = {
	errorMessage: null,
	loading: false,
	percentage: 0,
	pollingIntervalId: null,
	ready: false,
	taskId: null,
};

const setError = (error) => ({
	payload: error ?? Liferay.Language.get('unexpected-error'),
	type: ERROR,
});

const setTaskId = (taskId) => ({
	payload: taskId,
	type: COMPLETED,
});

const setProgress = (percentage) => ({
	payload: percentage,
	type: PROGRESS,
});

const reducer = (state = initialState, {payload, type}) => {
	switch (type) {
		case STOP_LOADING:
			return {
				...state,
				loading: false,
			};
		case LOADING:
			return {
				...state,
				loading: true,
			};
		case ERROR:
			clearInterval(state.pollingIntervalId);

			return {
				...state,
				errorMessage: payload,
				loading: false,
				pollingIntervalId: null,
			};
		case COMPLETED:
			clearInterval(state.pollingIntervalId);

			return {
				...state,
				loading: false,
				percentage: 100,
				pollingIntervalId: null,
				ready: true,
				taskId: payload,
			};
		case PROGRESS:
			return {
				...state,
				percentage: payload,
			};
		case START_POLLING:
			return {
				...state,
				pollingIntervalId: payload,
			};
		default:
			return state;
	}
};

const ImportPoller = (fieldsMap, formDataQuerySelector, formSubmitURL) => {
	const isMounted = useIsMounted();
	const [state, dispatch] = useReducer(reducer, initialState);

	const dispatchIfMounted = useCallback(
		(action) => {
			if (isMounted()) {
				dispatch(action);
			}
		},
		[dispatch, isMounted]
	);

	useEffect(() => {
		let pollingIntervalId;

		async function callStartImport() {
			dispatchIfMounted({type: LOADING});

			try {
				const {error, importTaskId} = await startImport(
					fieldsMap,
					formDataQuerySelector,
					formSubmitURL
				);

				if (error) {
					dispatchIfMounted(setError(error));
				}

				pollingIntervalId = setInterval(
					() =>
						getImportStatus({
							onFail: (error) =>
								dispatchIfMounted(setError(error)),
							onProgress: (percent) =>
								dispatchIfMounted(setProgress(percent)),
							onSuccess: () =>
								dispatchIfMounted(setTaskId(importTaskId)),
							taskId: importTaskId,
						}),
					POLL_INTERVAL
				);

				dispatchIfMounted({
					payload: pollingIntervalId,
					type: START_POLLING,
				});
			}
			catch (error) {
				console.error(error);
				dispatchIfMounted(setError());
			}
		}

		callStartImport();

		return () => {
			if (pollingIntervalId) {
				clearInterval(pollingIntervalId);
			}
		};
	}, [
		dispatchIfMounted,
		fieldsMap,
		formDataQuerySelector,
		formSubmitURL,
		isMounted,
	]);

	return {
		errorMessage: state.errorMessage,
		loading: state.loading,
		percentage: state.percentage,
		ready: state.ready,
	};
};

export default ImportPoller;
