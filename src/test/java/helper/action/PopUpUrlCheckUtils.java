package helper.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Set;

public class PopUpUrlCheckUtils {

    static WebDriver driver;

    public void checkByClickingOnTheLinkTakesToExpectedUrl(WebElement linkName, String expectedUrl) {
        linkName.click();
        String parentWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }
        Assert.assertEquals("Link url is not matching", expectedUrl, driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}