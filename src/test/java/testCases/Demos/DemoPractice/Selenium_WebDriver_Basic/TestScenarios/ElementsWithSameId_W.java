package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.TestScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ElementsWithSameId_W {
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
	  String cssSelect="input[id='Lid'][name='userauth1']";
	  driver.findElement(By.cssSelector(cssSelect)).clear();
	  driver.findElement(By.cssSelector(cssSelect)).sendKeys("gsahai");
	  String cssSelect1="input[id='Lpwd'][name='userauth']";
	  driver.findElement(By.cssSelector(cssSelect1)).clear();
	  driver.findElement(By.cssSelector(cssSelect1)).sendKeys("pass123");
	  driver.findElement(By.xpath(".//*[@id='Lsub']")).click();
                         //OR//
	  /*driver.get(baseUrl + "/whizTrial/");
	  driver.findElement(By.xpath("html/body/section[1]/div[1]/form/p[2]/input")).clear();
	  driver.findElement(By.xpath("html/body/section[1]/div[1]/form/p[2]/input")).sendKeys("gsahai");
	  driver.findElement(By.xpath("html/body/section[1]/div[1]/form/p[3]/input")).clear();
	  driver.findElement(By.xpath("html/body/section[1]/div[1]/form/p[3]/input")).sendKeys("pass123");
	  driver.findElement(By.xpath(".//*[@id='Lsub']")).click();*/
  }

  @After
  public void tearDown() throws Exception {
	  driver.quit();
    
  }

}

