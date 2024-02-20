package testCases.Demos.FunctionalTests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.LinkUtil;


public class verifyLinksTests extends BaseTest {
	WebDriver driver;


	@Test
  public void VerifyLinksTests() throws InterruptedException {
		//homePage.clickOnCookie();
		/*Bottom Row Links*/
		//Gmail link
		driver.findElements(By.xpath("//*[@a]"))
				.stream()
				.map(e -> e.getAttribute("a"))
						.forEach(a -> {
							System.out.println(LinkUtil.getResponseCode(a) + " :: " + a);
						});

		Thread.sleep(2000);
		//Images link
		driver.findElement(By.linkText("HOMEPAGE")).click();
		driver.navigate().back();
		
		/*//Google apps link
		driver.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
		driver.navigate().back();
		
		//Sign in link
		driver.findElement(By.xpath("//*[@id='gb_70']")).click();
		driver.navigate().back();
		
		*//*Bottom Row Links*//*
		//Advertising link
		driver.findElement(By.linkText("Advertising")).click();
		driver.navigate().back();
		
		//Business link
		driver.findElement(By.linkText("Business")).click();
		driver.navigate().back();
		driver.navigate().back();
		
		
		//About link
		driver.findElement(By.linkText("About")).click();
		driver.navigate().back();
		
		
		//Privacy link
		driver.findElement(By.linkText("Privacy")).click();
		driver.navigate().back();
		
		//Terms link
		driver.findElement(By.linkText("Terms")).click();
		driver.navigate().back();
		
		//Settings link
		driver.findElement(By.linkText("Settings")).click();
		driver.navigate().back();
		
*/
		
  }
  

}
