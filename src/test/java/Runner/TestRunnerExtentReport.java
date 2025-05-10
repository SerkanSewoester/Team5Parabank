package Runner;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;


@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class TestRunnerExtentReport extends AbstractTestNGCucumberTests {
    @AfterClass
    public  static void writeExtendReport()
    {
        ExtentService.getInstance().setSystemInfo("Project Name", "Parabank Automation");
        ExtentService.getInstance().setSystemInfo("Tested By", "Serkan SEWOESTER");
        ExtentService.getInstance().setSystemInfo("Operating System", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("Department", "QA Team");
        ExtentService.getInstance().setSystemInfo("Application URL", "https://parabank.parasoft.com/");

    }
}
