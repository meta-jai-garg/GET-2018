package hexarithmatic;

public interface ArithmaticOperations {
    String add(String firstNumber, String secondNumber);

    String subtract(String firstNumber, String secondNumber);

    String multiply(String firstNumber, String secondNumber);

    String divide(String firstNumber, String secondNumber) throws ArithmeticException;

    boolean isEqual(String firstNumber, String secondNumber);

    boolean isGreater(String firstNumber, String secondNumber);

    boolean isLess(String firstNumber, String secondNumber);
}
