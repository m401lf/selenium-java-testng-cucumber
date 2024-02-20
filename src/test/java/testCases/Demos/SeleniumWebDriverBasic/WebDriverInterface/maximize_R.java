package testCases.Demos.SeleniumWebDriverBasic.WebDriverInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.fail;

      public class maximize_R {
	  private WebDriver driver;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  @Test
	  public void testUntitled()  throws Exception {
	   driver.get("https:\\www.google.co.in\\");
	   driver.manage().window().setSize(new Dimension(350,500));
	   driver.manage().window().maximize();
	  
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