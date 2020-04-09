package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.RegisterPageUI;


public class RegisterPageObject extends AbstractPages {
	private WebDriver driver;

	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
	}
	
	public void clickToMaleButton() {
		waitToElementVisible(driver,RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver,RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitToElementVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,firstNameValue);
		
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastNameValue);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,email);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,passwordValue);
	}

	public void inputToConfirmPasswordTextbox(String passwordValue) {
		waitToElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,passwordValue);
		
	}

	public void clickToRegisterButton() {
		waitToElementVisible(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isSuccessMesageDisplayed() {
		waitToElementVisible(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		
		
	}

	public HomePageObject clickToLogout() {
		waitToElementVisible(driver,RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver,RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
		
	}

}
