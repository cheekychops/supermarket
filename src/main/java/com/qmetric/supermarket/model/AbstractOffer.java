package com.qmetric.supermarket.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractOffer implements Offer {
	private final Product product;

	public AbstractOffer(Product product) {
		super();
		this.product = product;
	}

	Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
