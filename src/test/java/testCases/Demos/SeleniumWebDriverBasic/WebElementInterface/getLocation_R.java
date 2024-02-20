package testCases.Demos.SeleniumWebDriverBasic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class getLocation_R {
		private WebDriver driver;
		private String baseUrl;
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
		int X_Coordinate = Search_Button.getLocation().x;
	    System.out.println("X-Coordinate of Search button :- "+X_Coordinate);
	//------------------------------------------------------------------------------//
	    int Y_Coordinate = Search_Button.getLocation().y;
	    System.out.println("Y-Coordinate of Search button :- "+Y_Coordinate);
	//------------------------------------------------------------------------------//
	    Thread.sleep(3000);
	  	}
	    
	  @After
	  	public void tearDown() throws Exception {
	    driver.quit();		  
	}
}
