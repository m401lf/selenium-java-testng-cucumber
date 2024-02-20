package testCases.Demos.SeleniumBasicCommands;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Video_75_addCookieCommand {

    @Test(enabled = true)
    public void f1() throws Exception {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.tutorialsninja.com/demo/");

        //addCookie() command to add the own cookie in the browser apart from defualt cookies
        Cookie cookie = new Cookie("Name", "Arun");

        driver.manage().addCookie(cookie);


        Thread.sleep(2000);
        //driver.quit();

    }

}
