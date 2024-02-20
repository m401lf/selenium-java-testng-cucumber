package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class getCssValue_R {
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
	    String font_Size = Search_Button.getCssValue("font-size");
	    System.out.println("Font Size :- "+font_Size);
	//------------------------------------------------------------------------------//
	    String font_Style = Search_Button.getCssValue("font-style");
	    System.out.println("Font Style :- "+font_Style);
	//------------------------------------------------------------------------------//
	    String Background_Color = Search_Button.getCssValue("background-color");
	    System.out.println("Font Style :- "+Background_Color);
	    Thread.sleep(3000);
	    
	    }
	    

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
		  
	}


	}

