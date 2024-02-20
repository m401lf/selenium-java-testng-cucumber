package testCases.Demos.DemoPractice;

import java.io.File;

import java.io.IOException;

import java.time.Duration;
import java.util.HashMap;



import org.testng.Assert;

import org.testng.annotations.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class fileUpload {



    public static void main(String[] args) throws InterruptedException, IOException {

// TODO Auto-generated method stub

        String downloadPath=System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

        chromePrefs.put("profile.default_content_settings.popups", 0);

        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options=new ChromeOptions();

        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver=new ChromeDriver(options);

        driver.get("https://altoconvertpdftojpg.com/");

        driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

        Thread.sleep(3000);

        Runtime.getRuntime().exec("C:\\Users\\rahul\\Documents\\check\\fileupload.exe");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));

        driver.findElement(By.cssSelector("button[class*='medium']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));

        driver.findElement(By.linkText("Download Now")).click();

        Thread.sleep(5000);

        File f=new File(downloadPath+"/converted.zip");

        if(f.exists())

        {

            Assert.assertTrue(f.exists());

            if(f.delete())

                System.out.println("file deleted");

        }

    }



}


