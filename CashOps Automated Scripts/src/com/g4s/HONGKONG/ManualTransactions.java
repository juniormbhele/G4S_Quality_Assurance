package com.g4s.HONGKONG;

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
                suites.add(workingDir+"\\Resources\\HONGKONG\\TestSuiteHongKong.xml"); //path of .xml file to be run-provide complete path

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

    public static void Auth(int count)
    {
        try {

            for(int i=0;i<count;i++)
            {
                List<String> suites = new ArrayList<String>();

                workingDir = System.getProperty("user.dir");
                suites.add(workingDir+"\\Resources\\HONGKONG\\TestSuiteHongKong.xml"); //path of .xml file to be run-provide complete path

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

            loopTrans(5);
        }
	

}
