package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.FooterMyAccountPageObject;
import pageObjects.FooterNewProductPageObject;
import pageObjects.FooterSearchPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static FooterMyAccountPageObject getFooterMyAccountPage(WebDriver driver) {
		return new FooterMyAccountPageObject(driver);
	}
	
	public static FooterNewProductPageObject getFooterNewProductPage(WebDriver driver) {
		return new FooterNewProductPageObject(driver);
	}
	
	public static FooterSearchPageObject getFooterSearch(WebDriver driver) {
		return new FooterSearchPageObject(driver);
	}
}
	
	
