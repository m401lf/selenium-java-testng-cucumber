package testCases.Demos.click_sendKeys_Methods;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.utils.GlobalVars;

import java.time.Duration;

////@Listeners(testComponents.Listeners.class)

public class Click_SendKey_MethodsWithLoginTest {
    public WebDriver driver;
    Logger log = LogManager.getLogger(LoginPage.class);

    @BeforeMethod
    public void setup() {
        ChromeOptions ops = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        /*WebDriverManager.chromedriver().setup();
        ops.addArguments("--disable-dev-shm-usage");
        ops.addArguments("--no-sandbox");
        ops.addArguments("--disable-extensions");
        ops.addArguments("--start-maximized");
        ops.addArguments("--disable-gpu");
        ops.addArguments("--whitelisted-ips");
        ops.addArguments("--ignore-certificate-errors");
        //ops.addArguments("--headless");
        ops.addArguments("--test-type");
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.getImplicitWait()));
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/account");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(description = "Login test with click() method")
    public void loginTestUsingClick() {
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        email.sendKeys("admin@admin.com");
        password.sendKeys("Password");
        loginButton.submit();

    }

    @Test(description = "Login test with Actions class method")
    public void loginTestUsingActionsClass() {
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        Actions action = new Actions(driver);
        action.moveToElement(email).sendKeys(emailAddress).build().perform();
        action.moveToElement(email).sendKeys(pass).build().perform();
        action.moveToElement(email).click().build().perform();

    }

    @Test(description = "Login test using JavascriptExecutor method")
    public void loginTestUsingJavascriptExecutor() {
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        email.sendKeys("admin@admin.com");
        password.sendKeys("Password");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButton);

    }

    @Test(description = "Login test using mouse action: sendKeys(Keys.RETURN)")
    public void loginTestUsingMoseAction() {
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        Actions action = new Actions(driver);
        action.moveToElement(email).sendKeys(emailAddress).build().perform();
        action.moveToElement(password).sendKeys(pass).build().perform();
        loginButton.sendKeys(Keys.RETURN);

    }

    @Test(description = "Login test using WebDriverWait")
    public void loginTestUsingWebDriverWait() {
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

    @Test(description = "Testing browser")
    public void BrowserTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        //driver.quit();
    }

}