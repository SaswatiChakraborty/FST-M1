import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LMS_Activity1 {
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
        String title = driver.getTitle();

        Reporter.log("validate title");
        Assert.assertEquals(title, "Alchemy LMS – An LMS Application");

    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

}
