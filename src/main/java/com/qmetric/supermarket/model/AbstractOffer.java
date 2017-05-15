package com.qmetric.supermarket.model;

public abstract class AbstractOffer implements Offer {
	private final Product product;

	public AbstractOffer(Product product) {
		super();
		this.product = product;
	}

	Product getProduct() {
		return product;
	}

}
