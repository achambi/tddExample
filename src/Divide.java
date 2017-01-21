import java.math.BigDecimal;

/**
 * Created by Roberto on 21/01/2017.
 */
public class Divide implements IOperation {
    @Override
    public BigDecimal operation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.divide(secondNumber);
    }
}
