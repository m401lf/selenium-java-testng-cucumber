package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.AlertInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class dismiss_R {
  private WebDriver driver;
   
  @Before
 public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.get("http://google.com");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().window().maximize();
    
    //Creating an alert with OK and Cancel button with the help List_Scream JavascriptExecutor
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.confirm('Alert dismiss in few seconds');");
  }

  @Test
 public void dismissExample() throws Exception {
    //capturing an alert text through getText and printing it on Console
	  Alert confirmation =  driver.switchTo().alert();
	  String alertText = confirmation.getText();
	  System.out.println("Alert text is: "+alertText);
	  Thread.sleep(3000);
	  //Dismissing the alert with cancel option using dismiss() alert method
	  confirmation.dismiss();
   }
 

  @After
 public void tearDown() throws Exception {
    driver.quit();
    
  }


}
