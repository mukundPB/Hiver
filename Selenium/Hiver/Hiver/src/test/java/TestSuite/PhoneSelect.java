package TestSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.ConfigProperties;
import utilities.MouseActions;
import utilities.WaitforElement;

public class PhoneSelect {
	WebDriver driver=utilities.WebDriverFactory.getDriverInstance();
	ConfigProperties conf=new ConfigProperties();
	WaitforElement wait=new WaitforElement();
	WebPageObjects object = null;
	String amazonPrice,flipkartPrice;
	
	
	
	@BeforeTest
	public void browseSite()
	{
		driver.get(conf.getFlipkartURL());
		driver.manage().timeouts().implicitlyWait(Long.parseLong(conf.getWaitTime()), TimeUnit.SECONDS);
		object=PageFactory.initElements(driver,WebPageObjects.class);
	}

	@Test(priority=1)
	public void selectionTest()
	{
		object.navigateToPhone(driver);
	}
	
	@Test(priority=2)
	public void addToCartTest()
	{
		object.addToCart(driver);
	}

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
