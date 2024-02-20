package pages;


import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShippingReturnsPage extends BasePage {

    private final Logger log = LogManager.getLogger(ShippingReturnsPage.class);
    WebDriver driver;
    private WebElement shippingReturnsHeadingTxt;

    public ShippingReturnsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getShippingReturnsHeadingTxt() {
        return new VerificationHelper(driver).getText(shippingReturnsHeadingTxt);

    }

}
