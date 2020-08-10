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

package com.liferay.commerce.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommerceRegion service. Represents a row in the &quot;CommerceRegion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.model.impl.CommerceRegionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.model.impl.CommerceRegionImpl</code>.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceRegion
 * @generated
 */
@ProviderType
public interface CommerceRegionModel
	extends BaseModel<CommerceRegion>, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce region model instance should use the {@link CommerceRegion} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce region.
	 *
	 * @return the primary key of this commerce region
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce region.
	 *
	 * @param primaryKey the primary key of this commerce region
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this commerce region.
	 *
	 * @return the uuid of this commerce region
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this commerce region.
	 *
	 * @param uuid the uuid of this commerce region
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the commerce region ID of this commerce region.
	 *
	 * @return the commerce region ID of this commerce region
	 */
	public long getCommerceRegionId();

	/**
	 * Sets the commerce region ID of this commerce region.
	 *
	 * @param commerceRegionId the commerce region ID of this commerce region
	 */
	public void setCommerceRegionId(long commerceRegionId);

	/**
	 * Returns the company ID of this commerce region.
	 *
	 * @return the company ID of this commerce region
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce region.
	 *
	 * @param companyId the company ID of this commerce region
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce region.
	 *
	 * @return the user ID of this commerce region
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce region.
	 *
	 * @param userId the user ID of this commerce region
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce region.
	 *
	 * @return the user uuid of this commerce region
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce region.
	 *
	 * @param userUuid the user uuid of this commerce region
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce region.
	 *
	 * @return the user name of this commerce region
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce region.
	 *
	 * @param userName the user name of this commerce region
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce region.
	 *
	 * @return the create date of this commerce region
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce region.
	 *
	 * @param createDate the create date of this commerce region
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce region.
	 *
	 * @return the modified date of this commerce region
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce region.
	 *
	 * @param modifiedDate the modified date of this commerce region
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce country ID of this commerce region.
	 *
	 * @return the commerce country ID of this commerce region
	 */
	public long getCommerceCountryId();

	/**
	 * Sets the commerce country ID of this commerce region.
	 *
	 * @param commerceCountryId the commerce country ID of this commerce region
	 */
	public void setCommerceCountryId(long commerceCountryId);

	/**
	 * Returns the name of this commerce region.
	 *
	 * @return the name of this commerce region
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this commerce region.
	 *
	 * @param name the name of this commerce region
	 */
	public void setName(String name);

	/**
	 * Returns the code of this commerce region.
	 *
	 * @return the code of this commerce region
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this commerce region.
	 *
	 * @param code the code of this commerce region
	 */
	public void setCode(String code);

	/**
	 * Returns the priority of this commerce region.
	 *
	 * @return the priority of this commerce region
	 */
	public double getPriority();

	/**
	 * Sets the priority of this commerce region.
	 *
	 * @param priority the priority of this commerce region
	 */
	public void setPriority(double priority);

	/**
	 * Returns the active of this commerce region.
	 *
	 * @return the active of this commerce region
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this commerce region is active.
	 *
	 * @return <code>true</code> if this commerce region is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this commerce region is active.
	 *
	 * @param active the active of this commerce region
	 */
	public void setActive(boolean active);

	/**
	 * Returns the last publish date of this commerce region.
	 *
	 * @return the last publish date of this commerce region
	 */
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this commerce region.
	 *
	 * @param lastPublishDate the last publish date of this commerce region
	 */
	public void setLastPublishDate(Date lastPublishDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CommerceRegion commerceRegion);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceRegion> toCacheModel();

	@Override
	public CommerceRegion toEscapedModel();

	@Override
	public CommerceRegion toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}