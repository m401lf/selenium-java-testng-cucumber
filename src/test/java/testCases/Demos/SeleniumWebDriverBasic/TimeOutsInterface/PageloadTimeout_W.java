package testCases.Demos.SeleniumWebDriverBasic.TimeOutsInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class PageloadTimeout_W {
    private WebDriver driver;
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
  	//driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
  }

  @Test
  public void testExplicitwait() throws Exception {
	
    driver.get("http://localhost//whizTrial/");
    assertEquals(driver.getTitle(),"WhizTrial Registration");
  }
  
  @After
  public void tearDown() throws Exception{ 
	Thread.sleep(3000);
    driver.quit();
  }
}

 



