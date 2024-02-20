package testCases.Demos.Selenium4_New_Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.print.PrintOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

// //@Listeners(testComponents.Listeners.class)

public class PrintPDF {

    public static void main(String[] args) throws IOException {

        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

/*

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("..headless");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-extensions");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
*/

        driver.get("http://localhost/opencartshop");

        Pdf pdf = driver.print(new PrintOptions());  //work in only headless mode
        Files.write(Paths.get("./file_pdf/opencartshopIndexPage.pdf"),
                OutputType.BYTES.convertFromBase64Png(pdf.getContent()));

        driver.quit();
    }


}
