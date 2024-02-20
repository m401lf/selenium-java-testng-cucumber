package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.LocatingStrategies;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
public class Combinations_CSS_Selector_W {
  private WebDriver driver;
  private String baseUrl;
 
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testCsstagandclass() throws Exception {
	driver.get(baseUrl + "/whizTrial/");
	
    //Tag with attribute value
    /*driver.findElement(By.cssSelector("input#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input[name='userauth']")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();*/
    
    //id
    /*driver.findElement(By.cssSelector("#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input[name='userauth']")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();*/
    
    //Tag and id
    /*driver.findElement(By.cssSelector("input#Lid")).clear();
    driver.findElement(By.cssSelector("input#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input#Lpwd")).clear();
    driver.findElement(By.cssSelector("input#Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();*/
    
    //Tag and attribute class
    /*driver.findElement(By.cssSelector("input#Lid")).clear();
    driver.findElement(By.cssSelector("input#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input#Lpwd")).clear();
    driver.findElement(By.cssSelector("input#Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("a.link")).click();
    Thread.sleep(3000);*/
    
    //Class attribute
    driver.findElement(By.cssSelector("input#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input#Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".link")).click();
    Thread.sleep(3000);
        
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

}

