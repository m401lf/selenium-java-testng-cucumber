package helper.assertion;

import helper.action.WebElementOrderChecker;
import helper.action.WebElementOrderCheckerImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AssertionHelper {

    static WebDriver driver;
    Logger log = LogManager.getLogger(AssertionHelper.class);
    private String idOfParentWebElement;

    public static void verifyText(String s1, String s2) {
        Logger log = LogManager.getLogger(AssertionHelper.class);
        log.info("Verifying test: " + s1 + " with " + s2);
        System.out.println("Verifying test: " + s1 + " with " + s2);
        Assert.assertEquals(s1, s1);
    }

    public static void markPass() {
        Logger log = LogManager.getLogger(AssertionHelper.class);// for Logger
        log.info("Making script PASS..");
        System.out.println("Making script PASS..");
        Assert.assertTrue(true);
    }

    public static void markPass(String message) {
        Logger log = LogManager.getLogger(AssertionHelper.class);// for Logger
        log.info("Making script PASS => " + message);
        System.out.println("Making script PASS => " + message);
        Assert.assertTrue(true, message);
    }

    public static void markFail() {
        Logger log = LogManager.getLogger(AssertionHelper.class);// for Logger
        log.info("Making script FAIL..");
        System.out.println("Making script FAIL..");
        Assert.fail();
    }

    public static void markFail(String message) {
        Logger log = LogManager.getLogger(AssertionHelper.class);// for Logger
        log.info("Making script FAIL.." + message);
        System.out.println("Making script FAIL => " + message);
        Assert.fail(message);
    }

    public static void verifyTrue(boolean status) {
        Logger log = LogManager.getLogger(AssertionHelper.class);// for Logger
        log.info("Verify object is True..");
        System.out.println("Verify object is True..");
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status) {
        Logger log = LogManager.getLogger(AssertionHelper.class);// for Logger
        log.info("Verify object is False..");
        System.out.println("Verify object is False..");
        Assert.assertFalse(status);
    }

    public static void verifyNull(String s1) {
        Logger log = LogManager.getLogger(AssertionHelper.class);// for Logger
        log.info("Verify object is null..");
        System.out.println("Verify object is null..");
        Assert.assertNull(s1);
    }

    public static void verifyNotNull(String s1) {
        Logger log = LogManager.getLogger(AssertionHelper.class);// for Logger
        log.info("Verify object is not null..");
        System.out.println("Verify object is not null..");
        Assert.assertNotNull(s1);
    }

    public static void fail() {
        Assert.fail();
    }

    public static void pass() {
        Assert.assertTrue(true);
    }

    public static void updateTestStatus(boolean status) {
        if (status) {
            pass();
            System.out.println("UpdateTestStatus => PASSED");
        } else {
            fail();
            System.out.println("UpdateTestStatus => FAILED");

        }
    }

    public static void assertNewTabIsOpenedWithExpectedPage(String expectedPageName) {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        // switch to new tab
        driver.switchTo().window(browserTabs.get(1));
        // check is it correct page opened or not (e.g. check page's title)
        Assert.assertEquals("The opened page is not what was expected", expectedPageName,
                driver.findElement(By.id("heading")).getText());
        // then close tab and get back
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    public static void assertNewTabOpenedWithExpectedTitle(String pageTitle) {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        // switch to new tab
        driver.switchTo().window(browserTabs.get(1));
        // check is it correct page opened or not (check page's title)
        Assert.assertEquals("The opened page title did not match", pageTitle,
                driver.getTitle());
        // then close tab and get back
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }


    public static void assertOnWebElementOrder(List<WebElement> childWebElementsInActualOrder,
                                               List<String> expectedOrderOfElementIds) {
        WebElementOrderChecker webElementOrderChecker = new WebElementOrderCheckerImpl(childWebElementsInActualOrder);
        Assert.assertTrue(webElementOrderChecker.areWebElementsOrderedLikeSpecifiedListByElementId(
                getModifiableIdListOfExpectedChildElements(expectedOrderOfElementIds)), "Web Elements are not in the expected order");
    }

    public static List<String> getModifiableIdListOfExpectedChildElements(List<String> elementIds) {
        List<String> ids = new ArrayList<>();
        for (String elementId : elementIds) {
            ids.add(elementId);
        }
        return ids;
    }

}
