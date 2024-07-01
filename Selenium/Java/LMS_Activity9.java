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
import java.util.List;

public class LMS_Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://alchemy.hguy.co/lms/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(priority = 0)
    void navigateToCourse() {
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[contains(@href,'/all-courses/')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'All Courses')]")));

        WebElement course1 = driver.findElement(By.xpath("//div[@class='ld-course-list-items row']/div[1]"));
        course1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Social Media Marketing')]")));
        driver.findElement(By.xpath("//a[@href=\"#login\"]")).click();
    }

    @Test(priority = 1)
    @Parameters({ "username", "password" })
    void appLogin(String uname, String pwd) {
        Reporter.log("enter user id and password for login");
        driver.findElement(By.cssSelector("input[name$='log']")).sendKeys(uname);
        driver.findElement(By.cssSelector("input[name$='pwd']")).sendKeys(pwd);
        driver.findElement(By.cssSelector("input[name$='wp-submit']")).click();

        Reporter.log("validate login");
        boolean flag1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Edit Course')]"))).isDisplayed();
        Assert.assertTrue(flag1);
    }

    @Test(priority = 2)
    void completeCourse(){
       driver.findElement(By.xpath("(//*[@class='ld-item-title'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Developing Strategy')]")));

        Assert.assertEquals(driver.getTitle(),"Developing Strategy – Alchemy LMS");

        String courseStatus = driver.findElement(By.xpath("//div[contains(@class,'ld-status ld-status')]")).getText();
        if(courseStatus.equalsIgnoreCase("Complete"))
            System.out.println("course is already completed , so mark complete button is not present");
        else
            System.out.println("course is inprogress, find mark complete button");
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.close();
    }

}
