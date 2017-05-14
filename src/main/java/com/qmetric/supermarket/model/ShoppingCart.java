package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {
	private final List<LineItem> items;

	public ShoppingCart() {
		this(new ArrayList<>());
	}

	ShoppingCart(final List<LineItem> items) {
		this.items = items;
	}

	public BigDecimal getSubtotal() {
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

	public ShoppingCart withItem(Product product, BigDecimal weight) {
		return withItem(new LineItem(product, weight));
	}

	public List<Saving> getSavings(List<SpecialOffer> specialOffers) {
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



	public BigDecimal getTotalSavings(List<SpecialOffer> specialOffers) {
		return getSavings(specialOffers).stream().map(s -> s.getSaving()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal getTotal(List<SpecialOffer> specialOffers) {
		return getSubtotal().subtract(getTotalSavings(specialOffers));
	}

}
