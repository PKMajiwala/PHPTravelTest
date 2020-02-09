import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty" }, features = "src/test/resources/phptravel_login.feature", glue = "")
public class LoginRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public void tearDown() {
		StepDefs.driver.quit();
	}
}
