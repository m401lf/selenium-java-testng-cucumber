package testCases.Demos.SeleniumWebDriverBasic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Clear_W {

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
	  public void testRelativexpath() throws Exception {
	    driver.get(baseUrl + "/whizTrial/");  //  Launch the WhizTrial website
	    driver.findElement(By.id("Lid")).sendKeys("WrongUsername");  // Enter wrong username in the 'Username' input field
	    Thread.sleep(3000);
	    driver.findElement(By.id("Lid")).clear(); // Clear the wrong value from the 'Username' input field
	    Thread.sleep(3000);
	    driver.findElement(By.id("Lid")).sendKeys("gsahai");  // Enter the username in the 'Username' input field
	    driver.findElement(By.id("Lpwd")).sendKeys("WrongPassword");   //  Enter the wrong password in the 'Password' input field
	    Thread.sleep(3000);
	    driver.findElement(By.id("Lpwd")).clear();   // Clear the wrong value from the 'Password' input field
	    driver.findElement(By.id("Lpwd")).sendKeys("pass123");  //  Enter the password in the 'Password' input field  
	    driver.findElement(By.id("Lsub")).click();  // Click on the 'Login' button
	    Thread.sleep(3000);
	    assertEquals(driver.getTitle(),"WhizTrial Welcome"); // Verifying the welcome page
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	     driver.quit();
	
}
}