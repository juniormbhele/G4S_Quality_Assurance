package com.g4s.nedbank;

import cashOpsPackage.UIMap;
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

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CashOpsManualTransactions01

{
	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public UIMap values;
	public String workingDir;

	
	public static final String EXPECT_TITLE = "Deposita CashOps System: Transaction Details";
	
	// Declare An Excel Work Book
	HSSFWorkbook workbook;
	
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;
	public static String driverPath = null;
	
	
	
	@Test(description = "Opens the CashOps Manual Transactions URL", priority = 1)
	public void LaunchWebsite() throws Exception 
	{
	try 
	{
	driver.get("https://41.21.131.56/deposita/searchManualTransactions.do");
	Thread.sleep(1000);
	
	driver.manage().window().maximize();
	TestNGResults.put("2", new Object[] { 1d, "Navigate to CashOps Manual Transactions", "Site gets opened", "Pass" });
	

	// Take screenshot and store as a file format
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	// now copy the  screenshot to desired location using copyFile //method
        workingDir = System.getProperty("user.dir");
	FileUtils.copyFile(src, new File(workingDir+"\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));

	} catch (Exception e) {
	TestNGResults.put("2", new Object[] { 1d, "Navigate to CashOps Manual Transactions", "Site gets opened", "Fail" });
	Assert.assertTrue(false);
	}
	
	
	}
	
	
	
	@Test(description = "Fill the Login Details", priority = 2)
	public void FillLoginDetails() throws Exception 
	{
			try 
			{
			// Get the username element
			WebElement username = driver.findElement(uimap.getLocator("CO_Username_field"));
			username.sendKeys(datafile.getData("CO_username"));
			
			
			// Get the password element
			WebElement password = driver.findElement(uimap.getLocator("CO_Password_field"));
			password.sendKeys(datafile.getData("CO_password"));
	
			
			TestNGResults.put("3", new Object[] { 2d, "Fill Login form data (Username/Password)",
			"Login details gets filled", "Pass" });
			

			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			// now copy the  screenshot to desired location using copyFile //method
                workingDir = System.getProperty("user.dir");
			FileUtils.copyFile(src, new File(workingDir+"\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} catch (Exception e) 
			{
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
			WebElement login = driver.findElement(uimap.getLocator("CO_Login_button"));
			login.click();
			Thread.sleep(1000);
			// Assert the user login by checking the Online user
			
			AssertJUnit.assertEquals(driver.getTitle(), EXPECT_TITLE);
	
			TestNGResults.put("4",
			new Object[] { 3d, "Click Login and verify welcome message", "Login success", "Pass" });
			Thread.sleep(1000);
			
			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Thread.sleep(1000);
						
			// now copy the  screenshot to desired location using copyFile //method
                workingDir = System.getProperty("user.dir");
			FileUtils.copyFile(src, new File(workingDir+"\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} 
			catch (Exception e) 
			{
			TestNGResults.put("4",
			new Object[] { 3d, "Click Login and verify welcome message", "Login success", "Fail" });
			Assert.assertTrue(false);
			
			}
	}
	
	@Test(description = "Fill in Transactions Details", priority = 4)
	public void UsersTab() throws Exception 
	{
		
			try 
			{
				
			
				// Fill in the Transaction Type - 01
				WebElement TransTypeField = driver.findElement(uimap.getLocator("TransTypeField"));
				TransTypeField.sendKeys(datafile.getData("TransTypeField"));
			
				// Fill in the Canister Number
				WebElement canisterNumber = driver.findElement(uimap.getLocator("canisterNumber"));
				canisterNumber.sendKeys(values.getData("canisterNumber"));
				
				// Fill in the Seal Number
				WebElement sealNumber = driver.findElement(uimap.getLocator("sealNumber"));
				sealNumber.sendKeys(values.getData("sealNumber"));
		

				// Fill in the Client Code
				WebElement clientCode = driver.findElement(uimap.getLocator("clientCode"));
				clientCode.sendKeys(datafile.getData("clientCode"));
				

				// Fill in the Flash Number
				WebElement flashNumber = driver.findElement(uimap.getLocator("flashNumber"));
				flashNumber.sendKeys(datafile.getData("flashNumber"));
				
				
				// Fill in the Currency Code
				WebElement currencyCode = driver.findElement(uimap.getLocator("currencyCode"));
				currencyCode.sendKeys(datafile.getData("currencyCode"));
				
				// Fill in the amount
				WebElement amount = driver.findElement(uimap.getLocator("amount"));
				amount.sendKeys(values.getData("amount"));
		
			
			TestNGResults.put("5",
			new Object[] { 4d, "Fill in Manual Transaction Details and Search", "Fields should be field with required option", "Pass" });
			
			
			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
									
			// now copy the  screenshot to desired location using copyFile //method
                workingDir = System.getProperty("user.dir");
			FileUtils.copyFile(src, new File(workingDir+"\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} 
			catch (Exception e) 
			{
			TestNGResults.put("5",
			new Object[] { 4d, "Fill in Manual Transaction Details and Search", "Fields should be field with required option", "Fail" });
			Assert.assertTrue(false);
			
			}
	}
	
	
	@Test(description = "Search for Transactions Details", priority = 5)
	public void SearchTrans() throws Exception 
	{
		
			try 
			{
                 // Click the search button
                WebElement search = driver.findElement(uimap.getLocator("search"));
                search.click();
                Thread.sleep(1000);

                // Click the search button
                WebElement ProcessManualTrans = driver.findElement(uimap.getLocator("ProcessManualTrans"));
                ProcessManualTrans.click();
                Thread.sleep(1000);

                // Fill in the transaction Date
                WebElement transactionDateStr = driver.findElement(uimap.getLocator("transactionDateStr"));
                transactionDateStr.clear();
                transactionDateStr.sendKeys(datafile.getData("transactionDateStr"));

                // Fill in the Card Details
                WebElement cardId = driver.findElement(uimap.getLocator("cardId"));
                cardId.sendKeys(datafile.getData("cardId"));

                // Fill in the Vendor REF
                WebElement vendorSettlementReference = driver.findElement(uimap.getLocator("vendorSettlementReference"));
                vendorSettlementReference.sendKeys(datafile.getData("vendorSettlementReference"));

                // Fill in the Client REF
                WebElement clientSettlementReference = driver.findElement(uimap.getLocator("clientSettlementReference"));
                clientSettlementReference.sendKeys(datafile.getData("clientSettlementReference"));

                // Fill in the First Count - R100 Notes
                WebElement FirstR100Notes = driver.findElement(uimap.getLocator("FirstR100Notes"));
                FirstR100Notes.sendKeys(values.getData("FirstR100Notes"));

                // Fill in the Second Count - R100 Notes
                WebElement SecondR100Notes = driver.findElement(uimap.getLocator("SecondR100Notes"));
                SecondR100Notes.sendKeys(values.getData("SecondR100Notes"));


                // Fill in the First Count - Total
                WebElement firsttotal = driver.findElement(uimap.getLocator("firsttotal"));
                firsttotal.clear();
                firsttotal.sendKeys(values.getData("amount"));

                // Fill in the Second Count - Total
                WebElement secondtotal = driver.findElement(uimap.getLocator("secondtotal"));
                secondtotal.clear();
                secondtotal.sendKeys(values.getData("amount"));

                // Click Process Entry
                WebElement processEntry = driver.findElement(uimap.getLocator("processEntry"));
                processEntry.click();
			
			TestNGResults.put("6",
			new Object[] { 5d, "Fill in Manual Transaction Details and Search", "Fields should be field with required option", "Pass" });
			
			
			// Take screenshot and store as a file format
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
									
			// now copy the  screenshot to desired location using copyFile //method
                workingDir = System.getProperty("user.dir");
			FileUtils.copyFile(src, new File(workingDir+"\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
			} 
			catch (Exception e) 
			{
			TestNGResults.put("5",
			new Object[] { 5d, "Fill in Manual Transaction Details and Search", "Fields should be field with required option", "Fail" });
			Assert.assertTrue(false);
			
			}
	}

@Test(description = "Authorize 01 transactions", priority = 6, enabled = false)
    public void authorize01() throws Exception
    {

        try
        {
            //Navigate to the authorization screen
            driver.get("https://uat.cashops.deposita.co.za/deposita/authoriseTransactions.do");

        // Fill in the transaction from Date
            WebElement transactionDateStr = driver.findElement(uimap.getLocator("fromDateStr"));
            transactionDateStr.clear();
            transactionDateStr.sendKeys(datafile.getData("fromDateStr"));

            // Fill in the Transaction Type - 01
            WebElement TransTypeField = driver.findElement(uimap.getLocator("transactionType.id"));
            TransTypeField.sendKeys(datafile.getData("TransTypeField"));

            // Fill in the Canister Number
            WebElement canisterNumber = driver.findElement(uimap.getLocator("canisterNumber"));
            canisterNumber.sendKeys(values.getData("canisterNumber"));


            // Fill in the transactionState
            WebElement transactionState = driver.findElement(uimap.getLocator("transactionState"));
            transactionState.sendKeys(datafile.getData("transactionState"));

            //Click the search
            WebElement authorizedSearch = driver.findElement(uimap.getLocator("authorizedSearch"));
            authorizedSearch.click();
            Thread.sleep(1000);

            //Click the Authorize Transaction button
            WebElement authTranButtonId = driver.findElement(uimap.getLocator("authTranButtonId"));
            authTranButtonId.click();
            Thread.sleep(1000);


            TestNGResults.put("6",
                    new Object[]{6d, "Authorize 01 transaction", "01 Transaction should be authorized", "Pass"});


            // Take screenshot and store as a file format
            File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // now copy the  screenshot to desired location using copyFile //method
            workingDir = System.getProperty("user.dir");
            FileUtils.copyFile(src, new File(workingDir+"\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
        }
        catch (Exception e)
        {
            TestNGResults.put("5",
                    new Object[] { 6d, "Authorize 01 transaction","01 Transaction should be authorized", "Fail" });
            Assert.assertTrue(false);

        }
    }

    @Test(description = "Increment values for Canister and Seal Number", priority = 6)
    public void incrementValues() throws Exception
    {
        int canisterNumber = Integer.parseInt(values.getData("canisterNumber"));
        int sealNumber = Integer.parseInt(values.getData("sealNumber"));
        int amount = Integer.parseInt(values.getData("amount"));


        int firstR100Notes = Integer.parseInt(values.getData("FirstR100Notes"));
        int secondR100Notes = Integer.parseInt(values.getData("SecondR100Notes"));

        amount = amount + 100;

        canisterNumber++;
        sealNumber++;


        firstR100Notes = amount/100;


        secondR100Notes = amount/100;

        String CN = Integer.toString(canisterNumber);
        String SN = Integer.toString(sealNumber);
        String am = Integer.toString(amount);

        String first100 = Integer.toString(firstR100Notes);

        String second100 = Integer.toString(secondR100Notes);


        try
        {
            Properties properties = new Properties();


            workingDir = System.getProperty("user.dir");
            FileOutputStream out = new FileOutputStream(workingDir+"\\Resources\\NedBank\\values.properties");
            FileInputStream in = new FileInputStream(workingDir+"\\Resources\\NedBank\\values.properties");

            properties.load(in);
            //in.close();
           // properties.setProperty("canisterNumber", CN);
            //properties.setProperty("sealNumber",SN);
            properties.setProperty("amount", am);
            properties.setProperty("FirstR100Notes",first100);
            properties.setProperty("SecondR100Notes",second100);
            properties.store(out, null);
            out.close();



        }
        catch (Exception e)
        {

            Assert.assertTrue(false);
            System.out.println(e.getStackTrace());
        }
    }



    @BeforeClass(alwaysRun = true)
	public void suiteSetUp() 
	{
			// create a new work book
			workbook = new HSSFWorkbook();
			// create a new work sheet
			sheet = workbook.createSheet("CashOps Manual Tranctions");
			TestNGResults = new LinkedHashMap<String, Object[]>();
			// add test result excel file column header
			// write the header in the first row
			TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });
			try 
			{
			// Get current working directory and load the data file
			workingDir = System.getProperty("user.dir");
			datafile = new UIMap(workingDir + "\\Resources\\NedBank\\datafile.properties");
			
			// Get current working directory and load the data file
						workingDir = System.getProperty("user.dir");
						values = new UIMap(workingDir + "\\Resources\\NedBank\\values.properties");
			// Get the object map file
			uimap = new UIMap(workingDir + "\\Resources\\NedBank\\locator.properties");
			
			
			// Setting up Chrome driver path.
			System.setProperty("webdriver.chrome.driver", workingDir + "\\Resources\\chromedriver.exe");
			
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
		FileOutputStream out = new FileOutputStream(new File(System.currentTimeMillis()+".xls"));
		workbook.write(out);
		out.close();
		System.out.println("Successfully saved"+new File(System.currentTimeMillis()+"Results to an Excel File!!!"));
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
	// close the browser
	driver.close();
	
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
