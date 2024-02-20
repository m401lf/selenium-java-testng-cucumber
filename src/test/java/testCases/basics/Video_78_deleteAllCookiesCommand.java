package testCases.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Video_78_deleteAllCookiesCommand {
	
	@Test(enabled=true)
	public void f1() throws Exception {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.tutorialsninja.com/demo/");
			
	    //deleteAllCookies() command to delete all the cookies in the current session from the browser
		 driver.manage().deleteAllCookies();
	
		Thread.sleep(2000);
		//driver.quit();
			
	} 
	
}
