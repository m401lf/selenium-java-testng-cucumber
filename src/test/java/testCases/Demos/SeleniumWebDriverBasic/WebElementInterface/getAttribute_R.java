package testCases.Demos.SeleniumWebDriverBasic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class getAttribute_R {
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
		  driver.get("https://google.com");
	    
	    String  Search_Buttton_Value= driver.findElement(By.name("btnK")).getAttribute("value");
	    System.out.println("Value attribute of login button :- "+Search_Buttton_Value);	 
	    Thread.sleep(4000);
	    
	    }
	    

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
		  

	}


	}
