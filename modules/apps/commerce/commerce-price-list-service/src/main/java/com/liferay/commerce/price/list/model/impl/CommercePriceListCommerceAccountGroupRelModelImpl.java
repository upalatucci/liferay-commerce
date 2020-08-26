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

package com.liferay.commerce.price.list.model.impl;

import com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRel;
import com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRelModel;
import com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRelSoap;
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
 * The base model implementation for the CommercePriceListCommerceAccountGroupRel service. Represents a row in the &quot;CPLCommerceGroupAccountRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommercePriceListCommerceAccountGroupRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommercePriceListCommerceAccountGroupRelImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListCommerceAccountGroupRelImpl
 * @generated
 */
@JSON(strict = true)
public class CommercePriceListCommerceAccountGroupRelModelImpl
	extends BaseModelImpl<CommercePriceListCommerceAccountGroupRel>
	implements CommercePriceListCommerceAccountGroupRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce price list commerce account group rel model instance should use the <code>CommercePriceListCommerceAccountGroupRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "CPLCommerceGroupAccountRel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"CPLCommerceAccountGroupRelId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"commercePriceListId", Types.BIGINT},
		{"commerceAccountGroupId", Types.BIGINT}, {"order_", Types.INTEGER},
		{"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPLCommerceAccountGroupRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commercePriceListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceAccountGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CPLCommerceGroupAccountRel (uuid_ VARCHAR(75) null,CPLCommerceAccountGroupRelId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commercePriceListId LONG,commerceAccountGroupId LONG,order_ INTEGER,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table CPLCommerceGroupAccountRel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commercePriceListCommerceAccountGroupRel.order ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CPLCommerceGroupAccountRel.order_ ASC";

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
	public static final long COMMERCEACCOUNTGROUPID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMMERCEPRICELISTID_COLUMN_BITMASK = 2L;

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
	public static final long ORDER_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommercePriceListCommerceAccountGroupRel toModel(
		CommercePriceListCommerceAccountGroupRelSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommercePriceListCommerceAccountGroupRel model =
			new CommercePriceListCommerceAccountGroupRelImpl();

		model.setUuid(soapModel.getUuid());
		model.setCommercePriceListCommerceAccountGroupRelId(
			soapModel.getCommercePriceListCommerceAccountGroupRelId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommercePriceListId(soapModel.getCommercePriceListId());
		model.setCommerceAccountGroupId(soapModel.getCommerceAccountGroupId());
		model.setOrder(soapModel.getOrder());
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
	public static List<CommercePriceListCommerceAccountGroupRel> toModels(
		CommercePriceListCommerceAccountGroupRelSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommercePriceListCommerceAccountGroupRel> models =
			new ArrayList<CommercePriceListCommerceAccountGroupRel>(
				soapModels.length);

		for (CommercePriceListCommerceAccountGroupRelSoap soapModel :
				soapModels) {

			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.price.list.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRel"));

	public CommercePriceListCommerceAccountGroupRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commercePriceListCommerceAccountGroupRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommercePriceListCommerceAccountGroupRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commercePriceListCommerceAccountGroupRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommercePriceListCommerceAccountGroupRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommercePriceListCommerceAccountGroupRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommercePriceListCommerceAccountGroupRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String,
				 Function<CommercePriceListCommerceAccountGroupRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceListCommerceAccountGroupRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommercePriceListCommerceAccountGroupRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map
			<String,
			 BiConsumer<CommercePriceListCommerceAccountGroupRel, Object>>
				attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommercePriceListCommerceAccountGroupRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommercePriceListCommerceAccountGroupRel)this,
					entry.getValue());
			}
		}
	}

	public Map
		<String, Function<CommercePriceListCommerceAccountGroupRel, Object>>
			getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map
		<String, BiConsumer<CommercePriceListCommerceAccountGroupRel, Object>>
			getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function
		<InvocationHandler, CommercePriceListCommerceAccountGroupRel>
			_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommercePriceListCommerceAccountGroupRel.class.getClassLoader(),
			CommercePriceListCommerceAccountGroupRel.class, ModelWrapper.class);

		try {
			Constructor<CommercePriceListCommerceAccountGroupRel> constructor =
				(Constructor<CommercePriceListCommerceAccountGroupRel>)
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
		<String, Function<CommercePriceListCommerceAccountGroupRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommercePriceListCommerceAccountGroupRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommercePriceListCommerceAccountGroupRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function
						 <CommercePriceListCommerceAccountGroupRel, Object>>();
		Map<String, BiConsumer<CommercePriceListCommerceAccountGroupRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String,
					 BiConsumer<CommercePriceListCommerceAccountGroupRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", CommercePriceListCommerceAccountGroupRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, String>)
				CommercePriceListCommerceAccountGroupRel::setUuid);
		attributeGetterFunctions.put(
			"commercePriceListCommerceAccountGroupRelId",
			CommercePriceListCommerceAccountGroupRel::
				getCommercePriceListCommerceAccountGroupRelId);
		attributeSetterBiConsumers.put(
			"commercePriceListCommerceAccountGroupRelId",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Long>)
				CommercePriceListCommerceAccountGroupRel::
					setCommercePriceListCommerceAccountGroupRelId);
		attributeGetterFunctions.put(
			"companyId",
			CommercePriceListCommerceAccountGroupRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Long>)
				CommercePriceListCommerceAccountGroupRel::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CommercePriceListCommerceAccountGroupRel::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Long>)
				CommercePriceListCommerceAccountGroupRel::setUserId);
		attributeGetterFunctions.put(
			"userName", CommercePriceListCommerceAccountGroupRel::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, String>)
				CommercePriceListCommerceAccountGroupRel::setUserName);
		attributeGetterFunctions.put(
			"createDate",
			CommercePriceListCommerceAccountGroupRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Date>)
				CommercePriceListCommerceAccountGroupRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate",
			CommercePriceListCommerceAccountGroupRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Date>)
				CommercePriceListCommerceAccountGroupRel::setModifiedDate);
		attributeGetterFunctions.put(
			"commercePriceListId",
			CommercePriceListCommerceAccountGroupRel::getCommercePriceListId);
		attributeSetterBiConsumers.put(
			"commercePriceListId",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Long>)
				CommercePriceListCommerceAccountGroupRel::
					setCommercePriceListId);
		attributeGetterFunctions.put(
			"commerceAccountGroupId",
			CommercePriceListCommerceAccountGroupRel::
				getCommerceAccountGroupId);
		attributeSetterBiConsumers.put(
			"commerceAccountGroupId",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Long>)
				CommercePriceListCommerceAccountGroupRel::
					setCommerceAccountGroupId);
		attributeGetterFunctions.put(
			"order", CommercePriceListCommerceAccountGroupRel::getOrder);
		attributeSetterBiConsumers.put(
			"order",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Integer>)
				CommercePriceListCommerceAccountGroupRel::setOrder);
		attributeGetterFunctions.put(
			"lastPublishDate",
			CommercePriceListCommerceAccountGroupRel::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<CommercePriceListCommerceAccountGroupRel, Date>)
				CommercePriceListCommerceAccountGroupRel::setLastPublishDate);

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
	public long getCommercePriceListCommerceAccountGroupRelId() {
		return _commercePriceListCommerceAccountGroupRelId;
	}

	@Override
	public void setCommercePriceListCommerceAccountGroupRelId(
		long commercePriceListCommerceAccountGroupRelId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commercePriceListCommerceAccountGroupRelId =
			commercePriceListCommerceAccountGroupRelId;
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
	public long getCommercePriceListId() {
		return _commercePriceListId;
	}

	@Override
	public void setCommercePriceListId(long commercePriceListId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commercePriceListId = commercePriceListId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommercePriceListId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("commercePriceListId"));
	}

	@JSON
	@Override
	public long getCommerceAccountGroupId() {
		return _commerceAccountGroupId;
	}

	@Override
	public void setCommerceAccountGroupId(long commerceAccountGroupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceAccountGroupId = commerceAccountGroupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommerceAccountGroupId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("commerceAccountGroupId"));
	}

	@JSON
	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_order = order;
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
			PortalUtil.getClassNameId(
				CommercePriceListCommerceAccountGroupRel.class.getName()));
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
			getCompanyId(),
			CommercePriceListCommerceAccountGroupRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommercePriceListCommerceAccountGroupRel toEscapedModel() {
		if (_escapedModel == null) {
			Function
				<InvocationHandler, CommercePriceListCommerceAccountGroupRel>
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
		CommercePriceListCommerceAccountGroupRelImpl
			commercePriceListCommerceAccountGroupRelImpl =
				new CommercePriceListCommerceAccountGroupRelImpl();

		commercePriceListCommerceAccountGroupRelImpl.setUuid(getUuid());
		commercePriceListCommerceAccountGroupRelImpl.
			setCommercePriceListCommerceAccountGroupRelId(
				getCommercePriceListCommerceAccountGroupRelId());
		commercePriceListCommerceAccountGroupRelImpl.setCompanyId(
			getCompanyId());
		commercePriceListCommerceAccountGroupRelImpl.setUserId(getUserId());
		commercePriceListCommerceAccountGroupRelImpl.setUserName(getUserName());
		commercePriceListCommerceAccountGroupRelImpl.setCreateDate(
			getCreateDate());
		commercePriceListCommerceAccountGroupRelImpl.setModifiedDate(
			getModifiedDate());
		commercePriceListCommerceAccountGroupRelImpl.setCommercePriceListId(
			getCommercePriceListId());
		commercePriceListCommerceAccountGroupRelImpl.setCommerceAccountGroupId(
			getCommerceAccountGroupId());
		commercePriceListCommerceAccountGroupRelImpl.setOrder(getOrder());
		commercePriceListCommerceAccountGroupRelImpl.setLastPublishDate(
			getLastPublishDate());

		commercePriceListCommerceAccountGroupRelImpl.resetOriginalValues();

		return commercePriceListCommerceAccountGroupRelImpl;
	}

	@Override
	public int compareTo(
		CommercePriceListCommerceAccountGroupRel
			commercePriceListCommerceAccountGroupRel) {

		int value = 0;

		if (getOrder() < commercePriceListCommerceAccountGroupRel.getOrder()) {
			value = -1;
		}
		else if (getOrder() >
					commercePriceListCommerceAccountGroupRel.getOrder()) {

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

		if (!(object instanceof CommercePriceListCommerceAccountGroupRel)) {
			return false;
		}

		CommercePriceListCommerceAccountGroupRel
			commercePriceListCommerceAccountGroupRel =
				(CommercePriceListCommerceAccountGroupRel)object;

		long primaryKey =
			commercePriceListCommerceAccountGroupRel.getPrimaryKey();

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
	public CacheModel<CommercePriceListCommerceAccountGroupRel> toCacheModel() {
		CommercePriceListCommerceAccountGroupRelCacheModel
			commercePriceListCommerceAccountGroupRelCacheModel =
				new CommercePriceListCommerceAccountGroupRelCacheModel();

		commercePriceListCommerceAccountGroupRelCacheModel.uuid = getUuid();

		String uuid = commercePriceListCommerceAccountGroupRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commercePriceListCommerceAccountGroupRelCacheModel.uuid = null;
		}

		commercePriceListCommerceAccountGroupRelCacheModel.
			commercePriceListCommerceAccountGroupRelId =
				getCommercePriceListCommerceAccountGroupRelId();

		commercePriceListCommerceAccountGroupRelCacheModel.companyId =
			getCompanyId();

		commercePriceListCommerceAccountGroupRelCacheModel.userId = getUserId();

		commercePriceListCommerceAccountGroupRelCacheModel.userName =
			getUserName();

		String userName =
			commercePriceListCommerceAccountGroupRelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commercePriceListCommerceAccountGroupRelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commercePriceListCommerceAccountGroupRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commercePriceListCommerceAccountGroupRelCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commercePriceListCommerceAccountGroupRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commercePriceListCommerceAccountGroupRelCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		commercePriceListCommerceAccountGroupRelCacheModel.commercePriceListId =
			getCommercePriceListId();

		commercePriceListCommerceAccountGroupRelCacheModel.
			commerceAccountGroupId = getCommerceAccountGroupId();

		commercePriceListCommerceAccountGroupRelCacheModel.order = getOrder();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			commercePriceListCommerceAccountGroupRelCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			commercePriceListCommerceAccountGroupRelCacheModel.lastPublishDate =
				Long.MIN_VALUE;
		}

		return commercePriceListCommerceAccountGroupRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommercePriceListCommerceAccountGroupRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry
				<String,
				 Function<CommercePriceListCommerceAccountGroupRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceListCommerceAccountGroupRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(CommercePriceListCommerceAccountGroupRel)this));
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
		Map<String, Function<CommercePriceListCommerceAccountGroupRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry
				<String,
				 Function<CommercePriceListCommerceAccountGroupRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceListCommerceAccountGroupRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommercePriceListCommerceAccountGroupRel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommercePriceListCommerceAccountGroupRel>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private long _commercePriceListCommerceAccountGroupRelId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commercePriceListId;
	private long _commerceAccountGroupId;
	private int _order;
	private Date _lastPublishDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CommercePriceListCommerceAccountGroupRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply(
			(CommercePriceListCommerceAccountGroupRel)this);
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
			"CPLCommerceAccountGroupRelId",
			_commercePriceListCommerceAccountGroupRelId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("commercePriceListId", _commercePriceListId);
		_columnOriginalValues.put(
			"commerceAccountGroupId", _commerceAccountGroupId);
		_columnOriginalValues.put("order_", _order);
		_columnOriginalValues.put("lastPublishDate", _lastPublishDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"CPLCommerceAccountGroupRelId",
			"commercePriceListCommerceAccountGroupRelId");
		attributeNames.put("order_", "order");

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

		columnBitmasks.put("CPLCommerceAccountGroupRelId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("commercePriceListId", 128L);

		columnBitmasks.put("commerceAccountGroupId", 256L);

		columnBitmasks.put("order_", 512L);

		columnBitmasks.put("lastPublishDate", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CommercePriceListCommerceAccountGroupRel _escapedModel;

}