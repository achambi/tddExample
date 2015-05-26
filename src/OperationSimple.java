import java.util.HashMap;
import java.util.StringTokenizer;

public class OperationSimple {
    private double firstNumber;
    private double secondNumber;
    private String operator;

    public OperationSimple(String input) {
        StringTokenizer str = new StringTokenizer(input, Constans.DELIM);
        if(isFirstNumerNegative(input)){
            this.firstNumber = Double.parseDouble(Constans.OPERATOR_DEDUCT + str.nextToken());
        }else{
            this.firstNumber = Double.parseDouble(str.nextToken());
        }
        this.secondNumber = Double.parseDouble(str.nextToken());
        this.operator = extractOperator(input);
    }

    private boolean isFirstNumerNegative(String input) {
        return Constans.OPERATOR_DEDUCT.equals(input.substring(0, 1));
    }

    private String extractOperator(String input) {
        String operator ="";
        for(int cont = 1;cont<=input.length();cont++){
            try{
                Integer.parseInt(input.substring(cont-1,cont));
            }catch (NumberFormatException e){
                String character = input.substring(cont-1,cont);
                if((!Constans.OPERATOR_DEDUCT.equals(character) || cont-1 != 0) && !isPoint(character)){
                    operator = input.substring(cont-1,cont);
                }
            }
        }
        return operator;
    }

    private boolean isPoint(String character) {
        return ".".equals(character);
    }

    public String result() {
        HashMap<String,Double> mapOperations = inicialiceMap();
        return Double.toString(mapOperations.get(this.operator));
    }

    private HashMap<String, Double> inicialiceMap() {
        HashMap<String,Double> mapOperations = new HashMap<String, Double>();
        mapOperations.put(Constans.OPERATOR_ADD, add());
        mapOperations.put(Constans.OPERATOR_DEDUCT, deduct());
        mapOperations.put(Constans.OPERATOR_MULTIPLY, multiply());
        mapOperations.put(Constans.OPERATOR_DIVIDE, divide());
        return mapOperations;
    }

    private Double divide() {
        return this.firstNumber/this.secondNumber;
    }

    private Double multiply() {
        return this.firstNumber*this.secondNumber;
    }

    private Double deduct() {
        return this.firstNumber-this.secondNumber;
    }

    private Double add() {
        return this.firstNumber+this.secondNumber;
    }
}
