
public class Operation {
    private final String input;

    public Operation(String input){
        this.input = input;
    }

    public String result(){
        boolean fistOperation = true;
        boolean finish = false;
        String candenaOperation ="";
        String remainderOperation = "";

        for(int cont = 1;cont<=this.input.length() && !finish;cont++){
            try{
                candenaOperation += Integer.parseInt(this.input.substring(cont-1,cont));
            }catch (NumberFormatException e){
                String character = this.input.substring(cont-1,cont);
                if(fistOperation){
                    fistOperation = false;
                    if(isFirstNumberNegative(cont, character) || isPoint(character)){
                        fistOperation = true;
                    }
                    candenaOperation += this.input.substring(cont-1,cont);
                }else{
                    if(!isPoint(character)) {
                        finish = true;
                        remainderOperation = this.input.substring(cont - 1);
                    }else{
                        candenaOperation += this.input.substring(cont-1,cont);
                    }
                }
            }
        }
        OperationSimple operation = new OperationSimple(candenaOperation);
        return operation.result() + remainderOperation;
    }

    private boolean isPoint(String character) {
        return ".".equals(character);
    }

    private boolean isFirstNumberNegative(int cont, String character) {
        return Constans.OPERATOR_DEDUCT.equals(character) && cont-1 == 0;
    }
}
