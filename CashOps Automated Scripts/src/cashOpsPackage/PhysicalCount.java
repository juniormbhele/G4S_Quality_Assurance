package cashOpsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PhysicalCount 
{
	
	static WebDriver driver;
	String cITClientID = "281449"	;
	double expectedAmount = 3000;
	double count1 = 3000;
	String RemovalDate = "25/09/2017";
	String BankedDate = "25/09/2017";
	int CanisterNumber =610044;
	String DepositReference = "'REF:CashPro Count 001";
	String CashCentreName = "117 G4S Krugersdorp";
	int BinSealNumber = 12005;
	int SealNumber = 5237155;
	String CurrencyCode = "ZAR (South Africa)"; 
	
	String ManagerUsername = "Siyabonga.Mnguni";
	String ManagerPassword = "password";
	
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
	  
	  
	  for (int i = 0; i < 50; i++)
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
