/**
 * Exponential operation.
 */
class OperationExponential {

    private final String input;

    OperationExponential(String input) {
        this.input = input;
    }

    String result() {
        int position = this.input.indexOf(Constants.EXPONENTIAL);
        int startPosition = SearchPosition.searchStartPosition(position, this.input);
        int endPosition = SearchPosition.searchEndPosition(position, this.input);
        String firstNumber = input.substring(startPosition, position);
        String secondNumber = input.substring(position + 1, endPosition);
        double resultOperation = Math.pow(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber));
        return this.input.substring(0, startPosition) + resultOperation + this.input.substring(endPosition);
    }
}
