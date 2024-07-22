package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.sec.android.app.popupcalculator")
                .setAppActivity(".Calculator")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"7\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"5\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        String multiplicationValue = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_tv_result")).getText();
        Assert.assertEquals(multiplicationValue,"35");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
