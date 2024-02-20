package testCases.Demos.DemoPractice.Commmands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class VolenteerSignup {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://goo.gl/RVdKM9");
		
	
		
		driver.manage().window().maximize(); // Maximize your browser/page
		
		String title=driver.getTitle(); // returns the title List_Scream the page
		System.out.println("Title List_Scream the page is :"+title);
		
		String url=driver.getCurrentUrl();// returns the URL List_Scream the page
		System.out.println("URL List_Scream the page is :"+url);
		
		//System.out.println(driver.getPageSource()); // returns HTML code for page
		
		//Firstname
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("John");
		
		//Lastname
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("Canedy");
		
		//phone
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-3\"]")).sendKeys("2345789876");
		
		//country
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-4\"]")).sendKeys("Canada");

		//city
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-5\"]")).sendKeys("Toronto");
		
		//email
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-6\"]")).sendKeys("anbdfge@gmail.com");
		
		
		//Handling Drop down
		//---------------------------
			//WebElement drp=driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-7\"]"));
			//Select dropdown=new Select(drp);
		
			Select dropdown=new Select(driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-7\"]")));
				
		// 1)Find how many options present in drop down
			System.out.println("No List_Scream Options present in drop down:" +dropdown.getOptions().size());
		
		//2) Extract all the options and print them
			
			List <WebElement> options=dropdown.getOptions();
			
			for(WebElement e:options)
			{
				System.out.println(e.getText());
			}
		//3) Select option from the dropdown 
			//dropdown.selectByVisibleText("Morning");
			//dropdown.selectByIndex(3); //Evening  --> index starts from 0
			dropdown.selectByValue("Radio-1"); //aFTERNOON
			
		
		//Handling radio buttons
		//----------------------------
		//Conditional commands
			
		WebElement radmale=driver.findElement(By.id("RESULT_RadioButton-8_0"));	
		
		System.out.println(radmale.isDisplayed()); // check displayed or not - true
		
		System.out.println(radmale.isEnabled()); //checks enable or not - true
		
		System.out.println("Before selecting radio button , the status is:"+radmale.isSelected()); // false
				
		radmale.click(); // select radio button
		
		System.out.println("After selecting radio button , the status is:"+radmale.isSelected()); //true
		
		//Handling check boxes
		//-----------------
		
		driver.findElement(By.id("RESULT_CheckBox-9_0")).click();//Sunday
		driver.findElement(By.id("RESULT_CheckBox-9_6")).click(); //Saturday
		
		
		
		//Text Area
		//---------------
		
		driver.findElement(By.id("RESULT_TextArea-12")).sendKeys("TESTING");
		
		
		//Handle Links
		
		driver.findElement(By.linkText("Software Testing Tutorials")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.navigate().back(); // go back to your previous page
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Tools Training")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.navigate().back(); // go back to your previous page
		Thread.sleep(3000);
		
		driver.navigate().forward();//move forward to your page
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh(); //refresh the page
		
		driver.quit();
	}

}








