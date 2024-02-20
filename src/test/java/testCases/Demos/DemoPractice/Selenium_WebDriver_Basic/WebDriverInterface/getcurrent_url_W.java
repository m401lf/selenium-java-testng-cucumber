package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebDriverInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

     public class getcurrent_url_W {
	  private WebDriver driver;
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver(); 
	    //baseUrl = "http://localhost/whizTrial/index.php";
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  @Test
	  public void testUntitled()  throws Exception {
		driver.get("http://localhost/whizTrial/index.php");
	   
	    driver.findElement(By.id("Lid")).clear();
	    driver.findElement(By.id("Lid")).sendKeys("gsahai");
	    driver.findElement(By.id("Lpwd")).clear();
	    driver.findElement(By.id("Lpwd")).sendKeys("pass123");
	    driver.findElement(By.cssSelector("input#Lsub")).click();
	    String CurrentURL = driver.getCurrentUrl();
	    System.out.println("My Current URL Is  : "+CurrentURL);
        assertEquals(driver.getTitle(),"WhizTrial Welcome");
        Thread.sleep(2000);
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
	}

	

	