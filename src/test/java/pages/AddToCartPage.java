package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AddToCartPage extends BasePage {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AddToCartPage.class);

    public AddToCartPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id='quickSearch']/div/section/ul/li[2]")
    public WebElement addToCartByIndex;

    @FindBy(id="quantity_wanted")
    private WebElement quantity;

    @FindBy(name="group_1")
    private WebElement size;

    @FindBy(xpath="//span[text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath="//*[@id='layer_cart']//h2/i")
    private WebElement addToCartMessage;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public void enterQuantity(String quantity1) throws Throwable {
        waitAndSendKeys(quantity, quantity1);
    }
    public void clickOnAddToCart() throws Throwable {
        waitAndClick(addToCartBtn);
    }
    public String getAddToCart() throws Throwable {
        waitForElement(addToCartMessage, 3);
        return new VerificationHelper(driver).getText(addToCartMessage);
    }
    public OrderConfirmationPage clickOnCheckOut() throws Throwable {
        waitAndClick(proceedToCheckOutBtn);
        return new OrderConfirmationPage(driver);
    }
    public void ClickOnAddToCartByIndex() {
        JSClick(driver,addToCartByIndex);
    }

}
