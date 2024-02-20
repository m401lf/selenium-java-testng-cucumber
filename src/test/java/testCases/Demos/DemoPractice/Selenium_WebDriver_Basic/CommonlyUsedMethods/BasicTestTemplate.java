package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.CommonlyUsedMethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class BasicTestTemplate {
		private WebDriver driver;
		private String baseUrl;
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.google.com";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    }
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    }
	  @Test
	  public void test_01() throws Exception {
	    driver.get(baseUrl);
	    String ExpectedTitle =driver.getTitle();
        assertEquals(ExpectedTitle,"Google");
	  	}
	  @Test
	  public void test_02() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium Webdriver");
	    driver.findElement(By.name("btnG")).click();
	    driver.findElement(By.linkText("Selenium WebDriver")).click();
	    assertEquals(driver.getTitle(),"Selenium WebDriver");
		}
	  }
