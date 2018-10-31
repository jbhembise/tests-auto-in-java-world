package jbhembise.testauto.serenitybdd;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class WhenUsingCalculator {

    @Steps
    CalculatorSteps calculatorSteps;

    @Test
    public void should_add_two_numbers() {
        // GIVEN
        calculatorSteps.a_calculator_exists();

        // WHEN
        calculatorSteps.add_n1_and_n2(1, 9);

        // THEN
        calculatorSteps.should_return_result(10);
    }
}
