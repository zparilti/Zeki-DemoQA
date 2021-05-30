package Zeki.DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyLocators {

    WebDriver driver;

    public void userProperty(String userName,String userProperty){

        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        String column="3";


        // Loop for checking user property
        for(int i=1;i<=7;i++){

            WebElement tempProperty = driver.findElement(By.xpath("//div[@role='grid']/div[@class='rt-thead -header']/div/div["+i+"]"));
            //System.out.println(tempProperty.getText());
            if(tempProperty.getText().equalsIgnoreCase(userProperty)){
                  column = i+"";
                  break;
            }
        }

        // Loop for checking user name and getting the cell value
        for(int n=1;n<=3;n++){
            WebElement tempName = driver.findElement(By.xpath("//div[@role='grid']/div[@class='rt-tbody']/div["+n+"]/div[1]/div[1]"));
            //System.out.println(tempName.getText());
            if(tempName.getText().equalsIgnoreCase(userName)){
                WebElement cell = driver.findElement(By.xpath("//div[@role='grid']/div[@class='rt-tbody']/div["+n+"]/div[1]/div["+column+"]"));
                System.out.println(userName+" " + userProperty + " is " + cell.getText());
                break;
            }

        }

    }

    @Test
    public void test02() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement table = driver.findElement(By.cssSelector("li[id='item-3']"));
        table.click();
        userProperty("Alden","Age");


        // WebElement cell = driver.findElement(By.xpath("//div[@role='grid']/div[@class='rt-tbody']/div[2]/div[1]/div[3]"));
        // Assert.assertEquals(cell.getText(),"45");
        // String row = "2"; String column ="3";
        //WebElement cell01 = driver.findElement(By.xpath("//div[@role='grid']/div[@class='rt-tbody']/div["+row+"]/div[1]/div["+column+"]"));

        // Finding Alden age and salary with CSS or XPath
        // driver.findElement(By.cssSelector("div[role='grid'] div[class='rt-tbody'] div:nth-of-type(3) div:nth-of-type(1) div:nth-of-type(2)"));

        // XPath alternative
        //WebElement textBox = driver.findElement(By.xpath("//li[@id='item-3']"));

    }
}

// driver.manage().window().fullscreen();
// WebElement newel = driver.findElement(By.xpath("//input[starts-with(@name,'q')]"));
// newel.click();
// newel.sendKeys("Thailand ");
// newel.click();
// WebElement mn = driver.findElement(By.xpath("//input[starts-with(@value,'Goog')]"));
// mn.click();
// System.out.println(newel.isEnabled());

