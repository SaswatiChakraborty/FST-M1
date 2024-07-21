package activities;

import com.beust.ah.A;
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

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.samsung.android.messaging")
                .setAppActivity("com.android.mms.ui.ConversationComposer")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void sendNewMessage(){
        driver.findElement(AppiumBy.accessibilityId("Messages")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Compose new message")));
        driver.findElement(AppiumBy.accessibilityId("Compose new message")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.samsung.android.messaging:id/recipients_editor_to")));
        driver.findElement(AppiumBy
                .xpath("android.widget.LinearLayout[@content-desc='Add from Contacts, Button']/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/search_src_text")).sendKeys("9254967176");
        driver.findElement(AppiumBy.
                xpath("android.widget.FrameLayout[@resource-id='com.samsung.android.messaging:id/container_contact_list_item_content']/android.widget.LinearLayout"))
                .click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Done')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.samsung.android.messaging:id/recipients_editor_to")));
        driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.samsung.android.messaging:id/title' and @text='Conversations']")));
        String message = driver.findElement(AppiumBy.
                xpath("//android.widget.TextView[@resource-id='com.samsung.android.messaging:id/text_content' and @text='Hello from Appium']")).getText();
        Assert.assertEquals(message, "Hello from Appium");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
