package com.qmetric.supermarket.model;

import java.math.BigDecimal;

class SpecialOffer {
	private final Product product;
	private final int triggerQuantity;
	private final BigDecimal saving;

	SpecialOffer(Product product, int triggerQuantity, BigDecimal saving) {
		this.product = product;
		this.triggerQuantity = triggerQuantity;
		this.saving = saving;
	}

	int getTriggerQuantity() {
		return triggerQuantity;
	}

	BigDecimal getSaving() {
		return saving;
	}

	Product getProduct() {
		return product;
	}

}
