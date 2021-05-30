package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class buttonsWebelement {

    @Test
    public void bettonElement() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().fullscreen();
        Actions a =new Actions(driver);

        // How to double click on a button
        WebElement doubleClick = driver.findElement(By.cssSelector("#doubleClickBtn"));
        a.doubleClick(doubleClick).perform();
        String doubleClickString = driver.findElement(By.cssSelector("#doubleClickMessage")).getText();
        System.out.println(doubleClickString);
        Assert.assertTrue(doubleClickString.contains("double"));
        Thread.sleep(2000);

        // How to right click on a button
        WebElement rightClick = driver.findElement(By.cssSelector("#rightClickBtn"));
        a.contextClick(rightClick).perform();
        String rightClickString = driver.findElement(By.cssSelector("#rightClickMessage")).getText();
        System.out.println(rightClickString);
        Assert.assertTrue(rightClickString.contains("right"));
        Thread.sleep(2000);

        // How to click on a DYNAMIC button
        // Since the id of the button was dynamic, we cannot locate the button by using css or xpath directly
        // Therefore we used parent-child relations
        //WebElement oesaq = driver.findElement(By.cssSelector("#0esaq"));
        //WebElement oesaq = driver.findElement(By.xpath("//button[@id='0esaq']"));
        WebElement oesaq = driver.findElement(By.xpath("//div[@class='mt-4'][2]/button"));
        oesaq.click();
        //a.click(oesaq).perform();
        String dynamicClickString = driver.findElement(By.cssSelector("#dynamicClickMessage")).getText();
        System.out.println(dynamicClickString);
        Assert.assertTrue(dynamicClickString.contains("dynamic"));
        Thread.sleep(2000);
        
    }

}
