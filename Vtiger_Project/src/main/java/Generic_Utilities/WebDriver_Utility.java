package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	/**
	 * This method is used for maximizing window
	 * @param driver
	 * @author Anitha
	 */

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait all elements to get loaded in GUI
	 * @param driver
	 */
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void switchingWindows(WebDriver driver,String partialText)
	{
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> it = allwin.iterator();
		
		while(it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			System.out.println(title);
			if(title.contains(partialText)) {
				break;
			}
		}
	}
	
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/** this method is used to dismiss the alert popup
	 * 
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method is used to handle drop down using Select class(SelectByIndex)
	 * @param ele
	 * @param value
	 */
	public void selectByIndexApproch(WebElement ele, int value)
	{
		Select select = new Select(ele);
		select.selectByIndex(value);
	}
	
	/**
	 * this method is used to handle drop down using Select class(SelectByValue)
	 * @param ele
	 * @param value
	 */
	public void selectByValueApproch(WebElement ele, String value)
	{
		Select select = new Select(ele);
		select.selectByValue(value);
	}
	
	/**
	 * this method is used to handle drop down using Select class(SelectByValue)
	 * @param ele
	 * @param value
	 */
	public void selectByVisibleTextApproch(WebElement ele, String text)
	{
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

	
	
}
