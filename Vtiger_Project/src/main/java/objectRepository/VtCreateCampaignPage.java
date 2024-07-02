package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtCreateCampaignPage {
	
	public VtCreateCampaignPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[alt=\"Create Campaign...\"]")
	private WebElement campaignPlusSign;
	
	
	@FindBy(css = "[name=\"campaignname\"]")
	private WebElement campaignName;
	
	@FindBy(css = "[title=\"Select\"]")
	private WebElement plusSignToProductPage;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getCampaignPlusSign() {
		return campaignPlusSign;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getPlusSignToProductPage() {
		return plusSignToProductPage;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void camPlusSign()
	{
		campaignPlusSign.click();
	}
	
	public void campData(String campName)
	{
		campaignName.sendKeys(campName);
	}
	
	public void prodPlusSign()
	{
		plusSignToProductPage.click();
	}
	
	public void saveButton() 
	{
		saveButton.click();
	}
	
}
