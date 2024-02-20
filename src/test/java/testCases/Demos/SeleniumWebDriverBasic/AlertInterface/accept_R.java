package testCases.Demos.SeleniumWebDriverBasic.AlertInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class accept_R {
  private WebDriver driver;
 

  @BeforeClass
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
 public void testFrameReal() throws Exception {
    
    driver.findElement(By.xpath("//*[@id='user_expert_login_btn']")).click();
    Thread.sleep(3000);
    //Getting the text of an alert and printing it
    String alert= driver.switchTo().alert().getText();
    System.out.println(alert);
    //Accepting an alert by clicking on OK button
    driver.switchTo().alert().accept();
    Thread.sleep(2000);
    
   }
  

  @AfterClass
 public void tearDown() throws Exception {
    driver.quit();
    
  }


}


