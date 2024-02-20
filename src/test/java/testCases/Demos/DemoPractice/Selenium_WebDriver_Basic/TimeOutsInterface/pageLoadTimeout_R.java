package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.TimeOutsInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class pageLoadTimeout_R {
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
	
    driver.get("https://www.google.co.in/");
    assertEquals(driver.getTitle(),"Google");

  }
  
  @After
  public void tearDown() throws Exception{ 
    driver.quit();
  }

}



