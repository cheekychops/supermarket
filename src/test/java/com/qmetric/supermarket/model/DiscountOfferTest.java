package com.qmetric.supermarket.model;

import static com.qmetric.supermarket.model.TestData.ORANGES;
import static com.qmetric.supermarket.model.TestData.ORANGES_OFFER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class DiscountOfferTest {

	@Test
	public void shouldCalculateSavings() {
		ShoppingCart cart = new ShoppingCart().withItem(ORANGES, Weight.of("0.2"));
		assertThat(ORANGES_OFFER.getSaving(cart), is(new Saving(ORANGES_OFFER, Money.of("0.04"))));
	}

}
