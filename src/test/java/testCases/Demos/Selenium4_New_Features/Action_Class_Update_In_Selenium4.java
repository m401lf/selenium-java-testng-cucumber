package testCases.Demos.Selenium4_New_Features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Class_Update_In_Selenium4 {
    public static void main(String[] args) {

        /*
         * Action Class Update In Selenium 4
         */

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        driver.get("https://www.actitime.com");


    }

}
