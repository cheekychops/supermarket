package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private final List<LineItem> items;

	public ShoppingCart() {
		this(new ArrayList<>());
	}

	ShoppingCart(final List<LineItem> items) {
		this.items = items;
	}

	public BigDecimal getTotal() {
		return items.stream().map(i -> i.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public ShoppingCart withItem(LineItem item) {
		List<LineItem> newItems = new ArrayList<>(items);
		newItems.add(item);
		return new ShoppingCart(newItems);
	}

	public ShoppingCart withItem(Product product) {
		return withItem(new LineItem(product));
	}

}
