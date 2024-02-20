package testCases.Demos.databaseTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.*;

public class jdbcconection {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String host = "localhost";

        String port = "3307";

        Connection con =
                DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":" + port + "/whiztrial", "root", "");

        Statement s = con.createStatement();

        ResultSet rs = s.executeQuery("select * from userprofile where last_name = 'Lastname'");
        while (rs.next()) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();

            driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
            driver.findElement(By.id("input-email")).sendKeys(rs.getString("email"));
            System.out.println(" :: " + rs.getString("email"));
            driver.findElement(By.id("input-password")).sendKeys(rs.getString("password"));
            System.out.println(" :: " + rs.getString("password"));
            driver.findElement(By.cssSelector("input[value='Login']")).click();
            driver.quit();
        }
    }
}