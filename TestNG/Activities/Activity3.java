import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    void testApplication() throws InterruptedException {
       driver.findElement(By.id("username")).sendKeys("admin");
       driver.findElement(By.id("password")).sendKeys("password");
       driver.findElement(By.xpath("//button[text()='Log in']")).click();
       String login_msg = driver.findElement(By.id("action-confirmation")).getText();
       Assert.assertEquals(login_msg,"Welcome Back, admin","Welcome Back, admin - message is displayed");
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }

}
