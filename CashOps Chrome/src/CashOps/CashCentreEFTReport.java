package CashOps;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CashCentreEFTReport 
{
	String toDate = "27/06/2017";
	 String fromDate = "28/06/2017";
	 
  @Test (description = "Negative Testing for User Log in", priority = 1)
  public void NegativeTestCaseUserLogin() throws InterruptedException 
  {
	  CAshOpsTest.LoginValidation();
	  
  }
  
  @Test (description = "Positive Testing for User Log in", priority = 2)
  public void PositiveTestCaseUserLogin() throws InterruptedException 
  {
	  CAshOpsTest.Userlogin();
  }
  
  @Test (description = "Generate Cash Centre EFT Report (For all of them)", priority = 3)
  public void CashCentreEFT() 
  {
	  CAshOpsTest.EFTReportsCashCentre(fromDate, toDate);
  }
  
  
  @BeforeTest (description = "Setting up the Test Suite")
  public void beforeTest() 
  {
	  CAshOpsTest.setUp();
  }

  @AfterTest (description = "Logging out and closing the browser")
  public void afterTest() 
  {
	  CAshOpsTest.logOut();
  }

}
