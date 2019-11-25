package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitforElement {
	ConfigProperties conf=new ConfigProperties();

	public void waitforElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Long.parseLong(conf.getWaitTime()));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
