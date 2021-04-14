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

import com.liferay.app.builder.it.model.AppBuilderModuleField;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppBuilderModuleField in entity cache.
 *
 * @author Marco Leo
 * @generated
 */
public class AppBuilderModuleFieldCacheModel
	implements CacheModel<AppBuilderModuleField>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppBuilderModuleFieldCacheModel)) {
			return false;
		}

		AppBuilderModuleFieldCacheModel appBuilderModuleFieldCacheModel =
			(AppBuilderModuleFieldCacheModel)object;

		if (appBuilderModuleFieldId ==
				appBuilderModuleFieldCacheModel.appBuilderModuleFieldId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appBuilderModuleFieldId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", appBuilderModuleFieldId=");
		sb.append(appBuilderModuleFieldId);
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
		sb.append(", appBuilderModuleId=");
		sb.append(appBuilderModuleId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", label=");
		sb.append(label);
		sb.append(", dbColumnName=");
		sb.append(dbColumnName);
		sb.append(", type=");
		sb.append(type);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append(", nullable=");
		sb.append(nullable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppBuilderModuleField toEntityModel() {
		AppBuilderModuleFieldImpl appBuilderModuleFieldImpl =
			new AppBuilderModuleFieldImpl();

		if (uuid == null) {
			appBuilderModuleFieldImpl.setUuid("");
		}
		else {
			appBuilderModuleFieldImpl.setUuid(uuid);
		}

		appBuilderModuleFieldImpl.setAppBuilderModuleFieldId(
			appBuilderModuleFieldId);
		appBuilderModuleFieldImpl.setCompanyId(companyId);
		appBuilderModuleFieldImpl.setUserId(userId);

		if (userName == null) {
			appBuilderModuleFieldImpl.setUserName("");
		}
		else {
			appBuilderModuleFieldImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			appBuilderModuleFieldImpl.setCreateDate(null);
		}
		else {
			appBuilderModuleFieldImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appBuilderModuleFieldImpl.setModifiedDate(null);
		}
		else {
			appBuilderModuleFieldImpl.setModifiedDate(new Date(modifiedDate));
		}

		appBuilderModuleFieldImpl.setAppBuilderModuleId(appBuilderModuleId);

		if (name == null) {
			appBuilderModuleFieldImpl.setName("");
		}
		else {
			appBuilderModuleFieldImpl.setName(name);
		}

		if (label == null) {
			appBuilderModuleFieldImpl.setLabel("");
		}
		else {
			appBuilderModuleFieldImpl.setLabel(label);
		}

		if (dbColumnName == null) {
			appBuilderModuleFieldImpl.setDbColumnName("");
		}
		else {
			appBuilderModuleFieldImpl.setDbColumnName(dbColumnName);
		}

		if (type == null) {
			appBuilderModuleFieldImpl.setType("");
		}
		else {
			appBuilderModuleFieldImpl.setType(type);
		}

		if (typeSettings == null) {
			appBuilderModuleFieldImpl.setTypeSettings("");
		}
		else {
			appBuilderModuleFieldImpl.setTypeSettings(typeSettings);
		}

		appBuilderModuleFieldImpl.setNullable(nullable);

		appBuilderModuleFieldImpl.resetOriginalValues();

		return appBuilderModuleFieldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		appBuilderModuleFieldId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		appBuilderModuleId = objectInput.readLong();
		name = objectInput.readUTF();
		label = objectInput.readUTF();
		dbColumnName = objectInput.readUTF();
		type = objectInput.readUTF();
		typeSettings = objectInput.readUTF();

		nullable = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(appBuilderModuleFieldId);

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

		objectOutput.writeLong(appBuilderModuleId);

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

		if (dbColumnName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dbColumnName);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (typeSettings == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}

		objectOutput.writeBoolean(nullable);
	}

	public String uuid;
	public long appBuilderModuleFieldId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long appBuilderModuleId;
	public String name;
	public String label;
	public String dbColumnName;
	public String type;
	public String typeSettings;
	public boolean nullable;

}