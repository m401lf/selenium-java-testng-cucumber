package testCases.Demos.SeleniumWebDriverBasic.AlertInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class dismiss_W {
  private WebDriver driver;
  private String baseUrl;
 
  
  @Before
 public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().window().maximize();
  }

  @Test
 public void testFrame() throws Exception {
    driver.get(baseUrl + "/whizTrial/");
    driver.findElement(By.id("Lid")).clear();
    driver.findElement(By.id("Lid")).sendKeys("gsahai");
    driver.findElement(By.id("Lpwd")).clear();
    driver.findElement(By.id("Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();
    driver.findElement(By.id("alert")).click();
    driver.findElement(By.xpath(".//*[@id='contt']/p[4]/button")).click();
    Thread.sleep(2000);
    Alert alert= driver.switchTo().alert();
    Thread.sleep(2000);
    driver.switchTo().alert().dismiss();
    //driver.switchTo().alert().accept();
    Thread.sleep(2000);
    driver.switchTo().alert().accept();
   }
 

  @After
 public void tearDown() throws Exception {
    driver.quit();
    
  }


}