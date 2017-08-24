/**
 * 
 */
package CopsPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Sphiwe.Mbhele
 *
 */
public class UnitTesting {

	static WebDriver driver;
	static String vendorName = "Absa Bank";
	
	public static void main(String[] args) 
	{
		try 
		{
			
			SetUp.setUp();
			SetUp.Userlogin();
			Billing.GenerateBillingTransactions(vendorName, driver);
			
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
