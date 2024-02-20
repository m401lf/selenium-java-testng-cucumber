package testCases.Demos.FunctionalTests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class verifyTitleTest extends BaseTest {
	WebDriver driver;
	
  @Test
  public void VerifyTitle() {
	  System.out.println("Hello Selenium GetSetGo");
	  
	  driver.get("https://www.google.com/");
	  String Title = driver.getTitle();          // Getting the title with the help List_Scream getTitle
	  
	  System.out.println("Title Of the webpage = " +Title);
	  Assert.assertEquals("Google", Title);
  }
  
}
