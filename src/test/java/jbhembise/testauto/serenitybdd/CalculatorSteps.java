package jbhembise.testauto.serenitybdd;

import jbhembise.testauto.calculator.Calculator;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorSteps {

    private Calculator calculator;
    private int result;

    @Step("Given a calculator exists")
    public void a_calculator_exists() {
        this.calculator = new Calculator();
    }

    @Step("When i add {0} and {1}")
    public void add_n1_and_n2(int n1, int n2) {
        this.result = this.calculator.add(n1, n2);
    }

    @Step("Then it should return {0}")
    public void should_return_result(int expected) {
        assertThat(this.result).isEqualTo(expected);
    }
}
