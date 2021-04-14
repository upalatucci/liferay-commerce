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

import com.liferay.app.builder.it.model.AppBuilderModuleEntry;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppBuilderModuleEntry in entity cache.
 *
 * @author Marco Leo
 * @generated
 */
public class AppBuilderModuleEntryCacheModel
	implements CacheModel<AppBuilderModuleEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppBuilderModuleEntryCacheModel)) {
			return false;
		}

		AppBuilderModuleEntryCacheModel appBuilderModuleEntryCacheModel =
			(AppBuilderModuleEntryCacheModel)object;

		if (appBuilderModuleEntryId ==
				appBuilderModuleEntryCacheModel.appBuilderModuleEntryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appBuilderModuleEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", appBuilderModuleEntryId=");
		sb.append(appBuilderModuleEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppBuilderModuleEntry toEntityModel() {
		AppBuilderModuleEntryImpl appBuilderModuleEntryImpl =
			new AppBuilderModuleEntryImpl();

		if (uuid == null) {
			appBuilderModuleEntryImpl.setUuid("");
		}
		else {
			appBuilderModuleEntryImpl.setUuid(uuid);
		}

		appBuilderModuleEntryImpl.setAppBuilderModuleEntryId(
			appBuilderModuleEntryId);
		appBuilderModuleEntryImpl.setGroupId(groupId);
		appBuilderModuleEntryImpl.setCompanyId(companyId);
		appBuilderModuleEntryImpl.setUserId(userId);

		if (userName == null) {
			appBuilderModuleEntryImpl.setUserName("");
		}
		else {
			appBuilderModuleEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			appBuilderModuleEntryImpl.setCreateDate(null);
		}
		else {
			appBuilderModuleEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appBuilderModuleEntryImpl.setModifiedDate(null);
		}
		else {
			appBuilderModuleEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		appBuilderModuleEntryImpl.setAppBuilderModuleId(appBuilderModuleId);

		if (lastPublishDate == Long.MIN_VALUE) {
			appBuilderModuleEntryImpl.setLastPublishDate(null);
		}
		else {
			appBuilderModuleEntryImpl.setLastPublishDate(
				new Date(lastPublishDate));
		}

		appBuilderModuleEntryImpl.setStatus(status);
		appBuilderModuleEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			appBuilderModuleEntryImpl.setStatusByUserName("");
		}
		else {
			appBuilderModuleEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			appBuilderModuleEntryImpl.setStatusDate(null);
		}
		else {
			appBuilderModuleEntryImpl.setStatusDate(new Date(statusDate));
		}

		appBuilderModuleEntryImpl.resetOriginalValues();

		return appBuilderModuleEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		appBuilderModuleEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		appBuilderModuleId = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(appBuilderModuleEntryId);

		objectOutput.writeLong(groupId);

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
		objectOutput.writeLong(lastPublishDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long appBuilderModuleEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long appBuilderModuleId;
	public long lastPublishDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}