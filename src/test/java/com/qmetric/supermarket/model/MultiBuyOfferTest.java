package com.qmetric.supermarket.model;

import static com.qmetric.supermarket.model.TestData.COKE;
import static com.qmetric.supermarket.model.TestData.COKE_OFFER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class MultiBuyOfferTest {

	@Test
	public void shouldCalculateSavings() {
		ShoppingCart cart = new ShoppingCart().withItem(COKE).withItem(COKE);
		assertThat(COKE_OFFER.getSaving(cart), is(new Saving(COKE_OFFER, Money.of("0.40"))));
	}

}
