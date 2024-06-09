import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({ "username", "password" })
    public void test(String sUsername, String sPassword) {
        driver.findElement(By.id("username")).sendKeys(sUsername);
        driver.findElement(By.id("password")).sendKeys(sPassword);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @AfterClass(alwaysRun = true)
    void tearDown(){
        driver.close();
    }
}
