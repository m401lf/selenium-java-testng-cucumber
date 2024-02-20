package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.TestScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HandlingDynamicElements{
  private WebDriver driver;
  private String baseUrl;
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testDynamicobjectid() throws Exception {
    driver.get(baseUrl + "/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("<mail id>");
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys("<mail password>");
    driver.findElement(By.id("signIn")).click();
    driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[8]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[5]/div[2]")).click(); // click on the first mail in the mail box
    driver.findElement(By.xpath(".//*[@id=':5']/div[2]/div[1]/div/div[1]/div/div/div")).click(); // click on the back button
    driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[8]/div/div[1]/div[2]/div/table/tbody/tr[2]/td[5]/div[2]")).click(); // click on the second mail in the mail box
    driver.findElement(By.xpath(".//*[@id='gbq1']/div/a/span")).click(); // click on the back button 
    driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")).click(); //click on the account button
    driver.findElement(By.xpath(".//*[@id='gb_71']")).click(); // click on the logout button
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}

