package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class isSelected_W {
	
		private WebDriver driver;
		private String baseUrl;
		
	  @Before
	  	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
		//driver = new ChromeDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  @Test
	  public void findElements() throws Exception {
		driver.get(baseUrl + "/whizTrial/");
	    WebElement Rem_me_Check = driver.findElement(By.id("Rem"));
	    Thread.sleep(3000);
	    boolean BeforeSelected = Rem_me_Check.isSelected();
	    System.out.println("Remember me check box status before checking it : "+BeforeSelected); 
	    Rem_me_Check.click();
	    boolean AfterSelected = Rem_me_Check.isSelected();
	    System.out.println("Remember me check box status after checking it : "+AfterSelected);
	    Thread.sleep(3000);
	   	    
	  }
		 	    
	  @After
	  	public void tearDown() throws Exception {
	    driver.quit();		  
	  }
}
