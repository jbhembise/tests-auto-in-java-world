package jbhembise.testauto.gauge;

import com.thoughtworks.gauge.Step;
import jbhembise.testauto.calculator.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorSpec {

    private Calculator calculator;
    private int result;
    private Exception exception;

    // Shared steps
    @Step("Given a calculator exists")
    public void a_calculator_exists() {
        this.calculator = new Calculator();
    }

    @Step("Then it should return <expected>")
    public void it_should_return_expected_result(int expected) {
        assertThat(this.result).isEqualTo(expected);
    }

    @Step("Then it should throw an exception")
    public void it_should_throw_an_exception() {
        assertThat(this.exception).isInstanceOf(ArithmeticException.class);
    }

    // Specific steps
    @Step("When i add <n1> and <n2>")
    public void add_two_numbers(int n1, int n2) {
        this.result = this.calculator.add(n1, n2);
    }

    @Step("When i substract <n1> and <n2>")
    public void substract_two_numbers(int n1, int n2) {
        this.result = this.calculator.substract(n1, n2);
    }

    @Step("When i multiply <n1> and <n2>")
    public void multiply_two_numbers(int n1, int n2) {
        this.result = this.calculator.multiply(n1, n2);
    }

    @Step("When i divide <n1> by <n2>")
    public void divide_two_numbers(int n1, int n2) {
        try {
            this.result = this.calculator.divide(n1, n2);
        } catch(Exception e) {
            this.exception = e;
        }
    }

    @Step("When i calculate the element <n> of the fibonacci suite")
    public void calculate_fibonacci_item(int n) {
        this.result = this.calculator.fibonacci(n);
    }

}
