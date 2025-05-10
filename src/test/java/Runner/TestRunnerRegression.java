package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest and @Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)
public class TestRunnerRegression extends AbstractTestNGCucumberTests {
}
