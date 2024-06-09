import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/");
    }

    @Test
    void testApplication(){
       String title = driver.getTitle();
       Assert.assertEquals(title,"Training Support");
        driver.findElement(By.id("about-link")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals(driver.getTitle(),"About Training Support");
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }

}
