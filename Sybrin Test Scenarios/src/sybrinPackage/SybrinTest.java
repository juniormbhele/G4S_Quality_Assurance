package sybrinPackage;

public class SybrinTest 
{

	public static void main(String[] args)  
	{
		// TODO Auto-generated method stub
		
		//Setting Up Environment to test
		try 
		{
			SetUpEnvironment.TestURL();
			RegistrationClass.SignIn();
			RegistrationClass.NoData();
			RegistrationClass.WrongEmail1();
			RegistrationClass.WrongEmail2();
			RegistrationClass.WrongEmail3();
			RegistrationClass.WrongEmail4();
			RegistrationClass.ExistingEmail();
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		

	}

}
