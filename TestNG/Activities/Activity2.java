import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test(priority = 0)
    void getApplication(){
       String title = driver.getTitle();
       Assert.assertEquals(title,"Target Practice");
    }

    @Test(priority = 1)
    void findBlackButton(){
        String buttonText =  driver.findElement(By.cssSelector(".ui.black.button")).getText();
        Assert.assertEquals(buttonText,"Yellow");
    }

    @Test(priority = 2, enabled = false)
    void skipTest(){
        System.out.println("This test will be skipped");
        Assert.assertTrue(false);
    }

    @Test(priority = 3)
    void skipByException(){
        if(1==1)
            throw new SkipException("Skipping test case");
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }

}
