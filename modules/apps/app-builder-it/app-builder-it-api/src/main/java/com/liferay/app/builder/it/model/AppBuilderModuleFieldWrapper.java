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
 * This class is a wrapper for {@link AppBuilderModuleField}.
 * </p>
 *
 * @author Marco Leo
 * @see AppBuilderModuleField
 * @generated
 */
public class AppBuilderModuleFieldWrapper
	extends BaseModelWrapper<AppBuilderModuleField>
	implements AppBuilderModuleField, ModelWrapper<AppBuilderModuleField> {

	public AppBuilderModuleFieldWrapper(
		AppBuilderModuleField appBuilderModuleField) {

		super(appBuilderModuleField);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("appBuilderModuleFieldId", getAppBuilderModuleFieldId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("appBuilderModuleId", getAppBuilderModuleId());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("dbColumnName", getDbColumnName());
		attributes.put("type", getType());
		attributes.put("typeSettings", getTypeSettings());
		attributes.put("nullable", isNullable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long appBuilderModuleFieldId = (Long)attributes.get(
			"appBuilderModuleFieldId");

		if (appBuilderModuleFieldId != null) {
			setAppBuilderModuleFieldId(appBuilderModuleFieldId);
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

		Long appBuilderModuleId = (Long)attributes.get("appBuilderModuleId");

		if (appBuilderModuleId != null) {
			setAppBuilderModuleId(appBuilderModuleId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String dbColumnName = (String)attributes.get("dbColumnName");

		if (dbColumnName != null) {
			setDbColumnName(dbColumnName);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}

		Boolean nullable = (Boolean)attributes.get("nullable");

		if (nullable != null) {
			setNullable(nullable);
		}
	}

	/**
	 * Returns the app builder module field ID of this app builder module field.
	 *
	 * @return the app builder module field ID of this app builder module field
	 */
	@Override
	public long getAppBuilderModuleFieldId() {
		return model.getAppBuilderModuleFieldId();
	}

	/**
	 * Returns the app builder module ID of this app builder module field.
	 *
	 * @return the app builder module ID of this app builder module field
	 */
	@Override
	public long getAppBuilderModuleId() {
		return model.getAppBuilderModuleId();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this app builder module field.
	 *
	 * @return the company ID of this app builder module field
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this app builder module field.
	 *
	 * @return the create date of this app builder module field
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the db column name of this app builder module field.
	 *
	 * @return the db column name of this app builder module field
	 */
	@Override
	public String getDbColumnName() {
		return model.getDbColumnName();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the label of this app builder module field.
	 *
	 * @return the label of this app builder module field
	 */
	@Override
	public String getLabel() {
		return model.getLabel();
	}

	/**
	 * Returns the localized label of this app builder module field in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized label of this app builder module field
	 */
	@Override
	public String getLabel(java.util.Locale locale) {
		return model.getLabel(locale);
	}

	/**
	 * Returns the localized label of this app builder module field in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized label of this app builder module field. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLabel(java.util.Locale locale, boolean useDefault) {
		return model.getLabel(locale, useDefault);
	}

	/**
	 * Returns the localized label of this app builder module field in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized label of this app builder module field
	 */
	@Override
	public String getLabel(String languageId) {
		return model.getLabel(languageId);
	}

	/**
	 * Returns the localized label of this app builder module field in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized label of this app builder module field
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
	 * Returns a map of the locales and localized labels of this app builder module field.
	 *
	 * @return the locales and localized labels of this app builder module field
	 */
	@Override
	public Map<java.util.Locale, String> getLabelMap() {
		return model.getLabelMap();
	}

	/**
	 * Returns the modified date of this app builder module field.
	 *
	 * @return the modified date of this app builder module field
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this app builder module field.
	 *
	 * @return the name of this app builder module field
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nullable of this app builder module field.
	 *
	 * @return the nullable of this app builder module field
	 */
	@Override
	public boolean getNullable() {
		return model.getNullable();
	}

	/**
	 * Returns the primary key of this app builder module field.
	 *
	 * @return the primary key of this app builder module field
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this app builder module field.
	 *
	 * @return the type of this app builder module field
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the type settings of this app builder module field.
	 *
	 * @return the type settings of this app builder module field
	 */
	@Override
	public String getTypeSettings() {
		return model.getTypeSettings();
	}

	/**
	 * Returns the user ID of this app builder module field.
	 *
	 * @return the user ID of this app builder module field
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this app builder module field.
	 *
	 * @return the user name of this app builder module field
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this app builder module field.
	 *
	 * @return the user uuid of this app builder module field
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this app builder module field.
	 *
	 * @return the uuid of this app builder module field
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this app builder module field is nullable.
	 *
	 * @return <code>true</code> if this app builder module field is nullable; <code>false</code> otherwise
	 */
	@Override
	public boolean isNullable() {
		return model.isNullable();
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
	 * Sets the app builder module field ID of this app builder module field.
	 *
	 * @param appBuilderModuleFieldId the app builder module field ID of this app builder module field
	 */
	@Override
	public void setAppBuilderModuleFieldId(long appBuilderModuleFieldId) {
		model.setAppBuilderModuleFieldId(appBuilderModuleFieldId);
	}

	/**
	 * Sets the app builder module ID of this app builder module field.
	 *
	 * @param appBuilderModuleId the app builder module ID of this app builder module field
	 */
	@Override
	public void setAppBuilderModuleId(long appBuilderModuleId) {
		model.setAppBuilderModuleId(appBuilderModuleId);
	}

	/**
	 * Sets the company ID of this app builder module field.
	 *
	 * @param companyId the company ID of this app builder module field
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this app builder module field.
	 *
	 * @param createDate the create date of this app builder module field
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the db column name of this app builder module field.
	 *
	 * @param dbColumnName the db column name of this app builder module field
	 */
	@Override
	public void setDbColumnName(String dbColumnName) {
		model.setDbColumnName(dbColumnName);
	}

	/**
	 * Sets the label of this app builder module field.
	 *
	 * @param label the label of this app builder module field
	 */
	@Override
	public void setLabel(String label) {
		model.setLabel(label);
	}

	/**
	 * Sets the localized label of this app builder module field in the language.
	 *
	 * @param label the localized label of this app builder module field
	 * @param locale the locale of the language
	 */
	@Override
	public void setLabel(String label, java.util.Locale locale) {
		model.setLabel(label, locale);
	}

	/**
	 * Sets the localized label of this app builder module field in the language, and sets the default locale.
	 *
	 * @param label the localized label of this app builder module field
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
	 * Sets the localized labels of this app builder module field from the map of locales and localized labels.
	 *
	 * @param labelMap the locales and localized labels of this app builder module field
	 */
	@Override
	public void setLabelMap(Map<java.util.Locale, String> labelMap) {
		model.setLabelMap(labelMap);
	}

	/**
	 * Sets the localized labels of this app builder module field from the map of locales and localized labels, and sets the default locale.
	 *
	 * @param labelMap the locales and localized labels of this app builder module field
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLabelMap(
		Map<java.util.Locale, String> labelMap,
		java.util.Locale defaultLocale) {

		model.setLabelMap(labelMap, defaultLocale);
	}

	/**
	 * Sets the modified date of this app builder module field.
	 *
	 * @param modifiedDate the modified date of this app builder module field
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this app builder module field.
	 *
	 * @param name the name of this app builder module field
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets whether this app builder module field is nullable.
	 *
	 * @param nullable the nullable of this app builder module field
	 */
	@Override
	public void setNullable(boolean nullable) {
		model.setNullable(nullable);
	}

	/**
	 * Sets the primary key of this app builder module field.
	 *
	 * @param primaryKey the primary key of this app builder module field
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this app builder module field.
	 *
	 * @param type the type of this app builder module field
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the type settings of this app builder module field.
	 *
	 * @param typeSettings the type settings of this app builder module field
	 */
	@Override
	public void setTypeSettings(String typeSettings) {
		model.setTypeSettings(typeSettings);
	}

	/**
	 * Sets the user ID of this app builder module field.
	 *
	 * @param userId the user ID of this app builder module field
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this app builder module field.
	 *
	 * @param userName the user name of this app builder module field
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this app builder module field.
	 *
	 * @param userUuid the user uuid of this app builder module field
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this app builder module field.
	 *
	 * @param uuid the uuid of this app builder module field
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
	protected AppBuilderModuleFieldWrapper wrap(
		AppBuilderModuleField appBuilderModuleField) {

		return new AppBuilderModuleFieldWrapper(appBuilderModuleField);
	}

}