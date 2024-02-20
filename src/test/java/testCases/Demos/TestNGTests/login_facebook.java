package testCases.Demos.TestNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class login_facebook {

    public WebDriver driver;

    @Test
    public static void login_positive() throws InterruptedException {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement declineOptionalCookies =  driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[4]/button[1]"));
        WebElement allowCookies =  driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[4]/button[2]"));
        allowCookies.click();
        //declineOptionalCookies.click();
        driver.findElement(By.id("email")).sendKeys("azetabenjamin@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Money_2017");
        driver.findElement(By.cssSelector("button[name='login']")).click();




    }

}
