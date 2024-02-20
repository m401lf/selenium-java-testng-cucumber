package testCases.Demos.DemoPractice.Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo2 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://api.jquery.com/dblclick/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0); //switch to frame
		
		WebElement ele=driver.findElement(By.xpath("/html/body/div"));
		
		Thread.sleep(5000);
		
		Actions act=new Actions(driver);
		
		act.doubleClick(ele).build().perform(); // Double click on element
		
		Thread.sleep(3000);
		
		act.doubleClick(ele).build().perform(); // Double click on element
		
		Thread.sleep(3000);
		
		act.doubleClick(ele).build().perform(); // Double click on element
		
		
		

	}

}
