package testCases.Demos.SeleniumWebDriverBasic.WebElementInterface;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class findElementsby_W {
	  private WebDriver driver;
	  private String baseUrl;
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
		//driver = new ChromeDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  @Test
	  public void findElements() throws Exception {
	    driver.get(baseUrl + "/whizTrial/");
	    driver.findElement(By.id("Lid")).sendKeys("gsahai");
	    driver.findElement(By.id("Lpwd")).sendKeys("pass123");
	    driver.findElement(By.id("Lsub")).click();
	    Thread.sleep(3000);
	    List<WebElement> linklist= driver.findElements(By.xpath("html/body/div[4]/a")); // Save the elements in the list with the help of findElements
		System.out.println("Total No. Of Links = " +linklist.size());
	    String[] DGarr = new String[linklist.size()];
	       
	       for(int i=0;i<linklist.size();i++)
	       {
	       	int y = i+1;                         
	       	DGarr[i]=driver.findElement(By.xpath("html/body/div[4]/a["+y+"]")).getText();
	       	System.out.println("************************************");
	       	System.out.println(DGarr[i]);
	       }
	    }
	    

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
		  

	}


	}

