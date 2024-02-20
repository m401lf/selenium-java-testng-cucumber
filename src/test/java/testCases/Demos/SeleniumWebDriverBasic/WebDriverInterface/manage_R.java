package testCases.Demos.SeleniumWebDriverBasic.WebDriverInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class manage_R {
  private WebDriver driver;
  
@Before
  public void setUp() throws Exception {
	
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

@Test
  public void testVerifytitle() throws Exception {
    driver.get("https://www.facebook.com/");
    driver.manage().window().maximize();
    Thread.sleep(2000);
  }

@After
  public void tearDown() throws Exception {
    driver.quit();
	    
  }
}


