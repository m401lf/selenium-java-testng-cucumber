package testCases.Demos.TestNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
@Test
public class add_An_Item{
        public static void Add_Item_ToCart(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/index.php?rt=product/category&path=43_46");

        List<WebElement> itemNames = driver.findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addToCartProduct = driver.findElements(By.cssSelector("a.productcart"));

        String itemsNeeded = "BODY CREAM BY BULGARI";

        for(int i = 0; i<itemNames.size(); i++)
        {
            String name = itemNames.get(i).getText();

            if(name.contains(itemsNeeded))
        {
            addToCartProduct.get(i).click();
            break;
        }

      }
    }

}
