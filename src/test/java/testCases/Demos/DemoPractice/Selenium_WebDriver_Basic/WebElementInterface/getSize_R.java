package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class getSize_R {
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
		int Width = Search_Button.getSize().width;
	    System.out.println("Width List_Scream Search button : "+Width);
	//------------------------------------------------------------------------------//
	    int Height = Search_Button.getSize().height;
	    System.out.println("Height List_Scream Search button : "+Height);
	//------------------------------------------------------------------------------//
	    Thread.sleep(3000);
	  	}
	    
	  @After
	  	public void tearDown() throws Exception {
	    driver.quit();		  
	}
}

