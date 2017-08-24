package CashOps;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class GenerateBillingTransactionsReport 
{
		String vendorName = "Absa Bank";
	
	 
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
  
  @Test (description = "Generate Billing Transactions Report", priority = 3)
  public void GenerateBillingTransactions() 
  {
	  CAshOpsTest.GenerateBillingTransactions(vendorName);
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
