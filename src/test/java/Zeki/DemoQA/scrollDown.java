package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollDown {

    @Test
    public void scrollDown() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://omayo.blogspot.com/");

        JavascriptExecutor scrollpageDown = (JavascriptExecutor)driver;
        scrollpageDown.executeScript("window.scrollBy(300,500)");
        Thread.sleep(3000);
        scrollpageDown.executeScript("window.scrollBy(-300,-500)");

        WebElement loginButton = driver.findElement(By.xpath("//button[@value='LogIn']"));
        scrollpageDown.executeScript("arguments[0].scrollIntoView();", loginButton);


    }

    
}
