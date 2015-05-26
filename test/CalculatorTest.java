import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void addTest(){
        String operation = "2+4";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo al sumar",result,"6");
    }

    @Test
    public void deductTest(){
        String operation = "4-2";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo al restar",result,"2");
    }

    @Test
    public void multiplyTest(){
        String operation = "10*2";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo al multiplicar",result,"20");
    }

    @Test
    public void divideTest(){
        String operation = "10/2";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo al dividir",result,"5");
    }

    @Test
    public void multiplyOperationsTest(){
        String operation = "5+6-3";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo en multiples operaciones",result,"8");
    }

    @Test
    public void distinOperatorDeductOfNegativeNumber(){
        String operation = "1-11+5";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo en la distincion de numeros negativos",result,"-5");
    }

    @Test
    public void multiplyOperationsWithMultiplyTest(){
        String operation = "5+6*3";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo en multiples operaciones con multiplicaciones",result,"23");
    }

    @Test
    public void multiplyOperationsWithDivideTest(){
        String operation = "5+100/2-5";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo en multiples operaciones con divisiones",result,"50");
    }

    @Test
    public void multiplyOperationsWithMultiplyAndDivideTest(){
        String operation = "4/2*4";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo en multiples operaciones",result,"8");
    }

   @Test
    public void OperationsWithParenthesisTest(){
        String operation = "(4+2+4)*3";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo operacion con parentesis",result,"30");
    }

    @Test
    public void OperationsWithMultiplyParenthesisTest(){
        String operation = "(4+2+4)*3+(142/2)";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo operacion con multiples parentesis",result,"101");
    }

    @Test
    public void resultParenthesisIntoParenthesis(){
        String operation = "(4*(2+4))*3";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo operacion con multiples parentesis",result,"72");
    }

    @Test
    public void resultOperationWithDecimal(){
        String operation = "(4.2*(2.3+4.4))*3.7";

        String result = calculator.executeOperation(operation);

        assertEquals("Fallo operacion con multiples parentesis",result,"104.118");
    }
}