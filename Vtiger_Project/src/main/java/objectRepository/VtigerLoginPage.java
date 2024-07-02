package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {
	
	//Initialization
	public VtigerLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//Declaration
		@FindBy(name ="user_name")
		private WebElement UserTextfield;
		
		@FindBy(name = "user_password")
		private WebElement PasswordTextfield;
		
		@FindBy(id ="submitButton")
		private WebElement LoginButton;
		
		//getter methods
		public WebElement getUserTextField() {
			return UserTextfield;
		}
		public WebElement getPasswordTextField() {
			return PasswordTextfield;
		}
		public WebElement getLoginButton() {
			return LoginButton;
		}
		
		//BusinessLogics
		/**
		 * This method is used to launch application
		 * @param Username
		 * @param Password
		 * @author Anitha
		 */
		public void loginToApp(String Username,String Password) {
			UserTextfield.sendKeys(Username);
			PasswordTextfield.sendKeys(Password);
			LoginButton.click();
		}
}
