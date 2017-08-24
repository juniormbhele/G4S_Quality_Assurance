package CopsPackage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SetUp 
{
	static WebDriver driver; 
    private static String baseUrl; 
    
	@SuppressWarnings("deprecation")
	public static void setUp() throws Exception 
    {
    	//Set up Webdriver for Firefox, I actually hate this shiiiit
    	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
	
		File pathToBinary = new File(Util.FIREFOX_PATH);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);

	
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, firefoxProfile);

	// Setting Base URL for COPS
	baseUrl = Util.BASE_URL;
	// Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
	// Refer - http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html
	driver.manage().timeouts()
		.implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
	// Go to https://uat.cashops.deposita.co.za/
	driver.get(baseUrl);
    }

	public static void LoginValidation() throws InterruptedException
	{
		
		try {
	    	//checking if the system really did log in by checking the page title
			String actualTitle;
			
			driver.manage().window().maximize();
			
			//Negative Testing (Wrong Username and right Password )
			
			driver.findElement(By.name("j_username")).clear();
			driver.findElement(By.name("j_username")).sendKeys(Util.Wrong_USER_NAME); // Enter username
			driver.findElement(By.name("j_password")).clear();
			driver.findElement(By.name("j_password")).sendKeys(Util.PASSWD); // Enter Password
			// Click Login
			driver.findElement(By.name("submit")).click();
			
			Thread.sleep(1000);
			
			
			//Negative Testing (right password and wrong Password )
			
			driver.findElement(By.name("j_username")).clear();
			driver.findElement(By.name("j_username")).sendKeys(Util.USER_NAME); // Enter username
			driver.findElement(By.name("j_password")).clear();
			driver.findElement(By.name("j_password")).sendKeys(Util.Wrong_PASSWD); // Enter Password
			// Click Login
			driver.findElement(By.name("submit")).click();
			
			Thread.sleep(1000);
			
			//Checking if the log in went through (should return pass)
			actualTitle = driver.getTitle();
			if (actualTitle.contains(Util.EXPECT_TITLE)) {
				System.out.println("Test case: Failed");
			} else {
				System.out.println("Test case : Passed");
			} 
		} finally {
			// TODO: handle finally clause
			
			
			
		}
		
	}
	public static void Userlogin() throws InterruptedException 
	   {
		
		    
		    try {
		    	//checking if the system really did log in by checking the page title
				String actualTitle;
				
				driver.manage().window().maximize();
				
				//Positive Testing (right Username and right Password )
				
				
				driver.findElement(By.name("j_username")).clear();
				driver.findElement(By.name("j_username")).sendKeys(Util.USER_NAME); // Enter username
				driver.findElement(By.name("j_password")).clear();
				driver.findElement(By.name("j_password")).sendKeys(Util.PASSWD); // Enter Password
				
				Thread.sleep(1000);
				// Click Login
				driver.findElement(By.name("submit")).click();
				
				Thread.sleep(1000);
				//Checking if the log in went through
				actualTitle = driver.getTitle();
				if (actualTitle.contains(Util.EXPECT_TITLE)) {
					System.out.println("Test case: Passed");
				} else {
					System.out.println("Test case : Failed");
				} 
			} finally {
				// TODO: handle finally clause
				
				
				
			}
					

	    }
	
	public static void close()
	{
		driver.close();
	}

     

}
