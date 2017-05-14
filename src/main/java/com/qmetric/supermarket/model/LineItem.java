package com.qmetric.supermarket.model;

class LineItem {

	private Product product;
	private Weight weight;

	LineItem(Product product) {
		if (product.isWeighed()) {
			throw new IllegalArgumentException(product.getName() + " needs to be weighed");
		}
		this.product = product;
		this.weight = Weight.ONE;
	}

	LineItem(Product product, Weight weight) {
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
