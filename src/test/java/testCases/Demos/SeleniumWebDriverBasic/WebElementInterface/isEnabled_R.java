package testCases.Demos.SeleniumWebDriverBasic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class isEnabled_R {
	
		private WebDriver driver;
		
	  @Before
	  	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
		//driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  @Test
	  public void findElements() throws Exception {
		driver.get("https://www.google.com");
		WebElement Search_Button = driver.findElement(By.name("btnK"));
		boolean Enabled = Search_Button.isEnabled();
	    System.out.println("Google Search button enabled status : "+Enabled);
	    Thread.sleep(3000);
	
	  }
	    
	  @After
	  	public void tearDown() throws Exception {
	    driver.quit();		  
	  }
}

