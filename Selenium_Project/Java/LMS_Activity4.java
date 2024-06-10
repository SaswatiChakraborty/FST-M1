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

public class LMS_Activity4 {
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

        Reporter.log("Get the title of the second most popular course");
        String popularCourse = driver.findElement(By.xpath("//h3[contains(text(),'Email Marketing Strategies')]")).getText();
        Assert.assertEquals(popularCourse, "Email Marketing Strategies");
    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

}
