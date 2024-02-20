package testCases.Demos.SeleniumWebDriverBasic.CommonlyUsedMethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class quit_R {
  private WebDriver driver;
  @Before
  public void setUp() throws Exception {
	  driver = new FirefoxDriver();
	  //System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
	  //driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testRelativexpath() throws Exception {
	  driver.get("https://google.com/");
	  assertEquals(driver.getTitle(),"Google");	  

  }
   

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
  
}
