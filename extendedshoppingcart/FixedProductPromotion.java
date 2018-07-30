package extendedshoppingcart;

import java.util.ArrayList;
import java.util.Date;

public class FixedProductPromotion implements Promotion {
	private int minPrice;
	private int fixedDiscount;
	private ArrayList<String> promotionProduct = new ArrayList<String>();

	public void setPromoCode() {
		promotionProduct.add(PromotionEnum.values()[0].toString());
		promotionProduct.add(PromotionEnum.values()[1].toString());
	}

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
		for (PromotionEnum orderPromotion : PromotionEnum.values()) {
			if (promoCode.equals(orderPromotion.getPromoCode())) {
				if (currentDate.after(orderPromotion.getStartDate().getTime())
						&& currentDate.before(orderPromotion.getEndDate()
								.getTime())) {
					isApplicable = true;
				}
			}
		}
		return isApplicable;
	}
}
