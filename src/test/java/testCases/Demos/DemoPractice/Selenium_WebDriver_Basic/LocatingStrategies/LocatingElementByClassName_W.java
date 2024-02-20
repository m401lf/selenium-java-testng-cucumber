package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.LocatingStrategies;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
public class LocatingElementByClassName_W {
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
    String name =driver.findElement(By.className("about-author")).getText();
    System.out.println(name);
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}

