package com.g4s.Blue_Label;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class ManualTransactions 
{

	public static String workingDir;

    public static void loopTrans(int count)
    {
        try {

            for(int i=0;i<count;i++)
            {
                List<String> suites = new ArrayList<String>();

                workingDir = System.getProperty("user.dir");
                suites.add(workingDir+"\\Resources\\BLUE\\TestSuiteBlue.xml"); //path of .xml file to be run-provide complete path

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


		public static void main(String[] args)
		{

            loopTrans(1);
        }
	

}
