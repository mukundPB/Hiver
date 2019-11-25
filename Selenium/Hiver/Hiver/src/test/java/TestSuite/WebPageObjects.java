package TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.ConfigProperties;
import utilities.MouseActions;
import utilities.WaitforElement;
import utilities.WindowHandler;

public class WebPageObjects {
	WaitforElement wait=new WaitforElement();
	ConfigProperties conf=new ConfigProperties();
	MouseActions act=new MouseActions();
	WindowHandler winhandler= new WindowHandler();
	String amazonPrice,flipkartPrice;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	private WebElement flipkartSearchText;
	
	@FindBy(xpath="//button[@type='submit']") 
	private WebElement flipSearchButton;
	
	@FindBy(xpath="//div[text()='Apple iPhone 7 (Black, 32 GB)']")
	private WebElement flipIphoneSelection;
	
	@FindBy(xpath="//div[div[div[text()='Apple iPhone 7 (Black, 32 GB)']]]/div[2]/div/div/div[contains(text(),'₹')]")
	private WebElement flipIphoneValue;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement amazonSearchText;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement amazonSearchButton;
	
	@FindBy(xpath="//div[div[div[div[div[h2[a[span[text()='Apple iPhone 7 (32GB) - Black']]]]]]]]/div[2]/div/div/div/div/div/a/span/span[2]/span[2]")
	private WebElement amazonIphoneValue;
	
	@FindBy(xpath="//span[text()='Electronics']")
	private WebElement flipElectronics;
	
	@FindBy(xpath="//a[text()='Realme XT']")
	private WebElement flipPhone;
	
	@FindBy(xpath="//h1[text()='Realme XT']")
	private WebElement flipPhonePage;
	
	
	@FindBy(xpath="//div[contains(text(),'Realme XT')]")
	private WebElement flipPhoneSelect;
	
	@FindBy(xpath="//button[text()='BUY NOW']")
	private WebElement flipAddToCart;
	
	@FindBy(xpath="//button[text()='+']")
	private WebElement flipAddMore;
	
	@FindBy(xpath="//div[button[text()='+']]/div/input")
	private WebElement flipItemQty;
	
	@FindBy(xpath="//div[contains(text(),'changed')]")
	private WebElement flipChangeAlert;
	
	
	public String amazonIPhoneSearch(WebDriver driver)
	{
		wait.waitforElement(driver, amazonSearchText);
		amazonSearchText.click();
		amazonSearchText.sendKeys(conf.getSearchText());
		amazonPrice=amazonIphoneValue.getText();
		return amazonPrice;
	}
	
	public String flipIphoneSearch(WebDriver driver)
	{
		wait.waitforElement(driver, flipkartSearchText);
		flipkartSearchText.sendKeys(conf.getSearchText());
		flipSearchButton.click();
		wait.waitforElement(driver, flipIphoneSelection);
		flipkartPrice=flipIphoneValue.getText();
		return(flipkartPrice.substring(1, (flipkartPrice.length()-1)));
		
	}
	
	public void priceCompare(int ap, int fp)
	{
		if(ap>fp)
		{
			System.out.println("amazon price is greater then Flipkart");
		}
		else if (fp>ap)
		{
			System.out.println("Iphone price in Flipkart  is greater then iphone price in Amazon");
		}
		else
		{
			System.out.println(conf.getSearchText()+" price is same on Amazon and Flipkart that is :: "+ap);
		}
	}
	
	public void navigateToPhone(WebDriver driver)
	{
		wait.waitforElement(driver, flipElectronics);
		act.moveMouseTo(driver, flipElectronics);
		flipPhone.click();
		wait.waitforElement(driver, flipPhonePage);
		flipPhoneSelect.click();
		
	}
	
	public void addToCart(WebDriver driver)
	{
		wait.waitforElement(driver, flipAddToCart);
		flipAddToCart.click();
		wait.waitforElement(driver, flipAddMore);
		flipAddMore.click();
		wait.waitforElement(driver, flipChangeAlert);
		Assert.assertEquals(2, flipItemQty.getText());
	}
	
	

}
