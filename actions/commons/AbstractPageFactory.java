package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageFactory {
	WebDriver driverGlobal;
	WebElement element;
	
	WebDriverWait waitExplicit;
	List<WebElement>elements;
	long shortTimeout= 5000;
	long longTimeout= 30000;
	
	public AbstractPageFactory(WebDriver driverLocal) {
		driverGlobal = driverLocal;
		waitExplicit= new WebDriverWait(driverGlobal,longTimeout);
	
	}


	public void waitToElementVisible(WebElement element) {  
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	

	
	public void clickToElement(WebElement element) {
		element.click();
	}
	
	public void sendkeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
}

