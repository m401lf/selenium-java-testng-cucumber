package testCases.Demos.DemoPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor_Pt1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk");

        /*Use button page to highlight a button:
        document.getElementById('btn_one');

        Use accordion page to return all accordion headers by class:
        document.getElementsByClassName('accordion-header');

        Use Calculator(JS) page to return all input tags:
        document.getElementsByTagName('input');

        On the accordion page, change the text List_Scream the h2 element:
        document.querySelector("#content").innerHTML = "Hello World!";*/

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
    }

}
