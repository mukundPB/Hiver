package utilities;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.*;

public class WebDriverFactory {

	private static WebDriver driver;
	private static ConfigProperties configProperties = new ConfigProperties();

	private WebDriverFactory() {

	}

	public static WebDriver getDriverInstance() {
		try {
			driver.getWindowHandle();
		} catch (Exception e) {
			String browser = configProperties.getPropertyValue("defaultBrowser", "firefox");
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",configProperties.getchromeDriverPath());
				driver = new ChromeDriver();
				Point targetPosition = new Point(0, 0);
				driver.manage().window().setPosition(targetPosition);
				Dimension targetSize = new Dimension(1440, 900); // your screen
																	// resolution
																	// here
				driver.manage().window().setSize(targetSize);
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",configProperties.getfirefoxDrierPath());
				driver = new FirefoxDriver();
				Point targetPosition = new Point(0, 0);
				driver.manage().window().setPosition(targetPosition);
				Dimension targetSize = new Dimension(1440, 900); // your screen
																	// resolution
																	// here
				driver.manage().window().setSize(targetSize);
			}else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.Edge.driver",configProperties.getedgeDriverPath());
				driver = new EdgeDriver();
				Point targetPosition = new Point(0, 0);
				driver.manage().window().setPosition(targetPosition);
				Dimension targetSize = new Dimension(1440, 900); // your screen
																	// resolution
																	// here
				driver.manage().window().setSize(targetSize);
			}
		}
		return driver;
	}


}
