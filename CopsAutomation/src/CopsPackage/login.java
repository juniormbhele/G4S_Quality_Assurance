/**
 * 
 */
package CopsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Sphiwe.Mbhele
 *
 */
public class login 
{
	
	static WebDriver driver; 
  
  
   public static void Userlogin() 
   {
	
	    
	    try {
	    	//checking if the system really did log in by checking the page title
			String actualTitle;
			
			driver.manage().window().maximize();
			
			driver.findElement(By.name("j_username")).clear();
			driver.findElement(By.name("j_username")).sendKeys(Util.USER_NAME); // Enter username
			driver.findElement(By.name("j_password")).clear();
			driver.findElement(By.name("j_password")).sendKeys(Util.PASSWD); // Enter Password
			// Click Login
			driver.findElement(By.name("submit")).click();
			actualTitle = driver.getTitle();
			if (actualTitle.contains(Util.EXPECT_TITLE)) {
				System.out.println("Test case: Passed");
			} else {
				System.out.println("Test case : Failed");
			} 
		} finally {
			// TODO: handle finally clause
			
			driver.quit();
			
		}
				

    }

	
}
