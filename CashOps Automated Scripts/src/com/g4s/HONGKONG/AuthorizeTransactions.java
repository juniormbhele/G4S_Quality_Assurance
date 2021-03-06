package com.g4s.HONGKONG;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sphiwe.Mbhele on 2017/08/31.
 */
public class AuthorizeTransactions
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
            driver.get("https://uat.cashops.deposita.co.za/deposita/searchManualTransactions.do");
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
    @Test(description = "Authorize 01 transactions", priority = 4, enabled = true)
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
            FileUtils.copyFile(src, new File(workingDir + "\\Screenshots\\Passed\\" + System.currentTimeMillis() + ".png"));
        }
        catch (Exception e)
        {
            TestNGResults.put("5",
                    new Object[] { 6d, "Authorize 01 transaction","01 Transaction should be authorized", "Fail" });
            Assert.assertTrue(false);

        }
    }

    @Test(description = "Authorize 03 transactions", priority = 5, enabled = true)
    public void authorize03() throws Exception
    {

        try
        {
            //Navigate to the authorization screen
            driver.get("https://uat.cashops.deposita.co.za/deposita/authoriseTransactions.do");

            // Fill in the transaction from Date
            WebElement transactionDateStr = driver.findElement(uimap.getLocator("fromDateStr"));
            transactionDateStr.clear();
            transactionDateStr.sendKeys(datafile.getData("fromDateStr"));

            // Fill in the Transaction Type - 03
            WebElement TransTypeField = driver.findElement(uimap.getLocator("transactionType.id"));
            TransTypeField.sendKeys(datafile.getData("TransTypeField03"));

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
                    new Object[]{6d, "Authorize 03 transaction", "03 Transaction should be authorized", "Pass"});


            // Take screenshot and store as a file format
            File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // now copy the  screenshot to desired location using copyFile //method
            workingDir = System.getProperty("user.dir");
            FileUtils.copyFile(src, new File(workingDir+"\\Screenshots\\Passed\\"+System.currentTimeMillis()+".png"));
        }
        catch (Exception e)
        {
            TestNGResults.put("5",
                    new Object[] { 6d, "Authorize 03 transaction","03 Transaction should be authorized", "Fail" });
            Assert.assertTrue(false);

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
