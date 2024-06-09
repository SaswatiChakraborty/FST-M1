package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/Activity1.feature",
        glue = {"stepDefinitions"},
        tags = "@activity1"
)
public class ActivitiesRunner1 {
}

