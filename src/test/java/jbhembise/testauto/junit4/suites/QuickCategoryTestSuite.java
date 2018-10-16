package jbhembise.testauto.junit4.suites;

import jbhembise.testauto.junit4.CalculatorTest;
import jbhembise.testauto.junit4.categories.Quick;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(Quick.class)
@Suite.SuiteClasses({
    CalculatorTest.class
})
public class QuickCategoryTestSuite {}
