package com.qmetric.supermarket.model;

import static com.qmetric.supermarket.model.TestData.BEANS;
import static com.qmetric.supermarket.model.TestData.COKE;
import static com.qmetric.supermarket.model.TestData.ORANGES;
import static com.qmetric.supermarket.model.TestData.SPECIAL_OFFERS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;
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
	public void shouldCalculateTotalWithOffersFullyUtilised() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS).withItem(BEANS).withItem(BEANS);
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("1.00")));
	}

	@Test
	public void shouldCalculateTotalWithOffersUnderUtilised() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS).withItem(BEANS);
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("1.00")));
	}

	@Test
	public void shouldCalculateTotalWithOffersOverUtilised() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS).withItem(BEANS).withItem(BEANS).withItem(BEANS);
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("1.50")));
	}

	@Test
	public void shouldCalculateTotalWithOffersAppliedMoreThanOnce() {
		ShoppingCart cart = new ShoppingCart().withItem(COKE).withItem(COKE).withItem(COKE).withItem(COKE);
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("2.00")));
	}

	@Test
	public void acceptanceTest() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS).withItem(BEANS).withItem(BEANS).withItem(COKE)
				.withItem(COKE).withItem(ORANGES, new BigDecimal("0.2"));
		assertThat(cart.getSubtotal(), is(Money.of("3.30")));
		assertThat(cart.getTotalSavings(SPECIAL_OFFERS), is(Money.of("0.90")));
		assertThat(cart.getTotal(SPECIAL_OFFERS), is(Money.of("2.40")));
	}

}
