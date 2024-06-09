package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/Activity4.feature",
        glue = {"stepDefinitions"},
        tags = "@activity4"
)
public class ActivitiesRunner4 {
}
