package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RecurringPaymentsPage extends BasePage {

    private final Logger log = LogManager.getLogger(RecurringPaymentsPage.class);
    WebDriver driver;

    public RecurringPaymentsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
