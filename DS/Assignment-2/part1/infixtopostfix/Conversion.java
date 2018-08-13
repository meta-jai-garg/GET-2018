package part1.infixtopostfix;

import stack.LinkedStack;
import stack.Stack;

public class Conversion {
    private static int getPrecedence(String operator) {
        switch (operator) {
            case "||":
                return 1;
            case "&&":
                return 2;
            case "!=":
            case "==":
                return 3;
            case ">":
            case ">=":
            case "<":
            case "<=":
                return 4;
            case "+":
            case "-":
                return 5;
            case "*":
            case "/":
                return 6;
            case "!":
            case "^":
                return 7;
        }
        return -1;
    }

    private static boolean isValid(String infixExpression) {
        boolean flag = false;
        String[] array = infixExpression.split(" ");
        int characterCount = 0;
        int operatorCount = 0;

        for (String anArray : array) {
            if (("(".equals(anArray)) || (")".equals(anArray))) {
                continue;
            }
            if (isVariable(anArray)) {
                characterCount++;
            }
            if (getPrecedence(anArray) != -1) {
                operatorCount++;
            }
        }
        if (characterCount == operatorCount + 1) {
            flag = true;
        }
        return flag;
    }

    public static String infixToPostfix(String expression) {
        if (!isValid(expression)) {
            throw new AssertionError("Invalid Expression");
        }
        String result = "";
        String[] exp = expression.split(" ");
        Stack<String> stack = new LinkedStack<>();
        for (String anExp : exp) {
            if (isVariable(anExp)) {
                result += anExp + " ";
            } else if ("(".equals(anExp)) {
                stack.push(anExp);
            } else if (")".equals(anExp)) {
                while (!stack.isEmpty() && !("(".equals(stack.peek()))) {
                    result += stack.pop() + " ";
                }
                if (stack.isEmpty() || !("(".equals(stack.peek()))) {
                    throw new AssertionError("invalid expression");
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty()
                        && getPrecedence(anExp) <= getPrecedence(stack.peek())) {
                    result += stack.pop() + " ";
                }
                stack.push(anExp);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }
        return result.trim();
    }

    private static boolean isVariable(String string) {
        for (int i = 0; i < string.length(); i++) {
            int c = string.charAt(i);
            if (!(c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 48
                    && c <= 57)) {
                return false;
            }
        }
        return true;
    }
}