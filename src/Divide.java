import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * class for divide Operator.
 */
public class Divide implements IOperation {

    @Override
    public BigDecimal operation(BigDecimal firstNumber, BigDecimal secondNumber) throws ArithmeticException {
        return firstNumber.divide(secondNumber, RoundingMode.UNNECESSARY);
    }
}
