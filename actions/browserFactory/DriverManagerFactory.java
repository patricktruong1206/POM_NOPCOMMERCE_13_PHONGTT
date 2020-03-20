package browserFactory;

public class DriverManagerFactory {

	public static DriverManager getBrowserManager(String browserName) {
		DriverManager driverManager;
		switch(browserName) {
		case "chrome":
			driverManager = new ChromeDriverManager();
			break;
		case "firefox":
			driverManager = new FireFoxDriverManager();
			break;
		default:
			driverManager = new ChromeHeadlessDriverManager();
			break;
		}
		return driverManager;
	}
}
