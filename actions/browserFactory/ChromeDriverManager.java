package browserFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	@Override
	void createDriver() {
		//add service and new driver
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver= new ChromeDriver(options);
		
	}

}
