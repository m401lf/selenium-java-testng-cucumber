package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.LocatingStrategies;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class LocatingElementByCSS_W {
  private WebDriver driver;
  private String baseUrl;
  

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testCssselector() throws Exception {
    driver.get(baseUrl + "/whizTrial/index.php");
    driver.findElement(By.id("N_acnt")).click();
    driver.findElement(By.name("Nm")).clear();
    driver.findElement(By.name("Nm")).sendKeys("abcd");
    driver.findElement(By.name("Lm")).clear();
    driver.findElement(By.name("Lm")).sendKeys("xyz");
    driver.findElement(By.name("Uid")).clear();
    driver.findElement(By.name("Uid")).sendKeys("MyName");
    driver.findElement(By.name("pwd")).clear();
    driver.findElement(By.name("pwd")).sendKeys("abcdxyz");
    driver.findElement(By.name("Eid")).clear();
    driver.findElement(By.name("Eid")).sendKeys("email@gmail.com");
    driver.findElement(By.name("Pno")).clear();
    driver.findElement(By.name("Pno")).sendKeys("+910000000000");
    driver.findElement(By.id("ml")).click();
    driver.findElement(By.name("dat")).clear();
    driver.findElement(By.name("dat")).sendKeys("11-07-1989");
    new Select(driver.findElement(By.id("sel"))).selectByVisibleText("Employee");
    driver.findElement(By.id("add")).clear();
    driver.findElement(By.cssSelector("#add.textare")).sendKeys("New Delhi");
    driver.findElement(By.name("Sub")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
   
  }

 
}
