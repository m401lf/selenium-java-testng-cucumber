package testCases.Demos.SeleniumWebDriverBasic.differentWebDrivers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;


public class HtmlUnit_W {
	
	WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = new HtmlUnitDriver();
	}
	
	@Test
    public void test1()
	{  
 
		driver.get("http://localhost/whizTrial/");    
		System.out.println("Page title is: " + driver.getTitle());
		assertEquals(driver.getTitle(),"WhizTrial Registration" );
    
    }
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	}

