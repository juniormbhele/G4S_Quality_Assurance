package CashOps;
/*
 * Declare some common parameters for scripts
 * You can change them to adapt your environment
 *
 */

public class Util {
	
	// Setting Base URL
	public static final String BASE_URL = "https://uat.cashops.deposita.co.za/";
    
	// Time to wait when searching for a page elements
	public static final int WAIT_TIME = 30; 
											

	// Valid account for login
	public static final String USER_NAME = "Bongs.Malabola";
	public static final String PASSWD = "Password";
	
	// inalid account for login
		public static final String Wrong_USER_NAME = "Bongs.Malabo";
		public static final String Wrong_PASSWD = "Password2";
	
	// Expected page title
	public static final String EXPECT_TITLE = "Deposita CashOps System: Approve Transactions";




}
