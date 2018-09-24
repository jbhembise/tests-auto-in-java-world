package jbhembise.testauto.junitquickcheck;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import jbhembise.testauto.discount.DiscountCalculator;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class DiscountCalculatorTest {

    @Property
    public void discountBetween0And499MustBeEqualTo0Percent(@InRange(maxInt = 499) int quantity) {
        assertEquals(0, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 0");
    }

    @Property
    public void discountBetween500And999MustBeEqualTo5Percent(@InRange(minInt = 500, maxInt = 999) int quantity) {
        assertEquals(5, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity +" must be equal to 5");
    }

    @Property
    public void discountBetween1000And1999MustBeEqualTo10Percent(@InRange(minInt = 1000, maxInt = 1999) int quantity) {
        assertEquals(10, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 10");
    }

    @Property
    public void discountAfter2000MustBeEqualTo15Percent(@InRange(minInt = 2000) int quantity) {
        assertEquals(15, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 15");
    }
}
