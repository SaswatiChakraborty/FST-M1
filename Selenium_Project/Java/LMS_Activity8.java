import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LMS_Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://alchemy.hguy.co/lms/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    void testApplication() {
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[contains(@href,'/contact/')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Need Help?')]")));
    }

    @Test(dependsOnMethods = "testApplication")
    void fillForm(){
        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("John Smith");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("John.Smith@test.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Selenium");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Please send the details");
        driver.findElement((By.name("wpforms[submit]"))).click();
        boolean flag = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='Thanks for contacting us! We will be in touch with you shortly.']")
        )).isDisplayed();
        Assert.assertTrue(flag);
        System.out.println(driver.findElement(
                By.xpath("//p[text()='Thanks for contacting us! We will be in touch with you shortly.']")).getText());
    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

}
