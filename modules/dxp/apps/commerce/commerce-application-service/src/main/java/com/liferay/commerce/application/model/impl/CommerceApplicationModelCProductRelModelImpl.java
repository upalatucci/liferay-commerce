/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.commerce.application.model.impl;

import com.liferay.commerce.application.model.CommerceApplicationModelCProductRel;
import com.liferay.commerce.application.model.CommerceApplicationModelCProductRelModel;
import com.liferay.commerce.application.model.CommerceApplicationModelCProductRelSoap;
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
 * The base model implementation for the CommerceApplicationModelCProductRel service. Represents a row in the &quot;CAModelCProductRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceApplicationModelCProductRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceApplicationModelCProductRelImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceApplicationModelCProductRelImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceApplicationModelCProductRelModelImpl
	extends BaseModelImpl<CommerceApplicationModelCProductRel>
	implements CommerceApplicationModelCProductRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce application model c product rel model instance should use the <code>CommerceApplicationModelCProductRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "CAModelCProductRel";

	public static final Object[][] TABLE_COLUMNS = {
		{"CAModelCProductRelId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"commerceApplicationModelId", Types.BIGINT},
		{"CProductId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("CAModelCProductRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceApplicationModelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CProductId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CAModelCProductRel (CAModelCProductRelId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceApplicationModelId LONG,CProductId LONG)";

	public static final String TABLE_SQL_DROP = "drop table CAModelCProductRel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceApplicationModelCProductRel.commerceApplicationModelCProductRelId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CAModelCProductRel.CAModelCProductRelId ASC";

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
	public static final long COMMERCEAPPLICATIONMODELID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long
		COMMERCEAPPLICATIONMODELCPRODUCTRELID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommerceApplicationModelCProductRel toModel(
		CommerceApplicationModelCProductRelSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceApplicationModelCProductRel model =
			new CommerceApplicationModelCProductRelImpl();

		model.setCommerceApplicationModelCProductRelId(
			soapModel.getCommerceApplicationModelCProductRelId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceApplicationModelId(
			soapModel.getCommerceApplicationModelId());
		model.setCProductId(soapModel.getCProductId());

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
	public static List<CommerceApplicationModelCProductRel> toModels(
		CommerceApplicationModelCProductRelSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceApplicationModelCProductRel> models =
			new ArrayList<CommerceApplicationModelCProductRel>(
				soapModels.length);

		for (CommerceApplicationModelCProductRelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.application.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.application.model.CommerceApplicationModelCProductRel"));

	public CommerceApplicationModelCProductRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceApplicationModelCProductRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceApplicationModelCProductRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceApplicationModelCProductRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceApplicationModelCProductRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceApplicationModelCProductRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceApplicationModelCProductRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String, Function<CommerceApplicationModelCProductRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceApplicationModelCProductRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommerceApplicationModelCProductRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceApplicationModelCProductRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceApplicationModelCProductRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceApplicationModelCProductRel)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceApplicationModelCProductRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceApplicationModelCProductRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function
		<InvocationHandler, CommerceApplicationModelCProductRel>
			_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceApplicationModelCProductRel.class.getClassLoader(),
			CommerceApplicationModelCProductRel.class, ModelWrapper.class);

		try {
			Constructor<CommerceApplicationModelCProductRel> constructor =
				(Constructor<CommerceApplicationModelCProductRel>)
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
		<String, Function<CommerceApplicationModelCProductRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommerceApplicationModelCProductRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceApplicationModelCProductRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<CommerceApplicationModelCProductRel, Object>>();
		Map<String, BiConsumer<CommerceApplicationModelCProductRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String,
					 BiConsumer<CommerceApplicationModelCProductRel, ?>>();

		attributeGetterFunctions.put(
			"commerceApplicationModelCProductRelId",
			CommerceApplicationModelCProductRel::
				getCommerceApplicationModelCProductRelId);
		attributeSetterBiConsumers.put(
			"commerceApplicationModelCProductRelId",
			(BiConsumer<CommerceApplicationModelCProductRel, Long>)
				CommerceApplicationModelCProductRel::
					setCommerceApplicationModelCProductRelId);
		attributeGetterFunctions.put(
			"companyId", CommerceApplicationModelCProductRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceApplicationModelCProductRel, Long>)
				CommerceApplicationModelCProductRel::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CommerceApplicationModelCProductRel::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceApplicationModelCProductRel, Long>)
				CommerceApplicationModelCProductRel::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceApplicationModelCProductRel::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceApplicationModelCProductRel, String>)
				CommerceApplicationModelCProductRel::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceApplicationModelCProductRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceApplicationModelCProductRel, Date>)
				CommerceApplicationModelCProductRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate",
			CommerceApplicationModelCProductRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceApplicationModelCProductRel, Date>)
				CommerceApplicationModelCProductRel::setModifiedDate);
		attributeGetterFunctions.put(
			"commerceApplicationModelId",
			CommerceApplicationModelCProductRel::getCommerceApplicationModelId);
		attributeSetterBiConsumers.put(
			"commerceApplicationModelId",
			(BiConsumer<CommerceApplicationModelCProductRel, Long>)
				CommerceApplicationModelCProductRel::
					setCommerceApplicationModelId);
		attributeGetterFunctions.put(
			"CProductId", CommerceApplicationModelCProductRel::getCProductId);
		attributeSetterBiConsumers.put(
			"CProductId",
			(BiConsumer<CommerceApplicationModelCProductRel, Long>)
				CommerceApplicationModelCProductRel::setCProductId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceApplicationModelCProductRelId() {
		return _commerceApplicationModelCProductRelId;
	}

	@Override
	public void setCommerceApplicationModelCProductRelId(
		long commerceApplicationModelCProductRelId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceApplicationModelCProductRelId =
			commerceApplicationModelCProductRelId;
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
	public long getCommerceApplicationModelId() {
		return _commerceApplicationModelId;
	}

	@Override
	public void setCommerceApplicationModelId(long commerceApplicationModelId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceApplicationModelId = commerceApplicationModelId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommerceApplicationModelId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("commerceApplicationModelId"));
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
			getCompanyId(), CommerceApplicationModelCProductRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceApplicationModelCProductRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceApplicationModelCProductRel>
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
		CommerceApplicationModelCProductRelImpl
			commerceApplicationModelCProductRelImpl =
				new CommerceApplicationModelCProductRelImpl();

		commerceApplicationModelCProductRelImpl.
			setCommerceApplicationModelCProductRelId(
				getCommerceApplicationModelCProductRelId());
		commerceApplicationModelCProductRelImpl.setCompanyId(getCompanyId());
		commerceApplicationModelCProductRelImpl.setUserId(getUserId());
		commerceApplicationModelCProductRelImpl.setUserName(getUserName());
		commerceApplicationModelCProductRelImpl.setCreateDate(getCreateDate());
		commerceApplicationModelCProductRelImpl.setModifiedDate(
			getModifiedDate());
		commerceApplicationModelCProductRelImpl.setCommerceApplicationModelId(
			getCommerceApplicationModelId());
		commerceApplicationModelCProductRelImpl.setCProductId(getCProductId());

		commerceApplicationModelCProductRelImpl.resetOriginalValues();

		return commerceApplicationModelCProductRelImpl;
	}

	@Override
	public int compareTo(
		CommerceApplicationModelCProductRel
			commerceApplicationModelCProductRel) {

		long primaryKey = commerceApplicationModelCProductRel.getPrimaryKey();

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

		if (!(object instanceof CommerceApplicationModelCProductRel)) {
			return false;
		}

		CommerceApplicationModelCProductRel
			commerceApplicationModelCProductRel =
				(CommerceApplicationModelCProductRel)object;

		long primaryKey = commerceApplicationModelCProductRel.getPrimaryKey();

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
	public CacheModel<CommerceApplicationModelCProductRel> toCacheModel() {
		CommerceApplicationModelCProductRelCacheModel
			commerceApplicationModelCProductRelCacheModel =
				new CommerceApplicationModelCProductRelCacheModel();

		commerceApplicationModelCProductRelCacheModel.
			commerceApplicationModelCProductRelId =
				getCommerceApplicationModelCProductRelId();

		commerceApplicationModelCProductRelCacheModel.companyId =
			getCompanyId();

		commerceApplicationModelCProductRelCacheModel.userId = getUserId();

		commerceApplicationModelCProductRelCacheModel.userName = getUserName();

		String userName =
			commerceApplicationModelCProductRelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceApplicationModelCProductRelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceApplicationModelCProductRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commerceApplicationModelCProductRelCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceApplicationModelCProductRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceApplicationModelCProductRelCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		commerceApplicationModelCProductRelCacheModel.
			commerceApplicationModelId = getCommerceApplicationModelId();

		commerceApplicationModelCProductRelCacheModel.CProductId =
			getCProductId();

		return commerceApplicationModelCProductRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceApplicationModelCProductRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry
				<String, Function<CommerceApplicationModelCProductRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceApplicationModelCProductRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceApplicationModelCProductRel)this));
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
		Map<String, Function<CommerceApplicationModelCProductRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry
				<String, Function<CommerceApplicationModelCProductRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceApplicationModelCProductRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceApplicationModelCProductRel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommerceApplicationModelCProductRel>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _commerceApplicationModelCProductRelId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceApplicationModelId;
	private long _CProductId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CommerceApplicationModelCProductRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CommerceApplicationModelCProductRel)this);
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

		_columnOriginalValues.put(
			"CAModelCProductRelId", _commerceApplicationModelCProductRelId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put(
			"commerceApplicationModelId", _commerceApplicationModelId);
		_columnOriginalValues.put("CProductId", _CProductId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put(
			"CAModelCProductRelId", "commerceApplicationModelCProductRelId");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("CAModelCProductRelId", 1L);

		columnBitmasks.put("companyId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("userName", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("commerceApplicationModelId", 64L);

		columnBitmasks.put("CProductId", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CommerceApplicationModelCProductRel _escapedModel;

}