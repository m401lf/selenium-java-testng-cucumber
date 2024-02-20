package testCases.Demos.FunctionalTests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class verifySearchTests extends BaseTest {
	WebDriver driver;
  @Test
  public void VerifySearchTests() throws InterruptedException {
	  WebElement searchBox = driver.findElement(By.name("q"));
	  
	  searchBox.sendKeys("TestToBeBest");
	  searchBox.sendKeys(Keys.ENTER);
	  
	  Thread.sleep(2000);
	  String Title = driver.getTitle();
	  Assert.assertEquals("TestToBeBest - Google Search", Title);
	  
  }
}
