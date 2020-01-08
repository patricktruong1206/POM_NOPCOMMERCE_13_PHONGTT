package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage{

	public LoginPageObject(WebDriver driverLocal) {
		super(driverLocal);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(LoginPageUI.EMAIL_TEXTBOX,email);
		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX,passwordValue);
		
	}

	public void clickToLoginButton() {
		waitToElementVisible(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		
	}



}
