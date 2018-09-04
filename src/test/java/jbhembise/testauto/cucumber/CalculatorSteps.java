package jbhembise.testauto.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jbhembise.testauto.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorSteps {

    private Calculator calculator;
    private int result;
    private Exception exception;

    // Shared steps
    @Given("^a calculator exists$")
    public void a_calculator_exists() {
        this.calculator = new Calculator();
    }

    @Then("^it should return (-?\\d+)$")
    public void it_should_return_expected_result(int expected) {
        assertThat(this.result).isEqualTo(expected);
    }

    @Then("^it should throw an exception$")
    public void it_should_throw_an_exception() {
        assertThat(this.exception).isInstanceOf(ArithmeticException.class);
    }

    // Specific steps
    @When("^i add (-?\\d+) and (-?\\d+)$")
    public void add_two_numbers(int n1, int n2) {
        this.result = this.calculator.add(n1, n2);
    }

    @When("^i substract (-?\\d+) and (-?\\d+)$")
    public void substract_two_numbers(int n1, int n2) {
        this.result = this.calculator.substract(n1, n2);
    }

    @When("^i multiply (-?\\d+) and (-?\\d+)$")
    public void multiply_two_numbers(int n1, int n2) {
        this.result = this.calculator.multiply(n1, n2);
    }

    @When("^i divide (-?\\d+) by (-?\\d+)$")
    public void divide_two_numbers(int n1, int n2) {
        try {
            this.result = this.calculator.divide(n1, n2);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @When("^i calculate the element (-?\\d+) of the fibonacci suite$")
    public void calculate_n_element_of_fibonacci_suite(int n) {
        this.result = this.calculator.fibonacci(n);
    }
}
