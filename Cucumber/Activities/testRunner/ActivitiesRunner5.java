package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/Activity5.feature",
        glue = {"stepDefinitions"},
        tags = "@activity5"
)
public class ActivitiesRunner5 {
}
