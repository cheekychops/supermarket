package com.qmetric.supermarket.model;

import java.math.BigDecimal;

public class Product {

	private String name;
	private BigDecimal price;
	private Unit unit;

	public Product(String name, BigDecimal price) {
		this(name, price, Unit.EACH);
	}

	public Product(String name, BigDecimal price, Unit unit) {
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Unit getUnit() {
		return unit;
	}

	public enum Unit {
		EACH, KG
	}

	public boolean isWeighed() {
		return Unit.KG == unit;
	}
}
