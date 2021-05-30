package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class singleinputField {

    // option instead of main method
    @Test // testng annotation are taken here

    public void newMethod() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver myDriver = new ChromeDriver();
        myDriver.get("https://www.seleniumeasy.com/test/");
        Thread.sleep(5000);

        myDriver.findElement(By.xpath("//a[text()='No, thanks!']")).click();
        WebElement myInputForms = myDriver.findElement(By.xpath("//*[text()='Input Forms']"));
        myInputForms.click();

        WebElement mySimpleForm = myDriver.findElement(By.xpath("(//*[text()='Simple Form Demo'])[2]"));
        mySimpleForm.click();

        WebElement myPlaceHolder = myDriver.findElement(By.xpath("//input[@placeholder='Please enter your Message']"));
        String str = "My"; String str1 = " Message";
        myPlaceHolder.sendKeys(str);
        Thread.sleep(5000);
        myPlaceHolder.sendKeys(str1);

        WebElement myShowMessageButton = myDriver.findElement(By.xpath("//button[@type='button'][@onclick='showInput();']"));
        myShowMessageButton.click();

        WebElement myDisplay = myDriver.findElement(By.cssSelector("#display"));
        String actual = myDisplay.getText();
        System.out.println(actual);
        Assert.assertEquals(actual,str);

    }

}
