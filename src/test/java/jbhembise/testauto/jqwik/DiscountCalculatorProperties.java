package jbhembise.testauto.jqwik;


import jbhembise.testauto.discount.DiscountCalculator;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountCalculatorProperties {

    // Examples
    @Example
    void discountFor0MustBeEqualTo0Percent() {
        assertEquals(0, DiscountCalculator.calculatePercentage(0), "Discount percentage for 0 must be equal to 0");
    }

    @Example
    void discountFor499MustBeEqualTo0Percent() {
        assertEquals(0, DiscountCalculator.calculatePercentage(0), "Discount percentage for 499 must be equal to 0");
    }

    @Example
    void discountFor500MustBeEqualTo5Percent() {
        assertEquals(5, DiscountCalculator.calculatePercentage(500), "Discount percentage for 500 must be equal to 5");
    }

    @Example
    void discountFor999MustBeEqualTo5Percent() {
        assertEquals(5, DiscountCalculator.calculatePercentage(999), "Discount percentage for 999 must be equal to 5");
    }

    @Example
    void discountFor1000MustBeEqualTo10Percent() {
        assertEquals(10, DiscountCalculator.calculatePercentage(1000), "Discount percentage for 1000 must be equal to 10");
    }

    @Example
    void discountFor1999MustBeEqualTo10Percent() {
        assertEquals(10, DiscountCalculator.calculatePercentage(1999), "Discount percentage for 1999 must be equal to 10");
    }

    @Example
    void discountFor2000MustBeEqualTo15Percent() {
        assertEquals(15, DiscountCalculator.calculatePercentage(2000), "Discount percentage for 2000 must be equal to 15");
    }

    // Properties
    @Property
    void discountBetween0And499MustBeEqualTo0Percent(@ForAll @IntRange(max = 499) int quantity) {
        assertEquals(0, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 0");
    }

    @Property
    void discountBetween500And999MustBeEqualTo5Percent(@ForAll @IntRange(min = 500, max = 999) int quantity) {
        assertEquals(5, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 5");
    }

    @Property
    void discountBetween1000And1999MustBeEqualTo10Percent(@ForAll @IntRange(min = 1000, max = 1999) int quantity) {
        assertEquals(10, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 10");
    }

    @Property
    void discountAfter2000MustBeEqualTo15Percent(@ForAll @IntRange(min = 2000, max = Integer.MAX_VALUE) int quantity) {
        assertEquals(15, DiscountCalculator.calculatePercentage(quantity), "Discount percentage for " + quantity + " must be equal to 15");
    }
}
