package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/Activity3.feature",
        glue = {"stepDefinitions"},
        tags = "@PromptAlert"
)
public class ActivitiesRunner3_c {
}
