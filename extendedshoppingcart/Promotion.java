package extendedshoppingcart;

public interface Promotion {
	int getMinimumPrice();

	void setMinimumPrice(int minPrice);

	int getFixedDiscount();

	void setFixedDiscount(int fixedDiscount);

	boolean isPromotionApplicable(String promoCode);
}
