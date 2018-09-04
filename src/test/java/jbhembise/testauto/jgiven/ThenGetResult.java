package jbhembise.testauto.jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThenGetResult extends Stage<ThenGetResult> {

    @ExpectedScenarioState
    private int result;

    @ExpectedScenarioState
    private Exception exception;

    void should_obtain_$(int expected) {
        assertEquals(expected, result);
    }

    void should_have_an_exception() {
        assertTrue(exception instanceof ArithmeticException);
    }
}
