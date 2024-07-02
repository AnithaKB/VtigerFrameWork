package Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.VtCreateOrganizationPage;
import objectRepository.VtigerHomepage;
import objectRepository.VtigerLoginPage;

public class CreateOrganizationTest {
@Test(retryAnalyzer = Generic_Utilities.RetryImplementation.class)
@Parameters("BROWSER")
	public void createOrganizationTest() throws Throwable {
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
		
		//excel utility implementation
		
		int ranNumber = jlib.getRandomNumber();
		
		VtigerHomepage home = new VtigerHomepage(driver);
		home.clickOrganizationLink();
		
		VtCreateOrganizationPage createOrgPage = new VtCreateOrganizationPage(driver);
		createOrgPage.ClickOrgPlusSign();
		String OrganizationData = elib.readExcelDataUsingDataFormatter("Organizations", 0, 0)+ranNumber;
		String phone = elib.readExcelDataUsingDataFormatter("Organizations", 1, 1);
		String mail = elib.readExcelDataUsingDataFormatter("Organizations", 2, 2);
		
		createOrgPage.OrgData(OrganizationData, phone, mail);
		createOrgPage.clickSaveButton();
		
		Thread.sleep(2000);
		
		home.logoutFromApp();
		
	}

}
