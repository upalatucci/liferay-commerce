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

import com.liferay.commerce.application.model.CommerceApplicationModel;
import com.liferay.commerce.application.model.CommerceApplicationModelModel;
import com.liferay.commerce.application.model.CommerceApplicationModelSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
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
import com.liferay.portal.kernel.util.StringBundler;

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
 * The base model implementation for the CommerceApplicationModel service. Represents a row in the &quot;CommerceApplicationModel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceApplicationModelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceApplicationModelImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceApplicationModelImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceApplicationModelModelImpl
	extends BaseModelImpl<CommerceApplicationModel>
	implements CommerceApplicationModelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce application model model instance should use the <code>CommerceApplicationModel</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceApplicationModel";

	public static final Object[][] TABLE_COLUMNS = {
		{"commerceApplicationModelId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"commerceApplicationBrandId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"year", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceApplicationModelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceApplicationBrandId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("year", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceApplicationModel (commerceApplicationModelId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceApplicationBrandId LONG,name VARCHAR(75) null,year VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceApplicationModel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceApplicationModel.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceApplicationModel.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.application.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.application.model.CommerceApplicationModel"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.application.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.application.model.CommerceApplicationModel"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.application.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.application.model.CommerceApplicationModel"),
		true);

	public static final long COMMERCEAPPLICATIONBRANDID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long NAME_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceApplicationModel toModel(
		CommerceApplicationModelSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceApplicationModel model = new CommerceApplicationModelImpl();

		model.setCommerceApplicationModelId(
			soapModel.getCommerceApplicationModelId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceApplicationBrandId(
			soapModel.getCommerceApplicationBrandId());
		model.setName(soapModel.getName());
		model.setYear(soapModel.getYear());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceApplicationModel> toModels(
		CommerceApplicationModelSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceApplicationModel> models =
			new ArrayList<CommerceApplicationModel>(soapModels.length);

		for (CommerceApplicationModelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.application.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.application.model.CommerceApplicationModel"));

	public CommerceApplicationModelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceApplicationModelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceApplicationModelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceApplicationModelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceApplicationModel.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceApplicationModel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceApplicationModel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceApplicationModel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceApplicationModel, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceApplicationModel)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceApplicationModel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceApplicationModel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceApplicationModel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceApplicationModel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceApplicationModel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceApplicationModel>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceApplicationModel.class.getClassLoader(),
			CommerceApplicationModel.class, ModelWrapper.class);

		try {
			Constructor<CommerceApplicationModel> constructor =
				(Constructor<CommerceApplicationModel>)
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

	private static final Map<String, Function<CommerceApplicationModel, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommerceApplicationModel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceApplicationModel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceApplicationModel, Object>>();
		Map<String, BiConsumer<CommerceApplicationModel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceApplicationModel, ?>>();

		attributeGetterFunctions.put(
			"commerceApplicationModelId",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.
						getCommerceApplicationModelId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceApplicationModelId",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object commerceApplicationModelIdObject) {

					commerceApplicationModel.setCommerceApplicationModelId(
						(Long)commerceApplicationModelIdObject);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object companyIdObject) {

					commerceApplicationModel.setCompanyId(
						(Long)companyIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object userIdObject) {

					commerceApplicationModel.setUserId((Long)userIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object userNameObject) {

					commerceApplicationModel.setUserName(
						(String)userNameObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object createDateObject) {

					commerceApplicationModel.setCreateDate(
						(Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object modifiedDateObject) {

					commerceApplicationModel.setModifiedDate(
						(Date)modifiedDateObject);
				}

			});
		attributeGetterFunctions.put(
			"commerceApplicationBrandId",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.
						getCommerceApplicationBrandId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceApplicationBrandId",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object commerceApplicationBrandIdObject) {

					commerceApplicationModel.setCommerceApplicationBrandId(
						(Long)commerceApplicationBrandIdObject);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object nameObject) {

					commerceApplicationModel.setName((String)nameObject);
				}

			});
		attributeGetterFunctions.put(
			"year",
			new Function<CommerceApplicationModel, Object>() {

				@Override
				public Object apply(
					CommerceApplicationModel commerceApplicationModel) {

					return commerceApplicationModel.getYear();
				}

			});
		attributeSetterBiConsumers.put(
			"year",
			new BiConsumer<CommerceApplicationModel, Object>() {

				@Override
				public void accept(
					CommerceApplicationModel commerceApplicationModel,
					Object yearObject) {

					commerceApplicationModel.setYear((String)yearObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceApplicationModelId() {
		return _commerceApplicationModelId;
	}

	@Override
	public void setCommerceApplicationModelId(long commerceApplicationModelId) {
		_commerceApplicationModelId = commerceApplicationModelId;
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
	public long getCommerceApplicationBrandId() {
		return _commerceApplicationBrandId;
	}

	@Override
	public void setCommerceApplicationBrandId(long commerceApplicationBrandId) {
		_columnBitmask |= COMMERCEAPPLICATIONBRANDID_COLUMN_BITMASK;

		if (!_setOriginalCommerceApplicationBrandId) {
			_setOriginalCommerceApplicationBrandId = true;

			_originalCommerceApplicationBrandId = _commerceApplicationBrandId;
		}

		_commerceApplicationBrandId = commerceApplicationBrandId;
	}

	public long getOriginalCommerceApplicationBrandId() {
		return _originalCommerceApplicationBrandId;
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
	public String getYear() {
		if (_year == null) {
			return "";
		}
		else {
			return _year;
		}
	}

	@Override
	public void setYear(String year) {
		_year = year;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceApplicationModel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceApplicationModel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceApplicationModel>
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
		CommerceApplicationModelImpl commerceApplicationModelImpl =
			new CommerceApplicationModelImpl();

		commerceApplicationModelImpl.setCommerceApplicationModelId(
			getCommerceApplicationModelId());
		commerceApplicationModelImpl.setCompanyId(getCompanyId());
		commerceApplicationModelImpl.setUserId(getUserId());
		commerceApplicationModelImpl.setUserName(getUserName());
		commerceApplicationModelImpl.setCreateDate(getCreateDate());
		commerceApplicationModelImpl.setModifiedDate(getModifiedDate());
		commerceApplicationModelImpl.setCommerceApplicationBrandId(
			getCommerceApplicationBrandId());
		commerceApplicationModelImpl.setName(getName());
		commerceApplicationModelImpl.setYear(getYear());

		commerceApplicationModelImpl.resetOriginalValues();

		return commerceApplicationModelImpl;
	}

	@Override
	public int compareTo(CommerceApplicationModel commerceApplicationModel) {
		int value = 0;

		value = getName().compareTo(commerceApplicationModel.getName());

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

		if (!(object instanceof CommerceApplicationModel)) {
			return false;
		}

		CommerceApplicationModel commerceApplicationModel =
			(CommerceApplicationModel)object;

		long primaryKey = commerceApplicationModel.getPrimaryKey();

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

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;
		_originalCommerceApplicationBrandId = _commerceApplicationBrandId;

		_setOriginalCommerceApplicationBrandId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceApplicationModel> toCacheModel() {
		CommerceApplicationModelCacheModel commerceApplicationModelCacheModel =
			new CommerceApplicationModelCacheModel();

		commerceApplicationModelCacheModel.commerceApplicationModelId =
			getCommerceApplicationModelId();

		commerceApplicationModelCacheModel.companyId = getCompanyId();

		commerceApplicationModelCacheModel.userId = getUserId();

		commerceApplicationModelCacheModel.userName = getUserName();

		String userName = commerceApplicationModelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceApplicationModelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceApplicationModelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commerceApplicationModelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceApplicationModelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceApplicationModelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceApplicationModelCacheModel.commerceApplicationBrandId =
			getCommerceApplicationBrandId();

		commerceApplicationModelCacheModel.name = getName();

		String name = commerceApplicationModelCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commerceApplicationModelCacheModel.name = null;
		}

		commerceApplicationModelCacheModel.year = getYear();

		String year = commerceApplicationModelCacheModel.year;

		if ((year != null) && (year.length() == 0)) {
			commerceApplicationModelCacheModel.year = null;
		}

		return commerceApplicationModelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceApplicationModel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceApplicationModel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceApplicationModel, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CommerceApplicationModel)this));
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
		Map<String, Function<CommerceApplicationModel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceApplicationModel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceApplicationModel, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CommerceApplicationModel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommerceApplicationModel>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _commerceApplicationModelId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceApplicationBrandId;
	private long _originalCommerceApplicationBrandId;
	private boolean _setOriginalCommerceApplicationBrandId;
	private String _name;
	private String _year;
	private long _columnBitmask;
	private CommerceApplicationModel _escapedModel;

}