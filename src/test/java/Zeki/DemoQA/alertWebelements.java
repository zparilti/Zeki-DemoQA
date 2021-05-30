package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertWebelements {
//Deneme 123git
    @Test
    public void alertWeb() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");

        WebElement firstButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
        firstButton.click();
        Alert newAlert = driver.switchTo().alert();
        newAlert.accept();

        Thread.sleep(4000); firstButton.click(); newAlert.dismiss();
        Thread.sleep(4000); firstButton.click();
        System.out.println(newAlert.getText()); newAlert.dismiss();

        WebElement protButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        protButton.click();
        Thread.sleep(6000);

        Alert mynewAlert = driver.switchTo().alert();
        String mysTr = mynewAlert.getText();
        System.out.println(mysTr);
        mynewAlert.sendKeys("This is mr. Ugur");
        Thread.sleep(5000);
        mynewAlert.accept();

        Thread.sleep(10000);
    }

}
