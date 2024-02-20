package testCases.Demos.Selenium4_New_Features;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

////@Listeners(testComponents.Listeners.class)

public class RelativeLocators {
    public WebDriver driver;

/*

  Selenium 4 - Relative Locators
  ==============================

  below - Login page of TutorialsNinja.com/demo
  toRightOf - Search button beside Search Text Field
  below and toLeftOf - Submit button (Get Text)
  toRightOf and toLeftOf - Login button (Get Text)
  below - compendium dev link
  below and above - compendium and theautomationtester
  near - Search button (Click)

  */


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        ops.addArguments("--ignore-certificate-errors");
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(description = "Relative locator using below()")
    public void relativeLocatorUsing_below() {

        driver.get("http://localhost/opencartshop/index.php?route=account/login");
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        email.sendKeys("admin@admin.com");
        password.sendKeys("Password");

        WebElement relativeLocatorBelow_loginButton = driver.findElement(RelativeLocator.with(By.tagName("input")).below(password));
        relativeLocatorBelow_loginButton.click();

    }

    @Test(description = "Relative locator using above()")
    public void relativeLocatorUsing_above() {
        driver.get("http://localhost/opencartshop/index.php?route=account/login");
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        WebElement password_relativeLocatorAbove = driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginButton));

        email.sendKeys(emailAddress);
        password_relativeLocatorAbove.sendKeys(pass);
        loginButton.click();

    }

    @Test(description = "Relative locator using toRightOf")
    public void relativeLocatorUsing_toRightOf() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://localhost/opencartshop/index.php?route=account/login");

        String keyword = "iMac";
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        WebElement searchButton_toRightOf = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(searchBox));
        searchBox.click();
        searchBox.sendKeys(keyword);
        searchButton_toRightOf.click();

    }

    @Test(description = "Relative locator using toLeftOf()")
    public void relativeLocatorUsing_toLeftOf() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://localhost/opencartshop/index.php?route=account/login");

        String keyword = "iMac";
        WebElement searchButton = driver.findElement(By.cssSelector("i.fa.fa-search"));
        WebElement searchBox_toLeftOf = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(searchButton));
        searchBox_toLeftOf.click();
        searchBox_toLeftOf.sendKeys(keyword);
        searchButton.click();

    }

    @Test(description = "Relative locator using WebDriverWait")
    public void relativeLocatorUsingWebDriverWait() {
        driver.get("http://localhost/opencartshop/index.php?route=account/login");
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