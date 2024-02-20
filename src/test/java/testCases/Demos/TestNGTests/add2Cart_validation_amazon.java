package testCases.Demos.TestNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class add2Cart_validation_amazon {

    public WebDriver driver;


    @Test
    public static void login_positive() throws InterruptedException {
        WebDriver driver;

        driver = new ChromeDriver();
        driver.get("https://www.amazon.co.uk/");
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[4]"));
        products.stream()
                .parallel()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .forEach(s-> System.out.println());

    }

}
