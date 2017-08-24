package cashOpsPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AddCITVehicles 
{
	
static WebDriver driver;
String baseUrl;

  @Test
  public void addCITVehicle() throws Exception 
  {
	  //Go to the CashOps Link
	  driver.get(baseUrl);
	  
	  //Log in with your username
	  driver.findElement(By.name("j_username")).clear();
	  driver.findElement(By.name("j_username")).sendKeys(Util.USER_NAME);
	  driver.findElement(By.name("j_password")).clear();
	  driver.findElement(By.name("j_password")).sendKeys(Util.PASSWD);
	  
	  
	  //submit
	  driver.findElement(By.name("submit")).click();
	  
	  
	  //find a menu
	  
	  
	  String name = "JNR_";
	  String number = "004";
	  String code = name + number;
	  String registration = "568 004";	  
	 
	 // for (int i = 0; i < 20; i++)  
	  //{
		  String menuName = "Admin";
		  
		
		  
		//driver.findElement(By.name("code")).sendKeys(code+i);
		//driver.findElement(By.name("registration")).sendKeys(registration+i);
		//driver.findElement(By.name("citBranch.id")).sendKeys("Coin Bethlehem");
		
		//driver.findElement(By.cssSelector(".formTable > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > input:nth-child(1)")).click();
		
		//driver.get(baseUrl);
		
		//*[@id="nav"]/li[2]
		  
		 // driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]")).click();
		  
		 //driver.findElement(By.xpath("///*[@id=\"nav\"]/li[2]/ul/li[10]/a")).click();
		  //CashOpsTest.getTheMainMenu("Admin");
		 //CashOpsTest.clickLinkByHref("CIT Vehicles");
		  //CashOpsTest.clickLinkByHref("Add CIT Vehicle");
		
	 // }
	  
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
	  //driver.quit();
  }
  

}
