package jbhembise.testauto.junit4;

import jbhembise.testauto.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void should_add() {
        assertEquals("1 + 2 = 3", calculator.add(1, 2), 3);
    }

    @Test
    public void should_substract() {
        assertEquals("5 - 2 = 3", calculator.substract(5, 2), 3);
    }

    @Test
    public void should_multiply() {
        assertEquals("5 * 2 = 10", calculator.multiply(5, 2), 10);
    }

    @Test
    public void should_divide() {
        assertEquals("6 / 2 = 3", calculator.divide(6, 2), 3);
    }

    //@Test(expected = ArithmeticException.class)
    @Test
    public void should_throw_exception_when_dividing_by_zero() {
        try {
            calculator.divide(6, 0);
            fail();
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void should_calculate_fibonacci() {
        assertEquals(calculator.fibonacci(6), 8);
    }
}
