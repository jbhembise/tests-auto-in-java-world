package jbhembise.testauto.junit5;

import java.util.stream.Stream;

import jbhembise.testauto.Calculator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    static Stream<Arguments> createSampleForAdd() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 2, 4),
                Arguments.of(2, 6, 8)
        );
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("createSampleForAdd")
    @Tag("quick")
    void should_add(int a, int b, int c) {
        assertEquals(c, calculator.add(a, b), a + " + " + b + " = " + c);
    }

    @Test
    @Tag("quick")
    void should_substract() {
        assertEquals(3, calculator.substract(5, 2),"5 - 2 = 3");
    }

    @Test
    @Tag("quick")
    void should_multiply() {
        assertEquals(10, calculator.multiply(5, 2), "5 * 2 = 10");
    }

    @Test
    @Tag("quick")
    void should_divide() {
        assertEquals(3, calculator.divide(6, 2), "6 / 2 = 3");
    }

    @Test
    @Tag("quick")
    void should_throw_exception_when_dividing_by_zero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    @Tag("long")
    void should_calculate_fibonacci() {
        assertEquals(8, calculator.fibonacci(6));
    }
}
