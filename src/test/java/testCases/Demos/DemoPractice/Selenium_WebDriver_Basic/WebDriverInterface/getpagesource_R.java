package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebDriverInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class getpagesource_R {
	private WebDriver driver;
	 
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.get("https://www.google.co.in");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

  @Test
  public void testClickonthefooterlink() throws Exception {
	//driver.get("https://www.google.co.in");
	String Source =driver.getPageSource();
	System.out.println(Source);
	assertEquals(driver.getTitle(),"Google");
	}
   
   @After
   public void tearDown() throws Exception {
	driver.quit();
		    
	}
  }


