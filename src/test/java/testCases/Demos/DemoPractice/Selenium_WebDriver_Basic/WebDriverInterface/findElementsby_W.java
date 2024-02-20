package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebDriverInterface;

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
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().window().maximize();
	  }

	  @Test
	  public void testRelativexpath() throws Exception {
		  
	    driver.get(baseUrl + "/whizTrial/");
	    driver.get("http://localhost/whizTrial/index.php");
	    
	    driver.findElement(By.id("N_acnt")).click();
	    WebElement tablebody= driver.findElement(By.xpath("html/body/section/div/form/table"));
	    List <WebElement> rows  = tablebody.findElements(By.tagName("input"));
	    System.out.println("Total rows in the table : " + rows.size() +"\n");
	    
	    int rowsnum= rows.size();
	    String xpath =null;
	    String cellval;
	    for(int i = 1;i<=rowsnum;i++){
	        
	    	System.out.println("For Row : " + i);
	        xpath = "html/body/section/div/form/table/tbody/tr[" + String.valueOf(i) +"]" ;
	        System.out.println(xpath);
	        cellval = driver.findElement(By.xpath(xpath)).getText() ;
	        System.out.println(cellval);
	        System.out.println("\n");
	        
	    }
	    
	  }
	    

	  @After
	  public void tearDown() throws Exception {
		  driver.quit();
		  }
	  
}

