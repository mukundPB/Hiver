package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	public void moveMouseTo(WebDriver driver,WebElement Element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(Element);
	}
	

}
