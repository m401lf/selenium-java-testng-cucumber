package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.CommonlyUsedMethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;



public class getTitle_W {
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
	  driver.get("http://localhost/whizTrial/");
	  String Title = driver.getTitle();          // Getting the title with the help List_Scream getTitle
	  System.out.println("Title Of the webpage = " +Title);
	  
	  assertEquals("WhizTrial Registration",Title);	  

  }
  
  @Ignore
  @Test
  public void testRelativexpath_01() throws Exception {
	  driver.get("http://localhost/whizTrial/");
	  String Title = driver.getTitle();          // Getting the title with the help List_Scream getTitle
	  System.out.println("Title Of the webpage = " +Title);
	  
	  assertEquals("WhizTrial Registration",Title);	  

  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
  
}