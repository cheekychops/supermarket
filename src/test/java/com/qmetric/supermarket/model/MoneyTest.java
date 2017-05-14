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

}
