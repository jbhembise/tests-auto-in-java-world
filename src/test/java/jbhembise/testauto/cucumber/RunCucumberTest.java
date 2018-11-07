package jbhembise.testauto.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/jbhembise/testauto/cucumber",
        tags = "~@ignore",
        monochrome = true,
        plugin = { "pretty", "json:build/reports/cucumber.json"}
)
public class RunCucumberTest {}