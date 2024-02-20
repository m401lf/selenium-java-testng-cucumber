package testCases.Demos.SeleniumWebDriverBasic.WebDriverInterface;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class navigate_R {
  private WebDriver driver;
    
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testFrame() throws Exception {
	driver.get("http://localhost/whizTrial/");
	driver.get("https://www.google.co.in/");
	driver.get("https://www.bing.com/");
	
	Thread.sleep(2000);
	driver.navigate().to("https://www.google.co.in/");
	Assert.assertEquals(driver.getTitle(), "Google");
	
	Thread.sleep(2000);
	driver.navigate().to("http://localhost/whizTrial/");
	Assert.assertEquals(driver.getTitle(), "WhizTrial Registration");
    
	Thread.sleep(2000);
	driver.navigate().to("https://www.bing.com/");
    Assert.assertEquals(driver.getTitle(), "Bing");
    Thread.sleep(2000);
    
  }
  

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}
