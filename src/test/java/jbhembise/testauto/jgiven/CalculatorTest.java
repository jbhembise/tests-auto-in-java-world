package jbhembise.testauto.jgiven;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class CalculatorTest extends ScenarioTest<GivenCalculator, WhenOperation, ThenGetResult> {

    @Test
    @DataProvider({
        "1, 1, 2",
        "0, 2, 2",
        "1, 0, 1"
    })
    public void should_add_two_numbers(int n1, int n2, int result) {
        given().a_calculator();
        when().add_$_and_$(n1, n2);
        then().should_obtain_$(result);
    }

    @Test
    @DataProvider({
        "6, 3, 3",
        "5, 3, 2"
    })
    public void should_substract_two_numbers(int n1, int n2, int result) {
        given().a_calculator();
        when().substract_$_and_$(n1, n2);
        then().should_obtain_$(result);
    }

    @Test
    @DataProvider({
        "3, 3, 9",
        "6, 5, 30"
    })
    public void should_multiply_two_numbers(int n1, int n2, int result) {
        given().a_calculator();
        when().multiply_$_and_$(n1, n2);
        then().should_obtain_$(result);
    }

    @Test
    @DataProvider({
        "9, 3, 3",
        "30, 5, 6"
    })
    public void should_divide_two_numbers(int n1, int n2, int result) {
        given().a_calculator();
        when().divide_$_and_$(n1, n2);
        then().should_obtain_$(result);
    }

    @Test
    public void should_divide_by_zero() {
        given().a_calculator();
        when().divide_$_and_$(10, 0);
        then().should_have_an_exception();
    }

    @Test
    @DataProvider({
        "4, 3",
        "6, 8"
    })
    public void should_calculate_fibonacci_element(int n, int result) {
        given().a_calculator();
        when().calculate_fibonnacci_element_$(n);
        then().should_obtain_$(result);
    }
}
