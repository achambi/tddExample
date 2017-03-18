
class OperationWithPriority {
    private final String input;

    OperationWithPriority(String input) {
        this.input = input;
    }

    String result() {
        String result = "";
        boolean finish = false;
        int positionOperator = 0;
        while (!finish) {
            String character = this.input.substring(positionOperator, positionOperator + 1);
            if (Constants.OPERATOR_MULTIPLY.equals(character) || Constants.OPERATOR_DIVIDE.equals(character)) {
                int startPosition = SearchPosition.searchStartPosition(positionOperator, this.input);
                int endPosition = SearchPosition.searchEndPosition(positionOperator, this.input);
                OperationSimple operation = new OperationSimple(this.input.substring(startPosition, endPosition));
                String resultOperation = operation.result();
                result = this.input.substring(0, startPosition) + resultOperation + this.input.substring(endPosition);
                finish = true;
            }
            positionOperator++;
        }
        return result;
    }
}
