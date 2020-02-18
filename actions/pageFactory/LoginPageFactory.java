package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageFactory extends AbstractPageFactory {
	
	
	public LoginPageFactory(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, this);
	}
	
	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextbox;
	
	@FindBy(how = How.ID, using = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.CSS, using= ".login-button")
	private WebElement loginButton;
	
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox);
		sendkeyToElement(emailTextbox,email);
		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(passwordTextbox);
		sendkeyToElement(passwordTextbox,passwordValue);
	}
		
	
	public void clickToLoginButton() {
		waitToElementVisible(loginButton);
		clickToElement(loginButton);
		
	}

}

