package testCases.Demos.DemoPractice.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingByXpath_Contains {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk");

        driver.findElement(By.linkText("ACTIONS")).click();

        String data = "ACTIONS";

        driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();

    }

}

