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

import PropTypes from 'prop-types';
import React from 'react';

import {PRODUCT_OPTIONS_CHANGED} from '../../utilities/eventsDefinitions';
import MainImage from './MainImage';
import Overlay from './Overlay';
import Thumbnails from './Thumbnails';

function fetchImage(url) {
	return new Promise((resolve) => {
		const img = new Image();
		img.src = url;
		img.onload = () => resolve(url);
	});
}

export default class Gallery extends React.Component {
	constructor(props) {
		super(props);

		this.state = {
			fullscreen: false,
			images: this.props.images,
			loaded: new Set(),
			loading: false,
			selected: 0,
		};

		this.fullscreenClose = this.fullscreenClose.bind(this);
		this.fullscreenOpen = this.fullscreenOpen.bind(this);
		this.goTo = this.goTo.bind(this);
		this.goToNext = this.goToNext.bind(this);
		this.goToPrev = this.goToPrev.bind(this);
		this.imageLoad = this.imageLoad.bind(this);
		this.imageSelect = this.imageSelect.bind(this);
		this._handleImagesUpdate = this._handleImagesUpdate.bind(this);
	}

	componentDidMount() {
		Liferay.on(PRODUCT_OPTIONS_CHANGED, this._handleImagesUpdate, this);
	}

	componentWillUnmount() {
		Liferay.detach(PRODUCT_OPTIONS_CHANGED, this._handleImagesUpdate, this);
	}

	_handleImagesUpdate(e) {
		if (e.images) {
			this.setState({
				images: e.images,
				selected: 0,
			});
		}
	}

	fullscreenOpen() {
		if (!this.state.loading) {
			this.imageLoad(this.state.images[this.state.selected].url).then(
				() => {
					this.setState({fullscreen: true});
				}
			);
		}
	}

	fullscreenClose() {
		this.setState({fullscreen: false});
	}

	goTo(pos) {
		this.imageSelect(
			(this.state.images.length + pos) % this.state.images.length
		);
	}

	goToPrev(e) {
		e.stopPropagation();
		this.goTo(this.state.selected - 1);
	}

	goToNext(e) {
		e.stopPropagation();
		this.goTo(this.state.selected + 1);
	}

	imageLoad(imageUrl) {
		return new Promise((resolve) => {
			if (this.state.loaded.has(imageUrl)) {
				resolve(imageUrl);
			}
			else {
				this.setState({loading: true});
				fetchImage(imageUrl).then(() => {
					this.setState(
						{
							loaded: new Set(this.state.loaded).add(imageUrl),
							loading: false,
						},
						() => {
							resolve(imageUrl);
						}
					);
				});
			}
		});
	}

	imageSelect(toSelect) {
		if (toSelect !== this.state.selected && !this.state.loading) {
			this.imageLoad(this.state.images[toSelect].url).then(() => {
				this.setState({selected: toSelect});
			});
		}
	}

	render() {
		const {background} = this.props;
		const {fullscreen, images, loading, selected} = this.state;

		return (
			<div className="product-gallery">
				{images && images.length > 0 && (
					<MainImage
						background={background}
						loading={loading}
						onNext={images.length > 1 ? this.goToNext : null}
						onPrev={images.length > 1 ? this.goToPrev : null}
						onZoom={this.fullscreenOpen}
						src={images[selected].url}
						title={images[selected].title}
					/>
				)}

				{images.length > 1 ? (
					<Thumbnails
						background={background}
						images={images}
						onChange={this.imageSelect}
						selected={selected}
					/>
				) : null}

				{fullscreen ? (
					<Overlay
						background={background}
						onClose={this.fullscreenClose}
						onNext={images.length > 1 ? this.goToNext : null}
						onPrev={images.length > 1 ? this.goToPrev : null}
						src={images[selected].url}
						title={images[selected].title}
					/>
				) : null}
			</div>
		);
	}
}

Gallery.propTypes = {
	background: PropTypes.string,
	images: PropTypes.arrayOf(
		PropTypes.shape({
			thumbnailUrl: PropTypes.string.isRequired,
			title: PropTypes.string.isRequired,
			url: PropTypes.string.isRequired,
		})
	),
};
