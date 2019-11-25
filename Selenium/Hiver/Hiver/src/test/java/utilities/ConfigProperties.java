package utilities;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
  private static Properties properties = new Properties();

  static {
    try {
      InputStream fileInput = ConfigProperties.class.getClassLoader().getSystemResourceAsStream("config/config.properties");
      properties.load(fileInput);
      fileInput.close();

    } catch (FileNotFoundException e) {
      System.err.println("Unable to find config.properties file - FileNotFoundException: " + e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("Exception on loading stream file to properties object: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public ConfigProperties() {
  }

  public String getPropertyValue(String key, String defaultValue) {
    return properties.getProperty(key, defaultValue);
  }
  
	/******************************************************************************
	 * Default Browser details
	 ******************************************************************************/
  public String getBrowser(){
    return properties.getProperty("defaultBrowser");
  }
  
	/******************************************************************************
	 * Get Wait time
	 ******************************************************************************/
  public String getWaitTime(){
    return properties.getProperty("wait");
  }
  
	/******************************************************************************
	 * Get Amazon URL
	 ******************************************************************************/
	public String getAmazonURL() {
		return properties.getProperty("amazonURL");
	}
	

	/******************************************************************************
	 * Get Flipkart URL
	 ******************************************************************************/
	public String getFlipkartURL() {
		return properties.getProperty("flipkartURL");
	}

	/******************************************************************************
	 * Get  Search Text 
	 ******************************************************************************/
	public String getSearchText() {
		return properties.getProperty("iphoneSearch");
	}
  
	/******************************************************************************
	 * Get chromeDriver path
	 ******************************************************************************/
  public String getchromeDriverPath(){
	    return properties.getProperty("chromeDriverPath");
	  }
  
	/******************************************************************************
	 * Get EdgeURl
	 ******************************************************************************/
  
  public String getedgeDriverPath(){
	    return properties.getProperty("edgeDriverPath");
	  }
  
	/******************************************************************************
	 * Get FirefoxDriver
	 ******************************************************************************/
  
  public String getfirefoxDrierPath(){
	    return properties.getProperty("firefoxDrierPath");
	  }

}
