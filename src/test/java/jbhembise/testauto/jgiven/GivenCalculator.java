package jbhembise.testauto.jgiven;

import jbhembise.testauto.Calculator;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenCalculator extends Stage<GivenCalculator> {

    @ProvidedScenarioState
    private Calculator calculator;

    void a_calculator() {
        calculator = new Calculator();
    }
}
