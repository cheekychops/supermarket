package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface TestData {
	public static final Product BEANS = new Product("Beans", new BigDecimal("0.50"));
	public static final Product COKE = new Product("Coke", new BigDecimal("0.70"));
	public static final Product ORANGES = new Product("Oranges", new BigDecimal("1.99"), Product.Unit.KG);
	public static final SpecialOffer BEANS_OFFER = new SpecialOffer("Beans 3 for 2", BEANS, 3, new BigDecimal("0.50"));
	public static final SpecialOffer COKE_OFFER = new SpecialOffer("Coke 2 for £1", COKE, 2, new BigDecimal("0.40"));

	public static final List<SpecialOffer> SPECIAL_OFFERS = Stream.of(BEANS_OFFER, COKE_OFFER)
			.collect(Collectors.toList());
}
