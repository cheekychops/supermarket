package com.qmetric.supermarket.model;

import static com.qmetric.supermarket.model.TestData.BEANS;
import static com.qmetric.supermarket.model.TestData.ORANGES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LineItemTest {

	@Test
	public void shouldCalculateEachPrice() {
		assertThat(new LineItem(BEANS).getPrice(), is(Money.of("0.50")));
	}

	@Test
	public void shouldCalculatePerUnitPrice() {
		assertThat(new LineItem(ORANGES, Weight.of("0.2")).getPrice(), is(Money.of("0.40")));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldThrowExceptionWhenNoWeightGivenWhenNeeded() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Oranges needs to be weighed");
		new LineItem(ORANGES);
	}

	@Test
	public void shouldThrowExceptionWhenWeightGivenWhenNotNeeded() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Beans is not weighed");
		new LineItem(BEANS, Weight.of("0.2"));
	}
}
