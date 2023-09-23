package stepDefinations;

import org.openqa.selenium.WebDriver;

import pageObject.AddNewCustomer;
import pageObject.AdminPage;
import pageObject.Vendor;
import utilities.ReadConfig;

public class Base {
	
	
	public WebDriver driver;
	public AdminPage ad;
	public AddNewCustomer addCust;
	public Vendor vdr;
	public ReadConfig readConfig;

}
