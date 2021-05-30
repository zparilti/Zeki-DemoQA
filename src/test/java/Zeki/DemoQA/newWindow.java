package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class newWindow {

    @Test
    public void newwindowTes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");

        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        newTab.click();
        Thread.sleep(3000);
        System.out.println("Text of newTab "+newTab.getText());
        String currentHandle = driver.getWindowHandle();
        Set<String> newHandles = driver.getWindowHandles();
        //REMOVE BELOW UNTIL REMOVE ABOVE
        //Iterator<String>;

        // REMOVE ABOVE
        
        // after saving window handles to a set, if you do another click, all window handle numbers will change randomly
        for (String s:newHandles) // check the new tab
             {
                 System.out.println(s);

                 if(!s.equalsIgnoreCase(currentHandle)){
                     driver.switchTo().window(s);//ask the driver go to new tab page
                     System.out.println(s);
                 }
        }

        WebElement newtabPage = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        System.out.println(newtabPage.getText());
        Thread.sleep(5000);
        driver.close(); // This closes the current
        driver.switchTo().window(currentHandle);
        //driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(3000);

        // Now we are clicking on New Window Button
        WebElement newWindow = driver.findElement(By.xpath("//*[@id='windowButton']"));
        newWindow.click();
        Thread.sleep(3000);
        System.out.println("Text of new window button "+ newWindow.getText());

        currentHandle = driver.getWindowHandle();
        newHandles = driver.getWindowHandles();
        for(String s2:newHandles){
            System.out.println(s2);
            if(!s2.equalsIgnoreCase(currentHandle)){
                driver.switchTo().window(s2);
                System.out.println(s2);
            }
        }

        newtabPage = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        System.out.println(newtabPage.getText());

        Assert.assertTrue("This is a sample page",newtabPage.getText().contains("sample"));
        Thread.sleep(5000);
        driver.close();

        // Now we are clicking on New Window Message Button - CHILD WINDOW
        System.out.println();
        driver.switchTo().window(currentHandle);

        WebElement newmWindow = driver.findElement(By.xpath("//*[@id='messageWindowButton']"));
        newmWindow.click();
        Thread.sleep(3000);
        System.out.println("Text of new m window button "+ newmWindow.getText());
        Thread.sleep(3000);

        currentHandle = driver.getWindowHandle();
        System.out.println(currentHandle);
        newHandles = driver.getWindowHandles();
        for (String s3:newHandles) {
            System.out.println(s3);
            if (!s3.equalsIgnoreCase(currentHandle)){
                driver.switchTo().window(s3);
                System.out.println(s3);
            }
        }
        //newtabPage = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        System.out.println("is this body text "+ newtabPage.getText());

        System.out.println(driver.getPageSource());
        System.out.println(driver.getTitle());
        //newtabPage = driver.findElement(By.xpath(""))

        driver.quit();

    }

}
