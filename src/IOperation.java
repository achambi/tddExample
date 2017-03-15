import java.math.BigDecimal;

/**
 * Interface Operation.
 */
public interface IOperation {
    BigDecimal operation(BigDecimal firstNumber, BigDecimal secondNumber) throws ArithmeticException;
}
