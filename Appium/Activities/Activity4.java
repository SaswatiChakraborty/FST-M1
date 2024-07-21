package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.samsung.android.dialer")
                .setAppActivity(".DialtactsActivity")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void createContact() {
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AppiumBy.id("arrowButton")));
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/arrowButton")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AppiumBy.id("firstEdit")));
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/firstEdit")).sendKeys("Aaditya");
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/lastEdit")).sendKeys("Varma");

        driver.findElement(AppiumBy
                        .xpath("(//android.widget.RelativeLayout[@resource-id='com.samsung.android.app.contacts:id/titleLayout'])[1]"))
                .sendKeys("999148292");
        driver.findElement(AppiumBy
                .xpath("//android.widget.TextView[@resource-id='com.samsung.android.app.contacts:id/navigation_bar_item_small_label_view' and @text='Save']"))
                .click();

        String addedName = driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/header")).getText();
        Assert.assertEquals(addedName,"Aaditya Varma");

        List<WebElement> contactNames = driver.findElements(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='com.samsung.android.dialer:id/contact_list_item_content']"));
        Assert.assertEquals(contactNames.get(4).getText(), "Aaditya Varma");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
