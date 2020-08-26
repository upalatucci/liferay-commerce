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

package com.liferay.commerce.model.impl;

import com.liferay.commerce.model.CPDAvailabilityEstimate;
import com.liferay.commerce.model.CPDAvailabilityEstimateModel;
import com.liferay.commerce.model.CPDAvailabilityEstimateSoap;
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
 * The base model implementation for the CPDAvailabilityEstimate service. Represents a row in the &quot;CPDAvailabilityEstimate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CPDAvailabilityEstimateModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDAvailabilityEstimateImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CPDAvailabilityEstimateImpl
 * @generated
 */
@JSON(strict = true)
public class CPDAvailabilityEstimateModelImpl
	extends BaseModelImpl<CPDAvailabilityEstimate>
	implements CPDAvailabilityEstimateModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cpd availability estimate model instance should use the <code>CPDAvailabilityEstimate</code> interface instead.
	 */
	public static final String TABLE_NAME = "CPDAvailabilityEstimate";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"CPDAvailabilityEstimateId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"commerceAvailabilityEstimateId", Types.BIGINT},
		{"CProductId", Types.BIGINT}, {"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPDAvailabilityEstimateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceAvailabilityEstimateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CPDAvailabilityEstimate (uuid_ VARCHAR(75) null,CPDAvailabilityEstimateId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceAvailabilityEstimateId LONG,CProductId LONG,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table CPDAvailabilityEstimate";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cpdAvailabilityEstimate.CPDAvailabilityEstimateId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CPDAvailabilityEstimate.CPDAvailabilityEstimateId ASC";

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
	public static final long CPRODUCTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMMERCEAVAILABILITYESTIMATEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CPDAVAILABILITYESTIMATEID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CPDAvailabilityEstimate toModel(
		CPDAvailabilityEstimateSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CPDAvailabilityEstimate model = new CPDAvailabilityEstimateImpl();

		model.setUuid(soapModel.getUuid());
		model.setCPDAvailabilityEstimateId(
			soapModel.getCPDAvailabilityEstimateId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceAvailabilityEstimateId(
			soapModel.getCommerceAvailabilityEstimateId());
		model.setCProductId(soapModel.getCProductId());
		model.setLastPublishDate(soapModel.getLastPublishDate());

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
	public static List<CPDAvailabilityEstimate> toModels(
		CPDAvailabilityEstimateSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CPDAvailabilityEstimate> models =
			new ArrayList<CPDAvailabilityEstimate>(soapModels.length);

		for (CPDAvailabilityEstimateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.model.CPDAvailabilityEstimate"));

	public CPDAvailabilityEstimateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPDAvailabilityEstimateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPDAvailabilityEstimateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPDAvailabilityEstimateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDAvailabilityEstimate.class;
	}

	@Override
	public String getModelClassName() {
		return CPDAvailabilityEstimate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CPDAvailabilityEstimate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CPDAvailabilityEstimate, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDAvailabilityEstimate, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CPDAvailabilityEstimate)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CPDAvailabilityEstimate, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CPDAvailabilityEstimate, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CPDAvailabilityEstimate)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CPDAvailabilityEstimate, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CPDAvailabilityEstimate, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CPDAvailabilityEstimate>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CPDAvailabilityEstimate.class.getClassLoader(),
			CPDAvailabilityEstimate.class, ModelWrapper.class);

		try {
			Constructor<CPDAvailabilityEstimate> constructor =
				(Constructor<CPDAvailabilityEstimate>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CPDAvailabilityEstimate, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CPDAvailabilityEstimate, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CPDAvailabilityEstimate, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CPDAvailabilityEstimate, Object>>();
		Map<String, BiConsumer<CPDAvailabilityEstimate, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CPDAvailabilityEstimate, ?>>();

		attributeGetterFunctions.put("uuid", CPDAvailabilityEstimate::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CPDAvailabilityEstimate, String>)
				CPDAvailabilityEstimate::setUuid);
		attributeGetterFunctions.put(
			"CPDAvailabilityEstimateId",
			CPDAvailabilityEstimate::getCPDAvailabilityEstimateId);
		attributeSetterBiConsumers.put(
			"CPDAvailabilityEstimateId",
			(BiConsumer<CPDAvailabilityEstimate, Long>)
				CPDAvailabilityEstimate::setCPDAvailabilityEstimateId);
		attributeGetterFunctions.put(
			"companyId", CPDAvailabilityEstimate::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CPDAvailabilityEstimate, Long>)
				CPDAvailabilityEstimate::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CPDAvailabilityEstimate::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CPDAvailabilityEstimate, Long>)
				CPDAvailabilityEstimate::setUserId);
		attributeGetterFunctions.put(
			"userName", CPDAvailabilityEstimate::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CPDAvailabilityEstimate, String>)
				CPDAvailabilityEstimate::setUserName);
		attributeGetterFunctions.put(
			"createDate", CPDAvailabilityEstimate::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CPDAvailabilityEstimate, Date>)
				CPDAvailabilityEstimate::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CPDAvailabilityEstimate::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CPDAvailabilityEstimate, Date>)
				CPDAvailabilityEstimate::setModifiedDate);
		attributeGetterFunctions.put(
			"commerceAvailabilityEstimateId",
			CPDAvailabilityEstimate::getCommerceAvailabilityEstimateId);
		attributeSetterBiConsumers.put(
			"commerceAvailabilityEstimateId",
			(BiConsumer<CPDAvailabilityEstimate, Long>)
				CPDAvailabilityEstimate::setCommerceAvailabilityEstimateId);
		attributeGetterFunctions.put(
			"CProductId", CPDAvailabilityEstimate::getCProductId);
		attributeSetterBiConsumers.put(
			"CProductId",
			(BiConsumer<CPDAvailabilityEstimate, Long>)
				CPDAvailabilityEstimate::setCProductId);
		attributeGetterFunctions.put(
			"lastPublishDate", CPDAvailabilityEstimate::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<CPDAvailabilityEstimate, Date>)
				CPDAvailabilityEstimate::setLastPublishDate);

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
	public long getCPDAvailabilityEstimateId() {
		return _CPDAvailabilityEstimateId;
	}

	@Override
	public void setCPDAvailabilityEstimateId(long CPDAvailabilityEstimateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_CPDAvailabilityEstimateId = CPDAvailabilityEstimateId;
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

	@JSON
	@Override
	public long getCommerceAvailabilityEstimateId() {
		return _commerceAvailabilityEstimateId;
	}

	@Override
	public void setCommerceAvailabilityEstimateId(
		long commerceAvailabilityEstimateId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceAvailabilityEstimateId = commerceAvailabilityEstimateId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommerceAvailabilityEstimateId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue(
				"commerceAvailabilityEstimateId"));
	}

	@JSON
	@Override
	public long getCProductId() {
		return _CProductId;
	}

	@Override
	public void setCProductId(long CProductId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_CProductId = CProductId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCProductId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("CProductId"));
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CPDAvailabilityEstimate.class.getName()));
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
			getCompanyId(), CPDAvailabilityEstimate.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPDAvailabilityEstimate toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CPDAvailabilityEstimate>
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
		CPDAvailabilityEstimateImpl cpdAvailabilityEstimateImpl =
			new CPDAvailabilityEstimateImpl();

		cpdAvailabilityEstimateImpl.setUuid(getUuid());
		cpdAvailabilityEstimateImpl.setCPDAvailabilityEstimateId(
			getCPDAvailabilityEstimateId());
		cpdAvailabilityEstimateImpl.setCompanyId(getCompanyId());
		cpdAvailabilityEstimateImpl.setUserId(getUserId());
		cpdAvailabilityEstimateImpl.setUserName(getUserName());
		cpdAvailabilityEstimateImpl.setCreateDate(getCreateDate());
		cpdAvailabilityEstimateImpl.setModifiedDate(getModifiedDate());
		cpdAvailabilityEstimateImpl.setCommerceAvailabilityEstimateId(
			getCommerceAvailabilityEstimateId());
		cpdAvailabilityEstimateImpl.setCProductId(getCProductId());
		cpdAvailabilityEstimateImpl.setLastPublishDate(getLastPublishDate());

		cpdAvailabilityEstimateImpl.resetOriginalValues();

		return cpdAvailabilityEstimateImpl;
	}

	@Override
	public int compareTo(CPDAvailabilityEstimate cpdAvailabilityEstimate) {
		long primaryKey = cpdAvailabilityEstimate.getPrimaryKey();

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

		if (!(object instanceof CPDAvailabilityEstimate)) {
			return false;
		}

		CPDAvailabilityEstimate cpdAvailabilityEstimate =
			(CPDAvailabilityEstimate)object;

		long primaryKey = cpdAvailabilityEstimate.getPrimaryKey();

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
	public CacheModel<CPDAvailabilityEstimate> toCacheModel() {
		CPDAvailabilityEstimateCacheModel cpdAvailabilityEstimateCacheModel =
			new CPDAvailabilityEstimateCacheModel();

		cpdAvailabilityEstimateCacheModel.uuid = getUuid();

		String uuid = cpdAvailabilityEstimateCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpdAvailabilityEstimateCacheModel.uuid = null;
		}

		cpdAvailabilityEstimateCacheModel.CPDAvailabilityEstimateId =
			getCPDAvailabilityEstimateId();

		cpdAvailabilityEstimateCacheModel.companyId = getCompanyId();

		cpdAvailabilityEstimateCacheModel.userId = getUserId();

		cpdAvailabilityEstimateCacheModel.userName = getUserName();

		String userName = cpdAvailabilityEstimateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpdAvailabilityEstimateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpdAvailabilityEstimateCacheModel.createDate = createDate.getTime();
		}
		else {
			cpdAvailabilityEstimateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpdAvailabilityEstimateCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			cpdAvailabilityEstimateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpdAvailabilityEstimateCacheModel.commerceAvailabilityEstimateId =
			getCommerceAvailabilityEstimateId();

		cpdAvailabilityEstimateCacheModel.CProductId = getCProductId();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			cpdAvailabilityEstimateCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			cpdAvailabilityEstimateCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return cpdAvailabilityEstimateCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CPDAvailabilityEstimate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CPDAvailabilityEstimate, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDAvailabilityEstimate, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CPDAvailabilityEstimate)this));
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
		Map<String, Function<CPDAvailabilityEstimate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CPDAvailabilityEstimate, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDAvailabilityEstimate, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CPDAvailabilityEstimate)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CPDAvailabilityEstimate>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private long _CPDAvailabilityEstimateId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceAvailabilityEstimateId;
	private long _CProductId;
	private Date _lastPublishDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CPDAvailabilityEstimate, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CPDAvailabilityEstimate)this);
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
		_columnOriginalValues.put(
			"CPDAvailabilityEstimateId", _CPDAvailabilityEstimateId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put(
			"commerceAvailabilityEstimateId", _commerceAvailabilityEstimateId);
		_columnOriginalValues.put("CProductId", _CProductId);
		_columnOriginalValues.put("lastPublishDate", _lastPublishDate);
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

		columnBitmasks.put("CPDAvailabilityEstimateId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("commerceAvailabilityEstimateId", 128L);

		columnBitmasks.put("CProductId", 256L);

		columnBitmasks.put("lastPublishDate", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CPDAvailabilityEstimate _escapedModel;

}