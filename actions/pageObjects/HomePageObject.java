package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPages  {
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitToElementVisible(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver,HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
		
	}

	public HomePageObject clickToLoginLink() {
		waitToElementVisible(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver,HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver,HomePageUI.ACCOUNT_LINK);
		return isElementDisplayed(driver,HomePageUI.ACCOUNT_LINK);
	}

	public boolean isLogOutLinkDisplayed() {
		waitToElementVisible(driver,HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver,HomePageUI.LOGOUT_LINK);
		
	}


}
