package shoppingcart;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Order {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CartOrder cart = new CartOrder();
        try {
            do {
                System.out.println("********** Shopping Cart **********");
                System.out.println("1. Add Item in cart");
                System.out.println("2. Remove Item from cart");
                System.out.println("3. Update Item in cart");
                System.out.println("4. See items of cart");
                System.out.println("5. Get Bill of cart");
                System.out.println("6. EXIT");
                System.out.println("\n Enter your choice");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Please enter item's Name, Price, Quantity");
                        String itemName = sc.next();
                        int itemPrice = sc.nextInt();
                        int itemQuantity = sc.nextInt();
                        cart.addItem(itemName, itemPrice, itemQuantity);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter item index to remove");
                        cart.removeItem(sc.nextInt());
                        break;
                    }
                    case 3: {
                        System.out.println("Enter item index to update quantity");
                        int index = sc.nextInt();
                        System.out.println("Please specify quantity");
                        int quantity = sc.nextInt();
                        cart.updateQuantity(index, quantity);
                        break;
                    }
                    case 4: {
                        List<Item> items = cart.getItems();
                        Iterator iterator = items.iterator();
                        System.out.println("Index\tName\tPrice\tQuantity");
                        int i = 0;
                        while (iterator.hasNext()) {
                            System.out.println(i + "\t" + items.get(i).getItemName() + "\t" + items.get(i).getItemPrice() + "\t" + items.get(i).getItemQuantity());
                            i++;
                            iterator.next();
                        }
                        break;
                    }
                    case 5: {
                        System.out.println("Total Amount in Cart: " + cart.cartBill());
                        break;
                    }
                    case 6: {
                        System.exit(0);
                    }
                    default:
                        System.out.println("Enter Valid Option");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
