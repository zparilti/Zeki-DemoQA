package Zeki.DemoQA;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumOtherMethods {

    @Test
    public void newTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/"); // browser
        //System.out.println(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.navigate().to("https://www.abc.com");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.manage().window().fullscreen();
        driver.navigate().to("http://localhost/");

        Thread.sleep(2000);
        driver.navigate().to("http://localhost/next.htm");
        Thread.sleep(2000);
        driver.navigate().back();
        //driver.manage().timeouts();

        driver.get("");

        driver.close();

    }
}


//    WebDriver driver01 = new ChromeDriver();
//        driver01.get("https://www.abc.com/"); // browser
//                System.out.println(driver01.getWindowHandles());
//
//                //System.out.println(driver.getPageSource());
//                Thread.sleep(1000);
//                driver.manage().window().fullscreen();
//                Thread.sleep(1000);
//                System.out.println(driver.manage().window().getPosition());
//
//                // driver.quit(); // closes all windows and the browser
//                driver.close(); // closes the current tab or window