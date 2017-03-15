import java.util.StringTokenizer;


class Calculator {
    private static final int CHARACTER_NOT_OCCUR = -1;
    private static final int CHARACTER_NEGATIVE_NUMBER = 0;

    String executeOperation(String input) {
        return selectOperation(input);
    }

    private String selectOperation(String input) {
        while (anyOperation(input)) {
            if (existParenthesis(input)) {
                OperationParenthesis operation = new OperationParenthesis(input);
                input = operation.result();
            }
            if (existExponential(input)) {
                OperationExponential operation = new OperationExponential(input);
                input = operation.result();
            } else if (existMultiply(input) || existDivide(input)) {
                OperationWithPriority operation = new OperationWithPriority(input);
                input = operation.result();
            } else {
                Operation operation = new Operation(input);
                input = operation.result();
            }
        }
        return deleteDecimalZero(input);
    }

    private boolean existExponential(String input) {
        int result = input.indexOf(Constants.EXPONENTIAL);
        return result != CHARACTER_NOT_OCCUR;
    }

    private String deleteDecimalZero(String entrada) {
        if (entrada.contains(Constants.POINT)) {
            StringTokenizer str = new StringTokenizer(entrada, Constants.POINT);
            String integerPart = str.nextToken();
            String decimalPart = str.nextToken();
            if ("0".equals(decimalPart)) {
                return integerPart;
            }
        }
        return entrada;
    }

    private boolean existParenthesis(String input) {
        int result = input.indexOf(Constants.PARENTHESIS_START);
        return result != CHARACTER_NOT_OCCUR;
    }

    private boolean anyOperation(String input) {
        return existAdd(input) || existSubtract(input) || existMultiply(input) || existDivide(input) || existExponential
                (input);
    }

    private boolean existDivide(String input) {
        return input.contains(Constants.OPERATOR_DIVIDE);
    }

    private boolean existMultiply(String input) {
        return input.contains(Constants.OPERATOR_MULTIPLY);
    }

    private boolean existSubtract(String input) {
        int result = input.lastIndexOf(Constants.OPERATOR_SUBTRACT);
        return (result != CHARACTER_NOT_OCCUR) && (result != CHARACTER_NEGATIVE_NUMBER);
    }

    private boolean existAdd(String input) {
        return input.contains(Constants.OPERATOR_ADD);
    }
}