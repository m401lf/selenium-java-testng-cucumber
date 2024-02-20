package testCases.Demos.SeleniumWebDriverBasic.LocatingStrategies;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LocatingByXpath_W {
  private WebDriver driver;
  private String baseUrl;
 
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/whizTrial";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testLoginascandidate() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//*[@id='Lid']")).clear ();
    driver.findElement(By.xpath("//*[@id='Lid']")).sendKeys("gsahai");
    driver.findElement(By.id("Lpwd")).clear();
    driver.findElement(By.id("Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
   
  }

}
