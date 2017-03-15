import java.math.BigDecimal;

/**
 *
 */
public class Multiply implements IOperation {
    @Override
    public BigDecimal operation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.multiply(secondNumber);
    }
}
