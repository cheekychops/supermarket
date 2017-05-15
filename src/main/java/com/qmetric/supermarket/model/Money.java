package com.qmetric.supermarket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		return true;
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
		return amount.toString();
	}

}
