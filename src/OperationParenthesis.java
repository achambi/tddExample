
 class OperationParenthesis {
    private static final int COUNTER_START_PARENTHESIS = 1;
    private static final int COUNTER_END_PARENTHESIS = 0;
    private final String input;

    OperationParenthesis(String input) {
        this.input = input;
    }

    String result() {
        int startParenthesis = searchStartParenthesis(this.input);
        int endParenthesis = searchEndParenthesis(this.input);
        String parenthesisOperation = this.input.substring(startParenthesis + 1, endParenthesis);
        Calculator calculator = new Calculator();
        String resultOperation = calculator.executeOperation(parenthesisOperation);
        return this.input.substring(0, startParenthesis) + resultOperation + this.input.substring(endParenthesis + 1);
    }

    private int searchEndParenthesis(String input) {
        int cont = input.indexOf(Constants.PARENTHESIS_START);
        boolean finish = false;
        int parenthesisStart = COUNTER_START_PARENTHESIS;
        int parenthesisEnd = COUNTER_END_PARENTHESIS;
        while (!finish) {
            cont++;
            String character = input.substring(cont, cont + 1);
            if (Constants.PARENTHESIS_START.equals(character)) {
                parenthesisStart++;
            }
            if (Constants.PARENTHESIS_EHND.equals(character)) {
                parenthesisEnd++;
                if (parenthesisStart == parenthesisEnd) {
                    finish = true;
                }
            }
        }
        return cont;
    }

    private int searchStartParenthesis(String input) {
        return input.indexOf(Constants.PARENTHESIS_START);
    }
}
