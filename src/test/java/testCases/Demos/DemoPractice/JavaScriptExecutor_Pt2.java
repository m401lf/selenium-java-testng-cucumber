package testCases.Demos.DemoPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor_Pt2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*Use button page to highlight a button:
        document.getElementById('btn_one');

        Use accordion page to return all accordion headers by class:
        document.getElementsByClassName('accordion-header');

        Use Calculator(JS) page to return all input tags:
        document.getElementsByTagName('input');

        On the accordion page, change the text List_Scream the h2 element:
        document.querySelector("#content").innerHTML = "Hello World!";*/

        driver.get("https://automationtesting.co.uk/contactForm.html");

        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("James");
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Smith");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("james@test.com");
        driver.findElement(By.cssSelector("textarea")).sendKeys("this is a sample comment");

        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        WebElement reset = driver.findElement(By.cssSelector("[type='reset']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click(), arguments[1].click()", reset, submit);

    }

}

