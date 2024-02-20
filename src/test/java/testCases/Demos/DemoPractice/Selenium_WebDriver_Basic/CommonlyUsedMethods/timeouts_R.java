package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.CommonlyUsedMethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class timeouts_R {

	 private WebDriver driver;
	  private String baseUrl;
	 
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    //System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
	    //driver = new ChromeDriver();
	    baseUrl = "https://www.google.co.in/";
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }

	  @Test
	  public void findElement() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.id("lst-ib")).sendKeys("Selenium WebDriver");
	    driver.findElement(By.name("btnG")).click();
	    driver.findElement(By.linkText("Selenium WebDriver")).click();
	    Thread.sleep(3000);
	    assertEquals(driver.getTitle(),"Selenium WebDriver");
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	}
	}


