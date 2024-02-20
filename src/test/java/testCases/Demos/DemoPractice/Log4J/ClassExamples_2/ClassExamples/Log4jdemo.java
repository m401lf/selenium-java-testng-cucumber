package testCases.Demos.DemoPractice.Log4J.ClassExamples_2.ClassExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class Log4jdemo {
	
	static Logger logger;
	
	@Test(priority=1)
	public void setup()
	{
	logger=Logger.getLogger("Log4jdemo");  // Provide test ase name/class name as a parameter
	PropertyConfigurator.configure("Log4j.properties");
	
	logger.info("Setup method is tarted");
	logger.info("Setup method is progress");
	
	//Add configuration steps
	System.out.println("This is setup method");
	}

	@Test(priority=2)
	public void login()
	{
		logger.info("Login_Portal_Test_Page is started");
		//Write webdriver code
		System.out.println(" This is Login_Portal_Test_Page test");
		logger.info("Login_Portal_Test_Page is progress");
		logger.info("Login_Portal_Test_Page is completed");
		logger.info("Login_Portal_Test_Page is passed");
		
	}
	
	@Test(priority=3)
	public void logout()
	{
		//Write webdriver code
		System.out.println(" This is logout test");
		logger.info("logout is completed");
	}
	
}
