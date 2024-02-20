package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    WebDriver driver;
    Logger log = LogManager.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='content']/div[3]//img")
    List<WebElement> searchProducts;
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement txtquantity;
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnaddToCart;
    @FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
    WebElement cnfMsg;
    @FindBy(linkText = "HP LP3065")
    private WebElement validHPProduct;
    @FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
    private WebElement noProductMessage;


    public boolean isProductExist(String productName) {
        boolean flag = false;
        for (WebElement product : searchProducts) {
            if (product.getAttribute("title").equals(productName)) {
                flag = true;
                break;
            }
        }

        return flag;

    }

    public void selectProduct(String productName) {
        for (WebElement product : searchProducts) {
            if (product.getAttribute("title").equals(productName)) {
                product.click();
            }
        }

    }

    public void setQuantity(String qty) {
        txtquantity.clear();
        txtquantity.sendKeys(qty);

    }

    public void addToCart() {
        btnaddToCart.click();

    }

    public boolean checkConfMsg() {
        try {
            return cnfMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String retrieveNoProductMessageText() {
        return noProductMessage.getText();

    }

    public boolean displayStatusOfHPValidProduct() {
        return validHPProduct.isDisplayed();

    }




}
