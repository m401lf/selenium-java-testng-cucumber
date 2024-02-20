package helper.action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollPage {

    static WebDriver driver;

    public static void scrollToView(WebElement elementName) throws Exception {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementName);
        Thread.sleep(500);
    }

    public static void scrollToViewSaveAndContinue(WebDriver driver) {
        try {
            scrollToView(driver.findElement(By.id("save_continue")));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void scrollToViewContinue(WebDriver driver) {
        try {
            scrollToView(driver.findElement(By.id("continue")));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void scrollToViewElement(WebDriver driver, String elementID) {
        try {
            scrollToView(driver.findElement(By.id(elementID)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void scrollToBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

}
