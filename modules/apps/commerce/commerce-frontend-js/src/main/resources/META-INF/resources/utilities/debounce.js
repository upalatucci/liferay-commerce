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

export default function debounce(func, wait, immediate) {
	let timeout;

	return function () {
		const context = this;
		const args = arguments;

		function later() {
			timeout = null;
			if (!immediate) {
				func.apply(context, args);
			}
		}
		const callNow = immediate && !timeout;

		clearTimeout(timeout);
		timeout = setTimeout(later, wait);
		if (callNow) {
			func.apply(context, args);
		}
	};
}

export function debouncePromise(inner, ms = 0) {
	let timer = null;
	let resolves = [];

	return function (...args) {
		clearTimeout(timer);
		timer = setTimeout(() => {
			const result = inner(...args);
			resolves.forEach((r) => r(result));
			resolves = [];
		}, ms);

		return new Promise((r) => resolves.push(r));
	};
}
