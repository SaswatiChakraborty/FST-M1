import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.est.LimitedSource;
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
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LMS_Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://alchemy.hguy.co/lms/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    void countCourses() {
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[contains(@href,'/all-courses/')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'All Courses')]")));

        List<WebElement> couses = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']/div"));
        System.out.println("total number of course present = "+couses.size());
    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

}
