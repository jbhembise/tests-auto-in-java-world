package jbhembise.testauto.junit4.suites;

import jbhembise.testauto.junit4.CalculatorTest;
import jbhembise.testauto.junit4.DiscountCalculatorTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses({
    CalculatorTest.class,
    DiscountCalculatorTest.class
})
public class JUnit4TestSuite {}
