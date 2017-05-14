package com.qmetric.supermarket.model;

import java.math.BigDecimal;

import com.qmetric.supermarket.model.Product;

public interface TestData {
	public static final BigDecimal FIFTY_PENCE = new BigDecimal("0.50");
	public static final Product BEANS = new Product("Beans", FIFTY_PENCE);


}
