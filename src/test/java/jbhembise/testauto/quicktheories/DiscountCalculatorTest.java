package jbhembise.testauto.quicktheories;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import jbhembise.testauto.discount.DiscountCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;

@RunWith(JUnitQuickcheck.class)
public class DiscountCalculatorTest {

    @Test
    public void discountBetween0And499MustBeEqualTo0Percent() {
        qt()
        .forAll(integers().between(0, 499))
        .check(quantity -> DiscountCalculator.calculatePercentage(quantity) == 0);
    }

    @Test
    public void discountBetween500And999MustBeEqualTo5Percent() {
        qt()
                .forAll(integers().between(500, 999))
                .check(quantity -> DiscountCalculator.calculatePercentage(quantity) == 5);
    }

    @Test
    public void discountBetween1000And1999MustBeEqualTo10Percent() {
        qt()
                .forAll(integers().between(1000, 1999))
                .check(quantity -> DiscountCalculator.calculatePercentage(quantity) == 10);
    }

    @Test
    public void discountAfter2000MustBeEqualTo15Percent() {
        qt()
                .forAll(integers().between(2000, Integer.MAX_VALUE))
                .check(quantity -> DiscountCalculator.calculatePercentage(quantity) == 15);
    }
}
