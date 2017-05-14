package com.qmetric.supermarket.model;

import static com.qmetric.supermarket.model.TestData.BEANS;
import static com.qmetric.supermarket.model.TestData.FIFTY_PENCE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class ProductTest {

	@Test
	public void shouldCalculateEachPrice() {
		assertThat(BEANS.getPrice(), is(FIFTY_PENCE));
	}

}
