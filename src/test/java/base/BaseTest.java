package base;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.logger.LoggerHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.IndexPage;
import utilities.utils.GlobalVars;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class BaseTest {
    public static File reportDirectery;
    public Logger log = LoggerHelper.getLogger(BaseTest.class);
    public WebDriver driver;
    public IndexPage indexPage;
    public Properties prop;

    public Properties dataProp;
    Status status;

    public WebDriver initializeDriver() throws IOException {
        // properties class
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir")+ "//src//test//java//testData//GlobalData.properties");


        dataProp = new Properties();
        File dataPropFile = new File(System.getProperty("user.dir")+ "//src//test//java//testData//testData.properties");

        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        }catch(Throwable e) {
            e.printStackTrace();
        }

        try {
            FileInputStream dataFis = new FileInputStream(dataPropFile);
            dataProp.load(dataFis);
        }catch(Throwable e) {
            e.printStackTrace();
        }


        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        if (browserName.contains("chrome")) {
            driver = new ChromeDriver();

            // Firefox
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--whitelisted-ips");
            driver = new FirefoxDriver(options);

        } else if (browserName.equalsIgnoreCase("edge")) {
            // Edge
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.implicitWait));
        driver.manage().window().maximize();
        return driver;

    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        //String to HashMap- Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<>() {
        });

    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//extentReports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//extentReports//" + testCaseName + ".png";
    }

    @BeforeMethod(alwaysRun = true)
    public IndexPage launchApplication() throws IOException {
        driver = initializeDriver();
        indexPage = new IndexPage(driver);
        indexPage.goTo();
        return indexPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }

    public void getApplicationUrl(String url) {
        driver.get(url);
        log.info("navigating to ..." + url);
    }

    public String captureScreen(String fileName) {
        if (driver == null) {
            log.info("driver is null..");
            return null;
        }
        if (Objects.equals(fileName, "")) {
            fileName = "blank";
        }
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File screFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            destFile = new File(reportDirectery + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
            Files.copy(screFile.toPath(), destFile.toPath());
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "'height='100' width='100'/></a>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destFile.toString();
    }

    public String randomString() {
        return (RandomStringUtils.randomAlphabetic(5));

    }

    public String randomNumber() {
        return (RandomStringUtils.randomNumeric(10));

    }

    public String randomEmail() {
        return (RandomStringUtils.randomNumeric(10)) +"@gmail.com";

    }

    public String randomAlphaNumeric() {
        String st = RandomStringUtils.randomAlphabetic(4);
        String num = RandomStringUtils.randomNumeric(3);
        return (st + "@" + num);
    }
}
