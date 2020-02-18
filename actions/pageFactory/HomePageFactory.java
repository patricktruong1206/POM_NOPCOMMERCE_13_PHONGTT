package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;


public class HomePageFactory extends AbstractPageFactory  {

	public HomePageFactory(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, this);
	}
	
	@FindBy(how = How.CSS, using=".ico-register")
	WebElement registerLink;
	
	@FindBy(how = How.CSS, using=".ico-login")
	WebElement loginLink;
	
	@FindBy(how = How.CSS, using=".ico-account")
	WebElement accountLink;
	
	@FindBy(how = How.CSS, using=".ico-logout")
	WebElement logoutLink;
	
	public void clickToRegisterLink() {
		waitToElementVisible(registerLink);
		clickToElement(registerLink);
		
	}

	public void clickToLoginLink() {
		waitToElementVisible(loginLink);
		clickToElement(loginLink);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(accountLink);
		return isElementDisplayed(accountLink);
	}

	public boolean isLogOutLinkDisplayed() {
		waitToElementVisible(logoutLink);
		return isElementDisplayed(logoutLink);
	}

	
	
	
	
}


