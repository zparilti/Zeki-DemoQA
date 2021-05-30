package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

public class iframesTesting {

    @Test
    public void iframeTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/nestedframes");

        // Make a webelement and then switch to the element
        WebElement iframeOne = driver.findElement(By.xpath("//iframe[@src='/sampleiframe']"));
        driver.switchTo().frame(iframeOne);

        // WebElement bodyiniframeOne = driver.findElement(By.xpath("//body"));
        System.out.println("iframeone text: " + driver.findElement(By.xpath("//body")).getText());

        WebElement iframeTwo = driver.findElement(By.xpath("//body/iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(iframeTwo);
        System.out.println("iframetwo text: " + driver.findElement(By.xpath("//body/p")).getText() );

        // driver.switchTo().parentFrame(); // switches to the previous frame or one level up
        driver.switchTo().defaultContent(); // switches to main page or top level
        
        WebElement defaultcontentText = driver.findElement(By.xpath("(//div[@id='framesWrapper']/div)[1]"));
        System.out.println("defaultcontentText: "+ defaultcontentText.getText());
        // System.out.println("defaultcontentText = " + defaultcontentText); // this is got by type "soutv"

    }

}
