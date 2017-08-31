package com.denty.cops;

import org.openqa.selenium.Keys;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Login 
{
	WiniumDriver driver = null;
	java.lang.String copsPath = "C:\\Users\\sphiwe.mbhele\\AppData\\Local\\Apps\\2.0\\W4CVAKPE.8YC\\4ANDD9CT.ZOB\\cash..tion_c8dba2e8e029687d_0005.0000_1267f94ca39fd1e2\\CashOpsDesktop.exe";

	 @BeforeClass
	  public void beforeClass()
	  {
		 DesktopOptions options = new DesktopOptions();
		 options.setApplicationPath(copsPath);

		 try
		 {
			driver = new WiniumDriver(new URL("http://localhost:9999"), options);
		 }
		 catch(MalformedURLException e)
		 {
			 e.printStackTrace();
		 }
	  }
  @Test
  public void login() throws InterruptedException, IllegalArgumentException
  {
	  Thread.sleep(9000);
      System.out.println(" Check title " + driver.getClass());


	  driver.findElementByName("Password").sendKeys("Jr_Admin");
      driver.findElementByName("Error").clear();
      driver.findElementByName("Error").sendKeys("password");
      driver.getKeyboard().releaseKey();




  }




    @AfterClass
  public void afterClass()
  {
	 // driver.close();
  }

}
