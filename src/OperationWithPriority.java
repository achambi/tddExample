
public class OperationWithPriority {
    private final String input;

    public OperationWithPriority(String input){
        this.input = input;
    }

    public String result(){
        String result = "";
        boolean finish = false;
        int positionOperator = 0;
        while(!finish){
            String character = this.input.substring(positionOperator,positionOperator+1);
            if(Constants.OPERATOR_MULTIPLY.equals(character) || Constants.OPERATOR_DIVIDE.equals(character)){
                int startPosition = searchStartPositionOperation(positionOperator, this.input);
                int endPosition = searchEndPositionOperation(positionOperator, this.input);
                OperationSimple operation = new OperationSimple(this.input.substring(startPosition,endPosition));
                String resultOperation = operation.result();
                result = this.input.substring(0,startPosition) + resultOperation + this.input.substring(endPosition);
                finish = true;
            }
            positionOperator++;
        }
        return  result;
    }

    private int searchEndPositionOperation(int start, String input) {
        int endPosition = start+1;
        boolean finish = false;
        for(int cont = start+2;cont<=input.length() && !finish;cont++){
            String character = input.substring(cont - 1, cont);
            try{
                Integer.parseInt(character);
                endPosition = cont;
            }catch (NumberFormatException e){
                if(!isPoint(character)){
                    finish = true;
                }
            }
        }
        return endPosition;
    }

    private int searchStartPositionOperation(int start, String input) {
        int startPosition = start-1;
        boolean finish = false;
        for(int cont = start-1;cont>=0 && !finish;cont--){
            String character = input.substring(cont, cont + 1);
            try{
                Integer.parseInt(character);
                startPosition = cont;
            }catch (NumberFormatException e){
                if(!isPoint(character)){
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
