package com.qmetric.supermarket.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void shouldParseAValidString() {
		assertThat(Money.of("12.00"), is(new Money(new BigDecimal("12.00"))));
	}

	@Test
	public void testAdd() {
		assertThat(Money.of("1.00").add(Money.of("1")), is(Money.of("2.00")));
	}

	@Test
	public void testMultiplyInt() {
		assertThat(Money.of("10").multiply(10), is(Money.of("100.00")));
	}

	@Test
	public void testMultiplyBigDecimal() {
		assertThat(Money.of("10").multiply(BigDecimal.TEN), is(Money.of("100.00")));
	}

	@Test
	public void testMultiplyWeight() {
		assertThat(Money.of("10").multiply(Weight.of("0.1")), is(Money.of("1.00")));
	}

}
