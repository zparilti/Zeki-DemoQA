package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Locators {

    // 1 set up driver   Webdrivermanager  driver
    // 2 locate elements   Selenium
    //3 do some action like click, send keys or else   Selenium
    //4 compare expected result with actual result TestNg  Assert.assertTrue( );

    @Test
    public void test1() throws InterruptedException {
        // 1 set up driver   Webdrivermanager  driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/");// get() method waits for loading
//        driver.navigate().to("https://demoqa.com/elements");// navigate doesnt waits for loading
//        driver.navigate().back();driver.navigate().forward();driver.navigate().refresh();
//        driver.close();  //closes the active browser

        // 2 locate elements   Selenium
        // Locate by ID
        WebElement TextAreaFieldBox=driver.findElement(By.id("ta1"));

        //3 do some action like click, send keys or else   Selenium
        TextAreaFieldBox.sendKeys("Zeki Bey");

        //4 compare expected result with actual result TestNg  Assert.assertTrue( );
        String str=driver.findElement(By.cssSelector("#HTML2 h2")).getText();
        Assert.assertEquals("Text Area Field",str);

        // Locate by Class
        WebElement Date=driver.findElement(By.className("date-header"));
        //3 do some action
        String s1=Date.getText();
//        System.out.println(s1);
        //4 compare expected result
        Assert.assertEquals("Monday, May 13, 2013", s1);

        // Locate by Name and do some action
        WebElement name=driver.findElement(By.name("Cross-Column 2"));
        String s2 = name.getText();
        System.out.println(s2);

        // Locate by TagName
        WebElement tableElement = driver.findElement(By.tagName("table"));
        tableElement.click();

        // Locate by Partial LinkText - CHECK LATER
        /*
        driver.navigate().refresh();
        WebElement partialLinkTest = driver.findElement(By.partialLinkText("Sele"));
        partialLinkTest.click();
        Thread.sleep(5000);
        driver.quit();
        // driver.navigate().back();
        Thread.sleep(5000);
         */

        // Locate by LinkText
        WebElement linkTest = driver.findElement(By.linkText("Selenium143"));
        linkTest.click();
        driver.navigate().back();

        //4 compare expected result
        Assert.assertTrue(s2.contains("blogspot"));

        String s3=driver.findElement(By.name("Cross-Column 2")).getText();
        Assert.assertTrue(s3.contains("blogspot"));
        Assert.assertTrue(driver.findElement(By.name("Cross-Column 2")).getText().contains("blogspot"));

        // EXAMPLES FROM https://demoqa.com/broken
        driver.get("https://demoqa.com/broken");
        WebElement partialLinkText02 = driver.findElement(By.partialLinkText("lid Lin"));
        partialLinkText02.click();
        driver.quit();
    }

    @Test public void testXPath() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        // Locate a text box and send keys
        WebElement textBox = driver.findElement(By.xpath("//li[@id='item-0']"));
        textBox.click();
        Thread.sleep(2000);
        WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        inputBox.sendKeys("UGUR EROGLU");

        Thread.sleep(1000);
        inputBox.clear();
        inputBox.sendKeys("NO I DID NOT LIKE THIS, TRY ANOTHER NAME");
        Thread.sleep(1000);
        inputBox.clear();
        inputBox.sendKeys("  ");

        // Locate a check box and check
        WebElement checkBox = driver.findElement(By.xpath("//*[text()='Check Box']"));
        checkBox.click();

        WebElement homeCheckBox = driver.findElement(By.xpath("//*[contains(text(),'ome')]"));
        homeCheckBox.click();
        Thread.sleep(5000);

        //  HERE IS A SHORT VERSION
        driver.findElement(By.xpath("//*[starts-with(@id,'item-2')]")).click();
        driver.findElement(By.xpath("//*[starts-with(@for,'impressive')]")).click();
        System.out.println(driver.findElement(By.xpath("//input[starts-with(@id,'impressive')]")).isSelected());

        //1 FIND impressive with contains - also used how to go to parent(main tag) to child (sub tag)
        String checkString = driver.findElement(By.xpath("//*[contains(text(),'You have selected')]/span")).getText();
        Assert.assertEquals(checkString,"Impressive");

        //1 FIND immpressive text and use assert to check the accurcy
        String newSt;
        newSt = driver.findElement(By.xpath("//*[starts-with(@for,'impressive')]")).getText();
        System.out.println(newSt);

        //2 use end-with to locate web elements; find labels yes or no and click them use method to verify texts
        driver.findElement(By.xpath("//input[@id='noRadio']")).isEnabled();
        Thread.sleep(2000);

        //Assert.assertEquals(driver.findElement(By.xpath("//label[ends-with(@for,'sRadio']")).getText(),"no");

        //3 Use contains to locate web elements;

    }

}