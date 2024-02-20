package testCases.Demos.DemoPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeOptions {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        org.openqa.selenium.chrome.ChromeOptions ops = new org.openqa.selenium.chrome.ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk");

    }

}

