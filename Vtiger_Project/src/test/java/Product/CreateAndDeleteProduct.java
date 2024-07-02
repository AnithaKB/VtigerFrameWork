package Product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.VtigerHomepage;
import objectRepository.VtigerLoginPage;

public class CreateAndDeleteProduct {

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
//	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	    driver.findElement(By.id("submitButton")).click();
	    
	    VtigerLoginPage loginpage = new VtigerLoginPage(driver);
		loginpage.loginToApp(USERNAME, PWD);
		
		VtigerHomepage home = new VtigerHomepage(driver);
		home.clickProductLink();
		
	    //driver.findElement(By.linkText("Products")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	   
        int ranNumber = jlib.getRandomNumber();
 	
        String productData = elib.readExcelDataUsingDataFormatter("Products",1,1)+ranNumber;
 	    System.out.println(productData);
        driver.findElement(By.name("productname")).sendKeys(productData+ranNumber);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
	
	    driver.findElement(By.linkText("Products")).click(); 
	    driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
	 
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		    
		wlib.alertAccept(driver);
		
		List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")); 
    	
		boolean flag = false;
		
		for (WebElement prdName : productList)
		{
			String actData = prdName.getText();
			if(actData.contains(productData))
			{
				flag=true;
			   break;
			}}
		if(flag)
		{
			System.out.println("product data is deleted");
		}
		else
		{
			System.out.println("product data is not deleted");
		}
			
        Thread.sleep(2000);
		home.logoutFromApp();
//	       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
