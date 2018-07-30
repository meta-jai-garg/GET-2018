package extendedshoppingcart;

import java.util.Date;

public class FixedOrderPromotion implements Promotion {
	private int minPrice;
	private int fixedDiscount;

	@Override
	public int getMinimumPrice() {
		return this.minPrice;
	}

	@Override
	public void setMinimumPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	@Override
	public int getFixedDiscount() {
		return this.fixedDiscount;
	}

	@Override
	public void setFixedDiscount(int fixedDiscount) {
		this.fixedDiscount = fixedDiscount;
	}

	@Override
	public boolean isPromotionApplicable(String promoCode) {
		Date currentDate = new Date();
		boolean isApplicable = false;
		PromotionEnum orderPromotion = PromotionEnum.values()[0];
		if (promoCode.equals(orderPromotion.getPromoCode())) {
			if (currentDate.after(orderPromotion.getStartDate().getTime())
					&& currentDate
							.before(orderPromotion.getEndDate().getTime())) {
				isApplicable = true;
			}
		}
		return isApplicable;
	}
}