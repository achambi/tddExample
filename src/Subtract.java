import java.math.BigDecimal;

/**
 * Subtract Operator
 */
public class Subtract implements IOperation {
    @Override
    public BigDecimal operation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.subtract(secondNumber);
    }
}
