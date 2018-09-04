package jbhembise.testauto.jgiven;

import jbhembise.testauto.Calculator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class WhenOperation extends Stage<WhenOperation> {

    @ExpectedScenarioState
    private Calculator calculator;

    @ProvidedScenarioState
    private int result;

    @ProvidedScenarioState
    private Exception exception;

    void add_$_and_$(int n1, int n2) {
        result = calculator.add(n1, n2);
    }

    void substract_$_and_$(int n1, int n2) {
        result = calculator.substract(n1, n2);
    }

    void multiply_$_and_$(int n1, int n2) {
        result = calculator.multiply(n1, n2);
    }

    void divide_$_and_$(int n1, int n2) {
        try {
            result = calculator.divide(n1, n2);
        } catch (Exception e) {
            exception = e;
        }
    }

    void calculate_fibonnacci_element_$(int n) {
        result = calculator.fibonacci(n);
    }
}
