package testCases.Demos.SeleniumWebDriverBasic.WebDriverInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class getpagesource_W {
  private WebDriver driver;
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   }

  @Test
  public void testClickonthefooterlink() throws Exception {
	  driver.get("http://localhost/whizTrial/");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  String Source =driver.getPageSource();
	  System.out.println(Source);
	  Thread.sleep(3000);
	  assertEquals(driver.getTitle(),"WhizTrial Registration");
    }
  
  @After
  public void tearDown() throws Exception {
	  driver.quit();
		       
	}
  }


