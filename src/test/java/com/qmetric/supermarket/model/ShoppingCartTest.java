package com.qmetric.supermarket.model;

import static com.qmetric.supermarket.model.TestData.BEANS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void shouldCalculateTotalForEmptyCart() {
		ShoppingCart cart = new ShoppingCart();
		assertThat(cart.getTotal(), is(BigDecimal.ZERO));
	}

	@Test
	public void shouldCalculateTotalForNonEmptyCart() {
		ShoppingCart cart = new ShoppingCart().withItem(BEANS);
		assertThat(cart.getTotal(), is(new BigDecimal("0.50")));
	}


}
