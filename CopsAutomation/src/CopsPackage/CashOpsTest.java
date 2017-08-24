package CopsPackage;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CashOpsTest 
{
	static WebDriver driver;
	
	@BeforeTest
    public void launchBrowser() throws Exception 
	{
		SetUp.setUp();
        
    }
	
	@org.testng.annotations.Test (description ="Login to CashOps: Validation", priority = 1)
    public void loginValidation() throws Exception 
    {
    	SetUp.LoginValidation();
        
    }
    
    @org.testng.annotations.Test (description ="Login to CashOps : Successful log in", priority = 2)
    public void login() throws Exception 
    {
    	SetUp.Userlogin();
    
    }
    
    @AfterTest
    public void closeBrowser() throws Exception
    {
    	
    	//SetUp.close();
    }

}
