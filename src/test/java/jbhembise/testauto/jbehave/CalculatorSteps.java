package jbhembise.testauto.jbehave;

import jbhembise.testauto.Calculator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorSteps {

    private Calculator calculator;
    private Integer result;
    private Exception exception;

    // Shared steps
    @Given("a calculator exists")
    public void a_calculator_exists() {
        calculator = new Calculator();
    }

    @Then("it should return <expected>")
    public void it_should_return_the_good_result(@Named("expected") int expected) {
        assertThat(result).isEqualTo(expected);
    }

    @Then("it should throw an exception")
    public void it_should_throw_an_exception() {
        assertThat(this.exception).isInstanceOf(ArithmeticException.class);
    }

    // Specific steps
    @When("i add <n1> and <n2>")
    public void add_two_numbers(@Named("n1") int n1, @Named("n2") int n2) {
        result = calculator.add(n1, n2);
    }

    @When("i substract <n1> and <n2>")
    public void substract_two_numbers(@Named("n1") int n1, @Named("n2") int n2) {
        this.result = this.calculator.substract(n1, n2);
    }

    @When("i multiply <n1> and <n2>")
    public void multiply_two_numbers(@Named("n1") int n1, @Named("n2") int n2) {
        this.result = this.calculator.multiply(n1, n2);
    }

    @When("i divide <n1> by <n2>")
    public void divide_two_numbers(@Named("n1") int n1, @Named("n2") int n2) {
        this.result = this.calculator.divide(n1, n2);
    }

    @When("i divide 10 by 0")
    public void divide_by_zero() {
        try {
            this.result = this.calculator.divide(10, 0);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @When("i calculate the element <n> of the fibonacci suite")
    public void calculate_n_element_of_fibonacci_suite(@Named("n") int n) {
        this.result = this.calculator.fibonacci(n);
    }
}
