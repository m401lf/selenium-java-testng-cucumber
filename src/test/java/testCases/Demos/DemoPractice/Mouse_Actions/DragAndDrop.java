package testCases.Demos.DemoPractice.Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		driver.manage().window().maximize();
		
		WebElement source_element=driver.findElement(By.id("box6")); //Italy - source element
		
		WebElement target_element=driver.findElement(By.id("box106"));//Rome -target element
		
		Actions act=new Actions(driver);
		
		Thread.sleep(5000);
		
		act.dragAndDrop(source_element, target_element).build().perform(); //Drag and drop
		
		

	}

}
