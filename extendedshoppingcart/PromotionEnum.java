package extendedshoppingcart;

import java.util.GregorianCalendar;

public enum PromotionEnum {

	A("A", new GregorianCalendar(2018, 6, 21), new GregorianCalendar(2018, 8, 25));

	private String promoCode;
	private GregorianCalendar startDate, endDate;

	private PromotionEnum(String promoCode, GregorianCalendar startDate,
			GregorianCalendar endDate) {
		this.promoCode = promoCode;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
}