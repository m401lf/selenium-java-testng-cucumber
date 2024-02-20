package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.AlertInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class accept_W {
  private WebDriver driver;
  private String baseUrl;
 

  @Before
 public void setUp() throws Exception {
    driver = new FirefoxDriver();
	//Creating chrome driver
	//System.setProperty("webdriver.chrome.driver", "F:\\Selenium Project\\Downloads\\chromedriver.exe");
	//driver = new ChromeDriver();
    baseUrl = "http://localhost";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().window().maximize();
  }

  @Test
 public void testFrame() throws Exception {
	//Login to Whiztrail site
    driver.get(baseUrl + "/whiztrial/");
    driver.findElement(By.id("Lid")).clear();
    driver.findElement(By.id("Lid")).sendKeys("gsahai");
    driver.findElement(By.id("Lpwd")).clear();
    driver.findElement(By.id("Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();
    driver.findElement(By.id("alert")).click();
    driver.findElement(By.xpath(".//*[@id='contt']/p[2]/button")).click();
    Thread.sleep(3000);
    //String alert= driver.switchTo().alert().getText();
    //System.out.println(alert);
    driver.switchTo().alert().accept();
  

  }
  

  @After
 public void tearDown() throws Exception {
    driver.quit();
    
  }


}
