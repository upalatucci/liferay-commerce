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

package com.liferay.commerce.product.model.impl;

import com.liferay.commerce.product.model.CPDisplayLayout;
import com.liferay.commerce.product.model.CPDisplayLayoutModel;
import com.liferay.commerce.product.model.CPDisplayLayoutSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CPDisplayLayout service. Represents a row in the &quot;CPDisplayLayout&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CPDisplayLayoutModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDisplayLayoutImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDisplayLayoutImpl
 * @generated
 */
@JSON(strict = true)
public class CPDisplayLayoutModelImpl
	extends BaseModelImpl<CPDisplayLayout> implements CPDisplayLayoutModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp display layout model instance should use the <code>CPDisplayLayout</code> interface instead.
	 */
	public static final String TABLE_NAME = "CPDisplayLayout";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"CPDisplayLayoutId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"classNameId", Types.BIGINT}, {"classPK", Types.BIGINT},
		{"layoutUuid", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPDisplayLayoutId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("layoutUuid", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CPDisplayLayout (uuid_ VARCHAR(75) null,CPDisplayLayoutId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,layoutUuid VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table CPDisplayLayout";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cpDisplayLayout.CPDisplayLayoutId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CPDisplayLayout.CPDisplayLayoutId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long LAYOUTUUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CPDISPLAYLAYOUTID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CPDisplayLayout toModel(CPDisplayLayoutSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CPDisplayLayout model = new CPDisplayLayoutImpl();

		model.setUuid(soapModel.getUuid());
		model.setCPDisplayLayoutId(soapModel.getCPDisplayLayoutId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setLayoutUuid(soapModel.getLayoutUuid());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<CPDisplayLayout> toModels(
		CPDisplayLayoutSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CPDisplayLayout> models = new ArrayList<CPDisplayLayout>(
			soapModels.length);

		for (CPDisplayLayoutSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.product.model.CPDisplayLayout"));

	public CPDisplayLayoutModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPDisplayLayoutId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPDisplayLayoutId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPDisplayLayoutId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDisplayLayout.class;
	}

	@Override
	public String getModelClassName() {
		return CPDisplayLayout.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CPDisplayLayout, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CPDisplayLayout, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDisplayLayout, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CPDisplayLayout)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CPDisplayLayout, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CPDisplayLayout, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CPDisplayLayout)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CPDisplayLayout, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CPDisplayLayout, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CPDisplayLayout>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CPDisplayLayout.class.getClassLoader(), CPDisplayLayout.class,
			ModelWrapper.class);

		try {
			Constructor<CPDisplayLayout> constructor =
				(Constructor<CPDisplayLayout>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CPDisplayLayout, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CPDisplayLayout, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CPDisplayLayout, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CPDisplayLayout, Object>>();
		Map<String, BiConsumer<CPDisplayLayout, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CPDisplayLayout, ?>>();

		attributeGetterFunctions.put("uuid", CPDisplayLayout::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CPDisplayLayout, String>)CPDisplayLayout::setUuid);
		attributeGetterFunctions.put(
			"CPDisplayLayoutId", CPDisplayLayout::getCPDisplayLayoutId);
		attributeSetterBiConsumers.put(
			"CPDisplayLayoutId",
			(BiConsumer<CPDisplayLayout, Long>)
				CPDisplayLayout::setCPDisplayLayoutId);
		attributeGetterFunctions.put("groupId", CPDisplayLayout::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CPDisplayLayout, Long>)CPDisplayLayout::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CPDisplayLayout::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CPDisplayLayout, Long>)CPDisplayLayout::setCompanyId);
		attributeGetterFunctions.put("userId", CPDisplayLayout::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CPDisplayLayout, Long>)CPDisplayLayout::setUserId);
		attributeGetterFunctions.put("userName", CPDisplayLayout::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CPDisplayLayout, String>)CPDisplayLayout::setUserName);
		attributeGetterFunctions.put(
			"createDate", CPDisplayLayout::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CPDisplayLayout, Date>)CPDisplayLayout::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CPDisplayLayout::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CPDisplayLayout, Date>)
				CPDisplayLayout::setModifiedDate);
		attributeGetterFunctions.put(
			"classNameId", CPDisplayLayout::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<CPDisplayLayout, Long>)CPDisplayLayout::setClassNameId);
		attributeGetterFunctions.put("classPK", CPDisplayLayout::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<CPDisplayLayout, Long>)CPDisplayLayout::setClassPK);
		attributeGetterFunctions.put(
			"layoutUuid", CPDisplayLayout::getLayoutUuid);
		attributeSetterBiConsumers.put(
			"layoutUuid",
			(BiConsumer<CPDisplayLayout, String>)
				CPDisplayLayout::setLayoutUuid);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getCPDisplayLayoutId() {
		return _CPDisplayLayoutId;
	}

	@Override
	public void setCPDisplayLayoutId(long CPDisplayLayoutId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_CPDisplayLayoutId = CPDisplayLayoutId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classNameId = classNameId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassNameId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("classNameId"));
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classPK = classPK;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassPK() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("classPK"));
	}

	@JSON
	@Override
	public String getLayoutUuid() {
		if (_layoutUuid == null) {
			return "";
		}
		else {
			return _layoutUuid;
		}
	}

	@Override
	public void setLayoutUuid(String layoutUuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_layoutUuid = layoutUuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLayoutUuid() {
		return getColumnOriginalValue("layoutUuid");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CPDisplayLayout.class.getName()),
			getClassNameId());
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CPDisplayLayout.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPDisplayLayout toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CPDisplayLayout>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CPDisplayLayoutImpl cpDisplayLayoutImpl = new CPDisplayLayoutImpl();

		cpDisplayLayoutImpl.setUuid(getUuid());
		cpDisplayLayoutImpl.setCPDisplayLayoutId(getCPDisplayLayoutId());
		cpDisplayLayoutImpl.setGroupId(getGroupId());
		cpDisplayLayoutImpl.setCompanyId(getCompanyId());
		cpDisplayLayoutImpl.setUserId(getUserId());
		cpDisplayLayoutImpl.setUserName(getUserName());
		cpDisplayLayoutImpl.setCreateDate(getCreateDate());
		cpDisplayLayoutImpl.setModifiedDate(getModifiedDate());
		cpDisplayLayoutImpl.setClassNameId(getClassNameId());
		cpDisplayLayoutImpl.setClassPK(getClassPK());
		cpDisplayLayoutImpl.setLayoutUuid(getLayoutUuid());

		cpDisplayLayoutImpl.resetOriginalValues();

		return cpDisplayLayoutImpl;
	}

	@Override
	public int compareTo(CPDisplayLayout cpDisplayLayout) {
		long primaryKey = cpDisplayLayout.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CPDisplayLayout)) {
			return false;
		}

		CPDisplayLayout cpDisplayLayout = (CPDisplayLayout)object;

		long primaryKey = cpDisplayLayout.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDisplayLayout> toCacheModel() {
		CPDisplayLayoutCacheModel cpDisplayLayoutCacheModel =
			new CPDisplayLayoutCacheModel();

		cpDisplayLayoutCacheModel.uuid = getUuid();

		String uuid = cpDisplayLayoutCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpDisplayLayoutCacheModel.uuid = null;
		}

		cpDisplayLayoutCacheModel.CPDisplayLayoutId = getCPDisplayLayoutId();

		cpDisplayLayoutCacheModel.groupId = getGroupId();

		cpDisplayLayoutCacheModel.companyId = getCompanyId();

		cpDisplayLayoutCacheModel.userId = getUserId();

		cpDisplayLayoutCacheModel.userName = getUserName();

		String userName = cpDisplayLayoutCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpDisplayLayoutCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpDisplayLayoutCacheModel.createDate = createDate.getTime();
		}
		else {
			cpDisplayLayoutCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpDisplayLayoutCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cpDisplayLayoutCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpDisplayLayoutCacheModel.classNameId = getClassNameId();

		cpDisplayLayoutCacheModel.classPK = getClassPK();

		cpDisplayLayoutCacheModel.layoutUuid = getLayoutUuid();

		String layoutUuid = cpDisplayLayoutCacheModel.layoutUuid;

		if ((layoutUuid != null) && (layoutUuid.length() == 0)) {
			cpDisplayLayoutCacheModel.layoutUuid = null;
		}

		return cpDisplayLayoutCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CPDisplayLayout, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CPDisplayLayout, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDisplayLayout, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CPDisplayLayout)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CPDisplayLayout, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CPDisplayLayout, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDisplayLayout, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CPDisplayLayout)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CPDisplayLayout>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _CPDisplayLayoutId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _classPK;
	private String _layoutUuid;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CPDisplayLayout, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CPDisplayLayout)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("CPDisplayLayoutId", _CPDisplayLayoutId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("classNameId", _classNameId);
		_columnOriginalValues.put("classPK", _classPK);
		_columnOriginalValues.put("layoutUuid", _layoutUuid);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("CPDisplayLayoutId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("classNameId", 256L);

		columnBitmasks.put("classPK", 512L);

		columnBitmasks.put("layoutUuid", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CPDisplayLayout _escapedModel;

}