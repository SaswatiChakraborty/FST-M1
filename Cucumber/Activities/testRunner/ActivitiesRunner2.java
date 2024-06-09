package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/Activity2.feature",
        glue = {"stepDefinitions"},
        tags = "@activity2"
)
public class ActivitiesRunner2 {
}
