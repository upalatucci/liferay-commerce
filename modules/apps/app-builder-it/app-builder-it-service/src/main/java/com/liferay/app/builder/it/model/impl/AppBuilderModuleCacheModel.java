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

package com.liferay.app.builder.it.model.impl;

import com.liferay.app.builder.it.model.AppBuilderModule;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppBuilderModule in entity cache.
 *
 * @author Marco Leo
 * @generated
 */
public class AppBuilderModuleCacheModel
	implements CacheModel<AppBuilderModule>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppBuilderModuleCacheModel)) {
			return false;
		}

		AppBuilderModuleCacheModel appBuilderModuleCacheModel =
			(AppBuilderModuleCacheModel)object;

		if (appBuilderModuleId ==
				appBuilderModuleCacheModel.appBuilderModuleId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appBuilderModuleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", appBuilderModuleId=");
		sb.append(appBuilderModuleId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", active=");
		sb.append(active);
		sb.append(", name=");
		sb.append(name);
		sb.append(", label=");
		sb.append(label);
		sb.append(", dbTableName=");
		sb.append(dbTableName);
		sb.append(", dbTablePKColumnName=");
		sb.append(dbTablePKColumnName);
		sb.append(", scope=");
		sb.append(scope);
		sb.append(", resourceName=");
		sb.append(resourceName);
		sb.append(", asset=");
		sb.append(asset);
		sb.append(", resource=");
		sb.append(resource);
		sb.append(", expando=");
		sb.append(expando);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppBuilderModule toEntityModel() {
		AppBuilderModuleImpl appBuilderModuleImpl = new AppBuilderModuleImpl();

		if (uuid == null) {
			appBuilderModuleImpl.setUuid("");
		}
		else {
			appBuilderModuleImpl.setUuid(uuid);
		}

		appBuilderModuleImpl.setAppBuilderModuleId(appBuilderModuleId);
		appBuilderModuleImpl.setCompanyId(companyId);
		appBuilderModuleImpl.setUserId(userId);

		if (userName == null) {
			appBuilderModuleImpl.setUserName("");
		}
		else {
			appBuilderModuleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			appBuilderModuleImpl.setCreateDate(null);
		}
		else {
			appBuilderModuleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appBuilderModuleImpl.setModifiedDate(null);
		}
		else {
			appBuilderModuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		appBuilderModuleImpl.setActive(active);

		if (name == null) {
			appBuilderModuleImpl.setName("");
		}
		else {
			appBuilderModuleImpl.setName(name);
		}

		if (label == null) {
			appBuilderModuleImpl.setLabel("");
		}
		else {
			appBuilderModuleImpl.setLabel(label);
		}

		if (dbTableName == null) {
			appBuilderModuleImpl.setDbTableName("");
		}
		else {
			appBuilderModuleImpl.setDbTableName(dbTableName);
		}

		if (dbTablePKColumnName == null) {
			appBuilderModuleImpl.setDbTablePKColumnName("");
		}
		else {
			appBuilderModuleImpl.setDbTablePKColumnName(dbTablePKColumnName);
		}

		if (scope == null) {
			appBuilderModuleImpl.setScope("");
		}
		else {
			appBuilderModuleImpl.setScope(scope);
		}

		if (resourceName == null) {
			appBuilderModuleImpl.setResourceName("");
		}
		else {
			appBuilderModuleImpl.setResourceName(resourceName);
		}

		appBuilderModuleImpl.setAsset(asset);
		appBuilderModuleImpl.setResource(resource);
		appBuilderModuleImpl.setExpando(expando);

		appBuilderModuleImpl.resetOriginalValues();

		return appBuilderModuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		appBuilderModuleId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		name = objectInput.readUTF();
		label = objectInput.readUTF();
		dbTableName = objectInput.readUTF();
		dbTablePKColumnName = objectInput.readUTF();
		scope = objectInput.readUTF();
		resourceName = objectInput.readUTF();

		asset = objectInput.readBoolean();

		resource = objectInput.readBoolean();

		expando = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(appBuilderModuleId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(active);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (label == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(label);
		}

		if (dbTableName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dbTableName);
		}

		if (dbTablePKColumnName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dbTablePKColumnName);
		}

		if (scope == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scope);
		}

		if (resourceName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resourceName);
		}

		objectOutput.writeBoolean(asset);

		objectOutput.writeBoolean(resource);

		objectOutput.writeBoolean(expando);
	}

	public String uuid;
	public long appBuilderModuleId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String name;
	public String label;
	public String dbTableName;
	public String dbTablePKColumnName;
	public String scope;
	public String resourceName;
	public boolean asset;
	public boolean resource;
	public boolean expando;

}