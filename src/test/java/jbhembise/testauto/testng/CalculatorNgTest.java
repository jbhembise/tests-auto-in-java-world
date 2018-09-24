package jbhembise.testauto.testng;

import jbhembise.testauto.calculator.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalculatorNgTest {

    private final Calculator calculator = new Calculator();

    @DataProvider(name = "samples_for_add", parallel = true)
    public Object[][] createSampleForAdd() {
        return new Object[][] {
                { 1, 2, 3 },
                { 2, 2, 4 },
                { 2, 6, 8 }
        };
    }

    @Test(groups = "quick", dataProvider = "samples_for_add")
    void should_add(int a, int b, int c) {
        assertEquals(a + " + " + b + " = " + c, calculator.add(a, b), c);
    }

    @Test(groups = "quick")
    void should_substract() {
        assertEquals("5 - 2 = 3", calculator.substract(5, 2), 3);
    }

    @Test(groups = "quick")
    void should_multiply() {
        assertEquals("5 * 2 = 10", calculator.multiply(5, 2), 10);
    }

    @Test(groups = "quick")
    void should_divide() {
        assertEquals("6 / 2 = 3", calculator.divide(6, 2), 3);
    }

    @Test(groups = "quick", expectedExceptions = ArithmeticException.class)
    void should_throw_exception_when_dividing_by_zero() {
        calculator.divide(6, 0);
    }

    @Test(groups = "long")
    void should_calculate_fibonacci() {
        assertEquals(calculator.fibonacci(6), 8);
    }
}
