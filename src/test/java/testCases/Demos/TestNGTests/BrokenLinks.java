package testCases.Demos.TestNGTests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class BrokenLinks extends BaseTest {

    @Test
    public void brokenLinksTest() throws InterruptedException, IOException {
        /*System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
        //broken URL
        //Step 1 - IS to get all urls tied up to the links using Selenium
        //  Java methods will call URL's and gets you the status code
        //if status code >400 then that url is not working-> link which tied to url is broken
        //a[href*="soapui"]'
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            a.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode);
        }
        a.assertAll();

    }

    private static Object getReturnCode(WebElement link) {
        return null;
    }

    public static class AddMultipleItemsToCart extends BaseTest {

        @Test
        public void addMultipleItemsToCartTest() throws InterruptedException {

           /* System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
            WebDriver driver = new ChromeDriver();*/

            String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

            driver.get("https://rahulshettyacademy.com/seleniumPractise/");
            Thread.sleep(3000);

            addItems(driver, itemsNeeded);

        }

        public static void addItems(WebDriver driver, String[] itemsNeeded) {

            int j = 0;

            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
            for (int i = 0; i < products.size(); i++) {
                //Brocolli - 1 Kg
                String[] name = products.get(i).getText().split("-");
                String formattedName = name[0].trim();
                //format it to get actual vegetable name
                //convert array into array list for easy search
                //  check whether name you extracted is present in arrayList or not-
                List itemsNeededList = Arrays.asList(itemsNeeded);
                if (itemsNeededList.contains(formattedName)) {
                    j++;
                    //click on Add to cart
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    if (j == itemsNeeded.length) {
                        break;

                    }

                }

            }

        }


    }
}