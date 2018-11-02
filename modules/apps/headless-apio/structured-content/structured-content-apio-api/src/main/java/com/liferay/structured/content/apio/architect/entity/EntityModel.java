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

package com.liferay.structured.content.apio.architect.entity;

import java.util.Map;

/**
 * Models an entity.
 *
 * @author     Cristina González
 * @deprecated As of Judson (7.1.x), replaced by {@code
 *             com.liferay.portal.odata.entity.EntityModel}
 */
@Deprecated
public interface EntityModel {

	/**
	 * Returns a map with all the entity fields used to create the EDM.
	 *
	 * @return the entity field map
	 */
	public Map<String, EntityField> getEntityFieldsMap();

	/**
	 * Returns the name of the single entity type used to create the EDM.
	 *
	 * @return the entity type name
	 */
	public String getName();

}