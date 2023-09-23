package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomer {
	
	public WebDriver ldriver;

	public AddNewCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
		
		By lnkCustomers_Menu =By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
		
		By lnk_Customers_menu_item=By.xpath("//p[text()=' Customers']");
		
		By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
		
		By txtEmail=By.xpath("//input[@id='Email']");
		
		By txtPassword=By.xpath("//input[@id='Password']");
		
		By txtFirstName=By.xpath("//input[@id='FirstName']");
		
		By txtLastName=By.xpath("//input[@id='LastName']");
		
		By txtCompanyName=By.xpath("//input[@id='Company']");
		
		By rdMalegender=By.xpath("//input[@id='Gender_Male']");
		
		By rdFemaleGender=By.xpath("//input[@id='Gender_Female']");
		
		By txtDOB=By.xpath("//input[@id='DateOfBirth']");
		
		By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
		
		By chkBoxTax =By.xpath("//input[@id='IsTaxExempt']");
		
		By btnSave=By.xpath("//button[@name='save']");
		
		By drpDownVM=By.xpath("//*[@id='VendorId']");
		
		public String getPageTitle() {
			return ldriver.getTitle();
		}
		
		public void clickOnCustomersMenu() {
			ldriver.findElement(lnkCustomers_Menu).click();
		}
		
		public void clickOnCustomersMenuItem() {
			ldriver.findElement(lnk_Customers_menu_item).click();
		}
		
		public void clickOnAddNew() {
			ldriver.findElement(btnAddNew).click();
		}
		
		public void setEmail(String email) {
			ldriver.findElement(txtEmail).sendKeys(email);
		}
		
		public void setPassword(String password) {
			ldriver.findElement(txtPassword).sendKeys(password);
		}
		
		public void setFirstName(String firstName) {
			ldriver.findElement(txtFirstName).sendKeys(firstName);
		}
		
		public void setLastName(String lastName) {
			ldriver.findElement(txtLastName).sendKeys(lastName);
		}
		
		public void tickCheckBox() {
			ldriver.findElement(chkBoxTax).click();
		}
		
		public void setGender(String gender) {
			if(gender.equals("Male")) {
				ldriver.findElement(rdMalegender).click();
			}else {
				ldriver.findElement(rdFemaleGender).click();
			}
		}
		
		public void enterDOB(String dob) {
			ldriver.findElement(txtDOB).sendKeys(dob);
		}
		
		public void enterManagerofVendor(String value) {
		Select drp=new Select((WebElement) drpDownVM);
		drp.selectByVisibleText(value);
		}
	
		public void setCompany(String compName) {
			ldriver.findElement(txtCompanyName).sendKeys(compName);
		}
		
		public void setAdminContent(String content) {
			ldriver.findElement(txtAdminContent).sendKeys(content);
		}
		
		public void clickOnSave() {
			ldriver.findElement(btnSave).click();
		}
		
		
	}

