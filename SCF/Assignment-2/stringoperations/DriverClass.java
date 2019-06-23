package stringoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringOperations stringOperations = new StringOperations();
        try {
            do {
                System.out.println("1. Equality");
                System.out.println("2. Reverse");
                System.out.println("3. Change Case");
                System.out.println("4. Largest Word");
                System.out.println("5. Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Enter first and second string");
                        String first = in.readLine();
                        String second = in.readLine();
                        System.out.println(stringOperations.isEquals(first, second));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter string to reverse");
                        String string = in.readLine();
                        System.out.println(stringOperations.reverse(string));
                        break;
                    }
                    case 3: {
                        System.out.println("Enter string");
                        String string = in.readLine();
                        System.out.println(stringOperations.changeCase(string));
                        break;
                    }
                    case 4: {
                        System.out.println("Enter String");
                        String string = in.readLine();
                        System.out.println(stringOperations.largestWord(string));
                        break;
                    }
                    case 5: {
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Enter Correct Choice");
                    }

                }
            } while (true);
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }
}
