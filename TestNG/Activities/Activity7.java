import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity7 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "admin", "password" },
                { "passWord", "password" }
        };
    }

    @Test(dataProvider = "Authentication")
    public void test(String userName, String passWord) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @AfterClass(alwaysRun = true)
    void tearDown(){
        driver.close();
    }
}
