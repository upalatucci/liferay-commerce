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
 * This class is used by SOAP remote services, specifically {@link com.liferay.app.builder.it.service.http.AppBuilderModuleFieldServiceSoap}.
 *
 * @author Marco Leo
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AppBuilderModuleFieldSoap implements Serializable {

	public static AppBuilderModuleFieldSoap toSoapModel(
		AppBuilderModuleField model) {

		AppBuilderModuleFieldSoap soapModel = new AppBuilderModuleFieldSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAppBuilderModuleFieldId(
			model.getAppBuilderModuleFieldId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAppBuilderModuleId(model.getAppBuilderModuleId());
		soapModel.setName(model.getName());
		soapModel.setLabel(model.getLabel());
		soapModel.setDbColumnName(model.getDbColumnName());
		soapModel.setType(model.getType());
		soapModel.setTypeSettings(model.getTypeSettings());
		soapModel.setNullable(model.isNullable());

		return soapModel;
	}

	public static AppBuilderModuleFieldSoap[] toSoapModels(
		AppBuilderModuleField[] models) {

		AppBuilderModuleFieldSoap[] soapModels =
			new AppBuilderModuleFieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppBuilderModuleFieldSoap[][] toSoapModels(
		AppBuilderModuleField[][] models) {

		AppBuilderModuleFieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AppBuilderModuleFieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppBuilderModuleFieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppBuilderModuleFieldSoap[] toSoapModels(
		List<AppBuilderModuleField> models) {

		List<AppBuilderModuleFieldSoap> soapModels =
			new ArrayList<AppBuilderModuleFieldSoap>(models.size());

		for (AppBuilderModuleField model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AppBuilderModuleFieldSoap[soapModels.size()]);
	}

	public AppBuilderModuleFieldSoap() {
	}

	public long getPrimaryKey() {
		return _appBuilderModuleFieldId;
	}

	public void setPrimaryKey(long pk) {
		setAppBuilderModuleFieldId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAppBuilderModuleFieldId() {
		return _appBuilderModuleFieldId;
	}

	public void setAppBuilderModuleFieldId(long appBuilderModuleFieldId) {
		_appBuilderModuleFieldId = appBuilderModuleFieldId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public String getDbColumnName() {
		return _dbColumnName;
	}

	public void setDbColumnName(String dbColumnName) {
		_dbColumnName = dbColumnName;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	public boolean getNullable() {
		return _nullable;
	}

	public boolean isNullable() {
		return _nullable;
	}

	public void setNullable(boolean nullable) {
		_nullable = nullable;
	}

	private String _uuid;
	private long _appBuilderModuleFieldId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _appBuilderModuleId;
	private String _name;
	private String _label;
	private String _dbColumnName;
	private String _type;
	private String _typeSettings;
	private boolean _nullable;

}