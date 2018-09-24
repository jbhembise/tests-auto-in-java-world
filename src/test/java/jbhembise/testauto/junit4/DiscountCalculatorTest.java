package jbhembise.testauto.junit4;

import jbhembise.testauto.discount.DiscountCalculator;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Theories.class)
public class DiscountCalculatorTest {

    @Theory
    public void discountBetween0And499MustBeEqualTo0Percent(@BetweenInt(max = 499) int quantity) {
        assertEquals(0, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 0");
    }

    @Theory
    public void discountBetween500And999MustBeEqualTo5Percent(@BetweenInt(min = 500, max = 999) int quantity) {
        assertEquals(5, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 5");
    }

    @Theory
    public void discountBetween1000And1999MustBeEqualTo10Percent(@BetweenInt(min = 1000, max = 1999) int quantity) {
        assertEquals(10, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 10");
    }

    @Theory
    public void discountAfter2000MustBeEqualTo15Percent(@BetweenInt(min = 2000) int quantity) {
        assertEquals(15, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 15");
    }
}
