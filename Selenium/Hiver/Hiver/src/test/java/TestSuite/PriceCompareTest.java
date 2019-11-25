package TestSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.ConfigProperties;
import utilities.WaitforElement;

public class PriceCompareTest {
	WebDriver driver=utilities.WebDriverFactory.getDriverInstance();
	ConfigProperties conf=new ConfigProperties();
	WaitforElement wait=new WaitforElement();
	WebPageObjects object = null;
	String amazonPrice,flipkartPrice;
	
	
	@BeforeTest
	public void browseSite()
	{
		driver.get(conf.getAmazonURL());
		driver.manage().timeouts().implicitlyWait(Long.parseLong(conf.getWaitTime()), TimeUnit.SECONDS);
		object=PageFactory.initElements(driver,WebPageObjects.class);
	}
	
	@Test(priority=1)
	public void amazonprice()
	{
		amazonPrice=object.amazonIPhoneSearch(driver);
	}
	
	@Test(priority=2)
	public void flipkartPrice()
	{
		driver.get(conf.getFlipkartURL());
		flipkartPrice=object.flipIphoneSearch(driver);
	}
	
	@Test(priority=3)
	public void priceCheck()
	{
		object.priceCompare(Integer.parseInt(amazonPrice), Integer.parseInt(flipkartPrice));
	}

	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
}
