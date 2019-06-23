package shoppingcart;

import java.util.*;

public class CartOrder {
    
    List<Item> list = new ArrayList<>();
    
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

    int cartBill() {
        Iterator iterator = list.iterator();
        int i = 0, totalAmount = 0;
        while (iterator.hasNext()) {
            Item item = list.get(i);
            totalAmount += item.getItemQuantity() * item.getItemPrice();
            iterator.next();
            i++;
        }
        return totalAmount;
    }
}
