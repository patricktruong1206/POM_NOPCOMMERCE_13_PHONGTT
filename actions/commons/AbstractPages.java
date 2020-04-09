package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.FooterMyAccountPageObject;
import pageObjects.FooterNewProductPageObject;
import pageObjects.FooterSearchPageObject;
import pageObjects.HomePageObject;
import pageUIs.AbstractPageUI;
import pageUIs.FooterNewProductUI;
import pageUIs.FooterSearchUI;
import pageUIs.HomePageUI;

public class AbstractPages {
	WebDriver driver;
	WebElement element;
	Select select;
	JavascriptExecutor jsExecutor;
	WebDriverWait waitExplicit;
	List<WebElement>elements;
	Actions action;
	By byXpath;
	long shortTimeout= 5000;
	long longTimeout= 30000;

	public void openURL(WebDriver driver,String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
		driver.manage().window().maximize();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
		
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert(WebDriver driver,String Value) {
		driver.switchTo().alert().sendKeys(Value);
	}
	
	public void waitToAlertPresence(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	
	public WebElement findElementByXpath(WebDriver driver,String locator) {
		return driver.findElement(By.xpath(locator));
		}
	
	public WebElement findElementByXpath(WebDriver driver,String locator, String ...values) {
		locator = String.format(locator, (Object[]) values);
		return  driver.findElement(byXpathLocator(locator));
	}
	
	public List<WebElement> findElementsByXpath(WebDriver driver,String locator){
		return driver.findElements(byXpathLocator(locator));
	}
	
	public List<WebElement> findElementsByXpath(WebDriver driver,String locator, String ...values){
		locator = String.format(locator, (Object[]) values);
		return driver.findElements(byXpathLocator(locator));
	}
	
	public By  byXpathLocator(String locator) {
		return byXpath= By.xpath(locator);
	}
	
	public By  byXpathLocator(String locator, String...values) {
		locator = String.format(locator, (Object[]) values);
		return byXpath= By.xpath(locator);
	}
	
	public void clickToElement(WebDriver driver,String locator) {
		findElementByXpath(driver,locator).click();
	}
	
	public void clickToElement(WebDriver driver,String locator,String...values) {
		findElementByXpath( driver,locator,values).click();
	}
	
	
	
	public void sendkeyToElement(WebDriver driver,String locator, String value) {
		findElementByXpath(driver,locator).clear();
		findElementByXpath(driver,locator).sendKeys(value);
	}
	
	public int countElementNumber(WebDriver driver,String locator) {
		return findElementsByXpath(driver,locator).size();
	}
	
	
	public void  selectItemInHtmlDropdown(WebDriver driver,String locator,String valueItem) {
		element = findElementByXpath(driver,locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	
	public String getValueItemInDropDown(WebDriver driver,String locator) {
		element = findElementByXpath(driver,locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
		
	}
	
	public void selectItemDropdown(WebDriver driver,String parentLocator, String allItemLocator, String expectedItem) throws InterruptedException{
		
		
		element= findElementByXpath(driver,parentLocator);
		
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		
		jsExecutor.executeScript("arguments[0].click();", element);

		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemLocator)));
		
		elements = findElementsByXpath(driver,allItemLocator);
			
		for (WebElement item:elements) {
			if(item.getText().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				Thread.sleep(1000); 
				item.click();
				Thread.sleep(2000);
				break;
			}
		}
		
	}
	
	public void sleepInSecond(long numberInSecond) {
		try {
			Thread.sleep(numberInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public String getAttributeValue(WebDriver driver,String attributeName,String locator) {
		return findElementByXpath(driver,locator).getAttribute(attributeName);
	}
	
	public String getTextElement(WebDriver driver,String locator) {	
		return findElementByXpath(driver,locator).getText();
	}

	public void checkTheCheckBox(WebDriver driver,String locator) {
		element= findElementByXpath(driver,locator);
		if (element.isSelected()==false) {
			element.click();
		}
	}
	public void unCheckTheCheckBox(WebDriver driver,String locator) {
		element= findElementByXpath(driver,locator);
		if (element.isSelected()==true) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locator) {
		return findElementByXpath(driver,locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locator, String ...values) {
		return findElementByXpath(driver,locator,values).isDisplayed();
	}
	
	
	
	public boolean isElementSelected(WebDriver driver,String locator) {
		return findElementByXpath(driver,locator).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver,String locator) {
		return findElementByXpath(driver,locator).isEnabled();
	}
	
	public void  switchToChildWindowByTitle(WebDriver driver,String title) {
		Set<String> allWindows= driver.getWindowHandles();
	
		for(String runWindows:allWindows){
			driver.switchTo().window(runWindows);
	
			String currentWin= driver.getTitle();
			
			if(currentWin.equals(title)) {
				break;
			}
		}
	}
	
	public boolean closeAllWindowsWithoutParent(WebDriver driver,String parentWindow) {
		Set<String> allWindows=driver.getWindowHandles();
		for(String runWindows:allWindows) {
			if(!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if(driver.getWindowHandles().size()==1)
			return true;
		else
			return false;
	}
	
	public void switchToChildWindowById(WebDriver driver,String parent) {
			Set<String> allWindows= driver.getWindowHandles();
			for(String runWindow:allWindows) {
				if(!runWindow.equals(parent)) {
					driver.switchTo().window(runWindow);
					break;
				}
			}
	}
	
	public void swithToFrameOrIframe(WebDriver driver,String locator) {
		driver.switchTo().frame(findElementByXpath(driver,locator));
	}
	
	public void switchToParentPage() {
		driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		element = findElementByXpath(driver,locator);
		action.moveToElement(element).perform();
	}
	public void doubleClickElement(WebDriver driver,String locator) {
		element = findElementByXpath(driver,locator);
		action.doubleClick(element).perform();
	}
	public void rightClickElement(WebDriver driver,String locator) {
		element = findElementByXpath(driver,locator);
		action.contextClick().perform();
	}
	
	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		element = findElementByXpath(driver,locator);
		action.sendKeys(element,key).perform();
	}
	
	public void dragAndDrop(WebDriver driver,String locatorSource, String locatorTarget) {
		WebElement elementSource = driver.findElement(By.xpath(locatorSource));
		WebElement elementTarget = driver.findElement(By.xpath(locatorTarget));
		action.dragAndDrop(elementSource, elementTarget).perform();
	}
	
	public boolean checkAnyImageLoaded(WebDriver driver,String locator) {
		boolean status;
		element = driver.findElement(By.xpath(locator));
		status = (boolean)jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth!=\"undefined\" &&arguments[0].naturalWidth>0 ", element);
		if(status) {
			return true;
		} else {
			return false;
				}	
	}
	
	public void waitToElementVisible(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}
	
	public void waitToElementVisible(WebDriver driver,String locator,String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}
	
	
	public void waitToElementInvisible(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
	}
	
	public void waitToElementInvisible(WebDriver driver,String locator, String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
	}
	
	public void waitToElementPresence(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
	}
	
	public void waitToElementPresence(WebDriver driver,String locator,String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
	}
	
	public void waitToElementClickable(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	
	public void waitToElementClickable(WebDriver driver,String locator, String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	public void highlightElement(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}
	public void clickToElementByJS(WebDriver driver,String locator) {
		element= driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver,String locator) {
		element= driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver,String locator, String value) {
		element= driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeElementAttribute(WebDriver driver,String locator, String attributeRemove) {
		element= driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	
	public FooterMyAccountPageObject openFooterMyAccountPage(WebDriver driver) {
		 waitToElementVisible(driver, AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		 clickToElement(driver,AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}

	public FooterSearchPageObject openFooterSearchPage(WebDriver driver) {
		
		waitToElementVisible(driver,AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);
		clickToElement(driver,AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);
		return PageGeneratorManager.getFooterSearch(driver);
	}
	
	public HomePageObject openHomePage(WebDriver driver) {
		waitToElementVisible(driver,AbstractPageUI.HOMEPAGE_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public FooterNewProductPageObject openNewProductPage(WebDriver driver) {
		waitToElementVisible(driver,AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);
	return PageGeneratorManager.getFooterNewProductPage(driver);
	}
	
	
	// Not so many page
	public  AbstractPages openFooterPageByName(WebDriver driver, String pageName) {
		waitToElementVisible(driver,AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(driver,AbstractPageUI.DYNAMIC_FOOTER_LINK,pageName); 
		//Factory Pattern
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getFooterSearch(driver);
		case "New products":
			return PageGeneratorManager.getFooterNewProductPage(driver);		
		default:
			return PageGeneratorManager.getFooterMyAccountPage(driver);
		}
	}
	
	public  void openFooterPagesByName(WebDriver driver, String pageName) {
		waitToElementVisible(driver,AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(driver,AbstractPageUI.DYNAMIC_FOOTER_LINK,pageName); 
		
	}
	

}

