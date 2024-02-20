package testData;

public class datastore {

    /**
     * Config Properties file
     **/
    public final static String CONFIG_PROPERTIES_DIRECTORY = "testng.properties\\testng.config.testng.properties";

    public final static String GECKO_DRIVER_PATH = "/src/main/java/resources/drivers/geckodriver.exe";

    public final static String CONFIG_PROPERTIES_DIR = System.getProperty("user.dir") + "src\\main\\java\\properties\\config.properties";

    public final static String CHROME_DRIVER_PATH = "/src/main/java/resources/drivers/chromedriver.exe";

    public final static String IE_DRIVER_DIRECTORY = System.getProperty("user.dir") + "src\\main\\java\\resources\\drivers\\IEDriverServer.exe";

    /**
     * Config Properties file
     **/

    public final static String HOME_URL = "https://automationteststore.com/";
    public final static String LOGIN_URL = "https://automationteststore.com/index.php?rt=account/login";
    public static final String BASE_URL = "https://automationteststore.com/";
    public static final String USER_DIRECTORY = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String DRIVERS_DIRECTORY = "//drivers//";
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String IE = "ie";
    public static final String GECKO_DRIVER_KEY = "webdriver.gecko.driver";
    public static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    public static final String IE_DRIVER_KEY = "webdriver.ie.driver";
    public static final String GECKO_DRIVER_VALUE = "geckodriver";
    public static final String CHROME_DRIVER_VALUE = "chromedriver";
    public static final String IE_DRIVER_VALUE = "IEDriverServer";
    public static final String DEFAULT_USERNAME = "test@email.com";
    public static final String DEFAULT_PASSWORD = "abcabc";

    public static String getConfigPropertiesDirectory() {
        return CONFIG_PROPERTIES_DIRECTORY;
    }

    public static String getGeckoDriverPath() {
        return GECKO_DRIVER_PATH;
    }

    public static String getChromeDriverPath() {
        return CHROME_DRIVER_PATH;
    }

    public static String getIeDriverDirectory() {
        return IE_DRIVER_DIRECTORY;
    }

    public static String getHomeUrl() {
        return HOME_URL;
    }

    public static String getLoginUrl() {
        return LOGIN_URL;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getUserDirectory() {
        return USER_DIRECTORY;
    }

    public static String getOsName() {
        return OS_NAME;
    }

    public static String getDriversDirectory() {
        return DRIVERS_DIRECTORY;
    }

    public static String getFIREFOX() {
        return FIREFOX;
    }

    public static String getCHROME() {
        return CHROME;
    }

    public static String getIE() {
        return IE;
    }

    public static String getGeckoDriverKey() {
        return GECKO_DRIVER_KEY;
    }

    public static String getChromeDriverKey() {
        return CHROME_DRIVER_KEY;
    }

    public static String getIeDriverKey() {
        return IE_DRIVER_KEY;
    }

    public static String getGeckoDriverValue() {
        return GECKO_DRIVER_VALUE;
    }

    public static String getConfigPropertiesDir() {
        return CONFIG_PROPERTIES_DIR;
    }

    public static String getChromeDriverValue() {
        return CHROME_DRIVER_VALUE;
    }

    public static String getIeDriverValue() {
        return IE_DRIVER_VALUE;
    }

    public static String getDefaultUsername() {
        return DEFAULT_USERNAME;
    }

    public static String getDefaultPassword() {
        return DEFAULT_PASSWORD;
    }
}
