import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity9 {
    WebDriver driver;
    Alert alert;
    WebDriverWait wait;

    @BeforeTest
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Reporter.log("Open alert page");
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @Test()
    public void simpleAlertTestCase() {
        Reporter.log("Clicking simple alert button");
        driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();

        Reporter.log("switch to alert");
        alert = driver.switchTo().alert();


        Reporter.log("get text from alert");
        String text = wait.until(ExpectedConditions.alertIsPresent()).getText();
        System.out.println(text);
        Assert.assertEquals(text,"This is a JavaScript Alert!");
    }

    @Test()
    public void confirmAlertTestCase() {
        Reporter.log("Clicking confirmation alert button");
        driver.findElement(By.xpath("//button[text()='Confirmation']")).click();

        Reporter.log("switch to alert");
        alert = driver.switchTo().alert();

        Reporter.log("get text from alert");
        String text = wait.until(ExpectedConditions.alertIsPresent()).getText();
        System.out.println(text);
        Assert.assertEquals(text,"This is a JavaScript Confirmation!");

        Reporter.log("accept alert");
        alert.accept();
    }

    @Test()
    public void promptAlertTestCase() {
        Reporter.log("Clicking prompt alert button");
        driver.findElement(By.xpath("//button[text()='Prompt']")).click();

        Reporter.log("switch to alert");
        alert = driver.switchTo().alert();

        Reporter.log("get text from alert");
        String text = wait.until(ExpectedConditions.alertIsPresent()).getText();
        System.out.println(text);
        Assert.assertEquals(text,"This is a JavaScript Prompt!");

        Reporter.log("enter value to alert");
        alert.sendKeys("Entering values");

        Reporter.log("dismiss alert");
        alert.dismiss();
    }

    @BeforeMethod
    public void backHomePage(){
        Reporter.log("return to home page");
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'generate an alert!')]")));
    }

    @AfterTest
    void tearDown(){
        Reporter.log("close browser");
        driver.quit();
    }
}
