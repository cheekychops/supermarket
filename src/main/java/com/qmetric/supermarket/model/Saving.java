package com.qmetric.supermarket.model;

import java.math.BigDecimal;

class Saving {

	private final SpecialOffer specialOffer;
	private final BigDecimal count;

	Saving(SpecialOffer specialOffer, int count) {
		this.specialOffer = specialOffer;
		this.count = BigDecimal.valueOf(count);
	}

	BigDecimal getSaving() {
		return specialOffer.getSaving().multiply(count);
	}

}
