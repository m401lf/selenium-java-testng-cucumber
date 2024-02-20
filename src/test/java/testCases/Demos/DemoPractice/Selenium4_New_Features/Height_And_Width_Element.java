package testCases.Demos.DemoPractice.Selenium4_New_Features;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Height_And_Width_Element {
    public static void main(String[] args) {

        /*
         * Getting Height and Width of an Element
         *
         * 1. Using getSize (Dimension Class)
         * 2. Using getRect (Rectangle Class)
         */

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");

        WebElement login = driver.findElement(By.xpath("//button[@name='Login_Portal_Test_Page']"));

        Dimension d = login.getSize();

        System.out.println(d.getHeight());
        System.out.println(d.getWidth());

        Rectangle r = login.getRect();

        System.out.println(r.getHeight());
        System.out.println(r.getWidth());

        driver.quit();

    }

}
