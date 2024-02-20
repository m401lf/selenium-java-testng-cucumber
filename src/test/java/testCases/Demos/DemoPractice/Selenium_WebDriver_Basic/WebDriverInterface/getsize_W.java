package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebDriverInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.fail;

       public class getsize_W {
	  public WebDriver driver;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver(); 
	   // baseUrl = "http://localhost/whizTrial/index.php";

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  @Test
	  public void testUntitled()  throws Exception {
		driver.get("http://localhost/whizTrial/index.php");
	   driver.manage().window().getSize().getHeight();
	   driver.manage().window().getSize().getWidth();
	   System.out.println("Width:" +driver.manage().window().getSize().getHeight());
	   System.out.println("Height:" +driver.manage().window().getSize().getWidth());
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

	

