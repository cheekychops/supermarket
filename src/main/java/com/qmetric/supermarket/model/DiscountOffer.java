package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountOffer extends AbstractOffer {
	private final BigDecimal percentageDiscount;

	public DiscountOffer(Product product, int percentageDiscount) {
		super(product);
		this.percentageDiscount = percentageAsBigDecimal(percentageDiscount);
	}

	private BigDecimal percentageAsBigDecimal(int percentageDiscount) {
		return BigDecimal.valueOf(percentageDiscount).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
	}

	@Override
	public Saving getSaving(ShoppingCart cart) {
		Money productTotal = cart.getLineItems().stream().filter(i -> i.getProduct().equals(getProduct()))
				.map(i -> i.getPrice())
				.reduce(Money.ZERO, Money::add);
		Money discount = productTotal.multiply(percentageDiscount);
		return new Saving(this, discount);
	}
}
