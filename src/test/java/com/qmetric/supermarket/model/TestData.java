package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface TestData {
	Product BEANS = new Product("Beans", new BigDecimal("0.50"));
	Product COKE = new Product("Coke", new BigDecimal("0.70"));
	Product ORANGES = new Product("Oranges", new BigDecimal("1.99"), Product.Unit.KG);
	SpecialOffer BEANS_OFFER = new SpecialOffer(BEANS, 3, new BigDecimal("0.50"));
	SpecialOffer COKE_OFFER = new SpecialOffer(COKE, 2, new BigDecimal("0.40"));
	List<SpecialOffer> SPECIAL_OFFERS = Stream.of(BEANS_OFFER, COKE_OFFER).collect(Collectors.toList());
}
