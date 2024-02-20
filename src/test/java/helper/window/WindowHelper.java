package helper.window;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHelper {

    private final WebDriver driver;
    private Logger log = LogManager.getLogger(WindowHelper.class);

    public WindowHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToParentWindow() {
        log.info("switching to parent window...");
        System.out.println("switching to parent window...");
        driver.switchTo().defaultContent();
    }

    public void switchToWindow(int index) {
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for (String window : windows) {
            if (i == index) {
                log.info("switched to : " + index + " window");
                System.out.println("switched to : " + index + " window");
                driver.switchTo().window(window);
            } else {
                i++;
            }
        }
    }

    public void closeAllTabsAndSwitchToMainWindow() {
        Set<String> windows = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();

        for (String window : windows) {
            if (!window.equalsIgnoreCase(mainWindow)) {
                driver.close();
            }
        }
        log.info("switched to main window");
        System.out.println("switched to main window");
        driver.switchTo().window(mainWindow);
    }

    public void navigateBack() {
        log.info("navigating back");
        System.out.println("navigating back");
        driver.navigate().back();
    }

    public void navigateForward() {
        log.info("navigating forward");
        System.out.println("navigating forward");
        driver.navigate().forward();
    }
}
