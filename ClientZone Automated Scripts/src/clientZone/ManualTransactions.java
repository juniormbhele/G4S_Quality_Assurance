package clientZone;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class ManualTransactions 
{

	public static String workingDir;

		public static void main (String[] args)
		{
            try {

                for(int i=0;i<5;i++)
                {
                List<String> suites = new ArrayList<String>();

                workingDir = System.getProperty("user.dir");
                suites.add(workingDir+"\\Resources\\ManualTrans.xml"); //path of .xml file to be run-provide complete path

                TestNG test = new TestNG();
                test.setTestSuites(suites);

                //run test suite
                test.run();
}
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
	

}
