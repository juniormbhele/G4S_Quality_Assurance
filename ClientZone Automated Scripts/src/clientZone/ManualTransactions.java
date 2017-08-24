package clientZone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class ManualTransactions 
{

	public static String workingDir;

		public static void main (String[] args)
		{
			for(int i=0;i<5;i++)
	        {
	            List<String> suites = new ArrayList<String>();
	            
	            workingDir = System.getProperty("user.dir");
	            suites.add(workingDir+"\\Resources\\ManualTrans.xml"); //path of .xml file to be run-provide complete path

	            TestNG tng = new TestNG();
	            tng.setTestSuites(suites);

	            tng.run(); //run test suite
	        }
		}
	

}
