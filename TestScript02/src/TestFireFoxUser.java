// import the package
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class TestFireFoxUser 
{

	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("xyzProfile");
	// Initialize Firefox driver
		WebDriver driver = new FirefoxDriver(myprofile);
	//Maximize browser window
		driver.manage().window().maximize();
	//Go to URL which you want to navigate
		driver.get("http://www.google.com");
	//Set  timeout  for 5 seconds so that the page may load properly within that time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//close firefox browser
		driver.close();


	}

}
