package browserFactory;

import org.openqa.selenium.firefox.FirefoxDriver;


public class FireFoxDriverManager extends DriverManager{
	@Override
	void createDriver() {
		//add service and new driver
		System.setProperty("webdriver.gecko.driver", ".//resources//geckodriver.exe");
		driver= new FirefoxDriver();
	}
}
