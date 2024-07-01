package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Home tile = " + driver.getTitle());
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='input-text']"));
        System.out.println("input box is enabled -> "+inputBox.isEnabled());
        driver.findElement(By.id("toggleInput")).click();
        Thread.sleep(2000);
        System.out.println("input box is enabled -> "+inputBox.isEnabled());
        driver.close();
    }
}
