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

public class LMS_Activity2 {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        Reporter.log("Open Browser");
        driver.get("https://alchemy.hguy.co/lms/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    void testApplication() {
        Reporter.log("getTitle");
        System.out.println(driver.getTitle());

        Reporter.log("validate header");
        String header_txt = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(header_txt, "Learn from Industry Experts");
    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

}
