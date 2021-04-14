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

package com.liferay.app.builder.it.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AppBuilderModuleEntry}.
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModuleEntry
 * @generated
 */
public class AppBuilderModuleEntryWrapper
	extends BaseModelWrapper<AppBuilderModuleEntry>
	implements AppBuilderModuleEntry, ModelWrapper<AppBuilderModuleEntry> {

	public AppBuilderModuleEntryWrapper(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		super(appBuilderModuleEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("appBuilderModuleEntryId", getAppBuilderModuleEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("appBuilderModuleId", getAppBuilderModuleId());
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long appBuilderModuleEntryId = (Long)attributes.get(
			"appBuilderModuleEntryId");

		if (appBuilderModuleEntryId != null) {
			setAppBuilderModuleEntryId(appBuilderModuleEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long appBuilderModuleId = (Long)attributes.get("appBuilderModuleId");

		if (appBuilderModuleId != null) {
			setAppBuilderModuleId(appBuilderModuleId);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the app builder module entry ID of this app builder module entry.
	 *
	 * @return the app builder module entry ID of this app builder module entry
	 */
	@Override
	public long getAppBuilderModuleEntryId() {
		return model.getAppBuilderModuleEntryId();
	}

	/**
	 * Returns the app builder module ID of this app builder module entry.
	 *
	 * @return the app builder module ID of this app builder module entry
	 */
	@Override
	public long getAppBuilderModuleId() {
		return model.getAppBuilderModuleId();
	}

	/**
	 * Returns the company ID of this app builder module entry.
	 *
	 * @return the company ID of this app builder module entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this app builder module entry.
	 *
	 * @return the create date of this app builder module entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this app builder module entry.
	 *
	 * @return the group ID of this app builder module entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last publish date of this app builder module entry.
	 *
	 * @return the last publish date of this app builder module entry
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the modified date of this app builder module entry.
	 *
	 * @return the modified date of this app builder module entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this app builder module entry.
	 *
	 * @return the primary key of this app builder module entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this app builder module entry.
	 *
	 * @return the status of this app builder module entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this app builder module entry.
	 *
	 * @return the status by user ID of this app builder module entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this app builder module entry.
	 *
	 * @return the status by user name of this app builder module entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this app builder module entry.
	 *
	 * @return the status by user uuid of this app builder module entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this app builder module entry.
	 *
	 * @return the status date of this app builder module entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this app builder module entry.
	 *
	 * @return the user ID of this app builder module entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this app builder module entry.
	 *
	 * @return the user name of this app builder module entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this app builder module entry.
	 *
	 * @return the user uuid of this app builder module entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this app builder module entry.
	 *
	 * @return the uuid of this app builder module entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this app builder module entry is approved.
	 *
	 * @return <code>true</code> if this app builder module entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this app builder module entry is denied.
	 *
	 * @return <code>true</code> if this app builder module entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this app builder module entry is a draft.
	 *
	 * @return <code>true</code> if this app builder module entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this app builder module entry is expired.
	 *
	 * @return <code>true</code> if this app builder module entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this app builder module entry is inactive.
	 *
	 * @return <code>true</code> if this app builder module entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this app builder module entry is incomplete.
	 *
	 * @return <code>true</code> if this app builder module entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this app builder module entry is pending.
	 *
	 * @return <code>true</code> if this app builder module entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this app builder module entry is scheduled.
	 *
	 * @return <code>true</code> if this app builder module entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the app builder module entry ID of this app builder module entry.
	 *
	 * @param appBuilderModuleEntryId the app builder module entry ID of this app builder module entry
	 */
	@Override
	public void setAppBuilderModuleEntryId(long appBuilderModuleEntryId) {
		model.setAppBuilderModuleEntryId(appBuilderModuleEntryId);
	}

	/**
	 * Sets the app builder module ID of this app builder module entry.
	 *
	 * @param appBuilderModuleId the app builder module ID of this app builder module entry
	 */
	@Override
	public void setAppBuilderModuleId(long appBuilderModuleId) {
		model.setAppBuilderModuleId(appBuilderModuleId);
	}

	/**
	 * Sets the company ID of this app builder module entry.
	 *
	 * @param companyId the company ID of this app builder module entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this app builder module entry.
	 *
	 * @param createDate the create date of this app builder module entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this app builder module entry.
	 *
	 * @param groupId the group ID of this app builder module entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last publish date of this app builder module entry.
	 *
	 * @param lastPublishDate the last publish date of this app builder module entry
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this app builder module entry.
	 *
	 * @param modifiedDate the modified date of this app builder module entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this app builder module entry.
	 *
	 * @param primaryKey the primary key of this app builder module entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this app builder module entry.
	 *
	 * @param status the status of this app builder module entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this app builder module entry.
	 *
	 * @param statusByUserId the status by user ID of this app builder module entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this app builder module entry.
	 *
	 * @param statusByUserName the status by user name of this app builder module entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this app builder module entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this app builder module entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this app builder module entry.
	 *
	 * @param statusDate the status date of this app builder module entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this app builder module entry.
	 *
	 * @param userId the user ID of this app builder module entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this app builder module entry.
	 *
	 * @param userName the user name of this app builder module entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this app builder module entry.
	 *
	 * @param userUuid the user uuid of this app builder module entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this app builder module entry.
	 *
	 * @param uuid the uuid of this app builder module entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AppBuilderModuleEntryWrapper wrap(
		AppBuilderModuleEntry appBuilderModuleEntry) {

		return new AppBuilderModuleEntryWrapper(appBuilderModuleEntry);
	}

}