import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LMS_Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Reporter.log("Open Browser");
        driver.get("https://alchemy.hguy.co/lms/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 0)
    void testApplication() {
        Reporter.log("get home page Title");
        System.out.println(driver.getTitle());
    }
    @Test(priority = 1)
    void openMyaccount() {
        Reporter.log("click my account tab");
        driver.findElement(By.xpath("//a[contains(@href,'/my-account/')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Reporter.log("get myaccount page Title");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"My Account – Alchemy LMS");
    }

    @Test(priority = 2)
    void clickLogin() {
        Reporter.log("Click login button");
        WebElement button = driver.findElement(By.xpath("//a[@href=\"#login\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    @Test(priority = 3)
    @Parameters({ "username", "password" })
    void validateLogin(String uname, String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Login')]")));
        Reporter.log("enter user id and password for login");
        driver.findElement(By.cssSelector("input[name$='log']")).sendKeys(uname);
        driver.findElement(By.cssSelector("input[name$='pwd']")).sendKeys(pwd);
        driver.findElement(By.cssSelector("input[name$='wp-submit']")).click();

        Reporter.log("validate login");
        boolean flag1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Edit Page')]"))).isDisplayed();
        boolean flag2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[text()='Your Courses']"))).isDisplayed();
        Assert.assertTrue(flag1);
        Assert.assertTrue(flag2);
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.close();
    }

}
