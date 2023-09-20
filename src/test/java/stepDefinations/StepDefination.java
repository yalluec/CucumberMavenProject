package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class StepDefination extends Base{
	
	@Before
	public void setUp() throws Exception {
		
		readConfig=new ReadConfig();
		System.out.println("setUp method executed");
		String browser=readConfig.getBrowser();
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kaver\\Automation\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(4000);
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	}
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\kaver\\Automation\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		//driver=new ChromeDriver();
	    ad=new AdminPage(driver);
	}

	@When("user opens url {string}")
	public void user_opens_url(String url) throws Exception {
		driver.get(url);
		Thread.sleep(8000);
	    
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
		ad.setUsername(email);
		Thread.sleep(9000);
		ad.setPassword(password);
		Thread.sleep(9000);
	    
	}

	@When("user click on login button")
	public void user_click_on_login_button() throws Exception {
	   ad.clickOnLogin();
	   Thread.sleep(9000);
	}

	@Then("user verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) throws Exception {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),title);
		Thread.sleep(4000);
	    
	}

	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}
	
	@After
	public void tearDown(Scenario sc) throws Exception {
		System.out.println("teatDown method executed");
		if(sc.isFailed()==true) {
			
			String fileWithPath="C:\\Users\\kaver\\eclipse-workspace\\BDDCucumberMavenProject\\screenshot\\failedScreenshot.png";
			
			//convert WebDriver object into TakesScreenshot
			TakesScreenshot scrShot=(TakesScreenshot)driver;
			
			//call getScreenshot as to store image file
			File scrFile=scrShot.getScreenshotAs(OutputType.FILE);	
			File destFile=new File(fileWithPath);
			try {
				FileUtils.copyFile(scrFile, destFile);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Thread.sleep(2000);
		driver.quit();
		
	}

}
