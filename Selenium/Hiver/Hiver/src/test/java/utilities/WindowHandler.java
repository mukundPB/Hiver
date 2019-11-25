package utilities;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class WindowHandler {
	
	public void switchTab(WebDriver driver)
	{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

}
