package com.qmetric.supermarket.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface TestData {
	Product BEANS = new Product("Beans", Money.of("0.50"));
	Product COKE = new Product("Coke", Money.of("0.70"));
	Product ORANGES = new Product("Oranges", Money.of("1.99"), Product.Unit.KG);
	SpecialOffer BEANS_OFFER = new SpecialOffer(BEANS, 3, Money.of("0.50"));
	SpecialOffer COKE_OFFER = new SpecialOffer(COKE, 2, Money.of("0.40"));
	List<SpecialOffer> SPECIAL_OFFERS = Stream.of(BEANS_OFFER, COKE_OFFER).collect(Collectors.toList());
}
