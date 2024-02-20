package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebDriverInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class getcurrenturl_R {
	  private WebDriver driver;
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver(); 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().window().maximize();
	  }

	  @Test
	  public void testUntitled()  throws Exception {
		driver.navigate().to("https://www.google.co.in/");
	    driver.findElement(By.id("lst-ib")).clear();
	    driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
	    driver.findElement(By.name("btnG")).click();
	    Thread.sleep(2000);
	    String CurrentURL = driver.getCurrentUrl();
	    System.out.println("My Current URL Is  : "+CurrentURL);
	    Thread.sleep(2000);
        assertEquals(driver.getTitle(),"Selenium - Google Search");
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
	}

	

	