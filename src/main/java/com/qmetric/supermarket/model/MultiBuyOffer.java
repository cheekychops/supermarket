package com.qmetric.supermarket.model;

import java.util.stream.Collectors;

class MultiBuyOffer extends AbstractOffer {
	private final int triggerQuantity;
	private final Money discount;

	MultiBuyOffer(Product product, int triggerQuantity, Money discount) {
		super(product);
		this.triggerQuantity = triggerQuantity;
		this.discount = discount;
	}

	@Override
	public Saving getSaving(ShoppingCart cart) {
		int quantity = cart.getLineItems().stream().filter(i -> i.getProduct().equals(getProduct()))
				.collect(Collectors.counting())
				.intValue();
		int hits = quantity / triggerQuantity;
		return new Saving(this, discount.multiply(hits));
	}

}
