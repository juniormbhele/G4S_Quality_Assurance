package clientZone;

public class Util 
{
	//Setting Base URL
	public static final String BASE_URL = "https://uat.cashops.deposita.co.za/clientZone/#/";
    
	// Time to wait when searching for a page elements
	public static final int WAIT_TIME = 30; 
											

	// Valid account for login
	public static final String USER_NAME = "systems";
	public static final String PASSWD = "password";
	
	// invalid account for login
		public static final String Wrong_USER_NAME = "System";
		public static final String Wrong_PASSWD = "Password";
	
	// Expected page title
	public static final String EXPECT_TITLE = "G4S Deposita - Dashboards";
	
	public static String username;
	public static String firstname;
	public static String lastname;
	public static String email;
	public static String role;
	public static String password;
	public static String phone;

	public static void ValuesDeclarations(String username2, String firstname2, String lastname2, 
			String email2, String role2, String password2,String phone2)
	{
		username = username2;
		firstname = firstname2;
		lastname = lastname2;
		email = email2;
		role =role2 ;
		password = password2;
		phone = phone2;

	}

}
