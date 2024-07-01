import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LMS_Activity5 {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        Reporter.log("Open Browser");
        driver.get("https://alchemy.hguy.co/lms/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    void testApplication() {
        Reporter.log("get home page Title");
        System.out.println(driver.getTitle());

        Reporter.log("click my account tab");
        driver.findElement(By.xpath("//a[contains(@href,'/my-account/')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Reporter.log("get myaccount page Title");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"My Account – Alchemy LMS");
    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

}
