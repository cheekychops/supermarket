package com.qmetric.supermarket.model;

import java.math.BigDecimal;

public class Saving {

	private SpecialOffer specialOffer;
	private BigDecimal count;

	public Saving(SpecialOffer specialOffer, int count) {
		this.specialOffer = specialOffer;
		this.count = BigDecimal.valueOf(count);
	}

	public BigDecimal getSaving() {
		return specialOffer.getSaving().multiply(count);
	}

}
