package clientZone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyCardAdministatorRoles 
{
	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;

	
	public static final String EXPECT_TITLE = "G4S Deposita - User details";
	
	// Declare An Excel Work Book
	HSSFWorkbook workbook;
	
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;
	public static String driverPath = "C:\\selenium\\";
	
	
	
	@Test(description = "Opens the ClientZone URL", priority = 1)
	public void LaunchWebsite() throws Exception 
	{
	try 
	{
	driver.get("https://uat.cashops.deposita.co.za/clientZone/#/");
	Thread.sleep(1000);
	
	driver.manage().window().maximize();
	Thread.sleep(1000);
	TestNGResults.put("2", new Object[] { 1d, "Navigate to ClientZone website", "Site gets opened", "Pass" });
	
	Thread.sleep(1000);
	// Take screenshot and store as a file format
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	Thread.sleep(1000);
	// now copy the  screenshot to desired location using copyFile //method
	FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));

	} catch (Exception e) {
	TestNGResults.put("2", new Object[] { 1d, "Navigate to ClientZone website", "Site gets opened", "Fail" });
	Assert.assertTrue(false);
	}
	
	
	}
	
	
	
	@Test(description = "Fill the First time loginLogin Details", priority = 2)
	public void FillLoginFirstTimeDetails() throws Exception 
	{
			try {
			// Get the username element
			WebElement username = driver.findElement(uimap.getLocator("Username_field"));
			username.sendKeys(datafile.getData("UserUsername"));
			Thread.sleep(1000);
			
			// Get the password element
			WebElement password = driver.findElement(uimap.getLocator("Password_field"));
			password.sendKeys(datafile.getData("UserPassword"));
			Thread.sleep(1000);
			
			TestNGResults.put("3", new Object[] { 2d, "Fill Login form data (Username/Password)",
			"Login details gets filled", "Pass" });
			Thread.sleep(1000);

			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Thread.sleep(1000);
			
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} catch (Exception e) {
			TestNGResults.put("3",
			new Object[] { 2d, "Fill Login form data (Username/Password)", "Login form gets filled", "Fail" });
			Assert.assertTrue(false);
			}
	}
	
	
	@Test(description = "Perform First Time Login", priority = 3)
	public void DoFirstTimeLogin() throws Exception 
	{
		
			try 
			{
			// Click on the Login button
			WebElement login = driver.findElement(uimap.getLocator("Login_button"));
			login.click();
			Thread.sleep(1000);
			
			// Assert the user login by checking the Online user
			
			AssertJUnit.assertEquals(driver.getTitle(), EXPECT_TITLE);
			Thread.sleep(1000);
			
			TestNGResults.put("4",
			new Object[] { 3d, "Click Login and verify welcome message", "Login success", "Pass" });
			
			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Thread.sleep(1000);
						
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} 
			catch (Exception e) 
			{
			TestNGResults.put("4",
			new Object[] { 3d, "Click Login and verify welcome message", "Login success", "Fail" });
			Assert.assertTrue(false);
			
			}
	}
	@Test(description = "Change User's Password", priority = 4)
	public void ChangePassword() throws Exception 
	{
		
			try 
			{
				
				// Get the current password element and fill in the password required
				WebElement currentPassword = driver.findElement(uimap.getLocator("currentPassword"));
				currentPassword.sendKeys(datafile.getData("UserPassword"));
				Thread.sleep(1000);
				
				
				// Get the new password element and fill in the password required
				WebElement newPassword = driver.findElement(uimap.getLocator("newPassword"));
				newPassword.sendKeys(datafile.getData("newPassword"));
				Thread.sleep(1000);
				
				// Get the new password element and fill in the password required
				WebElement confirmPassword = driver.findElement(uimap.getLocator("confirmPassword"));
				confirmPassword.sendKeys(datafile.getData("newPassword"));
				Thread.sleep(1000);
				
				// Take screenshot and store as a file format
				File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Thread.sleep(1000);
						
				// now copy the  screenshot to desired location using copyFile //method
				FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
				// Click on the Change Password button
				WebElement changePassowrdBtn = driver.findElement(uimap.getLocator("updateUserPasswordForm"));
				changePassowrdBtn.click();
				Thread.sleep(1000);
				// Assert the user login by checking the Online user
			
				AssertJUnit.assertEquals(driver.getTitle(), "G4S Deposita - User details");
	
				TestNGResults.put("5",
						new Object[] { 4d, "Click Login and verify welcome message for Card Name Editor\"", "Login success", "Pass" });
				Thread.sleep(1000);
				// Take screenshot and store as a file format
				File src2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Thread.sleep(1000);
						
				// now copy the  screenshot to desired location using copyFile //method
				FileUtils.copyFile(src2, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} 
			catch (Exception e) 
			{
				TestNGResults.put("5",
						new Object[] { 4d, "Click Login and verify welcome message for Card Name Editor", "Login success", "Fail" });
				Assert.assertTrue(false);
			
			}
	}
	
	@Test(description = "Fill the Second time loginLogin Details", priority = 5)
	public void FillLoginSecondTimeDetails() throws Exception 
	{
			try {
			// Get the username element
			WebElement username = driver.findElement(uimap.getLocator("Username_field"));
			username.sendKeys(datafile.getData("UserUsername"));
			Thread.sleep(1000);
			
			// Get the password element
			WebElement password = driver.findElement(uimap.getLocator("Password_field"));
			password.sendKeys(datafile.getData("newPassword"));
			Thread.sleep(1000);
			
			TestNGResults.put("6", new Object[] { 5d, "Fill Login form data (Username/Password) after change password",
			"Login details gets filled", "Pass" });
			
			Thread.sleep(1000);

			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} catch (Exception e) {
			TestNGResults.put("6",
			new Object[] { 5d, "Fill Login form data (Username/Password) after change password", "Login form gets filled", "Fail" });
			Assert.assertTrue(false);
			}
	}
	
	
	@Test(description = "Perform Second Time Login", priority = 6)
	public void DoSecondTimeLogin() throws Exception 
	{
		
			try 
			{
			// Click on the Login button
			WebElement login = driver.findElement(uimap.getLocator("Login_button"));
			login.click();
			Thread.sleep(1000);
			
			// Assert the user login by checking the Online user
			
			AssertJUnit.assertEquals(driver.getTitle(), "G4S Deposita - Dashboards");
			Thread.sleep(1000);
			
	
			TestNGResults.put("4",
			new Object[] { 3d, "Click Login after password change and verify welcome message", "Login success", "Pass" });
			Thread.sleep(1000);
			
			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Thread.sleep(1000);	
			
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} 
			catch (Exception e) 
			{
			TestNGResults.put("4",
			new Object[] { 3d, "Click Login after password change and verify welcome message", "Login success", "Fail" });
			Assert.assertTrue(false);
			
			}
	}
	
	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() 
	{
			// create a new work book
			workbook = new HSSFWorkbook();
			// create a new work sheet
			sheet = workbook.createSheet("ClientZone - Verify User Role");
			TestNGResults = new LinkedHashMap<String, Object[]>();
			// add test result excel file column header
			// write the header in the first row
			TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });
			try 
			{
			// Get current working directory and load the data file
			workingDir = System.getProperty("user.dir");
			datafile = new UIMap(workingDir + "\\Resources\\datafile.properties");
			
			// Get the object map file
			uimap = new UIMap(workingDir + "\\Resources\\locator.properties");
			
			
			// Setting up Chrome driver path.
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			
			// Launching Chrome browser.
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} catch (Exception e) {
			throw new IllegalStateException("Can't start the Chrome Web Driver", e);
			}
	}
	
	
	@AfterClass
	public void suiteTearDown() 
	{
			// write excel file and file name is LoginResults.xls
			Set<String> keyset = TestNGResults.keySet();
			int rownum = 0;
			for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
			Cell cell = row.createCell(cellnum++);
			if (obj instanceof Date)
			cell.setCellValue((Date) obj);
			else if (obj instanceof Boolean)
			cell.setCellValue((Boolean) obj);
			else if (obj instanceof String)
			cell.setCellValue((String) obj);
			else if (obj instanceof Double)
			cell.setCellValue((Double) obj);
	}
	
	
	}
		try {
		FileOutputStream out = new FileOutputStream(new File("Verify Card Name Editor Login.xls"));
		workbook.write(out);
		out.close();
		System.out.println("Successfully saved Card Name Editor Results to an Excel File!!!");
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
	// close the browser
	//driver.close();
	//driver.quit();
	}
	
	// It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	 
	// Here will compare if test is failing then only it will enter into if condition
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	// Create reference of TakesScreenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	// Call method to capture screenshot
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	// Copy files to specific location here it will save all screenshot in our project home directory and
	// result.getName() will return name of test case so that screenshot name will be same
	FileUtils.copyFile(source, new File("./Screenshots/Failed/"+result.getName()+".png"));
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	 
	 
	 
	}
	
	}
	 
  

}
