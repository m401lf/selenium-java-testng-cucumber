package testCases.Demos.Selenium4_New_Features;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

////@Listeners(testComponents.Listeners.class)

/*

Selenium 4 - ChromeDriver and EdgeDriver classes now extend ChromiumDriver
    ChromiumDriver class has some pre-defined methods to access the dev tools.
    ChromeDriver and EdgeDriver classes now extend ChromiumDriver class
Earlier all the browsers used to extend RemoteWebDriver
*/

public class WebdriverManagerReplacement4_6_0 {
    public WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://localhost/opencartshop/index.php?route=account/login");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(description = "WebDriverWait")
    public void myWebDriverWaitMethod() {
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(emailAddress);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

    }

}