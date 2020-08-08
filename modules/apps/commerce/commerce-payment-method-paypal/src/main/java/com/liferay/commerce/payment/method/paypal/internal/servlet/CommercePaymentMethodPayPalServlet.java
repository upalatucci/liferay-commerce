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

package com.liferay.commerce.payment.method.paypal.internal.servlet;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.payment.engine.CommercePaymentEngine;
import com.liferay.commerce.payment.engine.CommerceSubscriptionEngine;
import com.liferay.commerce.payment.method.paypal.internal.constants.PayPalCommercePaymentMethodConstants;
import com.liferay.commerce.payment.util.CommercePaymentHttpHelper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Luca Pellizzon
 */
@Component(
	immediate = true,
	property = {
		"osgi.http.whiteboard.context.path=/" + PayPalCommercePaymentMethodConstants.SERVLET_PATH,
		"osgi.http.whiteboard.servlet.name=com.liferay.commerce.payment.method.paypal.internal.servlet.CommercePaymentMethodPayPalServlet",
		"osgi.http.whiteboard.servlet.pattern=/" + PayPalCommercePaymentMethodConstants.SERVLET_PATH + "/*"
	},
	service = Servlet.class
)
public class CommercePaymentMethodPayPalServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, ServletException {

		try {
			HttpSession httpSession = httpServletRequest.getSession();

			if (PortalSessionThreadLocal.getHttpSession() == null) {
				PortalSessionThreadLocal.setHttpSession(httpSession);
			}

			CommerceOrder commerceOrder =
				_commercePaymentHttpHelper.getCommerceOrder(httpServletRequest);

			String paymentId = ParamUtil.getString(
				httpServletRequest, "paymentId");

			boolean cancel = ParamUtil.getBoolean(httpServletRequest, "cancel");

			if (cancel) {
				_commercePaymentEngine.cancelPayment(
					commerceOrder.getCommerceOrderId(), paymentId,
					httpServletRequest);
			}
			else {
				String token = ParamUtil.getString(httpServletRequest, "token");

				if (paymentId.isEmpty() && !token.isEmpty()) {
					_commerceSubscriptionEngine.completeRecurringPayment(
						commerceOrder.getCommerceOrderId(), token,
						httpServletRequest);
				}
				else {
					_commercePaymentEngine.completePayment(
						commerceOrder.getCommerceOrderId(), paymentId,
						httpServletRequest);
				}
			}

			String redirect = ParamUtil.getString(
				httpServletRequest, "redirect");

			httpServletResponse.sendRedirect(redirect);
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePaymentMethodPayPalServlet.class);

	@Reference
	private CommercePaymentEngine _commercePaymentEngine;

	@Reference
	private CommercePaymentHttpHelper _commercePaymentHttpHelper;

	@Reference
	private CommerceSubscriptionEngine _commerceSubscriptionEngine;

}