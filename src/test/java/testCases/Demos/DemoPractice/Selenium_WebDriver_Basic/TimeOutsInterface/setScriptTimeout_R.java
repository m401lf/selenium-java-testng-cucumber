package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.TimeOutsInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;


public class setScriptTimeout_R {
    private WebDriver driver;
    
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
  	//driver = new ChromeDriver();
    //driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
    driver.manage().window().maximize();

  }

  @Test
  public void testsetScriptTimeout() throws Exception {
	long start = System.currentTimeMillis();
	driver.get("https://www.google.co.in/");
	assertEquals("Google", driver.getTitle());
    long current = System.currentTimeMillis();
    long val = current - start;
    ((JavascriptExecutor) driver).executeAsyncScript(
        "window.setTimeout(arguments[arguments.length - 1], 1000);");
    System.out.println("Elapsed time: " + val);
  } 
  
  @After
  public void tearDown() throws Exception {
	Thread.sleep(10000);
    driver.quit();
    
  }
}
