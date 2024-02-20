package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SpecialOffersPage extends BasePage {
    private final Logger log = LogManager.getLogger(SpecialOffersPage.class);
    WebDriver driver;

    public SpecialOffersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
