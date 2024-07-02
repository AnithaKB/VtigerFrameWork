package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingToProductPage {
	public WindowSwitchingToProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	private WebElement productName;
	
	@FindBy(css = "[type=\"button\"]")
	private WebElement productSearch;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductSearch() {
		return productSearch;
	}

	public void enterProductName(String prodName)
	{
		productName.sendKeys(prodName);
	}
	
	public void searchProductName()
	{
		productSearch.click();
	}
	
	public void prodNameAvail(WebDriver driver,String productName)
	{
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	}
	
}
