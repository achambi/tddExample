/**
 * Created by Roberto on 21/01/2017.
 *
 */
public class OperationExponential {

    private final String input;

    public OperationExponential(String input) {
        this.input = input;
    }

    public String result() {
        int position = this.input.indexOf(Constants.EXPONENTIAL);
        int startPosition = searchStartPositionOperation(position, this.input);
        int endPosition = searchEndPositionOperation(position, this.input);
        String firstNumber = input.substring(startPosition, position);
        String secondNumber = input.substring(position + 1, endPosition);
        double resultOperation = Math.pow(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber));

        String result = this.input.substring(0, startPosition) + resultOperation + this.input.substring(endPosition);
        return result;
    }

    private int searchEndPositionOperation(int start, String input) {
        int endPosition = start + 1;
        boolean finish = false;
        for (int cont = start + 2; cont <= input.length() && !finish; cont++) {
            String character = input.substring(cont - 1, cont);
            try {
                Integer.parseInt(character);
                endPosition = cont;
            } catch (NumberFormatException e) {
                if (!isPoint(character)) {
                    finish = true;
                }
            }
        }
        return endPosition;
    }

    private int searchStartPositionOperation(int start, String input) {
        int startPosition = start - 1;
        boolean finish = false;
        for (int cont = start - 1; cont >= 0 && !finish; cont--) {
            String character = input.substring(cont, cont + 1);
            try {
                Integer.parseInt(character);
                startPosition = cont;
            } catch (NumberFormatException e) {
                if (!isPoint(character)) {
                    finish = true;
                }
            }
        }
        return startPosition;
    }

    private boolean isPoint(String character) {
        return ".".equals(character);
    }
}
