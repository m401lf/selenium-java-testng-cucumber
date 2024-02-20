package testCases.Demos.SeleniumBasicCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Video_76_deleteCookieNamedCommand {

    @Test(enabled = true)
    public void f1() throws Exception {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.tutorialsninja.com/demo/");

        //deleteCookieNamed() command to delete a particular cookie details
        driver.manage().deleteCookieNamed("OCSESSID");

        Thread.sleep(2000);
        //driver.quit();

    }

}
