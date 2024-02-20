package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class CheckoutSuccessPage extends BasePage {
    WebDriver driver;
    Logger log = LogManager.getLogger(CheckoutSuccessPage.class);

    @FindBy(css = "div#content > h1")
    WebElement header;
    @FindBy(xpath = "//p[normalize-space()='Your order has been successfully processed!']")
    WebElement successMsg;
    @FindBy(css = "div#content > p:nth-of-type(5)")
    WebElement thanksMsg;
    @FindBy(css = "d.btn.btn-primary")
    WebElement continueBtn;

    public CheckoutSuccessPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean assertSuccessMsg() {
        return new VerificationHelper(driver).isDisplayed(successMsg);

    }

    public String getSuccessMsg() {
        return new VerificationHelper(driver).getText(successMsg);

    }

    public boolean assertThanksMsg() {
        return new VerificationHelper(driver).isDisplayed(thanksMsg);

    }

    public String getThanksMsg() {
        return new VerificationHelper(driver).getText(thanksMsg);

    }


    public IndexPage clickContinueBtn() throws IOException {
        continueBtn.click();
        return new IndexPage(driver);
    }

}
