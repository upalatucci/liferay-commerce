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

package com.liferay.commerce.data.integration.model.impl;

import com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcess;
import com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcessModel;
import com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcessSoap;
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
 * The base model implementation for the CommerceDataIntegrationProcess service. Represents a row in the &quot;CDataIntegrationProcess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceDataIntegrationProcessModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceDataIntegrationProcessImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceDataIntegrationProcessImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceDataIntegrationProcessModelImpl
	extends BaseModelImpl<CommerceDataIntegrationProcess>
	implements CommerceDataIntegrationProcessModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce data integration process model instance should use the <code>CommerceDataIntegrationProcess</code> interface instead.
	 */
	public static final String TABLE_NAME = "CDataIntegrationProcess";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT},
		{"CDataIntegrationProcessId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"type_", Types.VARCHAR}, {"typeSettings", Types.CLOB},
		{"system_", Types.BOOLEAN}, {"active_", Types.BOOLEAN},
		{"cronExpression", Types.VARCHAR}, {"startDate", Types.TIMESTAMP},
		{"endDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CDataIntegrationProcessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.CLOB);
		TABLE_COLUMNS_MAP.put("system_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("cronExpression", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CDataIntegrationProcess (mvccVersion LONG default 0 not null,CDataIntegrationProcessId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,type_ VARCHAR(75) null,typeSettings TEXT null,system_ BOOLEAN,active_ BOOLEAN,cronExpression VARCHAR(75) null,startDate DATE null,endDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table CDataIntegrationProcess";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceDataIntegrationProcess.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CDataIntegrationProcess.modifiedDate DESC";

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

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long NAME_COLUMN_BITMASK = 2L;

	public static final long TYPE_COLUMN_BITMASK = 4L;

	public static final long MODIFIEDDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceDataIntegrationProcess toModel(
		CommerceDataIntegrationProcessSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceDataIntegrationProcess model =
			new CommerceDataIntegrationProcessImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setCommerceDataIntegrationProcessId(
			soapModel.getCommerceDataIntegrationProcessId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setType(soapModel.getType());
		model.setTypeSettings(soapModel.getTypeSettings());
		model.setSystem(soapModel.isSystem());
		model.setActive(soapModel.isActive());
		model.setCronExpression(soapModel.getCronExpression());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceDataIntegrationProcess> toModels(
		CommerceDataIntegrationProcessSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceDataIntegrationProcess> models =
			new ArrayList<CommerceDataIntegrationProcess>(soapModels.length);

		for (CommerceDataIntegrationProcessSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.data.integration.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcess"));

	public CommerceDataIntegrationProcessModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceDataIntegrationProcessId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceDataIntegrationProcessId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceDataIntegrationProcessId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceDataIntegrationProcess.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceDataIntegrationProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceDataIntegrationProcess, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceDataIntegrationProcess, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceDataIntegrationProcess, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommerceDataIntegrationProcess)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceDataIntegrationProcess, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceDataIntegrationProcess, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceDataIntegrationProcess)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceDataIntegrationProcess, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceDataIntegrationProcess, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceDataIntegrationProcess>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceDataIntegrationProcess.class.getClassLoader(),
			CommerceDataIntegrationProcess.class, ModelWrapper.class);

		try {
			Constructor<CommerceDataIntegrationProcess> constructor =
				(Constructor<CommerceDataIntegrationProcess>)
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
		<String, Function<CommerceDataIntegrationProcess, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommerceDataIntegrationProcess, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceDataIntegrationProcess, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<CommerceDataIntegrationProcess, Object>>();
		Map<String, BiConsumer<CommerceDataIntegrationProcess, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceDataIntegrationProcess, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", CommerceDataIntegrationProcess::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CommerceDataIntegrationProcess, Long>)
				CommerceDataIntegrationProcess::setMvccVersion);
		attributeGetterFunctions.put(
			"commerceDataIntegrationProcessId",
			CommerceDataIntegrationProcess::
				getCommerceDataIntegrationProcessId);
		attributeSetterBiConsumers.put(
			"commerceDataIntegrationProcessId",
			(BiConsumer<CommerceDataIntegrationProcess, Long>)
				CommerceDataIntegrationProcess::
					setCommerceDataIntegrationProcessId);
		attributeGetterFunctions.put(
			"companyId", CommerceDataIntegrationProcess::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceDataIntegrationProcess, Long>)
				CommerceDataIntegrationProcess::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CommerceDataIntegrationProcess::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceDataIntegrationProcess, Long>)
				CommerceDataIntegrationProcess::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceDataIntegrationProcess::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceDataIntegrationProcess, String>)
				CommerceDataIntegrationProcess::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceDataIntegrationProcess::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceDataIntegrationProcess, Date>)
				CommerceDataIntegrationProcess::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommerceDataIntegrationProcess::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceDataIntegrationProcess, Date>)
				CommerceDataIntegrationProcess::setModifiedDate);
		attributeGetterFunctions.put(
			"name", CommerceDataIntegrationProcess::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CommerceDataIntegrationProcess, String>)
				CommerceDataIntegrationProcess::setName);
		attributeGetterFunctions.put(
			"type", CommerceDataIntegrationProcess::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<CommerceDataIntegrationProcess, String>)
				CommerceDataIntegrationProcess::setType);
		attributeGetterFunctions.put(
			"typeSettings", CommerceDataIntegrationProcess::getTypeSettings);
		attributeSetterBiConsumers.put(
			"typeSettings",
			(BiConsumer<CommerceDataIntegrationProcess, String>)
				CommerceDataIntegrationProcess::setTypeSettings);
		attributeGetterFunctions.put(
			"system", CommerceDataIntegrationProcess::getSystem);
		attributeSetterBiConsumers.put(
			"system",
			(BiConsumer<CommerceDataIntegrationProcess, Boolean>)
				CommerceDataIntegrationProcess::setSystem);
		attributeGetterFunctions.put(
			"active", CommerceDataIntegrationProcess::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<CommerceDataIntegrationProcess, Boolean>)
				CommerceDataIntegrationProcess::setActive);
		attributeGetterFunctions.put(
			"cronExpression",
			CommerceDataIntegrationProcess::getCronExpression);
		attributeSetterBiConsumers.put(
			"cronExpression",
			(BiConsumer<CommerceDataIntegrationProcess, String>)
				CommerceDataIntegrationProcess::setCronExpression);
		attributeGetterFunctions.put(
			"startDate", CommerceDataIntegrationProcess::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate",
			(BiConsumer<CommerceDataIntegrationProcess, Date>)
				CommerceDataIntegrationProcess::setStartDate);
		attributeGetterFunctions.put(
			"endDate", CommerceDataIntegrationProcess::getEndDate);
		attributeSetterBiConsumers.put(
			"endDate",
			(BiConsumer<CommerceDataIntegrationProcess, Date>)
				CommerceDataIntegrationProcess::setEndDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getCommerceDataIntegrationProcessId() {
		return _commerceDataIntegrationProcessId;
	}

	@Override
	public void setCommerceDataIntegrationProcessId(
		long commerceDataIntegrationProcessId) {

		_commerceDataIntegrationProcessId = commerceDataIntegrationProcessId;
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
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
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
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
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

	@JSON
	@Override
	public boolean getSystem() {
		return _system;
	}

	@JSON
	@Override
	public boolean isSystem() {
		return _system;
	}

	@Override
	public void setSystem(boolean system) {
		_system = system;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;
	}

	@JSON
	@Override
	public String getCronExpression() {
		if (_cronExpression == null) {
			return "";
		}
		else {
			return _cronExpression;
		}
	}

	@Override
	public void setCronExpression(String cronExpression) {
		_cronExpression = cronExpression;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceDataIntegrationProcess.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceDataIntegrationProcess toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceDataIntegrationProcess>
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
		CommerceDataIntegrationProcessImpl commerceDataIntegrationProcessImpl =
			new CommerceDataIntegrationProcessImpl();

		commerceDataIntegrationProcessImpl.setMvccVersion(getMvccVersion());
		commerceDataIntegrationProcessImpl.setCommerceDataIntegrationProcessId(
			getCommerceDataIntegrationProcessId());
		commerceDataIntegrationProcessImpl.setCompanyId(getCompanyId());
		commerceDataIntegrationProcessImpl.setUserId(getUserId());
		commerceDataIntegrationProcessImpl.setUserName(getUserName());
		commerceDataIntegrationProcessImpl.setCreateDate(getCreateDate());
		commerceDataIntegrationProcessImpl.setModifiedDate(getModifiedDate());
		commerceDataIntegrationProcessImpl.setName(getName());
		commerceDataIntegrationProcessImpl.setType(getType());
		commerceDataIntegrationProcessImpl.setTypeSettings(getTypeSettings());
		commerceDataIntegrationProcessImpl.setSystem(isSystem());
		commerceDataIntegrationProcessImpl.setActive(isActive());
		commerceDataIntegrationProcessImpl.setCronExpression(
			getCronExpression());
		commerceDataIntegrationProcessImpl.setStartDate(getStartDate());
		commerceDataIntegrationProcessImpl.setEndDate(getEndDate());

		commerceDataIntegrationProcessImpl.resetOriginalValues();

		return commerceDataIntegrationProcessImpl;
	}

	@Override
	public int compareTo(
		CommerceDataIntegrationProcess commerceDataIntegrationProcess) {

		int value = 0;

		value = DateUtil.compareTo(
			getModifiedDate(),
			commerceDataIntegrationProcess.getModifiedDate());

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

		if (!(object instanceof CommerceDataIntegrationProcess)) {
			return false;
		}

		CommerceDataIntegrationProcess commerceDataIntegrationProcess =
			(CommerceDataIntegrationProcess)object;

		long primaryKey = commerceDataIntegrationProcess.getPrimaryKey();

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
		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;
		_originalName = _name;

		_originalType = _type;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceDataIntegrationProcess> toCacheModel() {
		CommerceDataIntegrationProcessCacheModel
			commerceDataIntegrationProcessCacheModel =
				new CommerceDataIntegrationProcessCacheModel();

		commerceDataIntegrationProcessCacheModel.mvccVersion = getMvccVersion();

		commerceDataIntegrationProcessCacheModel.
			commerceDataIntegrationProcessId =
				getCommerceDataIntegrationProcessId();

		commerceDataIntegrationProcessCacheModel.companyId = getCompanyId();

		commerceDataIntegrationProcessCacheModel.userId = getUserId();

		commerceDataIntegrationProcessCacheModel.userName = getUserName();

		String userName = commerceDataIntegrationProcessCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceDataIntegrationProcessCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceDataIntegrationProcessCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commerceDataIntegrationProcessCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceDataIntegrationProcessCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceDataIntegrationProcessCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		commerceDataIntegrationProcessCacheModel.name = getName();

		String name = commerceDataIntegrationProcessCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commerceDataIntegrationProcessCacheModel.name = null;
		}

		commerceDataIntegrationProcessCacheModel.type = getType();

		String type = commerceDataIntegrationProcessCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			commerceDataIntegrationProcessCacheModel.type = null;
		}

		commerceDataIntegrationProcessCacheModel.typeSettings =
			getTypeSettings();

		String typeSettings =
			commerceDataIntegrationProcessCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			commerceDataIntegrationProcessCacheModel.typeSettings = null;
		}

		commerceDataIntegrationProcessCacheModel.system = isSystem();

		commerceDataIntegrationProcessCacheModel.active = isActive();

		commerceDataIntegrationProcessCacheModel.cronExpression =
			getCronExpression();

		String cronExpression =
			commerceDataIntegrationProcessCacheModel.cronExpression;

		if ((cronExpression != null) && (cronExpression.length() == 0)) {
			commerceDataIntegrationProcessCacheModel.cronExpression = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			commerceDataIntegrationProcessCacheModel.startDate =
				startDate.getTime();
		}
		else {
			commerceDataIntegrationProcessCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			commerceDataIntegrationProcessCacheModel.endDate =
				endDate.getTime();
		}
		else {
			commerceDataIntegrationProcessCacheModel.endDate = Long.MIN_VALUE;
		}

		return commerceDataIntegrationProcessCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceDataIntegrationProcess, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceDataIntegrationProcess, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceDataIntegrationProcess, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceDataIntegrationProcess)this));
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
		Map<String, Function<CommerceDataIntegrationProcess, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceDataIntegrationProcess, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceDataIntegrationProcess, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceDataIntegrationProcess)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommerceDataIntegrationProcess>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _commerceDataIntegrationProcessId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _originalName;
	private String _type;
	private String _originalType;
	private String _typeSettings;
	private boolean _system;
	private boolean _active;
	private String _cronExpression;
	private Date _startDate;
	private Date _endDate;
	private long _columnBitmask;
	private CommerceDataIntegrationProcess _escapedModel;

}