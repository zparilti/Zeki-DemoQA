package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropdownSelect {

    @Test
    public void newdropDown() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        WebElement dropDown = driver.findElement(By.xpath("(//div[@class=' css-1wa3eu0-placeholder'])[3]"));

        List<WebElement> listColors = driver.findElements(By.xpath("//select[@id=\"oldSelectMenu\"]/option"));
        Integer listSize = listColors.size();
        for (int i = 0; i < listSize; i++) {
            System.out.println(listColors.get(i).getText());
        }

        WebElement ndropDown = driver.findElement(By.xpath("//select[@id=\"oldSelectMenu\"]"));
        Select select = new Select((ndropDown));
        select.selectByIndex(1);//index of options in the dropdown box
        Thread.sleep(2000);
        select.selectByValue("3"); //value of the value propery of option
        Thread.sleep(2000);
        select.selectByVisibleText("Yellow");


    }
}
