package question1.stackusingarray;

import question1.StackException;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**********Stack Operations**********");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top Element");
            System.out.println("4. Exit");
            System.out.println("Please Enter Your Choice: ");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter an item");
                        char item = sc.next().charAt(0);
                        stack.push(item);
                        break;
                    case 2:
                        System.out.println(stack.pop());
                        break;
                    case 3:
                        System.out.println(stack.top());
                        break;
                    case 4:
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Wrong Option");
                        break;
                }
            } catch (StackException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
