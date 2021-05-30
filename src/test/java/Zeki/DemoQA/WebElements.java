package Zeki.DemoQA;
// Webelements will be used here
// Reference to Excel File - Locators(XPath): Row10: Attribute&Value and Row 16: Index

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElements {

    @Test

    public void ElementsWeb() {

        WebDriverManager.chromedriver().setup();
        WebDriver mynewdriver = new ChromeDriver();
        mynewdriver.get("https://demoqa.com/elements");
        mynewdriver.manage().window().fullscreen();

        // Locating by XPath

        WebElement textBox01 = mynewdriver.findElement(By.xpath("(//span[@class='text'])[1]"));
        textBox01.click();
        String strtextBox01 = textBox01.getText();
        Assert.assertEquals(strtextBox01,"Text Box");
        System.out.println(strtextBox01);

        /*
        try {
            Assert.assertEquals(strtextBox01, "My TextBox");
        } catch (Exception e) {
            System.out.println("Bi hata oldu, kimbilir ne oldu!");
        } */

        WebElement textBox02 = mynewdriver.findElement(By.xpath("//span[@class='text']"));
        textBox02.click();
        String strtextBox02 = textBox02.getText();
        Assert.assertEquals(strtextBox02,"Check Box");
        System.out.println(strtextBox02);

        mynewdriver.close();

    }

}
