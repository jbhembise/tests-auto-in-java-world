package jbhembise.testauto.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/jbhembise/testauto/cucumber",
        tags = "~@ignore"
)
public class RunCucumberTest {}