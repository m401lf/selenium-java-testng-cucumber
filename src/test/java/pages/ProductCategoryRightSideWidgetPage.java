package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryRightSideWidgetPage extends BasePage {
    private final Logger log = LogManager.getLogger(ProductCategoryRightSideWidgetPage.class);
    WebDriver driver;

    public ProductCategoryRightSideWidgetPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
