package testCases.Demos.DemoPractice.Wait_commands_Links_Alerts_Popus_Frames_iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CountingLinks {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		//driver.manage().window().maximize(); //maximize the page
		
		List <WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
	
		//reading all the links from web page and display
		
		for(WebElement e:links)
		{
			System.out.println(e.getText());
		}
		
		
		
		
	}

}
