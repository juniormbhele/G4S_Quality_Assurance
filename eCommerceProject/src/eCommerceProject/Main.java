/**
 * 
 */
package eCommerceProject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



import junit.framework.Assert;

/**
 * @author Sphiwe.Mbhele
 *
 */
public class Main 
{

	/**
	 * @param args
	 */
	
	static WebDriver driver; // Selenium control driver
 
    
    // This method SetUp will read initialization parameters from the class Util.java & launch Firefox 

    public static void setUp() throws Exception 
    {
	
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(Util.BASE_URL);
			
			
			waitForPageLoaded();
			
			driver.manage().window().maximize();
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("System is down");
			driver.close();
			
		}
    }
    
    @SuppressWarnings("deprecation")
	public static void waitForPageLoaded() 
	{
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /**
     * @throws Exception 
     * 
     *
     */
   
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
	
		String actualTitle;

		    //Setup Firefox driver
		    setUp();
		
		  	actualTitle = driver.getTitle();
			if (actualTitle.contains("Home page")) 
			{
					    System.out.println("Test case - Verify the home page title: Passed");
					    
					  //Click the mobile tab
					    driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
					    
					    actualTitle = driver.getTitle();
					    
					    if (actualTitle.contains("Mobile")) 
						{
								    System.out.println("Test case - Verify the Mobile page title: Passed");
								 
								   
								    driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")).sendKeys("Name");
								    
								    String sortBy = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")).getText();
								    
								    if (sortBy.contains("Name"))
								    {
								    	System.out.println("Test case - Sort mobile by name: Passed");
								    	driver.close();

								    }
								    else
								    {
								    	System.out.println("Test case - Sort mobile by name: Failed");
								    	driver.close();
								    }
						} 
						else 
						{
								    System.out.println("Test case - Verify the Mobile page title :Failed");
								    driver.close();
						}
			} 
			else 
			{
					    System.out.println("Test case - Verify the home page title :Failed");
					    driver.close();
			}
					
		    //driver.close();
		

	}

}
