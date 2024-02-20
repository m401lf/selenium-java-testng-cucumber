package testData.data;

public class datarepo {

    public final static String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";
    public final static String GECKO_DRIVER_DIRECTORY = System.getProperty("webdriver.gecko.driver",
            "C:/drivers/geckodriver.exe");
    public final static String CHROME_DRIVER_DIRECTORY =
            System.getProperty("user.dir") + "\\driver\\chromedriver,exe";
    public final static String HalfCHROME_DRIVER_DIRECTORY = System.setProperty(
            "webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
    public final static String BaseUrl = "https://tutorialsninja.com/demo/";
    public static final String BASE_URL = "https://tutorialsninja.com/demo/";
    public static final String LOGIN_URL = "https://tutorialsninja.com/demo/index.php?route=account/login";
    public static final String BASEURL = "https://tutorialsninja.com/demo/";

    public static final String LOGIN_TITLE = "Your Store";
    public static final String USER_DIRECTORY = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String DRIVERS_DIRECTORY = "//drivers//";
    public static final String LOCAL_DRIVERS_CHROME_DIRECTORY = "C:\\drivers\\chromedriver.exe";
    public static final String LOCAL_DRIVERS_FIREFOX_DIRECTORY = "C:\\drivers\\geckodriver.exe";
    public static final String LOCAL_DRIVERS_IE_DIRECTORY = "C:\\drivers\\IEDriverServer.exe";
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String IE = "ie";
    public static final String GECKO_DRIVER_KEY = "webdriver.gecko.driver";
    public static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    public static final String IE_DRIVER_KEY = "webdriver.ie.driver";
    public static final String GECKO_DRIVER_VALUE = "geckodriver";
    public static final String CHROME_DRIVER_VALUE = "chromedriver";
    public static final String IE_DRIVER_VALUE = "IEDriverServer";
    public static final String LOGINNAME = "datastudioplace";
    public static final String PASSWORD = "Manchester1";

    public static final String FIRSTNAME = "FirstName";
    public static final String LASTNAME = "LastName";
    public static final String EMAIL = "admin@admin.com";
    public static final String TELEPHONE = "2022034001";
    public static final String FAX = "2022034005";

    public static final int pollingEveryInMiliSecInterval = 250;
    public static final int FIVE_SECONDS = 5;
    public static final int FOUR_SECONDS = 4;
    public static final int THREE_SECONDS = 3;
    public static final int TWO_SECONDS = 2;
    public static final int SIX_SECONDS = 6;
    public static final int SEVEN_SECONDS = 7;
    public static final int EIGHT_SECONDS = 8;
    public static final int TEN_SECONDS = 10;
    public static final int FIFTEEN_SECONDS = 15;
    public static final int THIRTY_SECONDS = 30;
    public static final int SIXTY_SECONDS = 60;
    public static final int HUNDREDANDTWENTY_SECONDS = 120;
    public static final int TEN = 10;
    public static final String firstName = "Firstname";
    public static final String lastName = "Lastname";
    public static final String email = "admin001@admin.com";
    public static final String telephone = "07405000000";
    public static final String faxNumber = "07405000001";
    public static final String fax = "07405000002";
    public static final String companyName = "yourCompanyName";
    public static final String address1 = "yourAddress1";
    public static final String address2 = "yourAddress2";
    public static final String city = "yourCity";
    public static final String regionState = "Lancashire";
    public static final String regionStateByIndex = "3563";
    public static final String zipCode = "M1 7TG";
    public static final String country = "United Kingdom";
    public static final String password = "Password";
    public static final String confirmPassword = "Password";
    public static final String expectedURL = "https://tutorialsninja.com/demo/";
    public static final String expectedTitle = "Your Store";


    public static String getConfigPropertiesDirectory() {
        return CONFIG_PROPERTIES_DIRECTORY;

    }

    public static String getGeckoDriverDirectory() {
        return GECKO_DRIVER_DIRECTORY;

    }

    public static String getChromeDriverDirectory() {
        return CHROME_DRIVER_DIRECTORY;

    }

    public static String getHalfCHROME_DRIVER_DIRECTORY() {
        return HalfCHROME_DRIVER_DIRECTORY;

    }

    public static String getBaseUrl() {
        return BaseUrl;

    }

    public static String getLoginUrl() {
        return LOGIN_URL;

    }

    public static String getBASEURL() {
        return BASEURL;

    }

    public static String getBaseTitle() {
        return LOGIN_TITLE;

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

    public static String getLocalDriversChromeDirectory() {
        return LOCAL_DRIVERS_CHROME_DIRECTORY;

    }

    public static String getLocalDriversFirefoxDirectory() {
        return LOCAL_DRIVERS_FIREFOX_DIRECTORY;

    }

    public static String getLocalDriversIeDirectory() {
        return LOCAL_DRIVERS_IE_DIRECTORY;

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

    public static String getChromeDriverValue() {
        return CHROME_DRIVER_VALUE;

    }

    public static String getIeDriverValue() {
        return IE_DRIVER_VALUE;

    }

    public static String getLOGINNAME() {
        return LOGINNAME;

    }

    public static String getPASSWORD() {
        return PASSWORD;

    }

    public static String getFIRSTNAME() {
        return FIRSTNAME;

    }

    public static String getLASTNAME() {
        return LASTNAME;

    }

    public static String getEMAIL() {
        return EMAIL;

    }

    public static String getTELEPHONE() {
        return TELEPHONE;

    }

    public static String getFAX() {
        return FAX;

    }

    public static int getFiveSeconds() {
        return FIVE_SECONDS;

    }

    public static int getFourSeconds() {
        return FOUR_SECONDS;

    }

    public static int getThreeSeconds() {
        return THREE_SECONDS;

    }

    public static int getTwoSeconds() {
        return TWO_SECONDS;

    }

    public static int getPollingEveryInMiliSecInterval() {
        return pollingEveryInMiliSecInterval;

    }

    public static int getSixSeconds() {
        return SIX_SECONDS;

    }

    public static int getSevenSeconds() {
        return SEVEN_SECONDS;

    }

    public static int getEightSeconds() {
        return EIGHT_SECONDS;

    }

    public static int getTenSeconds() {
        return TEN_SECONDS;

    }

    public static int getFifteenSeconds() {
        return FIFTEEN_SECONDS;

    }

    public static int getThirtySeconds() {
        return THIRTY_SECONDS;

    }

    public static int getSixtySeconds() {
        return SIXTY_SECONDS;

    }

    public static int getHundredAndTwentySeconds() {
        return HUNDREDANDTWENTY_SECONDS;

    }

    public static int getTEN() {
        return TEN;

    }

    public static String getFirstName() {
        return firstName;

    }

    public static String getLastName() {
        return lastName;

    }

    public static String getEmail() {
        return email;

    }

    public static String getTelephone() {
        return telephone;

    }

    public static String getFaxNumber() {
        return faxNumber;

    }

    public static String getFax() {
        return fax;

    }

    public static String getCompanyName() {
        return companyName;

    }

    public static String getAddress1() {
        return address1;

    }

    public static String getAddress2() {
        return address2;

    }

    public static String getCity() {
        return city;

    }

    public static String getRegionState() {
        return regionState;

    }

    public static String getZipCode() {
        return zipCode;

    }

    public static String getCountry() {
        return country;

    }

    public static String getPassword() {
        return password;

    }

    public static String getConfirmPassword() {
        return confirmPassword;

    }

    public static String getExpectedURL() {
        return expectedURL;

    }

    public static String getExpectedTitle() {
        return expectedTitle;

    }


}
