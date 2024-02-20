package testCases.Demos.TestNGTests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FacebookLoginTest extends BaseTest {

    public FacebookLoginTest() {
        super();
    }

    @Test
    public void fbTest() {

        // Navigate to Facebook
        driver.get("https://www.facebook.com");

        WebElement declineOptionalCookies =  driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[4]/button[1]"));
        declineOptionalCookies.click();

        // Locate the email/phone input field and enter your login credentials
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("azetabenjamin@yahoo.com");

        // Locate the password input field and enter your password
        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys("Money_2017");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        // Wait for the login to complete (you might need to adjust the wait time)
        //wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/"));

        // Verify that you are logged in successfully
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.facebook.com/")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }

        // Close the browser
        driver.quit();
    }
}







