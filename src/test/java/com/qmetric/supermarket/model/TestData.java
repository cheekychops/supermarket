package com.qmetric.supermarket.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface TestData {
	Product BEANS = new Product("Beans", Money.of("0.50"));
	Product COKE = new Product("Coke", Money.of("0.70"));
	Product ORANGES = new Product("Oranges", Money.of("1.99"), Product.Unit.KG);
	MultiBuyOffer BEANS_OFFER = new MultiBuyOffer(BEANS, 3, Money.of("0.50"));
	MultiBuyOffer COKE_OFFER = new MultiBuyOffer(COKE, 2, Money.of("0.40"));
	DiscountOffer ORANGES_OFFER = new DiscountOffer(ORANGES, 10);
	List<Offer> SPECIAL_OFFERS = Stream.of(BEANS_OFFER, COKE_OFFER, ORANGES_OFFER).collect(Collectors.toList());
}
