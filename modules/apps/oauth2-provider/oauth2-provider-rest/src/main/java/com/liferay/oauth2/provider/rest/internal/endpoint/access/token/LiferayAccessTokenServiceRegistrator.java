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

package com.liferay.oauth2.provider.rest.internal.endpoint.access.token;

import com.liferay.oauth2.provider.rest.internal.endpoint.liferay.LiferayOAuthDataProvider;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.MapUtil;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.cxf.rs.security.oauth2.provider.AccessTokenGrantHandler;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.FieldOption;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Tomas Polesovsky
 */
@Component(
	immediate = true,
	property = {
		"block.unsecure.requests=true", "can.support.public.clients=true",
		"enabled=true"
	},
	service = {}
)
public class LiferayAccessTokenServiceRegistrator {

	@Activate
	protected void activate(
		BundleContext bundleContext, Map<String, Object> properties) {

		_enabled = MapUtil.getBoolean(properties, "enabled", true);

		if (!_enabled) {
			return;
		}

		_blockUnsecureRequests = MapUtil.getBoolean(
			properties, "block.unsecure.requests", true);
		_canSupportPublicClients = MapUtil.getBoolean(
			properties, "allow.public.clients", true);

		LiferayAccessTokenService liferayAccessTokenService =
			new LiferayAccessTokenService();

		liferayAccessTokenService.setBlockUnsecureRequests(
			_blockUnsecureRequests);
		liferayAccessTokenService.setCanSupportPublicClients(
			_canSupportPublicClients);
		liferayAccessTokenService.setDataProvider(_liferayOAuthDataProvider);
		liferayAccessTokenService.setGrantHandlers(_accessTokenGrantHandlers);

		Dictionary<String, Object> liferayAccessTokenServiceProperties =
			new HashMapDictionary<>();

		liferayAccessTokenServiceProperties.put(
			"osgi.jaxrs.application.select",
			"(osgi.jaxrs.name=Liferay.OAuth2.Application)");
		liferayAccessTokenServiceProperties.put(
			"osgi.jaxrs.name", "Liferay.Access.Token.Service.");
		liferayAccessTokenServiceProperties.put("osgi.jaxrs.resource", true);

		_serviceRegistration = bundleContext.registerService(
			Object.class, liferayAccessTokenService,
			liferayAccessTokenServiceProperties);
	}

	@Deactivate
	protected void deactivate() {
		_enabled = false;

		unregister();
	}

	protected void unregister() {
		if (_serviceRegistration != null) {
			_serviceRegistration.unregister();

			_serviceRegistration = null;
		}
	}

	@Reference(
		cardinality = ReferenceCardinality.AT_LEAST_ONE,
		fieldOption = FieldOption.UPDATE, policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile List<AccessTokenGrantHandler> _accessTokenGrantHandlers =
		new CopyOnWriteArrayList<>();

	private boolean _blockUnsecureRequests;
	private boolean _canSupportPublicClients;
	private volatile boolean _enabled;

	@Reference
	private LiferayOAuthDataProvider _liferayOAuthDataProvider;

	private volatile ServiceRegistration<Object> _serviceRegistration;

}