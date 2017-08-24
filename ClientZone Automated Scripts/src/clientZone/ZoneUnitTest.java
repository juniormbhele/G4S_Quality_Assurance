/**
 * 
 */
package clientZone;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import clientZone.Util;
import junit.framework.Assert;

/**
 * @author Sphiwe.Mbhele
 *
 */
public class ZoneUnitTest 
{

	/**
	 * @param args
	 */
	static WebDriver driver;

	//setting up the driver before begging to test
	public static void setUp()
	{
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(Util.BASE_URL);
			
			
			waitForPageLoaded();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("System is down");
			driver.close();
			
		}
		
	}
	
	//negative testing for User log in
	public static void LoginValidation() throws InterruptedException
	{
		
		try {
	    	//checking if the system really did log in by checking the page title
			String actualTitle;
			
			driver.manage().window().maximize();
			
			//Negative Testing (Wrong Username and right Password )
		
			
			
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/input")).clear();
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/input")).sendKeys(Util.Wrong_USER_NAME); // Enter username
			driver.findElement(By.xpath("html/body/div/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/input")).clear();
			driver.findElement(By.xpath("html/body/div/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/input")).sendKeys(Util.PASSWD); // Enter Password
			// Click Sign in
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div[2]/button")).click();
			
			Thread.sleep(1000);
			
			
			//Negative Testing (right password and wrong Password )
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/input")).clear();
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/input")).sendKeys(Util.USER_NAME); // Enter username
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/input")).clear();
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/input")).sendKeys(Util.Wrong_PASSWD); // Enter Password
			// Click Sign in
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div[2]/button")).click();
			
			Thread.sleep(1000);
			
			//Checking if the log in went through (should return pass)
			actualTitle = driver.getTitle();
			if (actualTitle.contains(Util.EXPECT_TITLE)) {
				System.out.println("Negative Test case for User Login: Failed");
			} else {
				System.out.println("Negative Test case for User Login : Passed");
			} 
		} finally 
		{
			// TODO: handle finally clause
			
			
			
		}
		
		waitForPageLoaded();
	}
	
	//positive testing for user logging in
	public static void Userlogin() throws InterruptedException 
		   {
			
			    
			    try {
			    	//checking if the system really did log in by checking the page title
					String actualTitle;
					
					driver.manage().window().maximize();
					
					//Positive Testing (right Username and right Password )
					
					
					driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/input")).clear();
					driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div/div/input")).sendKeys(Util.USER_NAME); // Enter username
					driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/input")).clear();
					driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[2]/div/div/input")).sendKeys(Util.PASSWD); // Enter Password
					
					Thread.sleep(1000);
					// Click Sign in
					driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/form/div[3]/div/div[2]/button")).click();
					
					Thread.sleep(1000);
					//Checking if the log in went through
					actualTitle = driver.getTitle();
					if (actualTitle.contains(Util.EXPECT_TITLE)) {
						System.out.println("User log in was successful");
					} else {
						System.out.println("User log in was unsuccessful");
					} 
				} finally {
					// TODO: handle finally clause
					
				}
						
			    waitForPageLoaded();
		    }
	@SuppressWarnings("deprecation")
	public static void waitForPageLoaded() 
	{
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	
	//Method that will find a href and click if because there are too many of them and selenium won't find it.
	public static void clickLinkByHref(String href) 
		{
	        try {
				List<WebElement> anchors = driver.findElements(By.tagName("a"));
				java.util.Iterator<WebElement> i = anchors.iterator();
 
      while(i.hasNext()) 
      {
				    WebElement anchor = i.next();
				    if(anchor.getAttribute("href").contains(href)) 
				    {
				        anchor.click();
				        break;
				    }
				    
     }
     waitForPageLoaded();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Couldn't find the tab "+href);
			}
		}
		
	//add User - Data Admin
		public static void AddUser()
		{
			
			//<a href="#/users">Users</a>
			String tab = "Users";
			//clickLinkByHref(tab);
			driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
			
			waitForPageLoaded();
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[2]/a")).click();
			
			waitForPageLoaded();
			
			UserDetails ();
			
			driver.findElement(By.id("submit")).click();
			waitForPageLoaded();
			
			searchUserName(Util.username);
			waitForPageLoaded();
			
			ReturnUserName(Util.username);
			waitForPageLoaded();
			
			
		}
		
		public static void UserDetails()
		{
			//Fill in the username
			driver.findElement(By.id("userName")).sendKeys(Util.username);
			
			//Fill in the First Name
			driver.findElement(By.id("firstName")).sendKeys(Util.firstname);
			
			//Fill in the last Name
			driver.findElement(By.id("lastname")).sendKeys(Util.lastname);
			
			//for now, let's enter the email
			driver.findElement(By.id("email")).sendKeys(Util.email);
			
			//newPassword
			driver.findElement(By.id("newPassword")).sendKeys(Util.password);
			
			//Fill in the phone number
			driver.findElement(By.id("phone")).sendKeys(Util.phone);
			
			if (Util.role.contains("System Admin"))
			{
				driver.findElement(By.xpath("/html/body/div/section/form/div[7]/div[1]/checkbox-group/div[2]/div[1]/label/input")).click();
			}
			else if (Util.role.contains("Store Admin"))
			{
				driver.findElement(By.xpath("/html/body/div/section/form/div[7]/div[1]/checkbox-group/div[2]/div[2]/label/input")).click();
			}
			else if (Util.role.contains("Cashier"))
			{
				driver.findElement(By.xpath("/html/body/div/section/form/div[7]/div[1]/checkbox-group/div[2]/div[3]/label/input")).click();
			}
			else if (Util.role.contains("Data Admin"))
			{
				driver.findElement(By.xpath("/html/body/div/section/form/div[7]/div[1]/checkbox-group/div[2]/div[4]/label/input")).click();
			}
			else if (Util.role.contains("Card Administrator"))
			{
				driver.findElement(By.xpath("/html/body/div/section/form/div[7]/div[1]/checkbox-group/div[2]/div[5]/label/input")).click();
			}
			else
			{
				System.out.println("Couldn't find the element looking for");
			}
		}
			
			
		public static void ReturnUserName(String username)
		{
			List<WebElement> anchors = driver.findElements(By.tagName("td"));
	        java.util.Iterator<WebElement> i = anchors.iterator();
	        int count = 0;
	       while(i.hasNext()) 
	       {
	            WebElement anchor = i.next();
	          
	            
	            if (anchors.get(count).getText().equals(username))
	            {
	            	System.out.println("User with a username:" + username+" has been created");
	   
	            	break;
	            	
	           
	            }
	            else
	            {
	            	count++;
	            }
	            
	      }
	      waitForPageLoaded();
		}
			
		public static void searchUserName(String username)
		{
			driver.findElement(By.name("search")).sendKeys(username);
							
			driver.findElement(By.xpath("/html/body/div/section/div[2]/div/form/input[2]")).click();
		}
			
		
	
	
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		setUp();
		LoginValidation();
		Userlogin();
		AddUser();

	}
	
	
}
