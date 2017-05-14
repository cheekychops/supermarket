package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

	ShoppingCart withItem(Product product, BigDecimal weight) {
		return withItem(new LineItem(product, weight));
	}

	private List<Saving> getSavings(List<SpecialOffer> specialOffers) {
		Map<Product, Long> productCounts = getProductCounts();

		return specialOffers.stream().filter(offer -> productCounts.containsKey(offer.getProduct())).map(offer -> {
			int quantity = productCounts.get(offer.getProduct()).intValue();
			int hits = quantity / offer.getTriggerQuantity();
			return new Saving(offer, hits);
		}).collect(Collectors.toList());
	}

	private Map<Product, Long> getProductCounts() {
		return items.stream().collect(Collectors.groupingBy(LineItem::getProduct, Collectors.counting()));
	}

	Money getTotalSavings(List<SpecialOffer> specialOffers) {
		return getSavings(specialOffers).stream().map(Saving::getSaving).reduce(Money.ZERO, Money::add);
	}

	Money getTotal(List<SpecialOffer> specialOffers) {
		return getSubtotal().subtract(getTotalSavings(specialOffers));
	}

}
