package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerification {

	public ValidationAndVerification(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void campData(WebDriver driver,String campaignName)
	{
		String actData=driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
	     if(campaignName.contains(actData))
	    	 System.out.println("Campaign Data is matched");
	     else
	    	 System.out.println("Campaign Data is not matched");

	}
	
	public void prodData(WebDriver driver,String productData) 
	{
		String actData=driver.findElement(By.className("productname")).getText();
	     if(productData.contains(actData))
	    	 System.out.println("Product Data is matched");
	     else
	    	 System.out.println("Product Data is not matched");
	}
}
