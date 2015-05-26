import java.util.StringTokenizer;


public class Calculator {
    public static final int CHARACTER_NOT_OCCUR = -1;
    public static final int CHARACTER_NEGATIVE_NUMBER = 0;

    public String executeOperation(String input){
        String result = selectOperation(input);
        return result;
    }

    private String selectOperation(String input){
        String entrada = input;
        while(anyOperation (entrada)){
            if(existParenthesis(entrada)){
                OperationParenthesis operation = new OperationParenthesis(entrada);
                entrada = operation.result();
            }else if(existMultiply(entrada) || existDivide(entrada)){
                OperationWithPriority operation = new OperationWithPriority(entrada);
                entrada = operation.result();
            }else{
                Operation operation = new Operation(entrada);
                entrada = operation.result();
            }
        }
        return deleteDecimalZero(entrada);
    }

    private String deleteDecimalZero(String entrada) {
        StringTokenizer str = new StringTokenizer(entrada, ".");
        String integerPart = str.nextToken();
        String decimalPart = str.nextToken();
        if("0".equals(decimalPart)){
            return integerPart;
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
        if(existAdd(input) || existDeduct(input) || existMultiply(input) || existDivide(input)){
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

    private boolean existDeduct(String input) {
        int result = input.lastIndexOf(Constans.OPERATOR_DEDUCT);
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