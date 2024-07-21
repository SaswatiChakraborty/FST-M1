package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.keep")
                .setAppActivity(".activities.BrowseActivity")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void googleNoteAddNote() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("New task1");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("New task description");

        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.
                id("com.google.android.keep:id/browse_note_interior_content")));

        Assert.assertEquals(driver.findElement(AppiumBy.id("index_note_title")).getText(), "New task1");
        Assert.assertEquals(driver.findElement(AppiumBy.id("index_note_text_description")).getText(), "New task description");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
