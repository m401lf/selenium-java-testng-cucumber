package testCases.Demos.SeleniumWebDriverBasic.WebDriverInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.fail;

      public class setposition_R {
	  private WebDriver driver;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver(); 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  @Test
	  public void testUntitled()  throws Exception {
	   driver.get("https://www.google.co.in/");
	   driver.manage().window().setPosition(new Point(70,300));
	   System.out.println("X coordinate window position " +driver.manage().window().getPosition().getX());
	   System.out.println("Y coordinate window position " +driver.manage().window().getPosition().getY());
	   //assertEquals(driver.getTitle(),"WhizTrial Registration");
	  }

	  @After
	  public void tearDown() throws Exception {
	   driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	}

