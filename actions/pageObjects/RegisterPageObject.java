package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	public RegisterPageObject(WebDriver driverLocal) {
		super(driverLocal);
	}

	public void clickToMaleButton() {
		waitToElementVisible(RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitToElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX,firstNameValue);
		
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX,lastNameValue);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX,email);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX,passwordValue);
	}

	public void inputToConfirmPasswordTextbox(String passwordValue) {
		waitToElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,passwordValue);
		
	}

	public void clickToRegisterButton() {
		waitToElementVisible(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isSuccessMesageDisplayed() {
		waitToElementVisible(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		
		
	}

	public void clickToLogout() {
		waitToElementVisible(RegisterPageUI.LOGOUT_LINK);
		clickToElement(RegisterPageUI.LOGOUT_LINK);
		
	}

}
