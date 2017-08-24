package clientZone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
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

import org.apache.commons.io.FileUtils;

public class CardNameEditor 
{
	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;

	
	public static final String EXPECT_TITLE = "G4S Deposita - Dashboards";
	
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
	driver.manage().window().maximize();
	TestNGResults.put("2", new Object[] { 1d, "Navigate to ClientZone website", "Site gets opened", "Pass" });
	
	// Take screenshot and store as a file format
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	// now copy the  screenshot to desired location using copyFile //method
	FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Opens the ClientZone URL.png"));

	} catch (Exception e) {
	TestNGResults.put("2", new Object[] { 1d, "Navigate to ClientZone website", "Site gets opened", "Fail" });
	Assert.assertTrue(false);
	}
	
	
	}
	
	
	
	@Test(description = "Fill the Login Details", priority = 2)
	public void FillLoginDetails() throws Exception 
	{
			try {
			// Get the username element
			WebElement username = driver.findElement(uimap.getLocator("Username_field"));
			username.sendKeys(datafile.getData("username"));
			// Get the password element
			WebElement password = driver.findElement(uimap.getLocator("Password_field"));
			password.sendKeys(datafile.getData("password"));
			Thread.sleep(1000);
			TestNGResults.put("3", new Object[] { 2d, "Fill Login form data (Username/Password)",
			"Login details gets filled", "Pass" });
			

			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Fill the Login Details.png"));
			} catch (Exception e) {
			TestNGResults.put("3",
			new Object[] { 2d, "Fill Login form data (Username/Password)", "Login form gets filled", "Fail" });
			Assert.assertTrue(false);
			}
	}
	@Test(description = "Perform Login", priority = 3)
	public void DoLogin() throws Exception 
	{
		
			try 
			{
			// Click on the Login button
			WebElement login = driver.findElement(uimap.getLocator("Login_button"));
			login.click();
			Thread.sleep(1000);
			// Assert the user login by checking the Online user
			
			AssertJUnit.assertEquals(driver.getTitle(), EXPECT_TITLE);
	
			TestNGResults.put("4",
			new Object[] { 3d, "Click Login and verify welcome message", "Login success", "Pass" });
			
			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Perform Login.png"));
			} 
			catch (Exception e) 
			{
			TestNGResults.put("4",
			new Object[] { 3d, "Click Login and verify welcome message", "Login success", "Fail" });
			Assert.assertTrue(false);
			
			}
	}
	
	@Test(description = "Navigate to Users' page", priority = 4)
	public void UsersTab() throws Exception 
	{
		
			try 
			{
			// Click on the Users tab
			WebElement usersButton = driver.findElement(uimap.getLocator("users"));
			usersButton.click();
			Thread.sleep(1000);
			// Assert the users' tab page details
			String usersHeading = driver.findElement(uimap.getLocator("usersHeading")).getText();
			AssertJUnit.assertEquals("Users", usersHeading);
	
			TestNGResults.put("5",
			new Object[] { 4d, "Click the Users tab and verity the users' page", "Users' navigation Tab success", "Pass" });
			
			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
									
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Navigate to Users' page.png"));
			} 
			catch (Exception e) 
			{
			TestNGResults.put("5",
			new Object[] { 4d, "Click the Users tab and verity the users' page", "Users' navigation Tab sucess", "Fail" });
			Assert.assertTrue(false);
			
			}
	}
	
	@Test(description = "Navigate to Add User page", priority = 5)
	public void AddUserTab() throws Exception 
	{
		
			try 
			{
			// Click on the Add User tab
			WebElement AddUserButton = driver.findElement(uimap.getLocator("addUser"));
			AddUserButton.click();
			Thread.sleep(1000);
			// Assert the Add User tab page details
			String addUserHeading = driver.findElement(uimap.getLocator("addUserHeading")).getText();
			AssertJUnit.assertEquals("Add User", addUserHeading);
	
			TestNGResults.put("6",
			new Object[] { 5d, "Click the Add User tab and verity the Add User page", "Add User navigation Tab success", "Pass" });
			
			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
												
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\Navigate to Add User page.png"));
			} 
			catch (Exception e) 
			{
			TestNGResults.put("6",
			new Object[] { 5d, "Click the Add User tab and verity the Add User page", "Add User navigation Tab success", "Fail" });
			Assert.assertTrue(false);
			
			}
	}
	
	
	@Test(description = "Fill in User's details and submit", priority = 6)
	public void FillInUserDetails() throws Exception 
	{
		
			try 
			{
				
			// Get the User's username element and fill the details
			WebElement UserUsername = driver.findElement(uimap.getLocator("UserUsername"));
			UserUsername.sendKeys(datafile.getData("UserUsername"));
				
			// Get the User's First Name element and fill the details
			WebElement FirstName = driver.findElement(uimap.getLocator("FirstName"));
			FirstName.sendKeys(datafile.getData("FirstName"));
			
			// Get the User's Last Name element and fill the details
			WebElement LastName = driver.findElement(uimap.getLocator("LastName"));
			LastName.sendKeys(datafile.getData("LastName"));
			

			// Get the User's Email element and fill the details
			WebElement Email = driver.findElement(uimap.getLocator("Email"));
			Email.sendKeys(datafile.getData("Email"));
			
			// Get the User's Password element and fill the details
			WebElement UserPassword = driver.findElement(uimap.getLocator("UserPassword"));
			UserPassword.sendKeys(datafile.getData("UserPassword"));
				
			
			// Get the User's Phone element and fill the details
			WebElement Phone = driver.findElement(uimap.getLocator("Phone"));
			Phone.sendKeys(datafile.getData("Phone"));
				
			
			// Click on the Card Name Editor Checkbox
			WebElement cardNameEditorCheckbox = driver.findElement(uimap.getLocator("cardNameEditor"));
			cardNameEditorCheckbox.click();
			Thread.sleep(1000);
			
			//Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
												
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\User Details.png"));
			
			// Click on the add User button
			WebElement addUserForm = driver.findElement(uimap.getLocator("addUserForm"));
			addUserForm.click();
			
			// Get the search field element and fill the search input
			WebElement search = driver.findElement(uimap.getLocator("search"));
			search.sendKeys(datafile.getData("UserUsername"));
			
			// Click on the search button button
			WebElement searchButton = driver.findElement(uimap.getLocator("searchButton"));
			searchButton.click();
			Thread.sleep(1000);
			//Take screenshot and store as a file format
			File src1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
												
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src1, new File("C:\\Users\\sphiwe.mbhele\\eclipse-workspace\\ClientZone Automated Scripts\\Screenshots\\SearchReturns.png"));
			
			List<WebElement> anchors = driver.findElements(By.tagName("td"));
	        java.util.Iterator<WebElement> i = anchors.iterator();
	        int count = 0;
	       while(i.hasNext()) 
	       {
	            WebElement anchor = i.next();
	          
	            
	            if (anchors.get(count).getText().equals(UserUsername))
	            {
	            	// Getting the User details
	    			
	    			AssertJUnit.assertEquals(UserUsername, anchors.get(count).getText().equals(UserUsername));
	    			TestNGResults.put("7",
	    			new Object[] { 6d, "Fill in User's details and submit", "User details submission", "Pass" });
	    			
	            	break;
	            	
	           
	            }
	            else
	            {
	            	count++;
	            }
	            
	      }
			
			
			
			} catch (Exception e) {
			TestNGResults.put("7",
			new Object[] { 6d, "Fill in User's details and submit", "User details submission", "Fail" });
			Assert.assertTrue(false);
			
			}
	}
	
	
	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() 
	{
			// create a new work book
			workbook = new HSSFWorkbook();
			// create a new work sheet
			sheet = workbook.createSheet("ClientZone - Add  Card Name Editor Role");
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
		FileOutputStream out = new FileOutputStream(new File("CardNameEditor.xls"));
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
	FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	 
	 
	 
	}
	
	}
	 
	
	
	
}