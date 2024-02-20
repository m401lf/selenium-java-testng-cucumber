package testCases.Demos.TestNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class add_Multiple_Items{
    public WebDriver driver;
    @Test
    public void add_multiple_products() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/index.php?rt=product/category&path=43_46");

        List<WebElement> itemNames = driver.findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addToCartProduct = driver.findElements(By.cssSelector("a.productcart"));

        String[] itemsNeeded = {"BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML","JASMIN NOIR BODY LOTION 6.8 FL OZ"};

        for(int i = 0; i<itemNames.size(); i++)
        {
            String name = itemNames.get(i).getText();
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(name))
        {
            addToCartProduct.get(i).click();
        }

      }


    }

}
