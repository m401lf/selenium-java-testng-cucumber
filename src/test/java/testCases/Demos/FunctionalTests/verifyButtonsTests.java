package testCases.Demos.FunctionalTests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class verifyButtonsTests extends BaseTest {
	WebDriver driver;

	@Test
	public void VerifyButtonsTests() {
	  
	//Google Search button
	String searchButtonName;
	searchButtonName = driver.findElement(By.name("btnK")).getAttribute("value");
	//assertEquals("Google Search", searchButtonName);
	
	//I'm Feeling Lucky button
	String feelingLuckyButtonName;
	feelingLuckyButtonName = driver.findElement(By.name("btnI")).getAttribute("value");
	//assertEquals("I'm Feeling Lucky", feelingLuckyButtonName);
		
  }
}
