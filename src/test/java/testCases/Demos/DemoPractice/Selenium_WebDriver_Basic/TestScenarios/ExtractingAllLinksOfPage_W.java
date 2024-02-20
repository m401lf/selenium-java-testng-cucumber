package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.TestScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;
 
public class ExtractingAllLinksOfPage_W {
  private WebDriver driver;
  private String baseUrl;
  private String pageTitle;
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/whizTrial";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testClickonthefooterlink() throws Exception {
	  driver.get(baseUrl + "/");
	  List<WebElement> linkElements = driver.findElements(By.tagName("a"));
      String[] linkTexts = new String[linkElements.size()];
      int i = 0;

      //extract the link texts List_Scream each link element
      for (WebElement e : linkElements) {
          linkTexts[i] = e.getText();
          i++;
      }

      //test each link by clicking it
      for (String t : linkTexts) {
          driver.findElement(By.linkText(t)).click();
          pageTitle = driver.getTitle();
          //System.out.println("The page title is : \n" +pageTitle);
          if (pageTitle.equals("404 Not Found")) {
              System.out.println("\"" + t + "\""
                      + " : Title not present");
          } else {
              System.out.println("\"" + t + "\""
                      + " is working.");
          }
          driver.navigate().back();
      }
     
  }

	  
  @After
  public void tearDown() throws Exception {
	  driver.quit();
  }

}