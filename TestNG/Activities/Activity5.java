import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests", "ButtonTests"} , priority = 0)
    void checkTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }

    @Test(groups = {"HeaderTests"}, priority = 1)
    void headerTest1(){
        String header3 = driver.findElement(By.cssSelector(".ui.yellow.header")).getText();
        Assert.assertEquals(header3,"Third header");
    }

    @Test(groups = {"HeaderTests"}, priority = 1)
    void headerTest2(){
        String header_color = driver.findElement(By.cssSelector(".ui.green.header")).getCssValue("color");
        System.out.println(header_color);
        Assert.assertEquals(header_color,"rgb(33, 186, 69)");
    }

    @Test(groups = {"ButtonTests"},priority = 1)
    void buttonTest1(){
        String oliveButton = driver.findElement(By.xpath("//button[contains(@class,'olive ')]")).getText();
        Assert.assertEquals(oliveButton,"Olive");
    }

    @Test(groups = {"ButtonTests"}, priority = 1)
    void buttonTest2(){
        String button_color = driver.findElement(By.xpath("//button[contains(@class,'teal')]")).getCssValue("color");
        System.out.println(button_color);
        Assert.assertEquals(button_color,"rgb(255, 255, 255)");
    }

    @AfterClass(alwaysRun = true)
    void tearDown(){
        driver.close();
    }
}
