package testCases.Demos.SeleniumWebDriverBasic.TestScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.fail;

public class ClickingOnLinkOneByOne_W {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  /*public void testClickingOnLinkOneByOne() throws Exception {
	  driver.get(baseUrl + "whizTrial/");
	  WebElement box =driver.findElement(By.xpath("html/body/section[1]"));
	  List<WebElement> links = box.findElements(By.tagName("a"));
	  
	  System.out.println(links.size());
	  
	  for (int i=0; i<links.size();i++) 
	  {
		  System.out.println(links.get(i).getText());
		  links.get(i).click();
		  
		  //get back to original webpage and get the elements again
		  driver.get(baseUrl + "whizTrial/");
		  box=driver.findElement(By.xpath("html/body/section[1]"));
		  links=box.findElements(By.tagName("a"));
		  System.out.println("********************************");
	  }
  }*/
  
  public void testClickingOnLinkOneByOne() throws Exception {
	  driver.get(baseUrl + "whizTrial/");
	  WebElement box =driver.findElement(By.xpath("html"));
	  List<WebElement> links = box.findElements(By.tagName("a"));
	  
	  System.out.println(links.size());
	  
	  for (int i=0; i<links.size();i++) 
	  {
		  System.out.println(links.get(i).getText());
		  links.get(i).click();
		  //System.out.println(driver.getTitle());
		  //get back to original webpage and get the elements again
		  driver.get(baseUrl + "whizTrial/");
		  box=driver.findElement(By.xpath("html"));
		  links=box.findElements(By.tagName("a"));
		  System.out.println("********************************");
	  }
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}

