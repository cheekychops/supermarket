package com.qmetric.supermarket.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ShoppingCart {
	private final List<LineItem> items;

	ShoppingCart() {
		this(new ArrayList<>());
	}

	private ShoppingCart(final List<LineItem> items) {
		this.items = items;
	}

	Money getSubtotal() {
		return items.stream().map(LineItem::getPrice).reduce(Money.ZERO, Money::add);
	}

	private ShoppingCart withItem(LineItem item) {
		List<LineItem> newItems = new ArrayList<>(items);
		newItems.add(item);
		return new ShoppingCart(newItems);
	}

	ShoppingCart withItem(Product product) {
		return withItem(new LineItem(product));
	}

	ShoppingCart withItem(Product product, Weight weight) {
		return withItem(new LineItem(product, weight));
	}

	private List<Saving> getSavings(List<Offer> offers) {
		return offers.stream().map(offer -> offer.getSaving(this)).collect(Collectors.toList());
	}

	Money getTotalSavings(List<Offer> offers) {
		return getSavings(offers).stream().map(Saving::getSaving).reduce(Money.ZERO, Money::add);
	}

	Money getTotal(List<Offer> offers) {
		return getSubtotal().subtract(getTotalSavings(offers));
	}

	public List<LineItem> getLineItems() {
		return items;
	}

}
