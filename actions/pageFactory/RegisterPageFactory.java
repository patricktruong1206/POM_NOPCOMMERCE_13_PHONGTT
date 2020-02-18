package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageFactory extends AbstractPageFactory {
	
	public RegisterPageFactory(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, this);
	}

	@FindBy(how= How.ID, using ="gender-male")
	private WebElement genderMaleRadioButton;
	 
	@FindBy(how= How.ID, using ="FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(how= How.ID, using ="LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(how= How.ID, using ="Email")
	private WebElement emailTextbox;
	
	@FindBy(how= How.ID, using ="Password")
	private WebElement PasswordTextbox;
	
	@FindBy(how= How.ID, using ="ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(how= How.CSS, using ="#register-button")
	private WebElement registerButton;
	
	@FindBy(how= How.XPATH, using ="//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(how = How.CSS, using =".ico-logout")
	private WebElement logoutLink;
	
	
	
	public void clickToMaleButton() {
		waitToElementVisible(genderMaleRadioButton);
		clickToElement(genderMaleRadioButton);
		
	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitToElementVisible(firstNameTextbox);
		sendkeyToElement(firstNameTextbox,firstNameValue);
		
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementVisible(lastNameTextbox);
		sendkeyToElement(lastNameTextbox,lastNameValue);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox);
		sendkeyToElement(emailTextbox,email);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(PasswordTextbox);
		sendkeyToElement(PasswordTextbox,passwordValue);
	}

	public void inputToConfirmPasswordTextbox(String passwordValue) {
		waitToElementVisible(confirmPasswordTextbox);
		sendkeyToElement(confirmPasswordTextbox,passwordValue);
		
	}

	public void clickToRegisterButton() {
		waitToElementVisible(registerButton);
		clickToElement(registerButton);
	}

	public boolean isSuccessMesageDisplayed() {
		waitToElementVisible(registerSuccessMessage);
		return isElementDisplayed(registerSuccessMessage);

	}

	public void clickToLogout() {
		waitToElementVisible(logoutLink);
		clickToElement(logoutLink);
		
	}

}

