package testCases.Demos.DemoPractice.Selenium4_New_Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Minimizing_Browser_Window {

        public static void main(String[] args) throws Throwable {

            /*
             * Minimize the browser window
             *
             */

            WebDriver driver;
            WebDriverManager.chromedriver().setup();
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(ops);
            driver.manage().window().maximize();

            driver.get("https://www.amazon.com");

            driver.manage().window().minimize();

            Thread.sleep(1000);

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 12");

            Thread.sleep(1000);

            driver.findElement(By.id("nav-search-submit-button")).click();

        }

    }


