package testCases.Demos.DemoPractice.Mouse_Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleKeyPressDemo {

	public static void main(String[] args) throws InterruptedException {
    	WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://newtours.demoaut.com/");

		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		Actions act=new Actions(driver);
		
		act.sendKeys(Keys.CONTROL+"a").build().perform();

	}

}
