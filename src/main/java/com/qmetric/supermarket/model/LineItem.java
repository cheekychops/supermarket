package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LineItem {

	private Product product;
	private BigDecimal weight;

	public LineItem(Product product) {
		if (product.isWeighed()) {
			throw new IllegalArgumentException(product.getName() + " needs to be weighed");
		}
		this.product = product;
		this.weight = BigDecimal.ONE;
	}

	public LineItem(Product product, BigDecimal weight) {
		if (!product.isWeighed()) {
			throw new IllegalArgumentException(product.getName() + " is not weighed");
		}
		this.product = product;
		this.weight = weight;
	}

	public BigDecimal getPrice() {
		return weight.multiply(product.getPrice()).setScale(2, RoundingMode.HALF_UP);
	}

	public Product getProduct() {
		return product;
	}

}
