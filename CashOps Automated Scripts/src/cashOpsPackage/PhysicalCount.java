package cashOpsPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PhysicalCount 
{
	
	static WebDriver driver;
	String cITClientID = "1002"	;
	double expectedAmount = 1000;
	double count1 = 1000;
	String RemovalDate = "25/07/2017";
	String BankedDate = "27/07/2017";
	int CanisterNumber =855620;
	String DepositReference = "'REF:JNR Count 2";
	String CashCentreName = "000 SBV Capitec Bedfordview";
	int BinSealNumber = 12001;
	int SealNumber = 130002;
	String CurrencyCode = "ZAR (South Africa)"; 
	
	String ManagerUsername = "Junior.Bedfordview";
	String ManagerPassword = "Junior100@";
	
	String baseUrl ;
  @Test
  public void CashOpsPhysicalCount() 
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
	  
	  
	  for (int i = 0; i < 10; i++) 
	  {
		  
		  
		//Capture Unmatched Physical Count
		  
		  
		  //Now filling up required details
		//Searching for the physical count
		driver.findElement(By.xpath("//*[@id=\"expectedAmountSearchParameters\"]/table/tbody/tr[8]/td/input")).click();
		driver.findElement(By.xpath("//*[@id=\"contents\"]/p[2]/a")).click();
		//canisterRemovalDate
		driver.findElement(By.id("canisterRemovalDate")).sendKeys(RemovalDate);
		//bankedDate
		driver.findElement(By.id("bankedDate")).sendKeys(BankedDate);
		//canisterCode
		driver.findElement(By.id("canisterCode")).sendKeys( String.valueOf(CanisterNumber));
		//depositReference
		driver.findElement(By.id("depositReference")).sendKeys(DepositReference);
		//citClientCode
		driver.findElement(By.id("citClientCode")).sendKeys(cITClientID);
		//cashCentreId
		driver.findElement(By.id("cashCentreId")).sendKeys(CashCentreName);
		//binSealNumber
		driver.findElement(By.id("binSealNumber")).sendKeys( String.valueOf(BinSealNumber));
		//sealCode
		driver.findElement(By.id("sealCode")).sendKeys( String.valueOf(SealNumber));
		//currencyId
		driver.findElement(By.id("currencyId")).sendKeys(CurrencyCode);
		//total.expected
		driver.findElement(By.id("total.expected")).clear();
		driver.findElement(By.id("total.expected")).sendKeys(String.valueOf(expectedAmount));
		//total.counted_1
		driver.findElement(By.id("total.counted_1")).clear();
		driver.findElement(By.id("total.counted_1")).sendKeys(String.valueOf(count1));
		//authorisingManagerUsername
		driver.findElement(By.id("authorisingManagerUsername")).sendKeys(ManagerUsername);
		//authorisingManagerPassword
		driver.findElement(By.id("authorisingManagerPassword")).sendKeys(ManagerPassword);
		//Process Entry
		driver.findElement(By.xpath("//*[@id=\"form1\"]/table[2]/tbody/tr[4]/td/input")).click();
		String ExpectedMessage = "Physical Count saved successfully";
		if (ExpectedMessage.contains(driver.findElement(By.xpath("//*[@id=\"contents\"]/h1")).getText())) 
		{
			System.out.println("Physical Count saved successfully");
			driver.findElement(By.xpath("//*[@id=\"contents\"]/a")).click();
		} 
		expectedAmount=expectedAmount+1500;
		count1=count1+1500;
		CanisterNumber++;
		SealNumber++;
		BinSealNumber++;
	}
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() 
  {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		// Step 1 Goto http://live.guru99.com/
	    baseUrl = "https://41.21.131.56/deposita/physicalCountSearch.do";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  //driver.quit();
  }

}
