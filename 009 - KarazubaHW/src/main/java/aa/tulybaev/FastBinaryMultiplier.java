package aa.tulybaev;

public class FastBinaryMultiplier {
    public static void executeDemo() {
        String firstOperand = "1000";
        String secondOperand = "10";

        String multiplicationResult = computeProduct(firstOperand, secondOperand);
        System.out.println(convertToDecimalSystem(multiplicationResult));
    }

    private static String computeProduct(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());

        num1 = padWithLeadingZeros(num1, maxLength);
        num2 = padWithLeadingZeros(num2, maxLength);

        if (maxLength == 1) {
            return singleBitOperation(num1, num2);
        }

        int halfLength = maxLength / 2;

        String highPart1 = num1.substring(0, halfLength);
        String lowPart1 = num1.substring(halfLength);
        String highPart2 = num2.substring(0, halfLength);
        String lowPart2 = num2.substring(halfLength);

        String partialResult1 = computeProduct(highPart1, highPart2);
        String partialResult2 = computeProduct(lowPart1, lowPart2);
        String partialResult3 = computeProduct(
                addBinaryValues(highPart1, lowPart1),
                addBinaryValues(highPart2, lowPart2)
        );

        String intermediateValue = subtractBinaryValues(
                subtractBinaryValues(partialResult3, partialResult1),
                partialResult2
        );

        String term1 = appendTrailingZeros(partialResult1, 2 * halfLength);
        String term2 = appendTrailingZeros(intermediateValue, halfLength);
        String sum = addBinaryValues(term1, term2);
        return addBinaryValues(sum, partialResult2);
    }

    private static String padWithLeadingZeros(String input, int targetLength) {
        while (input.length() < targetLength) {
            input = "0" + input;
        }
        return input;
    }

    private static String singleBitOperation(String bit1, String bit2) {
        return (bit1.charAt(0) == '1' && bit2.charAt(0) == '1') ? "1" : "0";
    }

    private static String addBinaryValues(String binary1, String binary2) {
        StringBuilder resultBuilder = new StringBuilder();
        int idx1 = binary1.length() - 1, idx2 = binary2.length() - 1;
        int carryOver = 0;

        while (idx1 >= 0 || idx2 >= 0 || carryOver > 0) {
            int currentSum = carryOver;
            if (idx1 >= 0) currentSum += binary1.charAt(idx1--) - '0';
            if (idx2 >= 0) currentSum += binary2.charAt(idx2--) - '0';
            resultBuilder.append(currentSum % 2);
            carryOver = currentSum / 2;
        }

        return resultBuilder.reverse().toString();
    }

    private static String subtractBinaryValues(String minuend, String subtrahend) {
        minuend = padWithLeadingZeros(minuend, Math.max(minuend.length(), subtrahend.length()));
        subtrahend = padWithLeadingZeros(subtrahend, Math.max(minuend.length(), subtrahend.length()));

        StringBuilder resultBuilder = new StringBuilder();
        int debt = 0;

        for (int i = minuend.length() - 1; i >= 0; --i) {
            int difference = (minuend.charAt(i) - '0') - (subtrahend.charAt(i) - '0') - debt;
            if (difference < 0) {
                difference += 2;
                debt = 1;
            } else {
                debt = 0;
            }
            resultBuilder.append(difference);
        }
        return resultBuilder.reverse().toString().replaceFirst("^0+(?!$)", "");
    }

    private static String appendTrailingZeros(String value, int zeroCount) {
        return value + new String(new char[zeroCount]).replace('\0', '0');
    }

    private static int convertToDecimalSystem(String binaryValue) {
        return Integer.parseInt(binaryValue, 2);
    }

    public static void main(String[] args) {
        executeDemo();
    }
}
