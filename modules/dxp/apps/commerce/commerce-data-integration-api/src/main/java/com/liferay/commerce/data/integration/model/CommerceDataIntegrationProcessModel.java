/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.commerce.data.integration.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommerceDataIntegrationProcess service. Represents a row in the &quot;CDataIntegrationProcess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.data.integration.model.impl.CommerceDataIntegrationProcessModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.data.integration.model.impl.CommerceDataIntegrationProcessImpl</code>.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceDataIntegrationProcess
 * @generated
 */
@ProviderType
public interface CommerceDataIntegrationProcessModel
	extends AuditedModel, BaseModel<CommerceDataIntegrationProcess>,
			ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce data integration process model instance should use the {@link CommerceDataIntegrationProcess} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce data integration process.
	 *
	 * @return the primary key of this commerce data integration process
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce data integration process.
	 *
	 * @param primaryKey the primary key of this commerce data integration process
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce data integration process ID of this commerce data integration process.
	 *
	 * @return the commerce data integration process ID of this commerce data integration process
	 */
	public long getCommerceDataIntegrationProcessId();

	/**
	 * Sets the commerce data integration process ID of this commerce data integration process.
	 *
	 * @param commerceDataIntegrationProcessId the commerce data integration process ID of this commerce data integration process
	 */
	public void setCommerceDataIntegrationProcessId(
		long commerceDataIntegrationProcessId);

	/**
	 * Returns the company ID of this commerce data integration process.
	 *
	 * @return the company ID of this commerce data integration process
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce data integration process.
	 *
	 * @param companyId the company ID of this commerce data integration process
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce data integration process.
	 *
	 * @return the user ID of this commerce data integration process
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce data integration process.
	 *
	 * @param userId the user ID of this commerce data integration process
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce data integration process.
	 *
	 * @return the user uuid of this commerce data integration process
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce data integration process.
	 *
	 * @param userUuid the user uuid of this commerce data integration process
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce data integration process.
	 *
	 * @return the user name of this commerce data integration process
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce data integration process.
	 *
	 * @param userName the user name of this commerce data integration process
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce data integration process.
	 *
	 * @return the create date of this commerce data integration process
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce data integration process.
	 *
	 * @param createDate the create date of this commerce data integration process
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce data integration process.
	 *
	 * @return the modified date of this commerce data integration process
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce data integration process.
	 *
	 * @param modifiedDate the modified date of this commerce data integration process
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this commerce data integration process.
	 *
	 * @return the name of this commerce data integration process
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this commerce data integration process.
	 *
	 * @param name the name of this commerce data integration process
	 */
	public void setName(String name);

	/**
	 * Returns the type of this commerce data integration process.
	 *
	 * @return the type of this commerce data integration process
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this commerce data integration process.
	 *
	 * @param type the type of this commerce data integration process
	 */
	public void setType(String type);

	/**
	 * Returns the type settings of this commerce data integration process.
	 *
	 * @return the type settings of this commerce data integration process
	 */
	@AutoEscape
	public String getTypeSettings();

	/**
	 * Sets the type settings of this commerce data integration process.
	 *
	 * @param typeSettings the type settings of this commerce data integration process
	 */
	public void setTypeSettings(String typeSettings);

	/**
	 * Returns the system of this commerce data integration process.
	 *
	 * @return the system of this commerce data integration process
	 */
	public boolean getSystem();

	/**
	 * Returns <code>true</code> if this commerce data integration process is system.
	 *
	 * @return <code>true</code> if this commerce data integration process is system; <code>false</code> otherwise
	 */
	public boolean isSystem();

	/**
	 * Sets whether this commerce data integration process is system.
	 *
	 * @param system the system of this commerce data integration process
	 */
	public void setSystem(boolean system);

	/**
	 * Returns the active of this commerce data integration process.
	 *
	 * @return the active of this commerce data integration process
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this commerce data integration process is active.
	 *
	 * @return <code>true</code> if this commerce data integration process is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this commerce data integration process is active.
	 *
	 * @param active the active of this commerce data integration process
	 */
	public void setActive(boolean active);

	/**
	 * Returns the cron expression of this commerce data integration process.
	 *
	 * @return the cron expression of this commerce data integration process
	 */
	@AutoEscape
	public String getCronExpression();

	/**
	 * Sets the cron expression of this commerce data integration process.
	 *
	 * @param cronExpression the cron expression of this commerce data integration process
	 */
	public void setCronExpression(String cronExpression);

	/**
	 * Returns the start date of this commerce data integration process.
	 *
	 * @return the start date of this commerce data integration process
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this commerce data integration process.
	 *
	 * @param startDate the start date of this commerce data integration process
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this commerce data integration process.
	 *
	 * @return the end date of this commerce data integration process
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this commerce data integration process.
	 *
	 * @param endDate the end date of this commerce data integration process
	 */
	public void setEndDate(Date endDate);

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
	public int compareTo(
		CommerceDataIntegrationProcess commerceDataIntegrationProcess);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceDataIntegrationProcess> toCacheModel();

	@Override
	public CommerceDataIntegrationProcess toEscapedModel();

	@Override
	public CommerceDataIntegrationProcess toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}