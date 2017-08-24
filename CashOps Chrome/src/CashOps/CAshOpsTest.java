package CashOps;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import java.util.*;


public class CAshOpsTest 
{
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
						System.out.println("User log in was successful");
					} else {
						System.out.println("User log in was unsuccessful");
					} 
				} finally {
					// TODO: handle finally clause
					
				}
						
			    waitForPageLoaded();
		    }
	
	public static void getTheMainMenu(String li)
	{
		List<WebElement> anchors = driver.findElements(By.tagName("li"));
        java.util.Iterator<WebElement> i = anchors.iterator();
        int count = 0;
       while(i.hasNext()) 
       {
            WebElement anchor = i.next();
          
            
            if (anchors.get(count).getText().equals(li))
            {
            	anchors.get(count).click();
            	break;
            }
            else
            {
            	count++;
            }
            
      }
      waitForPageLoaded();
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
		
	
	public static void logOut()
		{
			try {
				//Logging out from CashOps
				 
				 clickLinkByHref("logout");
				 System.out.println("User log out was successful");
				 
				 //Closing the browser after logging out 
				 driver.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("User log out was unsuccessful");
			}
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
	
	//Generating Billing Transactions depending on a Vendor name and exporting the file to an Excel sheet
	public static void GenerateBillingTransactions(String vendorName)
	{
		
		try {
			getTheMainMenu("Billing");
			driver.findElement(By.xpath("//li[8]/ul/li/a")).click();
			waitForPageLoaded();
			
			new Select(driver.findElement(By.id("company.id"))).selectByVisibleText(vendorName);
			driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			driver.findElement(By.cssSelector("#invoiceTemplateSearchParameters > input[type=\"submit\"]")).click();

			System.out.println("Billing Transactions report for "+vendorName +" generation was successful, check your downloads folder for the report");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Billing Transactions report for "+vendorName +" generation was unsuccessful");
		}
	    
	}
	
	//This is checking if the element with throwing an exception
	private static boolean existsElement(String id) 
	{
	    try 
	    {
	       driver.findElement(By.xpath(id)).getSize();
	    } 
	    
	    catch (NoSuchElementException e) 
	    {
	        return false;
	    }
	    return true;
	}
	
	
	
	public static void EFTReportsCashCentre(String fromDate, String toDate)
	{
		try {
			String tab = "Reports";
			getTheMainMenu(tab);
			driver.findElement(By.xpath("//a[contains(text(),'EFT Reports')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Cash Centre EFT')]")).click();
			//Wait for the page to load
			
			waitForPageLoaded();

			driver.findElement(By.id("selectAllDealTypes")).click();
			//from Date
			driver.findElement(By.id("fromDateStr")).clear();
			driver.findElement(By.id("fromDateStr")).sendKeys(fromDate);
			//to Date
			driver.findElement(By.id("toDateStr")).clear();
			driver.findElement(By.id("toDateStr")).sendKeys(toDate);
			//Select a region
			driver.findElement(By.id("selectAll")).click();
			//Next button after selecting regions
			driver.findElement(By.xpath("//input[@value='Next']")).click();
			//Wait for the page to load
			waitForPageLoaded();
			//select All Cash Centres
			driver.findElement(By.id("selectAllCashCentres")).click();
			//Wait for the page to load
			waitForPageLoaded();
			//Next button after selecting All Cash Centres
			driver.findElement(By.xpath("//input[@value='Next']")).click();
			
			String path = "//*[@id=\"reportPhysicalCountFilterParameters\"]/p";
			
			boolean pathPresent = existsElement(path);
			
			if (pathPresent = true)
					{
				System.out.println("There were no physical counts found.");
				Thread.sleep(5000);
				logOut();
			} 
			else 
			{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250);");
				
				//Select all transactions
				driver.findElement(By.id("selectAll1")).click();

				//Generate EFT transactions
				driver.findElement(By.xpath("//input[@value='Generate EFT']")).click();

				//Wait for the page to load
				waitForPageLoaded();

				//Get the name of the report generated 
				String eftReportName = driver.findElement(By.xpath("//*[@id=\"contents\"]/table/tbody/tr[2]/td[2]/a"))
						.getText();

				System.out.println("The name of the report is " + eftReportName + ", Check your download folder");

				driver.findElement(By.xpath("//*[@id=\"contents\"]/table/tbody/tr[2]/td[2]/a")).click();
				
				//Wait for the page to load
				waitForPageLoaded();

			} 
		} catch (Exception e) 
		{
			// TODO: handle exception
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 250);");
			
			//Select all transactions
			driver.findElement(By.id("selectAll1")).click();

			//Generate EFT transactions
			driver.findElement(By.xpath("//input[@value='Generate EFT']")).click();

			//Wait for the page to load
			waitForPageLoaded();

			//Get the name of the report generated 
			String eftReportName = driver.findElement(By.xpath("//*[@id=\"contents\"]/table/tbody/tr[2]/td[2]/a"))
					.getText();

			System.out.println("The name of the report is " + eftReportName + ", Check your download folder");

			driver.findElement(By.xpath("//*[@id=\"contents\"]/table/tbody/tr[2]/td[2]/a")).click();
		}
		
		
		
	}
	 public static void main(String[] args) throws InterruptedException
	 {
		 
		 setUp();
		 LoginValidation();
		 Userlogin();
		 logOut();
	 }
}
