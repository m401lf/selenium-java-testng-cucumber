package helper.assertion;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VerificationHelper {

    Logger log = LogManager.getLogger(VerificationHelper.class);
    WebDriver driver;

    public VerificationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            //log.info("Element is Displayed: " + element);
            return true;
        } catch (Exception e) {
            log.info("Element is not Displayed..");
            return false;
        }
    }

    public boolean isSelected(WebElement element) {
        try {
            element.isSelected();
            //log.info("The element is Selected :: " + "<<" + element + ">>");
            System.out.println("The element is Selected");
            return true;
        } catch (Exception e) {
            System.out.println("Element is not Selected.... ");
            log.error("Element is not Selected: ", e.getCause());
            return false;
        }
    }

    public boolean assertElementEnabledAndDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            element.isEnabled();
            log.info("Element is enabled :: " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("Element is not enabled..", e.getCause());
            log.error("Element is not Displayed..", e.getCause());
            return false;
        }
    }

    public boolean isEnabled(WebElement element) {
        try {
            element.isEnabled();
            //System.out.println("Element is enabled :: " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("Element is not enabled..", e.getCause());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            //log.info("element is present.." + element.getText());
            return false;
        } catch (Exception e) {
            log.error("Element is not present..");
            return true;
        }
    }

    public String readValueFromElement(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("Element text is .." + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            //log.info("Element text is displayed:: " + element);
            return element.getText();
        } else {
            return null;
        }
    }

    public String getTitle() {
        //log.info("BasePage title is: " + driver.getTitle());
        return driver.getTitle();
    }

    public String getCurrentPageTitle() {
        //log.info("BasePage title is: " + driver.getTitle());
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        //log.info("BasePage Url is: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String getCurrentPageUrl() {
        //log.info("BasePage Url is: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

}
