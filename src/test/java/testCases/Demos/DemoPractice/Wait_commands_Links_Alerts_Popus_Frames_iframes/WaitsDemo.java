package testCases.Demos.DemoPractice.Wait_commands_Links_Alerts_Popus_Frames_iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WaitsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait
		
		driver.get("http://newtours.demoaut.com/");
		
		//Thread.sleep(5000);
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
	}

}
