package com.qmetric.supermarket.model;

import java.math.BigDecimal;

public class SpecialOffer {
	private String name;
	private Product product;
	private int triggerQuantity;
	private BigDecimal saving;

	public SpecialOffer(String name, Product product, int triggerQuantity, BigDecimal saving) {
		this.name = name;
		this.product = product;
		this.triggerQuantity = triggerQuantity;
		this.saving = saving;
	}

	public String getName() {
		return name;
	}

	public int getTriggerQuantity() {
		return triggerQuantity;
	}

	public BigDecimal getSaving() {
		return saving;
	}

	public Product getProduct() {
		return product;
	}

}
