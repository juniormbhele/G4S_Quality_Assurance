package JMeterPackage;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import clientZone.UIMap;

public class AddUser 
{

	@Before
	public void setUp() throws Exception 
	{
			// create a new work book
					workbook = new HSSFWorkbook();
					// create a new work sheet
					sheet = workbook.createSheet("ClientZone - Add User Role");
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

	@Test
	public void test() 
	{
		
		
		fail("Not yet implemented");
	}

}
