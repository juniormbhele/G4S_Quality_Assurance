package CopsPackage;

import org.testng.annotations.Test;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FireFoxTest 
{
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception 
	  {
		  SetUp.setUp();
	  }

	  @Test
	  public void testGenerateAbsaReport() throws Exception 
	  {
		  login.Userlogin();
	    //driver.get(baseUrl + "/deposita/invoiceTemplate.do");
	    driver.findElement(By.linkText("Generate Billing Transactions")).click();
	    new Select(driver.findElement(By.id("company.id"))).selectByVisibleText("Absa Bank");
	    new Select(driver.findElement(By.id("clientGroupId"))).selectByVisibleText("AB Beefmaster");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    new Select(driver.findElement(By.id("clientGroupId"))).selectByVisibleText("All");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
