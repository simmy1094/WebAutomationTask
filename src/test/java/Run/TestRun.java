package Run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        plugin = {"pretty", "json:target/json/json-report.json", "junit:target/cucumber-reports/Cucumber.xml", "html:target/html", "junit:target/junit/junit-report.xml"},
        glue = {"browser_Start_Up", "Utilities","step_definitions"}


)

public class TestRun
{
}
