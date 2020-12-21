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

import '@testing-library/jest-dom/extend-expect';
import {act, cleanup, fireEvent, render, wait} from '@testing-library/react';
import React from 'react';

import ServiceProvider from '../../../src/main/resources/META-INF/resources/ServiceProvider';
import AddToCartButton from '../../../src/main/resources/META-INF/resources/components/add_to_cart/AddToCartButton';
import {
	CP_INSTANCE_CHANGED,
	CURRENT_ORDER_UPDATED,
	PRODUCT_REMOVED_FROM_CART,
} from '../../../src/main/resources/META-INF/resources/utilities/eventsDefinitions';

jest.mock('../../../src/main/resources/META-INF/resources/ServiceProvider');

describe('AddToCartButton', () => {
	const INITIAL_PROPS = {
		channel: {
			currencyCode: 'USD',
			id: 12345,
		},
		cpInstance: {
			skuId: 12345,
		},
	};

	describe('by display settings', () => {
		let Component;

		beforeEach(() => {
			jest.resetAllMocks();

			window.Liferay.Language.get = jest.fn();
		});

		afterEach(() => {
			cleanup();

			Component = null;
		});

		it('renders by default a large Button element with a text label and an icon with the default class names', () => {
			const DEFAULT_CLASS_NAMES = [
				'btn',
				'btn-lg',
				'btn-add-to-cart',
				'btn-primary',
			];

			Component = render(<AddToCartButton {...INITIAL_PROPS} />);

			const button = Component.container.querySelector('button');
			const icon = Component.container.querySelector('.cart-icon svg');
			const textLabel = Component.container.querySelector(
				'.text-truncate'
			);

			expect(button).toBeInTheDocument();
			expect(icon).toBeInTheDocument();
			expect(textLabel).toBeInTheDocument();

			DEFAULT_CLASS_NAMES.forEach((className) => {
				expect(button.classList.contains(className)).toBe(true);
			});

			expect(window.Liferay.Language.get).toHaveBeenCalledWith(
				'add-to-cart'
			);
		});

		it('renders a default-sized, block-styled Button element with a text label and an icon', () => {
			const DEFAULT_CLASS_NAMES = [
				'btn',
				'btn-add-to-cart',
				'btn-primary',
			];

			const BLOCK_CLASS_NAME = 'btn-block';
			const LARGE_CLASS_NAME = 'btn-lg';

			const settings = {
				block: true,
			};

			Component = render(
				<AddToCartButton {...{...INITIAL_PROPS, settings}} />
			);

			const button = Component.container.querySelector('button');
			const icon = Component.container.querySelector('.cart-icon svg');
			const textLabel = Component.container.querySelector(
				'.text-truncate'
			);

			expect(button).toBeInTheDocument();
			expect(icon).toBeInTheDocument();
			expect(textLabel).toBeInTheDocument();

			expect(button.classList.contains(LARGE_CLASS_NAME)).toBe(false);

			[...DEFAULT_CLASS_NAMES, BLOCK_CLASS_NAME].forEach((className) => {
				expect(button.classList.contains(className)).toBe(true);
			});
		});

		it('renders an icon-only-styled Button element with an icon and no text label', () => {
			const DEFAULT_CLASS_NAMES = [
				'btn',
				'btn-lg',
				'btn-add-to-cart',
				'btn-primary',
			];

			const ICON_ONLY_CLASS_NAME = 'icon-only';

			const settings = {
				iconOnly: true,
			};

			Component = render(
				<AddToCartButton {...{...INITIAL_PROPS, settings}} />
			);

			const button = Component.container.querySelector('button');
			const icon = Component.container.querySelector('.cart-icon svg');
			const textLabel = Component.container.querySelector(
				'.text-truncate'
			);

			expect(button).toBeInTheDocument();
			expect(icon).toBeInTheDocument();

			expect(textLabel).not.toBeInTheDocument();

			[...DEFAULT_CLASS_NAMES, ICON_ONLY_CLASS_NAME].forEach(
				(className) => {
					expect(button.classList.contains(className)).toBe(true);
				}
			);

			expect(window.Liferay.Language.get).not.toHaveBeenCalled();
		});

		it('ignores block-styled button settings, if requested to render an icon-only-styled button', () => {
			const DEFAULT_CLASS_NAMES = [
				'btn',
				'btn-add-to-cart',
				'btn-primary',
			];

			const BLOCK_CLASS_NAME = 'btn-block';
			const ICON_ONLY_CLASS_NAME = 'icon-only';
			const LARGE_CLASS_NAME = 'btn-lg';

			const settings = {
				block: true,
				iconOnly: true,
			};

			Component = render(
				<AddToCartButton {...{...INITIAL_PROPS, settings}} />
			);

			const button = Component.container.querySelector('button');
			const icon = Component.container.querySelector('.cart-icon svg');
			const textLabel = Component.container.querySelector(
				'.text-truncate'
			);

			expect(button).toBeInTheDocument();
			expect(icon).toBeInTheDocument();

			expect(textLabel).not.toBeInTheDocument();

			expect(button.classList.contains(BLOCK_CLASS_NAME)).toBe(false);
			expect(button.classList.contains(LARGE_CLASS_NAME)).toBe(false);

			[...DEFAULT_CLASS_NAMES, ICON_ONLY_CLASS_NAME].forEach(
				(className) => {
					expect(button.classList.contains(className)).toBe(true);
				}
			);
		});

		it('renders a disabled Button element if requested via prop', () => {
			const props = {
				...INITIAL_PROPS,
				settings: {
					disabled: true,
				},
			};

			Component = render(<AddToCartButton {...props} />);

			const element = Component.getByRole('button');

			expect(element).toBeInTheDocument();
			expect(element).toBeDisabled();
		});
	});

	describe('by data flow', () => {
		let Component;

		beforeEach(() => {
			jest.resetAllMocks();
		});

		afterEach(() => {
			cleanup();

			Component = null;
		});

		it("renders a Button element with the 'is-added' class name when an item is already present in an order", () => {
			const DEFAULT_CLASS_NAMES = [
				'btn',
				'btn-lg',
				'btn-add-to-cart',
				'btn-primary',
			];

			const IS_ADDED_CLASS_NAME = 'is-added';

			const cpInstance = {
				...INITIAL_PROPS.cpInstance,
				isInCart: true,
			};

			Component = render(
				<AddToCartButton {...{...INITIAL_PROPS, cpInstance}} />
			);

			const button = Component.container.querySelector('button');

			expect(button).toBeInTheDocument();

			[...DEFAULT_CLASS_NAMES, IS_ADDED_CLASS_NAME].forEach(
				(className) => {
					expect(button.classList.contains(className)).toBe(true);
				}
			);
		});

		it("renders a disabled Button element if no 'accountId' is provided", () => {
			const cpInstance = {
				...INITIAL_PROPS.cpInstance,
				isInCart: true,
			};

			Component = render(
				<AddToCartButton {...{...INITIAL_PROPS, cpInstance}} />
			);

			const element = Component.getByRole('button');

			expect(element).toBeInTheDocument();
			expect(element).toBeDisabled();
		});
	});

	describe('by interaction', () => {
		const INTERACTION_PROPS = {
			...INITIAL_PROPS,
			cpInstance: {
				...INITIAL_PROPS.cpInstance,
				accountId: 12345,
				options: '[]',
				quantity: 1,
			},
		};

		const CART_ITEM = {
			options: INTERACTION_PROPS.cpInstance.options,
			quantity: INTERACTION_PROPS.cpInstance.quantity,
			skuId: INTERACTION_PROPS.cpInstance.skuId,
		};

		let Component;

		beforeEach(() => {
			jest.resetAllMocks();

			ServiceProvider.DeliveryCartAPI = jest.fn().mockReturnValue({
				createCartByChannelId: jest
					.fn()
					.mockReturnValue(Promise.resolve({id: 9999})),
				createItemByCartId: jest.fn(() => Promise.resolve()),
			});

			window.Liferay.fire = jest.fn();
		});

		afterEach(() => {
			cleanup();

			Component = null;
		});

		it("on click, calls the API to add a cpInstance to the current open cart/order if the latter's ID is not '0'", async () => {
			const orderId = 1234;

			Component = render(
				<AddToCartButton {...{...INTERACTION_PROPS, orderId}} />
			);

			await act(async () => {
				fireEvent.click(Component.getByRole('button'));
			});

			await wait(() => {
				expect(
					ServiceProvider.DeliveryCartAPI('v1').createItemByCartId
				).toHaveBeenCalledWith(orderId, CART_ITEM);

				expect(
					window.Liferay.fire
				).toHaveBeenCalledWith(CURRENT_ORDER_UPDATED, {orderId});
			});
		});

		it("on click, if cart/order ID is '0', calls the API to create the order and add a cpInstance to it", async () => {
			Component = render(<AddToCartButton {...{...INTERACTION_PROPS}} />);

			await act(async () => {
				fireEvent.click(Component.getByRole('button'));
			});

			await wait(() => {
				expect(
					ServiceProvider.DeliveryCartAPI('v1').createCartByChannelId
				).toHaveBeenCalledWith(INTERACTION_PROPS.channel.id, {
					accountId: INTERACTION_PROPS.cpInstance.accountId,
					cartItems: [CART_ITEM],
					currencyCode: INTERACTION_PROPS.channel.currencyCode,
				});

				expect(
					window.Liferay.fire
				).toHaveBeenCalledWith(CURRENT_ORDER_UPDATED, {orderId: 9999});
			});
		});

		it(`on '${PRODUCT_REMOVED_FROM_CART}' event, if skuId coincides, it removes the 'is-added' class from the button element`, async () => {
			let removeCBTrigger;

			window.Liferay.on = jest.fn((eventName, callback) => {
				if (eventName === PRODUCT_REMOVED_FROM_CART) {
					removeCBTrigger = callback;
				}
			});

			const props = {
				...INTERACTION_PROPS,
				cpInstance: {
					...INTERACTION_PROPS.cpInstance,
					isInCart: true,
				},
			};

			Component = render(<AddToCartButton {...props} />);

			await act(async () => {
				removeCBTrigger({skuId: INTERACTION_PROPS.cpInstance.skuId});
			});

			await wait(() => {
				const element = Component.getByRole('button');

				expect(element.classList.contains('is-added')).toBe(false);
			});
		});

		it(`on '${PRODUCT_REMOVED_FROM_CART}' event, if skuId does not coincide, it leaves the 'is-added' class from the button element`, async () => {
			let removeCBTrigger;

			window.Liferay.on = jest.fn((eventName, callback) => {
				if (eventName === PRODUCT_REMOVED_FROM_CART) {
					removeCBTrigger = callback;
				}
			});

			const props = {
				...INTERACTION_PROPS,
				cpInstance: {
					...INTERACTION_PROPS.cpInstance,
					isInCart: true,
				},
			};

			Component = render(<AddToCartButton {...props} />);

			await act(async () => {
				removeCBTrigger({skuId: 'fail'});
			});

			await wait(() => {
				const element = Component.getByRole('button');

				expect(element.classList.contains('is-added')).toBe(true);
			});
		});

		it(
			`on '${CP_INSTANCE_CHANGED}' event, calls the API and, if ` +
				'present in the order, updates the local cpInstance and renders' +
				"the button with the 'is-added' class name",
			async () => {
				ServiceProvider.DeliveryCartAPI(
					'v1'
				).getItemById = jest.fn().mockReturnValue(Promise.resolve());

				let resetCBTrigger;

				window.Liferay.on = jest.fn((eventName, callback) => {
					if (eventName === CP_INSTANCE_CHANGED) {
						resetCBTrigger = callback;
					}
				});

				const props = {
					...INTERACTION_PROPS,
					cpInstance: {
						...INTERACTION_PROPS.cpInstance,
					},
				};

				const outerCPInstanceId = 7777;

				Component = render(<AddToCartButton {...props} />);

				await act(async () => {
					resetCBTrigger({cpInstanceId: outerCPInstanceId});
				});

				await wait(() => {
					const element = Component.getByRole('button');

					expect(
						ServiceProvider.DeliveryCartAPI('v1').getItemById
					).toHaveBeenCalledWith(outerCPInstanceId);
					expect(element.classList.contains('is-added')).toBe(true);
				});
			}
		);

		it(
			`on '${CP_INSTANCE_CHANGED}' event, calls the API and, if not ` +
				'present in the order, updates the local cpInstance and renders' +
				"the button without the 'is-added' class name",
			async () => {
				ServiceProvider.DeliveryCartAPI(
					'v1'
				).getItemById = jest.fn().mockReturnValue(Promise.reject());

				let resetCBTrigger;

				window.Liferay.on = jest.fn((eventName, callback) => {
					if (eventName === CP_INSTANCE_CHANGED) {
						resetCBTrigger = callback;
					}
				});

				const props = {
					...INTERACTION_PROPS,
					cpInstance: {
						...INTERACTION_PROPS.cpInstance,
					},
				};

				const outerCPInstanceId = 7777;

				Component = render(<AddToCartButton {...props} />);

				await act(async () => {
					resetCBTrigger({cpInstanceId: outerCPInstanceId});
				});

				await wait(() => {
					const element = Component.getByRole('button');

					expect(
						ServiceProvider.DeliveryCartAPI('v1').getItemById
					).toHaveBeenCalledWith(outerCPInstanceId);
					expect(element.classList.contains('is-added')).toBe(false);
				});
			}
		);
	});
});
