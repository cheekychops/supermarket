package com.qmetric.supermarket.model;

import java.math.BigDecimal;

class LineItem {

	private Product product;
	private BigDecimal weight;

	LineItem(Product product) {
		if (product.isWeighed()) {
			throw new IllegalArgumentException(product.getName() + " needs to be weighed");
		}
		this.product = product;
		this.weight = BigDecimal.ONE;
	}

	LineItem(Product product, BigDecimal weight) {
		if (!product.isWeighed()) {
			throw new IllegalArgumentException(product.getName() + " is not weighed");
		}
		this.product = product;
		this.weight = weight;
	}

	Money getPrice() {
		return product.getPrice().multiply(weight);
	}

	Product getProduct() {
		return product;
	}

}
