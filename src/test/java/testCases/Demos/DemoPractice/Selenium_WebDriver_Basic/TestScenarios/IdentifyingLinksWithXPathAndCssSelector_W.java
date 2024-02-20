package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.TestScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class IdentifyingLinksWithXPathAndCssSelector_W {
  private WebDriver driver;
  private String baseUrl;
 
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testIdentifylinksbyxpathandcss() throws Exception {
    driver.get(baseUrl + "/whizTrial/");
    driver.findElement(By.id("Lid")).clear();
    driver.findElement(By.id("Lid")).sendKeys("gsahai");
    driver.findElement(By.id("Lpwd")).clear();
    driver.findElement(By.id("Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();
    String Text = driver.findElement(By.xpath(".//*[@id='ilink']")).getText();
   System.out.println(Text);
   String Text1 = driver.findElement(By.cssSelector("#icontext")).getText();
   System.out.println(Text1);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    
  }
}

