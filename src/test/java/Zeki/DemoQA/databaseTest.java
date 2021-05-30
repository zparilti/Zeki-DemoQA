package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseTest {

    @Test
    public void dbTestone() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //Connection con = DriverManager.getConnection();



    }

}
