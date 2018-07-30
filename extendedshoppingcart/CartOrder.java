package extendedshoppingcart;

import java.util.ArrayList;
import java.util.List;

public class CartOrder {

	List<Item> list = new ArrayList<>();
	Promotion orderPromotion;

	void addItem(String itemName, int itemPrice, int itemQuantity) {
		Item item = new Item(itemName, itemPrice, itemQuantity);
		list.add(item);
	}

	void removeItem(int index) {
		list.remove(index);
	}

	List<Item> getItems() {
		return list;
	}

	void updateQuantity(int index, int quantity) {
		Item item = list.get(index);
		item.setItemQuantity(quantity);
	}

	int cartBill(String promoCode) {
		int totalAmount = 0;
		for (Item item : list) {
			totalAmount += item.getItemPrice() * item.getItemQuantity();
		}
		orderPromotion = new FixedOrderPromotion();
		orderPromotion.setMinimumPrice(2000);
		orderPromotion.setFixedDiscount(10);
		int discount = applyPromo(orderPromotion, promoCode, totalAmount);
		totalAmount = (totalAmount * (100 - discount)) / 100;
		return totalAmount;
	}

	private int applyPromo(Promotion promotion, String promoCode,
			int totalAmount) {
		int discount = 0;
		if (promotion.isPromotionApplicable(promoCode)
				&& totalAmount >= promotion.getMinimumPrice()) {
			discount = promotion.getFixedDiscount();
			System.out.println("Discount : " + discount);
		}

		return discount;
	}
}