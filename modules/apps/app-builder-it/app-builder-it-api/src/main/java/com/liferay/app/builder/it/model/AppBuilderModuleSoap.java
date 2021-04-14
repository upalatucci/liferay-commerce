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
 * This class is used by SOAP remote services, specifically {@link com.liferay.app.builder.it.service.http.AppBuilderModuleServiceSoap}.
 *
 * @author Marco Leo
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AppBuilderModuleSoap implements Serializable {

	public static AppBuilderModuleSoap toSoapModel(AppBuilderModule model) {
		AppBuilderModuleSoap soapModel = new AppBuilderModuleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAppBuilderModuleId(model.getAppBuilderModuleId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.isActive());
		soapModel.setName(model.getName());
		soapModel.setLabel(model.getLabel());
		soapModel.setDbTableName(model.getDbTableName());
		soapModel.setDbTablePKColumnName(model.getDbTablePKColumnName());
		soapModel.setScope(model.getScope());
		soapModel.setResourceName(model.getResourceName());
		soapModel.setAsset(model.isAsset());
		soapModel.setResource(model.isResource());
		soapModel.setExpando(model.isExpando());

		return soapModel;
	}

	public static AppBuilderModuleSoap[] toSoapModels(
		AppBuilderModule[] models) {

		AppBuilderModuleSoap[] soapModels =
			new AppBuilderModuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppBuilderModuleSoap[][] toSoapModels(
		AppBuilderModule[][] models) {

		AppBuilderModuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AppBuilderModuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppBuilderModuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppBuilderModuleSoap[] toSoapModels(
		List<AppBuilderModule> models) {

		List<AppBuilderModuleSoap> soapModels =
			new ArrayList<AppBuilderModuleSoap>(models.size());

		for (AppBuilderModule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppBuilderModuleSoap[soapModels.size()]);
	}

	public AppBuilderModuleSoap() {
	}

	public long getPrimaryKey() {
		return _appBuilderModuleId;
	}

	public void setPrimaryKey(long pk) {
		setAppBuilderModuleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAppBuilderModuleId() {
		return _appBuilderModuleId;
	}

	public void setAppBuilderModuleId(long appBuilderModuleId) {
		_appBuilderModuleId = appBuilderModuleId;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
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

	public String getDbTableName() {
		return _dbTableName;
	}

	public void setDbTableName(String dbTableName) {
		_dbTableName = dbTableName;
	}

	public String getDbTablePKColumnName() {
		return _dbTablePKColumnName;
	}

	public void setDbTablePKColumnName(String dbTablePKColumnName) {
		_dbTablePKColumnName = dbTablePKColumnName;
	}

	public String getScope() {
		return _scope;
	}

	public void setScope(String scope) {
		_scope = scope;
	}

	public String getResourceName() {
		return _resourceName;
	}

	public void setResourceName(String resourceName) {
		_resourceName = resourceName;
	}

	public boolean getAsset() {
		return _asset;
	}

	public boolean isAsset() {
		return _asset;
	}

	public void setAsset(boolean asset) {
		_asset = asset;
	}

	public boolean getResource() {
		return _resource;
	}

	public boolean isResource() {
		return _resource;
	}

	public void setResource(boolean resource) {
		_resource = resource;
	}

	public boolean getExpando() {
		return _expando;
	}

	public boolean isExpando() {
		return _expando;
	}

	public void setExpando(boolean expando) {
		_expando = expando;
	}

	private String _uuid;
	private long _appBuilderModuleId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private String _name;
	private String _label;
	private String _dbTableName;
	private String _dbTablePKColumnName;
	private String _scope;
	private String _resourceName;
	private boolean _asset;
	private boolean _resource;
	private boolean _expando;

}