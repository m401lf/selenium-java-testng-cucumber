package testCases.Demos.DemoPractice.Selenium4_New_Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
public class Relative_Locators {
    public static void main(String[] args) throws Throwable {

        /*
         * Relative Locators:Finding WebElements with Reference to other WebElement
         *
         * above()
         * below()
         * near()
         * toLeftOf()
         * toRightOf()
         *
         * Usage:
         *
         * Validating element positions with respect to other elements on web page
         * Effectively locate the web elements with positional access which otherwise are not found easily by traditional ways
         * Locating elements with common description uniquely
         *
         * Note: Need to import static org.openqa.selenium.support.locators.RelativeLocator.with;
         */

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.goodreads.com/");

        Thread.sleep(2000);

        WebElement amazonBtn = driver.findElement(By.cssSelector("a.gr-button--amazon"));

        try {
            driver.findElement(with(By.cssSelector("a.gr-button--facebook")).above(amazonBtn));
            System.out.println("Pass: FB button is above amazon button");
        } catch (Exception e) {
            System.out.println("Fail: FB button is NOT above amazon button");
            e.printStackTrace();
        }

        try {
            driver.findElement(with(By.cssSelector("a.gr-button--apple")).below(amazonBtn));
            System.out.println("Pass: Apple button is below amazon button");
        } catch (Exception e) {
            System.out.println("Fail: Apple button is NOT below amazon button");
            e.printStackTrace();
        }

        driver.quit();



    }
}