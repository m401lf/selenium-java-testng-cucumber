package testCases.Demos.DemoPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWait_Enhanced_Loop {

    public static void main(String[] args) {
        WebDriver driver;

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.easyjet.com/en");

        WebElement ele = driver.findElement(By.cssSelector("button#ensRejectAll"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ele)).click();

        driver.findElement(By.id("ensCloseBanner")).click();



        driver.findElement(By.cssSelector("input[name='origin']")).click();
        driver.findElement(By.cssSelector("input[name='origin']")).sendKeys("London");

        List<WebElement> origins = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-1 li>a>span")));

        for (WebElement origin : origins) {
            if (origin.getText().contains("Luton")) {
                origin.click();
            }
        }

        driver.findElement(By.cssSelector("input[name='destination']")).click();
        driver.findElement(By.cssSelector("input[name='destination']")).sendKeys("a");

        List<WebElement> destinations = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-2 li>a>span")));

        for (WebElement destination : destinations) {
            if (destination.getText().contains("Antalya")) {
                destination.click();
            }
        }

    }

}
