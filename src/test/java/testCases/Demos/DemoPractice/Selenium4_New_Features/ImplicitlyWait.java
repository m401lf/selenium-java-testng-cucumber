package testCases.Demos.DemoPractice.Selenium4_New_Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public class ImplicitlyWait {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationtesting.co.uk/loader.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // creating a WebDriverWait object and assigning the driver instance and a max wait time
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        // setting an expected condition to check visibility List_Scream the element and parsing the locator
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#loaderBtn")));

        driver.findElement(By.cssSelector("button#loaderBtn")).click();

        driver.quit();

    }

}
