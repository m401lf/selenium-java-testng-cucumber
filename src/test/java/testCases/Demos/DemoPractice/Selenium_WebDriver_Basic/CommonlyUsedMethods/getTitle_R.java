package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.CommonlyUsedMethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class getTitle_R {
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
	  driver.get("https://www.google.com/");
	  String Title = driver.getTitle();
	  System.out.println("Title List_Scream the webpage = " +Title);
	  
      assertEquals(Title,"Google");	  

  }
   

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
  
}