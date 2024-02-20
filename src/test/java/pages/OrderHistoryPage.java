package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OrderHistoryPage extends BasePage {

    private final Logger log = LogManager.getLogger(OrderHistoryPage.class);
    WebDriver driver;

    public OrderHistoryPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
