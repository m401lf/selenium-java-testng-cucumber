package testCases.Demos.SeleniumBasicCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Video_37_selectByVisibleTextCommand {

    @Test(enabled = true)
    public void f1() throws Exception {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/");

        // The purpose selectByIndex() command is used to select an element from dropDown and MultiSelect webElement from the webPage
        WebElement dropdown = driver.findElement(By.id("drop1"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);

        Thread.sleep(1000);

        //MultiSelect Example
        WebElement multiSelect = driver.findElement(By.id("multiselect1"));
        Select select2 = new Select(multiSelect);
        select2.selectByIndex(3);


        Thread.sleep(2000);
        driver.quit();

    }

}
