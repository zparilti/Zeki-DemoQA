package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class waitsTesting {

    @Test
    public void waitsTestiing() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/dynamic-properties");

        // an example for implicit wait
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
        WebElement seeyouLater = driver.findElement(By.xpath("//button[@id='visibleAfter']"));

        // an example for explicit wait
        //1WebElement timedenabledButton = driver.findElement(By.xpath("//button[@id='enableAfter']"));
        //1Boolean buttonstatus = timedenabledButton.isEnabled();
        //1System.out.println("buttonstatus = " + buttonstatus);
        //1timedenabledButton.click(); // tried to click here
        //WebDriverWait waitforMe = new WebDriverWait(driver,10);
        WebDriverWait waitforYou = new WebDriverWait(driver,10);
        //1waitforYou.until(ExpectedConditions.elementToBeClickable(timedenabledButton));

        waitforYou.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
        seeyouLater = driver.findElement(By.xpath("//button[@id='visibleAfter']"));
        Boolean visibleNot = seeyouLater.isDisplayed();
        System.out.println("visibleNot = " + visibleNot);

        //


    }

}
