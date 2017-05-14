package com.qmetric.supermarket.model;

import java.math.BigDecimal;

public class Weight {

	public static final Weight ZERO = new Weight(BigDecimal.ZERO);
	public static final Weight ONE = new Weight(BigDecimal.ONE);;

	private BigDecimal kg;

	public Weight(BigDecimal kg) {
		this.kg = kg;
	}

	BigDecimal asBigDecimal() {
		return kg;
	}

	static Weight of(String kg) {
		return new Weight(new BigDecimal(kg));
	}

}
