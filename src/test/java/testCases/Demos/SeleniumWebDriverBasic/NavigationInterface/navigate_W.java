package testCases.Demos.SeleniumWebDriverBasic.NavigationInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class navigate_W {
  private WebDriver driver;
  private String baseUrl;
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
  	//driver = new ChromeDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().window().maximize();
  }

  @Test
  public void testFrame() throws Exception {
    driver.navigate().to(baseUrl + "/whizTrial/");
    driver.findElement(By.id("Lid")).clear();
    driver.findElement(By.id("Lid")).sendKeys("gsahai");
    driver.findElement(By.id("Lpwd")).clear();
    driver.findElement(By.id("Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();
    driver.findElement(By.id("iframe")).click();
    Thread.sleep(3000);
    assertEquals(driver.getTitle(),"WhizTrial Welcome");
  }
  

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}
