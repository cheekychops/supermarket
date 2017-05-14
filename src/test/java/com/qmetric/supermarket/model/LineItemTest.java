package com.qmetric.supermarket.model;

import static com.qmetric.supermarket.model.TestData.BEANS;
import static com.qmetric.supermarket.model.TestData.ORANGES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;

import org.junit.Test;

public class LineItemTest {

	@Test
	public void shouldCalculateEachPrice() {
		assertThat(new LineItem(BEANS).getPrice(), is(Money.of("0.50")));
	}

	@Test
	public void shouldCalculatePerUnitPrice() {
		assertThat(new LineItem(ORANGES, new BigDecimal("0.2")).getPrice(), is(Money.of("0.40")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenNoWeightGivenWhenNeeded() {
		new LineItem(ORANGES);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenWeightGivenWhenNotNeeded() {
		new LineItem(BEANS, new BigDecimal("0.2"));
	}
}
