package com.qmetric.supermarket.model;

import static com.qmetric.supermarket.model.TestData.BEANS;
import static com.qmetric.supermarket.model.TestData.COKE;
import static com.qmetric.supermarket.model.TestData.ORANGES;
import static com.qmetric.supermarket.model.TestData.SPECIAL_OFFERS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Collections;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void shouldCalculateSubtotalForEmptyCart() {
		ShoppingCart cart = new ShoppingCart();
		assertThat(cart.getSubtotal(), is(Money.ZERO));
	}

	@Test
	public void shouldCalculateSubtotalForNonEmptyCart() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS);
		assertThat(cart.getSubtotal(), is(Money.of("0.50")));
	}

	@Test
	public void shouldCalculateTotalWithoutOffers() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS);
		assertThat(cart.getTotal(Collections.emptyList()), is(Money.of("0.50")));
	}

	@Test
	public void shouldCalculateTotalWithMultiBuyOffersFullyUtilised() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS).withItem(BEANS).withItem(BEANS);
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("1.00")));
	}

	@Test
	public void shouldCalculateTotalWithMultiBuyOffersUnderUtilised() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS).withItem(BEANS);
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("1.00")));
	}

	@Test
	public void shouldCalculateTotalWithMultiBuyOffersOverUtilised() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS).withItem(BEANS).withItem(BEANS).withItem(BEANS);
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("1.50")));
	}

	@Test
	public void shouldCalculateTotalWithMultiBuyOffersAppliedMoreThanOnce() {
		ShoppingCart cart = new ShoppingCart().withItem(COKE).withItem(COKE).withItem(COKE).withItem(COKE);
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("2.00")));
	}

	@Test
	public void shouldCalculateTotalWithDiscountOffer() {
		ShoppingCart cart = new ShoppingCart().withItem(ORANGES, Weight.of("0.2"));
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("0.36")));
	}

	@Test
	public void acceptanceTest() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS).withItem(BEANS).withItem(BEANS).withItem(COKE)
				.withItem(COKE).withItem(ORANGES, Weight.of("0.2"));
		assertThat(cart.getSubtotal(), is(Money.of("3.30")));
		assertThat(cart.getTotalSavings(SPECIAL_OFFERS), is(Money.of("0.94")));
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("2.36")));
	}

}
