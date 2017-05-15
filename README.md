# Shopping Cart Exercise

## Implementation Notes
* Domain classes are immutable
* Only one class of Product - LineItem uses a weight of 1 for non-weighed products
* RoundingMode HALF_UP is used
* IllegalArgumentException can occur if an attempt to add a line item wih a weight for a product that doesn't
require it, or if the weight is not supplied and it is required.
* The Money abstraction does not include a currency, this could be added.
* Now there are two types of Offer - DiscountOffer and MultiBuyOffer




