package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage  {
	WebDriver driverGlobal;
	public HomePageObject(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal= driverLocal;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitToElementVisible(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driverGlobal);
		
	}

	public HomePageObject clickToLoginLink() {
		waitToElementVisible(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getHomePage(driverGlobal);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(HomePageUI.ACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.ACCOUNT_LINK);
	}

	public boolean isLogOutLinkDisplayed() {
		waitToElementVisible(HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.LOGOUT_LINK);
		
	}

}
