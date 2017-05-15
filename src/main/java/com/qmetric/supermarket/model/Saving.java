package com.qmetric.supermarket.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class Saving {

	private final Offer offer;
	private final Money money;

	Saving(Offer offer, Money money) {
		this.offer = offer;
		this.money = money;
	}

	Money getSaving() {
		return money;
	}

	Offer getOffer() {
		return offer;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,  obj,  true);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
