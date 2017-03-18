import java.math.BigDecimal;

/**
 * Add method.
 */
public class Add implements IOperation {
    @Override
    public BigDecimal operation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.add(secondNumber);
    }
}
