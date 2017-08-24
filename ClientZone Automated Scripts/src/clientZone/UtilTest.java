package clientZone;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class UtilTest 
{
	static WebDriver driver;
  @BeforeTest
  public void beforeTest() 
  {
	  String username = "Junior_System_Admin4";
	  String firstname = "Junior";
	  String lastname = "Mbhele"; 
	  String email = username+"@dentygroup.co.za"; 
	  String role = "Card Administrator"; 
	  String password = "Junior@100";
	  String phone = "0792360784";
	  
	  clientZone.ZoneUnitTest.setUp();
	  Util.ValuesDeclarations(username, firstname,lastname,email,role, password, phone);
  }

  @AfterTest
  public void afterTest()
  {
	 
  }

  @Test (description = "User login validation", priority = 1)
  public void LoginValidation() throws Exception 
  {
	  clientZone.ZoneUnitTest.LoginValidation();
	  
    throw new RuntimeException("Test not implemented");
  }
  
  @Test (description = "User login results", priority = 2)
  public void Userlogin() throws Exception 
  {
	  clientZone.ZoneUnitTest.Userlogin();
	  
    throw new RuntimeException("Test not implemented");
  }
  
  @Test ( description = "User creation results", priority = 3) 
  public void AddUser ()
  {
	 // clientZone.ZoneUnitTest.AddUser();
	  
    throw new RuntimeException("Test not implemented");
  }



 

  
 }

