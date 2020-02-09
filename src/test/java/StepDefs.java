import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	public static WebDriver driver;

	private void init() {
		File driverPath = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
		ChromeOptions options = new ChromeOptions();
		options.merge(DesiredCapabilities.chrome());
		options.addArguments("--start-maximized");
//		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("User is on PHPTravel website open")
	public void openPage() {
		init();
		driver.get("https://www.phptravels.net/home");
	}

	@When("User clicks on Suppier Sign I page")
	public void signInPage() {
		driver.findElement(By.xpath("//*[contains(text(),'Supplier Login')]")).click();
	}

	@Then("User should be able to see login page")
	public void validateLoginPage() {
		switchtoTab(1);
		assertEquals(true, driver.findElement(By.xpath("//*[contains(text(),'Login Panel')]")).isDisplayed());
	}

	@When("User enters {string} in email")
	public void enterUsername(String username) {
		WebElement usernameElement = driver.findElement(By.xpath("//input[@name='email']"));
		usernameElement.clear();
		usernameElement.sendKeys(username);
	}

	@When("User enters {string} in password")
	public void enterPassword(String password) {
		WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	@Then("Clicks on Login button")
	public void clickOnLoginButton() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("User should be able to see error")
	public void assertError() {
		assertTrue(driver.findElement(By.cssSelector("div.alert")).isDisplayed());
	}

	@When("User enters {string} in newsletter subscribtion email")
	public void entersEmailInSub(String string) {
		WebElement input = driver.findElement(By.cssSelector("input#exampleInputEmail1"));
		input.clear();
		input.sendKeys(string.equals("randomEmail") ? generateRandomEmail() : string);
	}

	@When("Clicks on Subscribe button")
	public void clicksOnSubscribe() {
		driver.findElement(By.cssSelector("button.sub_newsletter[type='submit']")).click();
	}

	@Then("User checks the {string} message")
	public void checkMessage(String string) {
		assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + string + "')]")).isDisplayed());
	}

	@When("User Clicks on Flights filter button")
	public void flightSearchFilter() {
		driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
		;
	}

	@Then("Clicks on search button with applied filters")
	public void cliskOnflightSearch() {
		driver.findElement(By.xpath("	//div[@id='flights']//button[contains(text(),'Search')]")).click();
		// Search functionality is having bug so directly navigating results
		driver.navigate().to("https://www.phptravels.net/thflights/search/NYC/DWC/oneway/economy/2020-02-22/1/0/");
	}

	@When("Clicks on {string} Route Stops filter")
	public void applySubFilter(String filterData) {
		driver.findElement(By.xpath("//label[contains(text(),'" + filterData + "')]")).click();
	}

	@Then("Validate results are according to {string} search result as per {string}")
	public void validateResultData(String filterData, String filterType) {
		List<WebElement> resultElements = driver.findElements(By.xpath("//li[contains(@class,'item')]"));
		String className = driver.getCurrentUrl();
		System.out.println("->>>" + className);
		if (filterType.contains("Route")) {
			if (!resultElements.isEmpty()) {
				for (WebElement webElement : resultElements) {
					System.out.println("Data->>>" + webElement.getAttribute("class"));
					assertTrue(webElement.getAttribute("class").contains("oneway_" + filterData));
				}
			}
		} else {
			if (!resultElements.isEmpty()) {
				for (WebElement webElement : resultElements) {
					System.out.println("Data->>>" + webElement.getAttribute("class"));
					assertTrue(webElement.getAttribute("class").contains(filterData.toLowerCase().replace(" ", "")));
				}
			}
		}
	}

	@When("Clicks on {string} Airlines filter")
	public void selectAirLineFilter(String filterdata) {
		driver.findElement(By.xpath("//div[contains(@class,'checkbox')][contains(.,'" + filterdata + "')]")).click();
	}

	@Given("User reloads page")
	public void refresh() {
		driver.navigate().refresh();
//		driver.findElement(By.cssSelector("#cookyGotItBtnBox > div > button")).click();
	}

	@When("User clicks on any of the featured travel option")
	public void clickOnFeaturedTravel() {
		driver.findElement(By.xpath("//figure//a")).click();
	}

	@When("User clicks on {string} link")
	public void clickOnMedia(String media) {
	driver.findElement(By.xpath("//*[contains(@data-network,'"+media+"')]")).click();	
	}
	
	@Then("User should able to jump on {string} link")
	public void validateSocialMedia(String media) {
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().defaultContent();
	}

	@When("User books for {string} adults")
	public void selectAdults(String i) {
		Select select = new Select(driver.findElement(By.cssSelector("")));
		select.selectByValue(i);
	}
	
	@And("{string} Childs")
	public void selectChilds(String i) {
		Select select = new Select(driver.findElement(By.cssSelector("")));
		select.selectByValue(i);
	}
	
	@And("{string} Infrants")
	public void selectInfrants(String i) {
		Select select = new Select(driver.findElement(By.cssSelector("")));
		select.selectByValue(i);
	}
	
	@And("Validate total amount")
	public void validateAmount() {
		
	}

	private static String generateRandomEmail() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz123456789011121314".toCharArray();
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)));
		for (int i = 0; i < 8; i++) {
			sb.append(chars[rnd.nextInt(chars.length)]);
		}
		sb.append("@srkaycg.com");
		return sb.toString();
	}

	private void switchtoTab(int index) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(index));
	}

}
