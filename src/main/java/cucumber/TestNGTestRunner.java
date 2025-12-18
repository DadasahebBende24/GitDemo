package cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/main/java/cucumber",
	glue = "ajinkyaproject01.stepDefinition",
	plugin = {"pretty", "html:target/cucumber-reports.html"},
	monochrome = true,
	tags = "@Regression"

)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
