package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.TimeOutsInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class  implicitwait_R {
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }

  @Test
  public void testExplicitwait() throws Exception {
    driver.get("https://www.google.co.in/"); 
    
    driver.findElement(By.id("lst-iib")).sendKeys("Selenium Webdriver");
    
  }
    

  @After
  public void tearDown() throws Exception {
   driver.quit();
  }
}
