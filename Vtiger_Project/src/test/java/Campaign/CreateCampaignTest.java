package Campaign;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.ValidationAndVerification;
import objectRepository.VtCreateCampaignPage;
import objectRepository.VtigerHomepage;
import objectRepository.VtigerLoginPage;

public class CreateCampaignTest extends BaseClass{
@Test
@Parameters("BROWSER")
	public void createCampaignTest() throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
		VtigerHomepage home=new VtigerHomepage(driver);
		home.clickMoreLink();
		home.clickCampaignLink();
		
		VtCreateCampaignPage campPage=new VtCreateCampaignPage(driver);
		campPage.camPlusSign();
				
		driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
		
		int ranNumber = jlib.getRandomNumber();
		
		String campaignName = elib.readExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNumber;
		campPage.campData(campaignName);
		
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File desc = new File("./ScreenShot.png");
		try {
			FileUtils.copyDirectory(src, desc);
		}catch(IOException e){
			e.printStackTrace();
		}
		Assert.assertEquals(false, true);
		campPage.saveButton();		

//		ValidationAndVerification verify=new ValidationAndVerification(driver);
//		verify.campData(driver, campaignName);
		String actData=driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
//		Assert.assertEquals(actData, campaignName);
//		Assert.assertTrue(actData.contains(campaignName));
		
//		Assert.assertTrue(actData.contains(campaignName), campaignName+"campaign name is not verified");
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actData, campaignName);
		soft.assertAll();
		//Edit and pulled
		
	}

}
