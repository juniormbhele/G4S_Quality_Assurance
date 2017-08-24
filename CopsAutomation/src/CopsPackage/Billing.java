package CopsPackage;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Billing 
{
	
	public static void GenerateBillingTransactions (String vendorName,WebDriver driver )
	{
		
		//List<WebElement> li =driver.findElements(By.linkText("Billing"));
		//((WebElement) li).click();
		
		//Billing.GenerateBillingTransactions(vendorName, driver);
		
		//List<WebElement> li =driver.findElements(By.linkText("Billing"));
		//((WebElement) li).click();
		
		//driver.findElement(By.xpath("//li[contains(text(), 'Billing')]")).click();;
		
		//driver.findElement(By.linkText("Generate Billing Transactions")).click();
		
		//driver.findElement(By.cssSelector("li.dir:nth-child(8) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
		//driver.findElement(By.partialLinkText("long")).click();
		
		
		driver.findElement(By.linkText("Logout")).click();
		
		
		//String element = driver.findElements(By.linkText("Generate Billing Transactions")).getTitle();

		//System.out.println("This is the element I'm trying to find" + element);
		
	}

}
