package com.qmetric.supermarket.model;

class Saving {

	private final SpecialOffer specialOffer;
	private final int count;

	Saving(SpecialOffer specialOffer, int count) {
		this.specialOffer = specialOffer;
		this.count = count;
	}

	Money getSaving() {
		return specialOffer.getSaving().multiply(count);
	}

}
