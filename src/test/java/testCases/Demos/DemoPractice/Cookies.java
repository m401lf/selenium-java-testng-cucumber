package testCases.Demos.DemoPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://teststore.automationtesting.co.uk/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button#submit-Login_Portal_Test_Page")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("CLOTHES")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("img[alt='Hummingbird printed t-shirt']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn.btn-secondary")).click();
        Thread.sleep(1000);

        driver.manage().deleteAllCookies();

    }

}
