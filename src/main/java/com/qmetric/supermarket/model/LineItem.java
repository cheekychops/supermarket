package com.qmetric.supermarket.model;

import java.math.BigDecimal;

public class LineItem {

	private Product product;

	public LineItem(Product product) {
		this.product = product;
	}

	public BigDecimal getPrice() {
		return product.getPrice();
	}

}
