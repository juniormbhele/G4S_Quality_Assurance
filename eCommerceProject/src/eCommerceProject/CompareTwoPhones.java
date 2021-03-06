package eCommerceProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class CompareTwoPhones 
{
	private WebDriver driver;
	  private String baseUrl;
	  public int scc = 0;
	  
	  private StringBuffer verificationErrors = new StringBuffer();
	  
  @Test
  public void compareTwoPhones() 
  {
	  	driver.get(baseUrl); 
	    driver.manage().window().maximize();
		//Step 2. Verify Title of the page
	    String demoSite  = driver.findElement(By.cssSelector("h2")).getText();
	    System.out.println(demoSite);
	    try {
	      AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", demoSite);
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }	    
	    

	    // Step 3. Click on �MOBILE� menu
	    driver.findElement(By.linkText("MOBILE")).click();	
	    
	    
	    //adding two phones to compare
	    
	    //iPhone 
	    
	    driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();
	  
	    
	    //Sony 
	    
	    driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	    
	    //Clicking the Compare button
	    
	    driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button/span/span")).click();
	    
	    //switching to the open window
	    
	    for (String handle : driver.getWindowHandles()) 
	    {
	    	driver.switchTo().window(handle);
	    	
	    }
	    
	    System.out.println("We see the page "+ driver.findElement(By.xpath("//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[1]/h2")).getText());
	  
	    System.out.println("We see the page "+ driver.findElement(By.xpath("//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[2]/h2/a")).getText());
	    
	  //*[@id="top"]/body/div/div[2]/button/span/span
	    
	    driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/button/span/span")).click();
	    
  }
  @BeforeTest
  public void beforeTest() 
  {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		// Step 1 Goto http://live.guru99.com/
	    baseUrl = "http://live.guru99.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
