package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import objectRepository.VtCreateCampaignPage;
import objectRepository.VtigerHomepage;
import objectRepository.VtigerLoginPage;

public class BaseClass {

	public WebDriver driver;
	File_Utility flib = new File_Utility();
	WebDriver_Utility wlib = new WebDriver_Utility();
	Java_Utility jlib = new Java_Utility();
	Excel_Utility elib = new Excel_Utility();
	
		@BeforeSuite
		public void bs()
		{
			System.out.println("DataBase Connection");
		}
		@BeforeTest
		public void bt()
		{
			System.out.println("parallel execution");
		}
		@BeforeClass
		public void bc() throws Throwable {
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
			System.out.println("Browser launched");
		}
		@BeforeMethod
		public void bm() throws Throwable
		{
			wlib.maximizeWindow(driver);
			wlib.waitForElementToLoad(driver);
			
			String URL = flib.getKeyAndValueData("url");
			String USERNAME = flib.getKeyAndValueData("username");
			String PWD = flib.getKeyAndValueData("password");
			
			driver.get(URL);
			
			VtigerLoginPage loginpage = new VtigerLoginPage(driver);
			loginpage.loginToApp(USERNAME, PWD);
			System.out.println("login to Application");
		}
		@AfterMethod
		public void am()
		{
			VtigerHomepage home=new VtigerHomepage(driver);
			home.logoutFromApp();
			System.out.println("logout from application");
		}
		@AfterClass
		public void ac()
		{
			driver.quit();
			System.out.println("close browser");
		}
		@AfterTest
		public void at()
		{
			System.out.println("parallel execution done");
		}
		@AfterSuite
		public void as()
		{
			System.out.println("close database");
		}
	}


