package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import pageObject.AddNewCustomer;
import pageObject.AdminPage;
import pageObject.Vendor;
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
		Thread.sleep(6000);
		ad.setPassword(password);
		Thread.sleep(6000);
	    
	}

	@When("user click on login button")
	public void user_click_on_login_button() throws Exception {
	   ad.clickOnLogin();
	   Thread.sleep(6000);
	}

	@Then("user verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) throws Exception {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),title);
		Thread.sleep(4000);
	    
	}
	//--------------------------------------------------------------------------Customer
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws Exception {
	    addCust=new AddNewCustomer(driver);
	    Assert.assertEquals(addCust.getPageTitle(), "Dashboard / nopCommerce administration");
	    Thread.sleep(4000);
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() throws Exception {
	    addCust.clickOnCustomersMenu();
	    Thread.sleep(4000);
	}

	@When("User click on customers menu item")
	public void user_click_on_customers_menu_item() throws Exception {
	    addCust.clickOnCustomersMenuItem();
	    Thread.sleep(4000);
	}

	@When("User click on new add button")
	public void user_click_on_new_add_button() throws Exception {
	    addCust.clickOnAddNew();
	    Thread.sleep(4000);
	}
	
	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws Exception {
		Thread.sleep(4000);
		Assert.assertEquals(addCust.getPageTitle(), "Add a new customer / nopCommerce administration");
	}

	@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail,String password, String firstName, String lastName, String gender, String adminComment,String compName) throws Exception {
	    addCust.setEmail(newEmail);
	    addCust.setPassword(password);
	    addCust.setFirstName(firstName);
		  addCust.setLastName(lastName);
		  addCust.setGender(gender);
		//  addCust.enterDob("6/13/1988");
		//  addCust.enterManagerofVendor("Vendor 1");
		  addCust.setCompany(compName);
		  addCust.setAdminContent(adminComment);
		  Thread.sleep(4000);
	}

	@When("user click on save button")
	public void user_click_on_save_button() throws Exception {
	    addCust.clickOnSave();
	    Thread.sleep(6000);
	}

	@Then("User can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) throws Exception {
	   // Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(" The new customer has been added successfully."));
	    Assert.assertEquals(addCust.getPageTitle(), "Customers / nopCommerce administration");
		Thread.sleep(2000);
	}
//-----------------------------------------------------------------Vendor
	
	@When("User click on vendor item")
	public void user_click_on_vendor_item() throws Exception {
		vdr=new Vendor(driver);
		vdr.clickOnVendors();
		Thread.sleep(4000);
	   
	}

	@Then("User can view vendor page")
	public void user_can_view_vendor_page() throws Exception {
	    Assert.assertEquals("Vendors / nopCommerce administration", vdr.getPageTitle());
	    Thread.sleep(4000);
	}

	@When("User enter Vendor name as {string} and password as {string}")
	public void user_enter_vendor_name_as_and_password_as(String venName, String venEmail) throws Exception {
	    vdr.searchName(venName);
	    Thread.sleep(4000);
	    vdr.searchEmail(venEmail);
	    Thread.sleep(4000);
	}

	@When("User click on Search button")
	public void user_click_on_search_button() throws Exception {
		vdr.clickOnSearchbutton();
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
