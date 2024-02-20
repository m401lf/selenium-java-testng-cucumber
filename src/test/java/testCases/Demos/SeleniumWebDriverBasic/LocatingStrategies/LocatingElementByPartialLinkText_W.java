package testCases.Demos.SeleniumWebDriverBasic.LocatingStrategies;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LocatingElementByPartialLinkText_W{
  private WebDriver driver;
  private String baseUrl;
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testRelativexpath() throws Exception {
    driver.get(baseUrl + "/whizTrial/");
    driver.findElement(By.partialLinkText("Create New")).click();
    Thread.sleep(3000);
  
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

}

