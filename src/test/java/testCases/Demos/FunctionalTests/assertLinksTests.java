package testCases.Demos.FunctionalTests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.LinkUtil;


public class assertLinksTests extends BaseTest {
	WebDriver driver;

	@Test
  public void assertForLinksTests() {
		//homePage.clickOnCookie();
		/*Bottom Row Links*/
		//Gmail link
		boolean result = driver.findElements(By.xpath("//*[@a]"))
				.stream()
				.map(e -> e.getAttribute("a"))
				.map(a -> LinkUtil.getResponseCode(a))
				.anyMatch(rc -> rc != 200);
		Assert.assertFalse(result);
	};


}
  


