package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtCreateProductPage {

	public VtCreateProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[title=\"Create Product...\"]")
	private WebElement productPlusSign;
	
	
	@FindBy(name = "productname")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getProductPlusSign() {
		return productPlusSign;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void prodPlusSign()
	{
		productPlusSign.click();
	}
	
	public void prodData(String prodName)
	{
		productName.sendKeys(prodName);
	}
	
	public void saveButton() 
	{
		saveButton.click();
	}

}
