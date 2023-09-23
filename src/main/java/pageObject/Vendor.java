package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendor {
	
	public WebDriver ldriver;

	public Vendor(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(xpath = "//p[text()=' Vendors']")
	WebElement lnkVendors;
	
	@FindBy(xpath = "//input[@id='SearchName']")
	WebElement searchVendorName;
	
	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement searchVendorEmail;
	
	@FindBy(xpath = "//button[@id='search-vendors']")
	WebElement btnSearch;
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnVendors() {
		lnkVendors.click();
	}
	
	public void searchName(String vname) {
		searchVendorName.sendKeys(vname);
	}
	
	public void searchEmail(String vemail) {
		searchVendorEmail.sendKeys(vemail);
	}
	
	public void clickOnSearchbutton() {
		btnSearch.click();
	}
	

}
