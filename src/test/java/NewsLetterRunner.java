import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty" }, features = "src/test/resources/phptravel_newsletter_subscription.feature", glue = "")
public class NewsLetterRunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public void tearDown() {
		StepDefs.driver.quit();
	}
}
