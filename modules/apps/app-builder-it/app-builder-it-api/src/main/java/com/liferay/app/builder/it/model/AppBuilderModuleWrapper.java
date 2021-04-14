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

package com.liferay.app.builder.it.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AppBuilderModule}.
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModule
 * @generated
 */
public class AppBuilderModuleWrapper
	extends BaseModelWrapper<AppBuilderModule>
	implements AppBuilderModule, ModelWrapper<AppBuilderModule> {

	public AppBuilderModuleWrapper(AppBuilderModule appBuilderModule) {
		super(appBuilderModule);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("appBuilderModuleId", getAppBuilderModuleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("dbTableName", getDbTableName());
		attributes.put("dbTablePKColumnName", getDbTablePKColumnName());
		attributes.put("scope", getScope());
		attributes.put("resourceName", getResourceName());
		attributes.put("asset", isAsset());
		attributes.put("resource", isResource());
		attributes.put("expando", isExpando());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long appBuilderModuleId = (Long)attributes.get("appBuilderModuleId");

		if (appBuilderModuleId != null) {
			setAppBuilderModuleId(appBuilderModuleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String dbTableName = (String)attributes.get("dbTableName");

		if (dbTableName != null) {
			setDbTableName(dbTableName);
		}

		String dbTablePKColumnName = (String)attributes.get(
			"dbTablePKColumnName");

		if (dbTablePKColumnName != null) {
			setDbTablePKColumnName(dbTablePKColumnName);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String resourceName = (String)attributes.get("resourceName");

		if (resourceName != null) {
			setResourceName(resourceName);
		}

		Boolean asset = (Boolean)attributes.get("asset");

		if (asset != null) {
			setAsset(asset);
		}

		Boolean resource = (Boolean)attributes.get("resource");

		if (resource != null) {
			setResource(resource);
		}

		Boolean expando = (Boolean)attributes.get("expando");

		if (expando != null) {
			setExpando(expando);
		}
	}

	/**
	 * Returns the active of this app builder module.
	 *
	 * @return the active of this app builder module
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the app builder module ID of this app builder module.
	 *
	 * @return the app builder module ID of this app builder module
	 */
	@Override
	public long getAppBuilderModuleId() {
		return model.getAppBuilderModuleId();
	}

	/**
	 * Returns the asset of this app builder module.
	 *
	 * @return the asset of this app builder module
	 */
	@Override
	public boolean getAsset() {
		return model.getAsset();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this app builder module.
	 *
	 * @return the company ID of this app builder module
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this app builder module.
	 *
	 * @return the create date of this app builder module
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the db table name of this app builder module.
	 *
	 * @return the db table name of this app builder module
	 */
	@Override
	public String getDbTableName() {
		return model.getDbTableName();
	}

	/**
	 * Returns the db table pk column name of this app builder module.
	 *
	 * @return the db table pk column name of this app builder module
	 */
	@Override
	public String getDbTablePKColumnName() {
		return model.getDbTablePKColumnName();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the expando of this app builder module.
	 *
	 * @return the expando of this app builder module
	 */
	@Override
	public boolean getExpando() {
		return model.getExpando();
	}

	/**
	 * Returns the label of this app builder module.
	 *
	 * @return the label of this app builder module
	 */
	@Override
	public String getLabel() {
		return model.getLabel();
	}

	/**
	 * Returns the localized label of this app builder module in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized label of this app builder module
	 */
	@Override
	public String getLabel(java.util.Locale locale) {
		return model.getLabel(locale);
	}

	/**
	 * Returns the localized label of this app builder module in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized label of this app builder module. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLabel(java.util.Locale locale, boolean useDefault) {
		return model.getLabel(locale, useDefault);
	}

	/**
	 * Returns the localized label of this app builder module in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized label of this app builder module
	 */
	@Override
	public String getLabel(String languageId) {
		return model.getLabel(languageId);
	}

	/**
	 * Returns the localized label of this app builder module in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized label of this app builder module
	 */
	@Override
	public String getLabel(String languageId, boolean useDefault) {
		return model.getLabel(languageId, useDefault);
	}

	@Override
	public String getLabelCurrentLanguageId() {
		return model.getLabelCurrentLanguageId();
	}

	@Override
	public String getLabelCurrentValue() {
		return model.getLabelCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized labels of this app builder module.
	 *
	 * @return the locales and localized labels of this app builder module
	 */
	@Override
	public Map<java.util.Locale, String> getLabelMap() {
		return model.getLabelMap();
	}

	/**
	 * Returns the modified date of this app builder module.
	 *
	 * @return the modified date of this app builder module
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this app builder module.
	 *
	 * @return the name of this app builder module
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this app builder module.
	 *
	 * @return the primary key of this app builder module
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the resource of this app builder module.
	 *
	 * @return the resource of this app builder module
	 */
	@Override
	public boolean getResource() {
		return model.getResource();
	}

	/**
	 * Returns the resource name of this app builder module.
	 *
	 * @return the resource name of this app builder module
	 */
	@Override
	public String getResourceName() {
		return model.getResourceName();
	}

	/**
	 * Returns the scope of this app builder module.
	 *
	 * @return the scope of this app builder module
	 */
	@Override
	public String getScope() {
		return model.getScope();
	}

	/**
	 * Returns the user ID of this app builder module.
	 *
	 * @return the user ID of this app builder module
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this app builder module.
	 *
	 * @return the user name of this app builder module
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this app builder module.
	 *
	 * @return the user uuid of this app builder module
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this app builder module.
	 *
	 * @return the uuid of this app builder module
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this app builder module is active.
	 *
	 * @return <code>true</code> if this app builder module is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this app builder module is asset.
	 *
	 * @return <code>true</code> if this app builder module is asset; <code>false</code> otherwise
	 */
	@Override
	public boolean isAsset() {
		return model.isAsset();
	}

	/**
	 * Returns <code>true</code> if this app builder module is expando.
	 *
	 * @return <code>true</code> if this app builder module is expando; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpando() {
		return model.isExpando();
	}

	/**
	 * Returns <code>true</code> if this app builder module is resource.
	 *
	 * @return <code>true</code> if this app builder module is resource; <code>false</code> otherwise
	 */
	@Override
	public boolean isResource() {
		return model.isResource();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets whether this app builder module is active.
	 *
	 * @param active the active of this app builder module
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the app builder module ID of this app builder module.
	 *
	 * @param appBuilderModuleId the app builder module ID of this app builder module
	 */
	@Override
	public void setAppBuilderModuleId(long appBuilderModuleId) {
		model.setAppBuilderModuleId(appBuilderModuleId);
	}

	/**
	 * Sets whether this app builder module is asset.
	 *
	 * @param asset the asset of this app builder module
	 */
	@Override
	public void setAsset(boolean asset) {
		model.setAsset(asset);
	}

	/**
	 * Sets the company ID of this app builder module.
	 *
	 * @param companyId the company ID of this app builder module
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this app builder module.
	 *
	 * @param createDate the create date of this app builder module
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the db table name of this app builder module.
	 *
	 * @param dbTableName the db table name of this app builder module
	 */
	@Override
	public void setDbTableName(String dbTableName) {
		model.setDbTableName(dbTableName);
	}

	/**
	 * Sets the db table pk column name of this app builder module.
	 *
	 * @param dbTablePKColumnName the db table pk column name of this app builder module
	 */
	@Override
	public void setDbTablePKColumnName(String dbTablePKColumnName) {
		model.setDbTablePKColumnName(dbTablePKColumnName);
	}

	/**
	 * Sets whether this app builder module is expando.
	 *
	 * @param expando the expando of this app builder module
	 */
	@Override
	public void setExpando(boolean expando) {
		model.setExpando(expando);
	}

	/**
	 * Sets the label of this app builder module.
	 *
	 * @param label the label of this app builder module
	 */
	@Override
	public void setLabel(String label) {
		model.setLabel(label);
	}

	/**
	 * Sets the localized label of this app builder module in the language.
	 *
	 * @param label the localized label of this app builder module
	 * @param locale the locale of the language
	 */
	@Override
	public void setLabel(String label, java.util.Locale locale) {
		model.setLabel(label, locale);
	}

	/**
	 * Sets the localized label of this app builder module in the language, and sets the default locale.
	 *
	 * @param label the localized label of this app builder module
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLabel(
		String label, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setLabel(label, locale, defaultLocale);
	}

	@Override
	public void setLabelCurrentLanguageId(String languageId) {
		model.setLabelCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized labels of this app builder module from the map of locales and localized labels.
	 *
	 * @param labelMap the locales and localized labels of this app builder module
	 */
	@Override
	public void setLabelMap(Map<java.util.Locale, String> labelMap) {
		model.setLabelMap(labelMap);
	}

	/**
	 * Sets the localized labels of this app builder module from the map of locales and localized labels, and sets the default locale.
	 *
	 * @param labelMap the locales and localized labels of this app builder module
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLabelMap(
		Map<java.util.Locale, String> labelMap,
		java.util.Locale defaultLocale) {

		model.setLabelMap(labelMap, defaultLocale);
	}

	/**
	 * Sets the modified date of this app builder module.
	 *
	 * @param modifiedDate the modified date of this app builder module
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this app builder module.
	 *
	 * @param name the name of this app builder module
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this app builder module.
	 *
	 * @param primaryKey the primary key of this app builder module
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this app builder module is resource.
	 *
	 * @param resource the resource of this app builder module
	 */
	@Override
	public void setResource(boolean resource) {
		model.setResource(resource);
	}

	/**
	 * Sets the resource name of this app builder module.
	 *
	 * @param resourceName the resource name of this app builder module
	 */
	@Override
	public void setResourceName(String resourceName) {
		model.setResourceName(resourceName);
	}

	/**
	 * Sets the scope of this app builder module.
	 *
	 * @param scope the scope of this app builder module
	 */
	@Override
	public void setScope(String scope) {
		model.setScope(scope);
	}

	/**
	 * Sets the user ID of this app builder module.
	 *
	 * @param userId the user ID of this app builder module
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this app builder module.
	 *
	 * @param userName the user name of this app builder module
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this app builder module.
	 *
	 * @param userUuid the user uuid of this app builder module
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this app builder module.
	 *
	 * @param uuid the uuid of this app builder module
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AppBuilderModuleWrapper wrap(AppBuilderModule appBuilderModule) {
		return new AppBuilderModuleWrapper(appBuilderModule);
	}

}