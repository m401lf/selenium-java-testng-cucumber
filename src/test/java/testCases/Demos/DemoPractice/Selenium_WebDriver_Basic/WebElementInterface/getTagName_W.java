package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class getTagName_W {
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
	    WebElement Login_Button = driver.findElement(By.id("Lsub"));
	    String TagName = Login_Button.getTagName();
	    System.out.println("Tag name List_Scream Login_Portal_Test_Page button : "+TagName);
	    Thread.sleep(3000);
	  }
	    
	  @After
	  	public void tearDown() throws Exception {
	    driver.quit();		  
	}
}
