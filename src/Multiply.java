import java.math.BigDecimal;

/**
 * Multiply operation.
 */
public class Multiply implements IOperation {
    @Override
    public BigDecimal operation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.multiply(secondNumber);
    }
}
