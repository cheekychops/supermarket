package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Money {

	public static final Money ZERO = new Money(BigDecimal.ZERO);

	private BigDecimal amount;

	public Money(BigDecimal amount) {
		this.amount = amount;
	}

	BigDecimal asBigDecimal() {
		return amount;
	}

	static Money of(String amount) {
		return new Money(new BigDecimal(amount));
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true);
	}

	public Money subtract(Money money) {
		return new Money(this.amount.subtract(money.amount));
	}

	public Money add(Money money) {
		return new Money(this.amount.add(money.amount));
	}

	public Money multiply(int count) {
		return multiply(BigDecimal.valueOf(count));
	}

	public Money multiply(BigDecimal bigDecimal) {
		return new Money(amount.multiply(bigDecimal).setScale(2, RoundingMode.HALF_UP));
	}

	public Money multiply(Weight weight) {
		return multiply(weight.asBigDecimal());
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
