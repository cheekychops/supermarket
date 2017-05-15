package com.qmetric.supermarket.model;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((offer == null) ? 0 : offer.hashCode());
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
		Saving other = (Saving) obj;
		if (money == null) {
			if (other.money != null) {
				return false;
			}
		} else if (!money.equals(other.money)) {
			return false;
		}
		if (offer == null) {
			if (other.offer != null) {
				return false;
			}
		} else if (!offer.equals(other.offer)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Saving [offer=" + offer + ", money=" + money + "]";
	}

}
