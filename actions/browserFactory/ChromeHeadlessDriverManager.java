package browserFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920x1080");
		driver= new ChromeDriver(options);
		
	}


	

}
