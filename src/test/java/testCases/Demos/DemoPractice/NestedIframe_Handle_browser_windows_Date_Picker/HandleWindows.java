package testCases.Demos.DemoPractice.NestedIframe_Handle_browser_windows_Date_Picker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandleWindows {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		//String handleValue=driver.getWindowHandle();
		//System.out.println(handleValue); //CDwindow-45FEE686DED3D844347AB3AC2E7F5E41
		
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		
		Set <String> handlevalues=driver.getWindowHandles();
		
		for(String h:handlevalues)
		{
			//System.out.println(h);
			String title=driver.switchTo().window(h).getTitle();
			//System.out.println(title);
			
			if(title.equals("Sakinalium | Home") )
			{
				driver.findElement(By.xpath("//*[@id=\"container\"]/header/div/div/div[2]/ul/li[4]/a")).click(); //contact menu
			}
		}
	
	}

}
