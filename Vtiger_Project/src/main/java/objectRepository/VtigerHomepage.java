package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class VtigerHomepage {
	
	//Initialization
	public VtigerHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(xpath = "//a[text()=\"More\"]")
    private WebElement moreLink;
	
	@FindBy(css = "[name=\"Campaigns\"]")
	private WebElement campaignLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement logoutImg;
	
	@FindBy(xpath = "//a[text()=\"Sign Out\"]")
	private WebElement signOut;


	//Getter methods
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}
	
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}
	
	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	//Business Logics
	/**
	 * this method is used to click organization link
	 */
	public void clickOrganizationLink() {
		organizationLink.click();
	}
	/**
	 * this method is used to click product link
	 */
	public void clickProductLink() {
		productLink.click();
	}
	/**
	 * this method is used to click more link
	 */
	public void clickMoreLink() {
		moreLink.click();
	}
	/**
	 * this method is used to click campaign link
	 */
	public void clickCampaignLink() {
		campaignLink.click();
	}
	
	public void logoutFromApp() {
		logoutImg.click();
		signOut.click();
	}
	
}
