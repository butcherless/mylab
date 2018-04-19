package cucumber.examples.java.calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report"},
        tags = {"@api"}
        //tags = {"@arithmetic", "@date", "not @shopping"}
)
public class RunCukesTest {
}
