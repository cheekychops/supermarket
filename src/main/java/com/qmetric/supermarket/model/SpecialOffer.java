package com.qmetric.supermarket.model;

class SpecialOffer {
	private final Product product;
	private final int triggerQuantity;
	private final Money saving;

	SpecialOffer(Product product, int triggerQuantity, Money saving) {
		this.product = product;
		this.triggerQuantity = triggerQuantity;
		this.saving = saving;
	}

	int getTriggerQuantity() {
		return triggerQuantity;
	}

	Money getSaving() {
		return saving;
	}

	Product getProduct() {
		return product;
	}

}
