package Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.ValidationAndVerification;
import objectRepository.VtCreateCampaignPage;
import objectRepository.VtCreateProductPage;
import objectRepository.VtigerHomepage;
import objectRepository.VtigerLoginPage;
import objectRepository.WindowSwitchingToProductPage;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
		WebDriver driver;
		String BROWSER = flib.getKeyAndValueData("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		
		wlib.maximizeWindow(driver);
		wlib.waitForElementToLoad(driver);

		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PWD = flib.getKeyAndValueData("password");
		
		driver.get(URL);	
		
		VtigerLoginPage loginpage = new VtigerLoginPage(driver);
		loginpage.loginToApp(USERNAME, PWD);
		
		int ranNumber = jlib.getRandomNumber();
		
		VtigerHomepage home=new VtigerHomepage(driver);
		home.clickProductLink();
		
		VtCreateProductPage product=new VtCreateProductPage(driver);
		product.prodPlusSign();
	    
	    String productData = elib.getExcelData("Products", 0, 0)+ranNumber;
	    product.prodData(productData);
	    product.saveButton();

		ValidationAndVerification verify=new ValidationAndVerification(driver);
		verify.prodData(driver, productData);
	    
	    
		home.clickMoreLink();
		home.clickCampaignLink();
		
		VtCreateCampaignPage campaign=new VtCreateCampaignPage(driver);
		campaign.camPlusSign();
		
		String campaignName = elib.readExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNumber;
		campaign.campData(campaignName);
		
		ValidationAndVerification verify1=new ValidationAndVerification(driver);
		verify1.campData(driver, campaignName);

		campaign.prodPlusSign();
		
		wlib.switchingWindows(driver, "Products&action");
	
		WindowSwitchingToProductPage switchPage=new WindowSwitchingToProductPage(driver);
		switchPage.enterProductName(productData);
		switchPage.searchProductName();
		
		switchPage.prodNameAvail(driver, productData);
	
		wlib.switchingWindows(driver, "Campaigns&action");
		
		Thread.sleep(2000);

		campaign.saveButton();
		Thread.sleep(2000);
		home.logoutFromApp();

	}

}
