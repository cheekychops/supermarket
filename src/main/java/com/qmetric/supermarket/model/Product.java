package com.qmetric.supermarket.model;

import java.math.BigDecimal;

class Product {

	private final String name;
	private final BigDecimal price;
	private final Unit unit;

	Product(String name, BigDecimal price) {
		this(name, price, Unit.EACH);
	}

	Product(String name, BigDecimal price, Unit unit) {
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	String getName() {
		return name;
	}

	BigDecimal getPrice() {
		return price;
	}

	enum Unit {
		EACH, KG
	}

	boolean isWeighed() {
		return Unit.KG == unit;
	}
}
