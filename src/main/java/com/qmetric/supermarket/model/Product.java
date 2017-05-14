package com.qmetric.supermarket.model;

class Product {

	private final String name;
	private final Money price;
	private final Unit unit;

	Product(String name, Money price) {
		this(name, price, Unit.EACH);
	}

	Product(String name, Money price, Unit unit) {
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	String getName() {
		return name;
	}

	Money getPrice() {
		return price;
	}

	enum Unit {
		EACH, KG
	}

	boolean isWeighed() {
		return Unit.KG == unit;
	}
}
