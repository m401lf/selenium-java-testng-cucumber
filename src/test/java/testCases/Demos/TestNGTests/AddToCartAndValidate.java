package testCases.Demos.TestNGTests;

import base.BaseTest;
import org.testng.annotations.Test;

public class AddToCartAndValidate extends BaseTest {
    @Test
    public void ValidateAddToCart() throws InterruptedException {
        

        // Navigate to automationteststore.com
        driver.get("https://www.automationteststore.com");

//        // Find and click on the first product (assuming you want to add two different products)
//        WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"block_frame_featured_1769\"]/div/div[1]/div[2]/div[3]/a/i"));
//        firstProduct.click();
//
//        // Wait for the cart to update (you might need to adjust the wait time)
//        Thread.sleep(2000);  // This is just a simple pause, not recommended for production code
//
//        // Navigate back to the main page
//        driver.navigate().back();
//
//        // Find and click on the second product
//        WebElement secondProduct = driver.findElement(By.xpath("//*[@id=\"block_frame_featured_1769\"]/div/div[1]/div[2]/div[3]/a/i"));
//        secondProduct.click();
//
//        // Wait for the cart to update (you might need to adjust the wait time)
//        Thread.sleep(2000);  // This is just a simple pause, not recommended for production code
//
//        // Navigate to the shopping cart
//        driver.get("https://www.automationteststore.com/index.php?rt=checkout/cart");
//
//        // Validate the products in the cart
//        WebElement cartProduct1 = driver.findElement(By.xpath("//a[contains(text(), 'Product 1')]"));
//        WebElement cartProduct2 = driver.findElement(By.xpath("//a[contains(text(), 'Product 2')]"));
//
//        if (cartProduct1.isDisplayed() && cartProduct2.isDisplayed()) {
//            System.out.println("Both products are in the cart.");
//        } else {
//            System.out.println("One or both products are missing from the cart.");
//        }

        // Close the browser
        driver.quit();
    }

}
