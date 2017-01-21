import java.util.StringTokenizer;


public class Calculator {
    public static final int CHARACTER_NOT_OCCUR = -1;
    public static final int CHARACTER_NEGATIVE_NUMBER = 0;

    public String executeOperation(String input){
        String result = selectOperation(input);
        return result;
    }

    private String selectOperation(String input){
        while(anyOperation (input)){
            if(existParenthesis(input)){
                OperationParenthesis operation = new OperationParenthesis(input);
                input = operation.result();
            }if(existExponential(input)){
                OperationExponential operation = new OperationExponential(input);
                input = operation.result();
            }else if(existMultiply(input) || existDivide(input)){
                OperationWithPriority operation = new OperationWithPriority(input);
                input = operation.result();
            }else{
                Operation operation = new Operation(input);
                input = operation.result();
            }
        }
        return deleteDecimalZero(input);
    }

    private boolean existExponential(String input) {
        int result = input.indexOf(Constans.EXPONENTIAL);
        if(result != CHARACTER_NOT_OCCUR){
            return  true;
        }
        return false;
    }

    private String deleteDecimalZero(String entrada) {
        if(entrada.indexOf(Constans.POINT) >= 0){
            StringTokenizer str = new StringTokenizer(entrada, Constans.POINT);
            String integerPart = str.nextToken();
            String decimalPart = str.nextToken();
            if("0".equals(decimalPart)){
                return integerPart;
            }
        }
        return entrada;
    }

    private boolean existParenthesis(String input) {
        int result = input.indexOf(Constans.PARENTHESIS_START);
        if(result != CHARACTER_NOT_OCCUR){
            return  true;
        }
        return false;
    }

    private boolean anyOperation (String input){
        if(existAdd(input) || existSubtract(input) || existMultiply(input) || existDivide(input) || existExponential(input)){
            return true;
        }
        return false;
    }

    private boolean existDivide(String input) {
        int result = input.indexOf(Constans.OPERATOR_DIVIDE);
        if(result != CHARACTER_NOT_OCCUR){
            return  true;
        }
        return false;
    }

    private boolean existMultiply(String input) {
        int result = input.indexOf(Constans.OPERATOR_MULTIPLY);
        if(result != CHARACTER_NOT_OCCUR){
            return  true;
        }
        return false;
    }

    private boolean existSubtract(String input) {
        int result = input.lastIndexOf(Constans.OPERATOR_SUBTRACT);
        if(result != CHARACTER_NOT_OCCUR && result != CHARACTER_NEGATIVE_NUMBER){
            return  true;
        }
        return false;
    }

    private boolean existAdd(String input) {
        int result = input.indexOf(Constans.OPERATOR_ADD);
        if(result != CHARACTER_NOT_OCCUR){
            return  true;
        }
        return false;
    }
}