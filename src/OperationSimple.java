import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class OperationSimple {
    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private String operator;
    private DecimalFormat decimalFormat;

    public OperationSimple(String input) {
        StringTokenizer str = new StringTokenizer(input, Constants.DELIM);
        defineDecimalFormat();
        try{
            if(isFirstNumerNegative(input)){
                this.firstNumber = (BigDecimal) decimalFormat.parse(Constants.OPERATOR_SUBTRACT + str.nextToken());
            }else{
                this.firstNumber = (BigDecimal) decimalFormat.parse(str.nextToken());
            }
            this.secondNumber = (BigDecimal) decimalFormat.parse(str.nextToken());
            this.operator = extractOperator(input);
        }catch (ParseException e){

        }
    }

    private void defineDecimalFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);
    }

    private boolean isFirstNumerNegative(String input) {
        return Constants.OPERATOR_SUBTRACT.equals(input.substring(0, 1));
    }

    private String extractOperator(String input) {
        String operator ="";
        for(int cont = 1;cont<=input.length();cont++){
            try{
                Integer.parseInt(input.substring(cont-1,cont));
            }catch (NumberFormatException e){
                String character = input.substring(cont-1,cont);
                if((!Constants.OPERATOR_SUBTRACT.equals(character) || cont-1 != 0) && !isPoint(character)){
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
        HashMap<String,IOperation> mapOperations = inicialiceMap();
        IOperation operation = mapOperations.get(this.operator);
        return operation.operation(this.firstNumber,this.secondNumber).toString();
    }

    private HashMap<String, IOperation> inicialiceMap() {
        HashMap<String,IOperation> mapOperations = new HashMap<String, IOperation>();
        mapOperations.put(Constants.OPERATOR_ADD, new Add());
        mapOperations.put(Constants.OPERATOR_SUBTRACT, new Subtract());
        mapOperations.put(Constants.OPERATOR_MULTIPLY, new Multiply());
        mapOperations.put(Constants.OPERATOR_DIVIDE, new Divide());
        return mapOperations;
    }
}
