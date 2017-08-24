package cashOpsPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AddCITVehicles 
{
	
static WebDriver driver;
String baseUrl;

  @Test
  public void addCITVehicle() 
  {
	  driver.get(baseUrl);
  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		// Step 1 Goto http://live.guru99.com/
	    baseUrl = "https://41.21.131.56/deposita/addEditCITVehicle.do?id=0";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }
  

}
