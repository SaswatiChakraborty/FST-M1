package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Home tile = "+driver.getTitle());
        Actions action = new Actions(driver);
        action.sendKeys("S").perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
        Thread.sleep(500);
        action.keyDown(Keys.CONTROL).sendKeys("c").build().perform();
        Thread.sleep(500);
        driver.close();
    }
}
