package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AbstractTest {
	private WebDriver driver;
	
	public WebDriver getBrowserDriver(String browserName) {
		 String rootFolder= System.getProperty("user.dir");
		  if(browserName.equalsIgnoreCase("chrome")) {
			  System.setProperty("webdriver.chrome.driver", rootFolder+"\\resources\\chromedriver.exe");
			  driver= new ChromeDriver();
		  } else if (browserName.equalsIgnoreCase("firefox")) {
			  System.setProperty("webdriver.gecko.driver",rootFolder + "\\resources\\geckodriver.exe");
			  System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");
			  driver= new FirefoxDriver();
		  } else if (browserName.equalsIgnoreCase("headless_chrome")) {
			  System.setProperty("webdriver.chrome.driver", rootFolder+"\\resources\\chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("headless");
			  options.addArguments("window-size=1920x1080");
			  driver= new ChromeDriver(options);
		  } else if (browserName.equalsIgnoreCase("headless_firefox")) {
			  System.setProperty("webdriver.gecko.driver",rootFolder + "\\resources\\geckodriver.exe");
			  FirefoxOptions options= new FirefoxOptions();
			  options.addArguments("--headless");
			  options.addArguments("window-size=1920x1080");
			  driver= new FirefoxDriver(options);
		  }
		  
		  driver.manage().window().maximize();
		  driver.get(GlobalConstants.DEV_URL);
		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		  return driver;
		  
	}

}
