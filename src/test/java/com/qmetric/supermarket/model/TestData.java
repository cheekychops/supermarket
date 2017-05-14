package com.qmetric.supermarket.model;

import java.math.BigDecimal;

public interface TestData {
	public static final Product BEANS = new Product("Beans", new BigDecimal("0.50"));
	public static final Product COKE = new Product("Coke", new BigDecimal("0.70"));
	public static final Product ORANGES = new Product("Oranges", new BigDecimal("1.99"), Product.Unit.KG);


}
