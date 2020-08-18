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

import com.liferay.commerce.product.model.CPDefinitionOptionValueRel;
import com.liferay.commerce.product.model.CPDefinitionOptionValueRelModel;
import com.liferay.commerce.product.model.CPDefinitionOptionValueRelSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CPDefinitionOptionValueRel service. Represents a row in the &quot;CPDefinitionOptionValueRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CPDefinitionOptionValueRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDefinitionOptionValueRelImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDefinitionOptionValueRelImpl
 * @generated
 */
@JSON(strict = true)
public class CPDefinitionOptionValueRelModelImpl
	extends BaseModelImpl<CPDefinitionOptionValueRel>
	implements CPDefinitionOptionValueRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp definition option value rel model instance should use the <code>CPDefinitionOptionValueRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "CPDefinitionOptionValueRel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"CPDefinitionOptionValueRelId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"CPDefinitionOptionRelId", Types.BIGINT},
		{"CPInstanceUuid", Types.VARCHAR}, {"CProductId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"priority", Types.DOUBLE},
		{"key_", Types.VARCHAR}, {"quantity", Types.INTEGER},
		{"preselected", Types.BOOLEAN}, {"price", Types.DECIMAL}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPDefinitionOptionValueRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("CPDefinitionOptionRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CPInstanceUuid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("preselected", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("price", Types.DECIMAL);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CPDefinitionOptionValueRel (uuid_ VARCHAR(75) null,CPDefinitionOptionValueRelId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,CPDefinitionOptionRelId LONG,CPInstanceUuid VARCHAR(75) null,CProductId LONG,name STRING null,priority DOUBLE,key_ VARCHAR(75) null,quantity INTEGER,preselected BOOLEAN,price DECIMAL(30, 16) null)";

	public static final String TABLE_SQL_DROP =
		"drop table CPDefinitionOptionValueRel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cpDefinitionOptionValueRel.priority ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CPDefinitionOptionValueRel.priority ASC";

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

	public static final long CPDEFINITIONOPTIONRELID_COLUMN_BITMASK = 1L;

	public static final long CPINSTANCEUUID_COLUMN_BITMASK = 2L;

	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long KEY_COLUMN_BITMASK = 16L;

	public static final long PRESELECTED_COLUMN_BITMASK = 32L;

	public static final long UUID_COLUMN_BITMASK = 64L;

	public static final long PRIORITY_COLUMN_BITMASK = 128L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CPDefinitionOptionValueRel toModel(
		CPDefinitionOptionValueRelSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CPDefinitionOptionValueRel model = new CPDefinitionOptionValueRelImpl();

		model.setUuid(soapModel.getUuid());
		model.setCPDefinitionOptionValueRelId(
			soapModel.getCPDefinitionOptionValueRelId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCPDefinitionOptionRelId(
			soapModel.getCPDefinitionOptionRelId());
		model.setCPInstanceUuid(soapModel.getCPInstanceUuid());
		model.setCProductId(soapModel.getCProductId());
		model.setName(soapModel.getName());
		model.setPriority(soapModel.getPriority());
		model.setKey(soapModel.getKey());
		model.setQuantity(soapModel.getQuantity());
		model.setPreselected(soapModel.isPreselected());
		model.setPrice(soapModel.getPrice());

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
	public static List<CPDefinitionOptionValueRel> toModels(
		CPDefinitionOptionValueRelSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CPDefinitionOptionValueRel> models =
			new ArrayList<CPDefinitionOptionValueRel>(soapModels.length);

		for (CPDefinitionOptionValueRelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.product.model.CPDefinitionOptionValueRel"));

	public CPDefinitionOptionValueRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPDefinitionOptionValueRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPDefinitionOptionValueRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPDefinitionOptionValueRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDefinitionOptionValueRel.class;
	}

	@Override
	public String getModelClassName() {
		return CPDefinitionOptionValueRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CPDefinitionOptionValueRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CPDefinitionOptionValueRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionOptionValueRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CPDefinitionOptionValueRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CPDefinitionOptionValueRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CPDefinitionOptionValueRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CPDefinitionOptionValueRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CPDefinitionOptionValueRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CPDefinitionOptionValueRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CPDefinitionOptionValueRel>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CPDefinitionOptionValueRel.class.getClassLoader(),
			CPDefinitionOptionValueRel.class, ModelWrapper.class);

		try {
			Constructor<CPDefinitionOptionValueRel> constructor =
				(Constructor<CPDefinitionOptionValueRel>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String, Function<CPDefinitionOptionValueRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CPDefinitionOptionValueRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CPDefinitionOptionValueRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CPDefinitionOptionValueRel, Object>>();
		Map<String, BiConsumer<CPDefinitionOptionValueRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CPDefinitionOptionValueRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", CPDefinitionOptionValueRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CPDefinitionOptionValueRel, String>)
				CPDefinitionOptionValueRel::setUuid);
		attributeGetterFunctions.put(
			"CPDefinitionOptionValueRelId",
			CPDefinitionOptionValueRel::getCPDefinitionOptionValueRelId);
		attributeSetterBiConsumers.put(
			"CPDefinitionOptionValueRelId",
			(BiConsumer<CPDefinitionOptionValueRel, Long>)
				CPDefinitionOptionValueRel::setCPDefinitionOptionValueRelId);
		attributeGetterFunctions.put(
			"groupId", CPDefinitionOptionValueRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CPDefinitionOptionValueRel, Long>)
				CPDefinitionOptionValueRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CPDefinitionOptionValueRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CPDefinitionOptionValueRel, Long>)
				CPDefinitionOptionValueRel::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CPDefinitionOptionValueRel::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CPDefinitionOptionValueRel, Long>)
				CPDefinitionOptionValueRel::setUserId);
		attributeGetterFunctions.put(
			"userName", CPDefinitionOptionValueRel::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CPDefinitionOptionValueRel, String>)
				CPDefinitionOptionValueRel::setUserName);
		attributeGetterFunctions.put(
			"createDate", CPDefinitionOptionValueRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CPDefinitionOptionValueRel, Date>)
				CPDefinitionOptionValueRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CPDefinitionOptionValueRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CPDefinitionOptionValueRel, Date>)
				CPDefinitionOptionValueRel::setModifiedDate);
		attributeGetterFunctions.put(
			"CPDefinitionOptionRelId",
			CPDefinitionOptionValueRel::getCPDefinitionOptionRelId);
		attributeSetterBiConsumers.put(
			"CPDefinitionOptionRelId",
			(BiConsumer<CPDefinitionOptionValueRel, Long>)
				CPDefinitionOptionValueRel::setCPDefinitionOptionRelId);
		attributeGetterFunctions.put(
			"CPInstanceUuid", CPDefinitionOptionValueRel::getCPInstanceUuid);
		attributeSetterBiConsumers.put(
			"CPInstanceUuid",
			(BiConsumer<CPDefinitionOptionValueRel, String>)
				CPDefinitionOptionValueRel::setCPInstanceUuid);
		attributeGetterFunctions.put(
			"CProductId", CPDefinitionOptionValueRel::getCProductId);
		attributeSetterBiConsumers.put(
			"CProductId",
			(BiConsumer<CPDefinitionOptionValueRel, Long>)
				CPDefinitionOptionValueRel::setCProductId);
		attributeGetterFunctions.put(
			"name", CPDefinitionOptionValueRel::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CPDefinitionOptionValueRel, String>)
				CPDefinitionOptionValueRel::setName);
		attributeGetterFunctions.put(
			"priority", CPDefinitionOptionValueRel::getPriority);
		attributeSetterBiConsumers.put(
			"priority",
			(BiConsumer<CPDefinitionOptionValueRel, Double>)
				CPDefinitionOptionValueRel::setPriority);
		attributeGetterFunctions.put("key", CPDefinitionOptionValueRel::getKey);
		attributeSetterBiConsumers.put(
			"key",
			(BiConsumer<CPDefinitionOptionValueRel, String>)
				CPDefinitionOptionValueRel::setKey);
		attributeGetterFunctions.put(
			"quantity", CPDefinitionOptionValueRel::getQuantity);
		attributeSetterBiConsumers.put(
			"quantity",
			(BiConsumer<CPDefinitionOptionValueRel, Integer>)
				CPDefinitionOptionValueRel::setQuantity);
		attributeGetterFunctions.put(
			"preselected", CPDefinitionOptionValueRel::getPreselected);
		attributeSetterBiConsumers.put(
			"preselected",
			(BiConsumer<CPDefinitionOptionValueRel, Boolean>)
				CPDefinitionOptionValueRel::setPreselected);
		attributeGetterFunctions.put(
			"price", CPDefinitionOptionValueRel::getPrice);
		attributeSetterBiConsumers.put(
			"price",
			(BiConsumer<CPDefinitionOptionValueRel, BigDecimal>)
				CPDefinitionOptionValueRel::setPrice);

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
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCPDefinitionOptionValueRelId() {
		return _CPDefinitionOptionValueRelId;
	}

	@Override
	public void setCPDefinitionOptionValueRelId(
		long CPDefinitionOptionValueRelId) {

		_CPDefinitionOptionValueRelId = CPDefinitionOptionValueRelId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
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
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
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

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCPDefinitionOptionRelId() {
		return _CPDefinitionOptionRelId;
	}

	@Override
	public void setCPDefinitionOptionRelId(long CPDefinitionOptionRelId) {
		_columnBitmask |= CPDEFINITIONOPTIONRELID_COLUMN_BITMASK;

		if (!_setOriginalCPDefinitionOptionRelId) {
			_setOriginalCPDefinitionOptionRelId = true;

			_originalCPDefinitionOptionRelId = _CPDefinitionOptionRelId;
		}

		_CPDefinitionOptionRelId = CPDefinitionOptionRelId;
	}

	public long getOriginalCPDefinitionOptionRelId() {
		return _originalCPDefinitionOptionRelId;
	}

	@JSON
	@Override
	public String getCPInstanceUuid() {
		if (_CPInstanceUuid == null) {
			return "";
		}
		else {
			return _CPInstanceUuid;
		}
	}

	@Override
	public void setCPInstanceUuid(String CPInstanceUuid) {
		_columnBitmask |= CPINSTANCEUUID_COLUMN_BITMASK;

		if (_originalCPInstanceUuid == null) {
			_originalCPInstanceUuid = _CPInstanceUuid;
		}

		_CPInstanceUuid = CPInstanceUuid;
	}

	public String getOriginalCPInstanceUuid() {
		return GetterUtil.getString(_originalCPInstanceUuid);
	}

	@JSON
	@Override
	public long getCProductId() {
		return _CProductId;
	}

	@Override
	public void setCProductId(long CProductId) {
		_CProductId = CProductId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		_priority = priority;
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	@JSON
	@Override
	public boolean getPreselected() {
		return _preselected;
	}

	@JSON
	@Override
	public boolean isPreselected() {
		return _preselected;
	}

	@Override
	public void setPreselected(boolean preselected) {
		_columnBitmask |= PRESELECTED_COLUMN_BITMASK;

		if (!_setOriginalPreselected) {
			_setOriginalPreselected = true;

			_originalPreselected = _preselected;
		}

		_preselected = preselected;
	}

	public boolean getOriginalPreselected() {
		return _originalPreselected;
	}

	@JSON
	@Override
	public BigDecimal getPrice() {
		return _price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		_price = price;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				CPDefinitionOptionValueRel.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CPDefinitionOptionValueRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			CPDefinitionOptionValueRel.class.getName(), getPrimaryKey(),
			defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public CPDefinitionOptionValueRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CPDefinitionOptionValueRel>
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
		CPDefinitionOptionValueRelImpl cpDefinitionOptionValueRelImpl =
			new CPDefinitionOptionValueRelImpl();

		cpDefinitionOptionValueRelImpl.setUuid(getUuid());
		cpDefinitionOptionValueRelImpl.setCPDefinitionOptionValueRelId(
			getCPDefinitionOptionValueRelId());
		cpDefinitionOptionValueRelImpl.setGroupId(getGroupId());
		cpDefinitionOptionValueRelImpl.setCompanyId(getCompanyId());
		cpDefinitionOptionValueRelImpl.setUserId(getUserId());
		cpDefinitionOptionValueRelImpl.setUserName(getUserName());
		cpDefinitionOptionValueRelImpl.setCreateDate(getCreateDate());
		cpDefinitionOptionValueRelImpl.setModifiedDate(getModifiedDate());
		cpDefinitionOptionValueRelImpl.setCPDefinitionOptionRelId(
			getCPDefinitionOptionRelId());
		cpDefinitionOptionValueRelImpl.setCPInstanceUuid(getCPInstanceUuid());
		cpDefinitionOptionValueRelImpl.setCProductId(getCProductId());
		cpDefinitionOptionValueRelImpl.setName(getName());
		cpDefinitionOptionValueRelImpl.setPriority(getPriority());
		cpDefinitionOptionValueRelImpl.setKey(getKey());
		cpDefinitionOptionValueRelImpl.setQuantity(getQuantity());
		cpDefinitionOptionValueRelImpl.setPreselected(isPreselected());
		cpDefinitionOptionValueRelImpl.setPrice(getPrice());

		cpDefinitionOptionValueRelImpl.resetOriginalValues();

		return cpDefinitionOptionValueRelImpl;
	}

	@Override
	public int compareTo(
		CPDefinitionOptionValueRel cpDefinitionOptionValueRel) {

		int value = 0;

		if (getPriority() < cpDefinitionOptionValueRel.getPriority()) {
			value = -1;
		}
		else if (getPriority() > cpDefinitionOptionValueRel.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CPDefinitionOptionValueRel)) {
			return false;
		}

		CPDefinitionOptionValueRel cpDefinitionOptionValueRel =
			(CPDefinitionOptionValueRel)object;

		long primaryKey = cpDefinitionOptionValueRel.getPrimaryKey();

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
		_originalUuid = _uuid;

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;
		_originalCPDefinitionOptionRelId = _CPDefinitionOptionRelId;

		_setOriginalCPDefinitionOptionRelId = false;

		_originalCPInstanceUuid = _CPInstanceUuid;

		_originalKey = _key;

		_originalPreselected = _preselected;

		_setOriginalPreselected = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDefinitionOptionValueRel> toCacheModel() {
		CPDefinitionOptionValueRelCacheModel
			cpDefinitionOptionValueRelCacheModel =
				new CPDefinitionOptionValueRelCacheModel();

		cpDefinitionOptionValueRelCacheModel.uuid = getUuid();

		String uuid = cpDefinitionOptionValueRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpDefinitionOptionValueRelCacheModel.uuid = null;
		}

		cpDefinitionOptionValueRelCacheModel.CPDefinitionOptionValueRelId =
			getCPDefinitionOptionValueRelId();

		cpDefinitionOptionValueRelCacheModel.groupId = getGroupId();

		cpDefinitionOptionValueRelCacheModel.companyId = getCompanyId();

		cpDefinitionOptionValueRelCacheModel.userId = getUserId();

		cpDefinitionOptionValueRelCacheModel.userName = getUserName();

		String userName = cpDefinitionOptionValueRelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpDefinitionOptionValueRelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpDefinitionOptionValueRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			cpDefinitionOptionValueRelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpDefinitionOptionValueRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			cpDefinitionOptionValueRelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpDefinitionOptionValueRelCacheModel.CPDefinitionOptionRelId =
			getCPDefinitionOptionRelId();

		cpDefinitionOptionValueRelCacheModel.CPInstanceUuid =
			getCPInstanceUuid();

		String CPInstanceUuid =
			cpDefinitionOptionValueRelCacheModel.CPInstanceUuid;

		if ((CPInstanceUuid != null) && (CPInstanceUuid.length() == 0)) {
			cpDefinitionOptionValueRelCacheModel.CPInstanceUuid = null;
		}

		cpDefinitionOptionValueRelCacheModel.CProductId = getCProductId();

		cpDefinitionOptionValueRelCacheModel.name = getName();

		String name = cpDefinitionOptionValueRelCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			cpDefinitionOptionValueRelCacheModel.name = null;
		}

		cpDefinitionOptionValueRelCacheModel.priority = getPriority();

		cpDefinitionOptionValueRelCacheModel.key = getKey();

		String key = cpDefinitionOptionValueRelCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			cpDefinitionOptionValueRelCacheModel.key = null;
		}

		cpDefinitionOptionValueRelCacheModel.quantity = getQuantity();

		cpDefinitionOptionValueRelCacheModel.preselected = isPreselected();

		cpDefinitionOptionValueRelCacheModel.price = getPrice();

		return cpDefinitionOptionValueRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CPDefinitionOptionValueRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CPDefinitionOptionValueRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionOptionValueRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(CPDefinitionOptionValueRel)this));
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
		Map<String, Function<CPDefinitionOptionValueRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CPDefinitionOptionValueRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionOptionValueRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CPDefinitionOptionValueRel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CPDefinitionOptionValueRel>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _CPDefinitionOptionValueRelId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _CPDefinitionOptionRelId;
	private long _originalCPDefinitionOptionRelId;
	private boolean _setOriginalCPDefinitionOptionRelId;
	private String _CPInstanceUuid;
	private String _originalCPInstanceUuid;
	private long _CProductId;
	private String _name;
	private String _nameCurrentLanguageId;
	private double _priority;
	private String _key;
	private String _originalKey;
	private int _quantity;
	private boolean _preselected;
	private boolean _originalPreselected;
	private boolean _setOriginalPreselected;
	private BigDecimal _price;
	private long _columnBitmask;
	private CPDefinitionOptionValueRel _escapedModel;

}