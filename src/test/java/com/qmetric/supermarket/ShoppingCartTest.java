package com.qmetric.supermarket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;

import org.junit.Test;

import com.qmetric.supermarket.model.ShoppingCart;

public class ShoppingCartTest {

	@Test
	public void shouldCalculateTotalsForEmptyCart() {
		ShoppingCart cart = new ShoppingCart();
		assertThat(cart.getTotal(), is(BigDecimal.ZERO));
	}
}
