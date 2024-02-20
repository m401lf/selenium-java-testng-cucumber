package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.NavigationInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class navigate_R {
  private WebDriver driver;
    
  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
    System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
  	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().window().maximize();
  }

  @Test
  public void testFrame() throws Exception {
    driver.navigate().to("https://www.google.co.in/");
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("india");
    driver.findElement(By.name("btnG")).click();
    Thread.sleep(3000);
    assertEquals(driver.getTitle(),"india - Google Search");
   
  }
  

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}
