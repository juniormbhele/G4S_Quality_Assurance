package sybrinPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUpEnvironment 
{
	// Time to wait when searching for a GUI element 
			public static final int WAIT_TIME = 10; 
			
			static WebDriver driver;
	
		
		//Setting up URL for the test
		
		public static void TestURL() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Junior Denty\\Documents\\Selenium\\Downloads\\chromedriver.exe");
			//Setting Base URL
			String url = "http://automationpractice.com";
			
			driver = new ChromeDriver();
			driver.manage().timeouts()
				.implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		
		}

}
