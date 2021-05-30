package Zeki.DemoQA;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class jvNewclass {

    @Test
    // @Test(timeout=5000)
    public void newTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://nileacademy.moodlecloud.com/"); // browser
        //System.out.println(driver.getWindowHandles());
        Thread.sleep(3000);

        WebElement usernamebox = driver.findElement(By.xpath("//input[@name=\'username\']"));
        usernamebox.sendKeys("YOUR NAME GOES HERE");
        Thread.sleep(2000);

        WebElement buttonClick = driver.findElement(By.xpath("(//button[@id='loginbtn'])[1]"));
        buttonClick.click();
        Thread.sleep(4000);

        driver.navigate().to("https://www.abc.com");

        Thread.sleep(2000);
        driver.quit();

    }
}
