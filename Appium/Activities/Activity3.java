package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity3 {
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
    public void addTest(){
        //5+9
        driver.findElement(AppiumBy.accessibilityId("Clear")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"5\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Plus")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_tv_result")).getText();
        Assert.assertEquals(result,"14");
    }

    @Test
    public void subtractTest(){
        //10-5
        driver.findElement(AppiumBy.accessibilityId("Clear")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.accessibilityId("Minus")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"5\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_tv_result")).getText();
        Assert.assertEquals(result,"5");
    }

    @Test
    public void multipleTest(){
        //5*100
        driver.findElement(AppiumBy.accessibilityId("Clear")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"5\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_tv_result")).getText();
        Assert.assertEquals(result,"500");
    }

    @Test
    public void divisionTest(){
        //50/2
        driver.findElement(AppiumBy.accessibilityId("Clear")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"5\"]")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.accessibilityId("Division")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_tv_result")).getText();
        Assert.assertEquals(result,"25");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
