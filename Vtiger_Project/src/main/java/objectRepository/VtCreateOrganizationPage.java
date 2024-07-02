package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtCreateOrganizationPage {
	
	public VtCreateOrganizationPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css = "[title=\"Create Organization...\"]")
	private WebElement organizationPlusSign;
	
	@FindBy(name = "accountname")
	private WebElement organizationName;
	
	@FindBy(id = "phone")
	private WebElement organizationPhoneNum;
	
	@FindBy(id = "email1")
	private WebElement organizationEmail;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	//Getter methods
	public WebElement getOrganizationPlusSign() {
		return organizationPlusSign;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getOrgPhoneNum() {
		return organizationPhoneNum;
	}

	public WebElement getOrgEmail() {
		return organizationEmail;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	//Business logics
	public void ClickOrgPlusSign()
	{
		organizationPlusSign.click();
	}
	
	public void OrgData(String orgName,String phoneNum,String Email)
	{
		organizationName.sendKeys(orgName);
		organizationPhoneNum.sendKeys(phoneNum);
		organizationEmail.sendKeys(Email);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
}
