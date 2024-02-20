package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.AlertInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

	public class gettextalert_R {
	  private WebDriver driver;
	  private String baseUrl;
	 
	  
	  @Before
	 public void setUp() throws Exception {
	    driver = new FirefoxDriver();
		//Creating chrome driver
		//System.setProperty("webdriver.chrome.driver", "F:\\Selenium Project\\Downloads\\chromedriver.exe");
		//driver = new ChromeDriver();
	    driver.get("http://bookmyinterview.in/export_login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().window().maximize();
	  }

	  @Test
	 public void testRealExample() throws Exception {
	    
	    driver.findElement(By.xpath("//*[@id='user_expert_login_btn']")).click();
	    Thread.sleep(3000);
	    //Getting an alert with getText() and then printing it
	 	String alert= driver.switchTo().alert().getText();
	    System.out.println(alert);
	    //Accepting an alert with Ok button
	    driver.switchTo().alert().accept();
	    Thread.sleep(2000);
	    
	   }
	  

	  @After
	 public void tearDown() throws Exception {
	    driver.quit();
	    
	  }

}


