package testCases.Demos.SeleniumWebDriverBasic.TimeOutsInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class  Implicitwait_W {
  private WebDriver driver;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
	//System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
	//driver = new ChromeDriver();
    baseUrl=("http://localhost/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  

  }

  @Test
  public void testExplicitwait() throws Exception {
    driver.get(baseUrl+"/whizTrial/");
    //assertEquals(driver.getTitle(),"WhizTrial Registration");
    driver.findElement(By.id("Lid")).sendKeys("gsahai"); 
    
  }
    

  @After
  public void tearDown() throws Exception {
	Thread.sleep(5000);
	driver.quit();

  }
}