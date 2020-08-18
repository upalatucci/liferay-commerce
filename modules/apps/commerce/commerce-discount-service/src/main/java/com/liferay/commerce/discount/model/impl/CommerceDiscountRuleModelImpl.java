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

package com.liferay.commerce.discount.model.impl;

import com.liferay.commerce.discount.model.CommerceDiscountRule;
import com.liferay.commerce.discount.model.CommerceDiscountRuleModel;
import com.liferay.commerce.discount.model.CommerceDiscountRuleSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the CommerceDiscountRule service. Represents a row in the &quot;CommerceDiscountRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceDiscountRuleModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceDiscountRuleImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CommerceDiscountRuleImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceDiscountRuleModelImpl
	extends BaseModelImpl<CommerceDiscountRule>
	implements CommerceDiscountRuleModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce discount rule model instance should use the <code>CommerceDiscountRule</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceDiscountRule";

	public static final Object[][] TABLE_COLUMNS = {
		{"commerceDiscountRuleId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"commerceDiscountId", Types.BIGINT},
		{"type_", Types.VARCHAR}, {"typeSettings", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceDiscountRuleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commerceDiscountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceDiscountRule (commerceDiscountRuleId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,commerceDiscountId LONG,type_ VARCHAR(75) null,typeSettings TEXT null)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceDiscountRule";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceDiscountRule.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceDiscountRule.createDate DESC";

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

	public static final long COMMERCEDISCOUNTID_COLUMN_BITMASK = 1L;

	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommerceDiscountRule toModel(
		CommerceDiscountRuleSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceDiscountRule model = new CommerceDiscountRuleImpl();

		model.setCommerceDiscountRuleId(soapModel.getCommerceDiscountRuleId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setCommerceDiscountId(soapModel.getCommerceDiscountId());
		model.setType(soapModel.getType());
		model.setTypeSettings(soapModel.getTypeSettings());

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
	public static List<CommerceDiscountRule> toModels(
		CommerceDiscountRuleSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceDiscountRule> models = new ArrayList<CommerceDiscountRule>(
			soapModels.length);

		for (CommerceDiscountRuleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.discount.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.discount.model.CommerceDiscountRule"));

	public CommerceDiscountRuleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceDiscountRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceDiscountRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceDiscountRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceDiscountRule.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceDiscountRule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceDiscountRule, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceDiscountRule, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceDiscountRule, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceDiscountRule)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceDiscountRule, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceDiscountRule, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceDiscountRule)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceDiscountRule, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceDiscountRule, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceDiscountRule>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceDiscountRule.class.getClassLoader(),
			CommerceDiscountRule.class, ModelWrapper.class);

		try {
			Constructor<CommerceDiscountRule> constructor =
				(Constructor<CommerceDiscountRule>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CommerceDiscountRule, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceDiscountRule, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceDiscountRule, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceDiscountRule, Object>>();
		Map<String, BiConsumer<CommerceDiscountRule, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceDiscountRule, ?>>();

		attributeGetterFunctions.put(
			"commerceDiscountRuleId",
			CommerceDiscountRule::getCommerceDiscountRuleId);
		attributeSetterBiConsumers.put(
			"commerceDiscountRuleId",
			(BiConsumer<CommerceDiscountRule, Long>)
				CommerceDiscountRule::setCommerceDiscountRuleId);
		attributeGetterFunctions.put(
			"companyId", CommerceDiscountRule::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceDiscountRule, Long>)
				CommerceDiscountRule::setCompanyId);
		attributeGetterFunctions.put("userId", CommerceDiscountRule::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceDiscountRule, Long>)
				CommerceDiscountRule::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceDiscountRule::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceDiscountRule, String>)
				CommerceDiscountRule::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceDiscountRule::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceDiscountRule, Date>)
				CommerceDiscountRule::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommerceDiscountRule::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceDiscountRule, Date>)
				CommerceDiscountRule::setModifiedDate);
		attributeGetterFunctions.put("name", CommerceDiscountRule::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CommerceDiscountRule, String>)
				CommerceDiscountRule::setName);
		attributeGetterFunctions.put(
			"commerceDiscountId", CommerceDiscountRule::getCommerceDiscountId);
		attributeSetterBiConsumers.put(
			"commerceDiscountId",
			(BiConsumer<CommerceDiscountRule, Long>)
				CommerceDiscountRule::setCommerceDiscountId);
		attributeGetterFunctions.put("type", CommerceDiscountRule::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<CommerceDiscountRule, String>)
				CommerceDiscountRule::setType);
		attributeGetterFunctions.put(
			"typeSettings", CommerceDiscountRule::getTypeSettings);
		attributeSetterBiConsumers.put(
			"typeSettings",
			(BiConsumer<CommerceDiscountRule, String>)
				CommerceDiscountRule::setTypeSettings);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceDiscountRuleId() {
		return _commerceDiscountRuleId;
	}

	@Override
	public void setCommerceDiscountRuleId(long commerceDiscountRuleId) {
		_commerceDiscountRuleId = commerceDiscountRuleId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public long getCommerceDiscountId() {
		return _commerceDiscountId;
	}

	@Override
	public void setCommerceDiscountId(long commerceDiscountId) {
		_columnBitmask |= COMMERCEDISCOUNTID_COLUMN_BITMASK;

		if (!_setOriginalCommerceDiscountId) {
			_setOriginalCommerceDiscountId = true;

			_originalCommerceDiscountId = _commerceDiscountId;
		}

		_commerceDiscountId = commerceDiscountId;
	}

	public long getOriginalCommerceDiscountId() {
		return _originalCommerceDiscountId;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@JSON
	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return "";
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceDiscountRule.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceDiscountRule toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceDiscountRule>
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
		CommerceDiscountRuleImpl commerceDiscountRuleImpl =
			new CommerceDiscountRuleImpl();

		commerceDiscountRuleImpl.setCommerceDiscountRuleId(
			getCommerceDiscountRuleId());
		commerceDiscountRuleImpl.setCompanyId(getCompanyId());
		commerceDiscountRuleImpl.setUserId(getUserId());
		commerceDiscountRuleImpl.setUserName(getUserName());
		commerceDiscountRuleImpl.setCreateDate(getCreateDate());
		commerceDiscountRuleImpl.setModifiedDate(getModifiedDate());
		commerceDiscountRuleImpl.setName(getName());
		commerceDiscountRuleImpl.setCommerceDiscountId(getCommerceDiscountId());
		commerceDiscountRuleImpl.setType(getType());
		commerceDiscountRuleImpl.setTypeSettings(getTypeSettings());

		commerceDiscountRuleImpl.resetOriginalValues();

		return commerceDiscountRuleImpl;
	}

	@Override
	public int compareTo(CommerceDiscountRule commerceDiscountRule) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), commerceDiscountRule.getCreateDate());

		value = value * -1;

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

		if (!(object instanceof CommerceDiscountRule)) {
			return false;
		}

		CommerceDiscountRule commerceDiscountRule =
			(CommerceDiscountRule)object;

		long primaryKey = commerceDiscountRule.getPrimaryKey();

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
		_setModifiedDate = false;

		_originalCommerceDiscountId = _commerceDiscountId;

		_setOriginalCommerceDiscountId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceDiscountRule> toCacheModel() {
		CommerceDiscountRuleCacheModel commerceDiscountRuleCacheModel =
			new CommerceDiscountRuleCacheModel();

		commerceDiscountRuleCacheModel.commerceDiscountRuleId =
			getCommerceDiscountRuleId();

		commerceDiscountRuleCacheModel.companyId = getCompanyId();

		commerceDiscountRuleCacheModel.userId = getUserId();

		commerceDiscountRuleCacheModel.userName = getUserName();

		String userName = commerceDiscountRuleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceDiscountRuleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceDiscountRuleCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceDiscountRuleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceDiscountRuleCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceDiscountRuleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceDiscountRuleCacheModel.name = getName();

		String name = commerceDiscountRuleCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commerceDiscountRuleCacheModel.name = null;
		}

		commerceDiscountRuleCacheModel.commerceDiscountId =
			getCommerceDiscountId();

		commerceDiscountRuleCacheModel.type = getType();

		String type = commerceDiscountRuleCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			commerceDiscountRuleCacheModel.type = null;
		}

		commerceDiscountRuleCacheModel.typeSettings = getTypeSettings();

		String typeSettings = commerceDiscountRuleCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			commerceDiscountRuleCacheModel.typeSettings = null;
		}

		return commerceDiscountRuleCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceDiscountRule, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceDiscountRule, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceDiscountRule, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CommerceDiscountRule)this));
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
		Map<String, Function<CommerceDiscountRule, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceDiscountRule, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceDiscountRule, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CommerceDiscountRule)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceDiscountRule>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _commerceDiscountRuleId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private long _commerceDiscountId;
	private long _originalCommerceDiscountId;
	private boolean _setOriginalCommerceDiscountId;
	private String _type;
	private String _typeSettings;
	private long _columnBitmask;
	private CommerceDiscountRule _escapedModel;

}