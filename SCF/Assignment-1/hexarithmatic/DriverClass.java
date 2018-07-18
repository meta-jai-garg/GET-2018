package hexarithmatic;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmaticOperations operations = new HexaCalculator();
        System.out.println("\n********** Hexadecimal Operations **********\n");
        System.out.println("Enter First Number");
        String firstNumber = sc.next();
        System.out.println("Enter Second Number");
        String secondNumber = sc.next();
        do {

            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Divide");
            System.out.println("5. Equal");
            System.out.println("6. Greater");
            System.out.println("7. Less");
            System.out.println("8. EXIT");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Addition : " + operations.add(firstNumber, secondNumber));
                    break;
                }
                case 2: {
                    System.out.println("Subtraction : " + operations.subtract(firstNumber, secondNumber));
                    break;
                }
                case 3: {

                    System.out.println("Multiplication : " + operations.multiply(firstNumber, secondNumber));
                    break;
                }
                case 4: {
                    try {
                        System.out.println("Divide : " + operations.divide(firstNumber, secondNumber));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Equal : " + operations.isEqual(firstNumber, secondNumber));
                    break;
                }
                case 6: {
                    System.out.println("Greater: " + operations.isGreater(firstNumber, secondNumber));
                    break;
                }
                case 7: {
                    System.out.println("Less : " + operations.isLess(firstNumber, secondNumber));
                    break;
                }
                case 8: {
                    System.exit(0);
                    break;
                }
            }
        } while (true);
    }
}
