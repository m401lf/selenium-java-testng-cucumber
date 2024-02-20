package testCases.Demos.SeleniumWebDriverBasic.CommonlyUsedMethods;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class click_R {

    WebDriver driver;

    String baseUrl = "https://www.google.com";

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Clear() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium Webdriver");
        Thread.sleep(3000);
        driver.findElement(By.name("btnG")).click(); // Click on the search button
        driver.findElement(By.linkText("Selenium WebDriver")).click(); // Click on the 'Selenium WebDriver link text'
        Thread.sleep(3000);
        //assertEquals(driver.getTitle(),"Selenium WebDriver");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}


