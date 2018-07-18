package question1.palindrome;

import question1.StackException;
import question1.stackusingarray.StackArray;

import java.util.Scanner;

public class PalindromeUsingStack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String palString = sc.nextLine();
        char[] str = palString.toCharArray();
        StackArray stackArray = new StackArray(str.length);

        try {
            for (char item : str) {
                stackArray.push(item);
            }
        } catch (StackException e) {
            System.out.println(e.getMessage());
        }

        boolean isPalindrome = true;
        try {
            for (int i = 0; i < str.length; i++) {
                if (stackArray.pop() != str[i]) {
                    isPalindrome = false;
                    break;
                }
            }
        } catch (StackException e) {
            System.out.println(e.getMessage());
        }
        if (isPalindrome)
            System.out.println("String is palindrome.");
        else
            System.out.println("String is not palindrome.");
    }
}
