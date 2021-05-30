package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class interactionsWeb {
    WebDriver driver;
    Actions a;

    // This is executed before each test @BeforeMethod is used for this purpose
    @BeforeMethod
    public void beforeMeth() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        a = new Actions(driver);
    }

    @AfterMethod
    public void afterMeth(){
        driver.quit();
    }

    @Test
    public void testDraggable() throws InterruptedException {
       driver.get("https://demoqa.com/droppable");
       WebElement elementDraggable =  driver.findElement(By.xpath("//div[@id='draggable']"));
       WebElement elementDropable =  driver.findElement(By.xpath("//div[@id='droppable']"));

       a.dragAndDrop(elementDraggable,elementDropable).perform(); //
        Thread.sleep(2000);
       //a.clickAndHold(elementDraggable).moveToElement(elementDropable).release().perform();

    }

}
