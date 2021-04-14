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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.app.builder.it.service.http.AppBuilderModuleEntryServiceSoap}.
 *
 * @author Marco Leo
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AppBuilderModuleEntrySoap implements Serializable {

	public static AppBuilderModuleEntrySoap toSoapModel(
		AppBuilderModuleEntry model) {

		AppBuilderModuleEntrySoap soapModel = new AppBuilderModuleEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAppBuilderModuleEntryId(
			model.getAppBuilderModuleEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAppBuilderModuleId(model.getAppBuilderModuleId());
		soapModel.setLastPublishDate(model.getLastPublishDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static AppBuilderModuleEntrySoap[] toSoapModels(
		AppBuilderModuleEntry[] models) {

		AppBuilderModuleEntrySoap[] soapModels =
			new AppBuilderModuleEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppBuilderModuleEntrySoap[][] toSoapModels(
		AppBuilderModuleEntry[][] models) {

		AppBuilderModuleEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AppBuilderModuleEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppBuilderModuleEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppBuilderModuleEntrySoap[] toSoapModels(
		List<AppBuilderModuleEntry> models) {

		List<AppBuilderModuleEntrySoap> soapModels =
			new ArrayList<AppBuilderModuleEntrySoap>(models.size());

		for (AppBuilderModuleEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AppBuilderModuleEntrySoap[soapModels.size()]);
	}

	public AppBuilderModuleEntrySoap() {
	}

	public long getPrimaryKey() {
		return _appBuilderModuleEntryId;
	}

	public void setPrimaryKey(long pk) {
		setAppBuilderModuleEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAppBuilderModuleEntryId() {
		return _appBuilderModuleEntryId;
	}

	public void setAppBuilderModuleEntryId(long appBuilderModuleEntryId) {
		_appBuilderModuleEntryId = appBuilderModuleEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAppBuilderModuleId() {
		return _appBuilderModuleId;
	}

	public void setAppBuilderModuleId(long appBuilderModuleId) {
		_appBuilderModuleId = appBuilderModuleId;
	}

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private long _appBuilderModuleEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _appBuilderModuleId;
	private Date _lastPublishDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}