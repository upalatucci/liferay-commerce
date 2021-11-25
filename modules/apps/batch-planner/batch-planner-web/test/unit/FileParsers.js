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

import {parseCSV} from '../../src/main/resources/META-INF/resources/js/FileParsers';

describe('FileParsers', () => {
	it('must correctly read header', () => {
		const columns = parseCSV(`currencyCode,type,name
            USD,site,My Channel 0
            USD,site,My Channel 1
            USD,site,My Channel 2
            USD,site,My Channel 3
            USD,site,My Channel 4
        `);

		expect(columns).toStrictEqual(['currencyCode', 'type', 'name']);
	});
});
