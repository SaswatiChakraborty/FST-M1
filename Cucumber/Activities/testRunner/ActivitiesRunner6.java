package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/Activity3.feature",
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty","html:test-reports/index.html","json: test-reports/json-report.json"},
        tags = "@SmokeTest"
)
public class ActivitiesRunner6 {
}
