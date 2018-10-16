package jbhembise.testauto.junit4.suites;

import jbhembise.testauto.junit4.CalculatorTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(Long.class)
@Suite.SuiteClasses({
    CalculatorTest.class
})
public class LongCategoryTestSuite {}
