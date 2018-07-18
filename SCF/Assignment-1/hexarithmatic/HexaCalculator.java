package hexarithmatic;

public class HexaCalculator implements ArithmaticOperations {

    @Override
    public String add(String firstNumber, String secondNumber) {
        int firstDecimalNumber = HexaCalculator.hexaDecimalToDecimal(firstNumber);
        int secondDecimalNumber = HexaCalculator.hexaDecimalToDecimal(secondNumber);
        int result = firstDecimalNumber + secondDecimalNumber;
        return HexaCalculator.decimalToHexaDecimal(result);
    }

    @Override
    public String subtract(String firstNumber, String secondNumber) {
        int firstDecimalNumber = HexaCalculator.hexaDecimalToDecimal(firstNumber);
        int secondDecimalNumber = HexaCalculator.hexaDecimalToDecimal(secondNumber);
        int result = firstDecimalNumber - secondDecimalNumber;
        return HexaCalculator.decimalToHexaDecimal(result);
    }

    @Override
    public String multiply(String firstNumber, String secondNumber) {
        int firstDecimalNumber = HexaCalculator.hexaDecimalToDecimal(firstNumber);
        int secondDecimalNumber = HexaCalculator.hexaDecimalToDecimal(secondNumber);
        int result = firstDecimalNumber * secondDecimalNumber;
        return HexaCalculator.decimalToHexaDecimal(result);
    }

    @Override
    public String divide(String firstNumber, String secondNumber) throws ArithmeticException {
        int firstDecimalNumber = HexaCalculator.hexaDecimalToDecimal(firstNumber);
        int secondDecimalNumber = HexaCalculator.hexaDecimalToDecimal(secondNumber);
        int result;
        if (secondDecimalNumber == 0) {
            throw new ArithmeticException("Number Can't be divide by zero");
        } else {
            result = firstDecimalNumber / secondDecimalNumber;
        }
        return HexaCalculator.decimalToHexaDecimal(result);
    }

    @Override
    public boolean isEqual(String firstNumber, String secondNumber) {
        int result = firstNumber.compareTo(secondNumber);
        return result == 0;
    }

    @Override
    public boolean isGreater(String firstNumber, String secondNumber) {
        int result = firstNumber.compareTo(secondNumber);
        return result > 0;
    }

    @Override
    public boolean isLess(String firstNumber, String secondNumber) {
        int result = firstNumber.compareTo(secondNumber);
        return result < 0;
    }

    private static int hexaDecimalToDecimal(String hexNumber) {
        int length = hexNumber.length();
        int base = 1;
        int decimalValue = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (hexNumber.charAt(i) >= '0' && hexNumber.charAt(i) <= '9') {
                decimalValue += (hexNumber.charAt(i) - 48) * base;
                base *= 16;
            } else if (hexNumber.charAt(i) >= 'A' && hexNumber.charAt(i) <= 'F') {
                decimalValue += (hexNumber.charAt(i) - 55) * base;
                base = base * 16;
            }
        }
        return decimalValue;
    }

    private static String decimalToHexaDecimal(int decimalNumber) {
        char[] hexaDecimal = new char[10];
        int i = 0;
        while (decimalNumber != 0) {
            int temp = 0;
            temp = decimalNumber % 16;
            if (temp < 10) {
                hexaDecimal[i] = (char) (temp + 48);
                i++;
            } else {
                hexaDecimal[i] = (char) (temp + 55);
                i++;
            }
            decimalNumber = decimalNumber / 16;
        }
        StringBuilder hexNumber = new StringBuilder();
        for (int j = i - 1; j >= 0; j--) {
            hexNumber.append(hexaDecimal[j]);
        }
        return hexNumber.toString();
    }
}
