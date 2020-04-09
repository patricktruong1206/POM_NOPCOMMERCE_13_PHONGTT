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

public class AbstractPage {
	WebDriver driverGlobal;
	WebElement element;
	Select select;
	JavascriptExecutor jsExecutor;
	WebDriverWait waitExplicit;
	List<WebElement>elements;
	Actions action;
	By byXpath;
	long shortTimeout= 5000;
	long longTimeout= 30000;
	
	public AbstractPage(WebDriver driverLocal) {
		driverGlobal = driverLocal;
		jsExecutor = (JavascriptExecutor) driverGlobal;
		waitExplicit= new WebDriverWait(driverGlobal,longTimeout);
		action = new Actions(driverGlobal);
	
	}


	public void openURL(String urlValue) {
		driverGlobal.get(urlValue);
		driverGlobal.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
		driverGlobal.manage().window().maximize();
	}
	
	public String getPageTitle() {
		return driverGlobal.getTitle();
	}
	
	public String getPageURL() {
		return driverGlobal.getCurrentUrl();
	}
	
	public String getPageSource() {
		return driverGlobal.getPageSource();
		
	}
	
	public void backToPage() {
		driverGlobal.navigate().back();
	}
	
	public void fowardToPage() {
		driverGlobal.navigate().forward();
	}
	
	public void refreshPage() {
		driverGlobal.navigate().refresh();
	}
	
	public void acceptAlert() {
		driverGlobal.switchTo().alert().accept();
	}
	
	public void cancelAlert() {
		driverGlobal.switchTo().alert().dismiss();
	}
	
	public String getTextAlert() {
		return driverGlobal.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert(String Value) {
		driverGlobal.switchTo().alert().sendKeys(Value);
	}
	
	public void waitToAlertPresence(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	
	public WebElement findElementByXpath(String locator) {
		return driverGlobal.findElement(By.xpath(locator));
		}
	
	public WebElement findElementByXpath(String locator, String ...values) {
		locator = String.format(locator, (Object[]) values);
		return  driverGlobal.findElement(byXpathLocator(locator));
	}
	
	public List<WebElement> findElementsByXpath(String locator){
		return driverGlobal.findElements(byXpathLocator(locator));
	}
	
	public List<WebElement> findElementsByXpath(String locator, String ...values){
		locator = String.format(locator, (Object[]) values);
		return driverGlobal.findElements(byXpathLocator(locator));
	}
	
	public By  byXpathLocator(String locator) {
		return byXpath= By.xpath(locator);
	}
	
	public By  byXpathLocator(String locator, String...values) {
		locator = String.format(locator, (Object[]) values);
		return byXpath= By.xpath(locator);
	}
	
	public void clickToElement(String locator) {
		findElementByXpath(locator).click();
	}
	
	public void clickToElement(String locator, String ... values) {
		findElementByXpath(locator,values).click();
	}
	
	
	
	public void sendkeyToElement(String locator, String value) {
		findElementByXpath(locator).clear();
		findElementByXpath(locator).sendKeys(value);
	}
	
	public int countElementNumber(String locator) {
		return findElementsByXpath(locator).size();
	}
	
	
	public void  selectItemInHtmlDropdown(String locator,String valueItem) {
		element = findElementByXpath(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	
	public String getValueItemInDropDown(String locator) {
		element = findElementByXpath(locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
		
	}
	
	public void selectItemDropdown(String parentLocator, String allItemLocator, String expectedItem) throws InterruptedException{
		
		
		element= findElementByXpath(parentLocator);
		
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		
		jsExecutor.executeScript("arguments[0].click();", element);

		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemLocator)));
		
		elements = findElementsByXpath(allItemLocator);
			
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
	
	public String getAttributeValue(String attributeName,String locator) {
		return findElementByXpath(locator).getAttribute(attributeName);
	}
	
	public String getTextElement(String locator) {	
		return findElementByXpath(locator).getText();
	}

	public void checkTheCheckBox(String locator) {
		element= findElementByXpath(locator);
		if (element.isSelected()==false) {
			element.click();
		}
	}
	public void unCheckTheCheckBox(String locator) {
		element= findElementByXpath(locator);
		if (element.isSelected()==true) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(String locator, String ...values) {
		return findElementByXpath(locator,values).isDisplayed();
	}
	
	
	
	public boolean isElementSelected(String locator) {
		return findElementByXpath(locator).isSelected();
	}
	
	public boolean isElementEnabled(String locator) {
		return findElementByXpath(locator).isEnabled();
	}
	
	public void  switchToChildWindowByTitle(String title) {
		Set<String> allWindows= driverGlobal.getWindowHandles();
	
		for(String runWindows:allWindows){
			driverGlobal.switchTo().window(runWindows);
	
			String currentWin= driverGlobal.getTitle();
			
			if(currentWin.equals(title)) {
				break;
			}
		}
	}
	
	public boolean closeAllWindowsWithoutParent(String parentWindow) {
		Set<String> allWindows=driverGlobal.getWindowHandles();
		for(String runWindows:allWindows) {
			if(!runWindows.equals(parentWindow)) {
				driverGlobal.switchTo().window(runWindows);
				driverGlobal.close();
			}
		}
		driverGlobal.switchTo().window(parentWindow);
		if(driverGlobal.getWindowHandles().size()==1)
			return true;
		else
			return false;
	}
	
	public void switchToChildWindowById(String parent) {
			Set<String> allWindows= driverGlobal.getWindowHandles();
			for(String runWindow:allWindows) {
				if(!runWindow.equals(parent)) {
					driverGlobal.switchTo().window(runWindow);
					break;
				}
			}
	}
	
	public void swithToFrameOrIframe(String locator) {
		driverGlobal.switchTo().frame(findElementByXpath(locator));
	}
	
	public void switchToParentPage() {
		driverGlobal.switchTo().defaultContent();
	}
	
	public void hoverToElement(String locator) {
		element = findElementByXpath(locator);
		action.moveToElement(element).perform();
	}
	public void doubleClickElement(String locator) {
		element = findElementByXpath(locator);
		action.doubleClick(element).perform();
	}
	public void rightClickElement(String locator) {
		element = findElementByXpath(locator);
		action.contextClick().perform();
	}
	
	public void sendKeyboardToElement(String locator, Keys key) {
		element = findElementByXpath(locator);
		action.sendKeys(element,key).perform();
	}
	
	public void dragAndDrop(String locatorSource, String locatorTarget) {
		WebElement elementSource = driverGlobal.findElement(By.xpath(locatorSource));
		WebElement elementTarget = driverGlobal.findElement(By.xpath(locatorTarget));
		action.dragAndDrop(elementSource, elementTarget).perform();
	}
	
	public boolean checkAnyImageLoaded(String locator) {
		boolean status;
		element = driverGlobal.findElement(By.xpath(locator));
		status = (boolean)jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth!=\"undefined\" &&arguments[0].naturalWidth>0 ", element);
		if(status) {
			return true;
		} else {
			return false;
				}	
	}
	
	public void waitToElementVisible(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driverGlobal, longTimeout);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}
	
	public void waitToElementVisible(String locator, String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driverGlobal, longTimeout);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}
	
	
	public void waitToElementInvisible(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driverGlobal, longTimeout);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
	}
	
	public void waitToElementInvisible(String locator, String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driverGlobal, longTimeout);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
	}
	
	public void waitToElementPresence(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driverGlobal, longTimeout);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
	}
	
	public void waitToElementPresence(String locator,String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driverGlobal, longTimeout);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
	}
	
	public void waitToElementClickable(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driverGlobal, longTimeout);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	
	public void waitToElementClickable(String locator, String...values) {
		byXpath = byXpathLocator(locator,values);
		waitExplicit = new WebDriverWait(driverGlobal, longTimeout);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	public void highlightElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}
	public void clickToElementByJS(String locator) {
		element= driverGlobal.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(String locator) {
		element= driverGlobal.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(String locator, String value) {
		element= driverGlobal.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeElementAttribute(String locator, String attributeRemove) {
		element= driverGlobal.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
}
