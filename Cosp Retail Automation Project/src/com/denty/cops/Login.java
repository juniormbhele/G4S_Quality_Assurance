package com.denty.cops;

import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.apache.xpath.operations.String;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class Login 
{
	WiniumDriver driver = null;
	java.lang.String copsPath = "C:\\Users\\sphiwe.mbhele\\AppData\\Local\\Apps\\2.0\\W4CVAKPE.8YC\\4ANDD9CT.ZOB\\cash..tion_c8dba2e8e029687d_0005.0000_106bba5eac8eed62\\CashOpsDesktop.exe";

	 @BeforeClass
	  public void beforeClass() 
	  {
		 DesktopOptions options = new DesktopOptions();
		 options.setApplicationPath(copsPath);
		 
		 try
		 {
			 driver = new WiniumDriver(new URL("Http://localhost:9999"), options);
			 
		 }
		 catch(MalformedURLException e)
		 {
			 e.printStackTrace();
		 }
	  }
  @Test
  public void login() throws InterruptedException 
  {
	  Thread.sleep(9000);
	  
	  
	  driver.findElementByName("Login").click();
	  
	  driver.findElementByName("Password").sendKeys("password");

	  driver.findElementByName("Error").sendKeys("password");
	 

  }
 

  @AfterClass
  public void afterClass() 
  {
	 // driver.close();
  }

}
