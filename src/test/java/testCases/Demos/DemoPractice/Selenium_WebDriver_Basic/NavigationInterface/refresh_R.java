package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.NavigationInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class refresh_R {
	WebDriver driver ;
	
	@Before
	public void setup()
	{
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
	  	//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	@Test
	public void test_back() throws Exception
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Forgotten your password?")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		String actual_title = driver.getTitle();
		String expect_title = "Forgotten Password | Can't Log In | Facebook";
		assertEquals(actual_title, expect_title);
		Thread.sleep(2000);
	}
	
	@After
	public void teardown() throws Exception
	{
		driver.quit();
	}
}
