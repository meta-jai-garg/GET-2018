package part1.postfixevaluation;

import stack.LinkedStack;
import stack.Stack;


public class PostfixEvaluation {

    public int evaluate(String postfixExpression) {
        Stack<Integer> stack = new LinkedStack<>();
        if (isValid(postfixExpression)) {
            String array[] = postfixExpression.split(" ");
            for (String anArray : array) {
                if (isNumber(anArray)) {
                    stack.push(Integer.parseInt(anArray));
                }
                if (isOperator(anArray)) {
                    int firstNumber = stack.pop();
                    int secondNumber = stack.pop();
                    stack.push(performOperation(firstNumber, secondNumber, anArray));
                }
            }
        } else {
            throw new AssertionError("expression invalid");
        }

        return stack.pop();
    }

    @SuppressWarnings("unused")
    private boolean isNumber(String number) {
        try {
            int intNumber = Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean isValid(String postfixExpression) {
        boolean flag = false;
        String[] array = postfixExpression.split(" ");
        int operatorCount = 0;
        int numberCount = 0;
        for (String anArray : array) {
            if (isNumber(anArray)) {
                numberCount++;
            }
            if (isOperator(anArray)) {
                operatorCount++;
            }
        }
        if ((numberCount + operatorCount == array.length)
                && (numberCount == operatorCount + 1)) {
            flag = true;
        }
        return flag;
    }

    private boolean isOperator(String operator) {
        boolean flag = false;
        if (("*".equals(operator)) || ("+".equals(operator)) || ("-".equals(operator)) || ("/".equals(operator))) {
            flag = true;
        }
        return flag;
    }

    private Integer performOperation(int secondNumber, int firstNumber, String operator) {
        int result;
        switch (operator) {
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    throw new AssertionError("Can't Divide By Zero!!!");
                }
                result = firstNumber / secondNumber;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
