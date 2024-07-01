package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Home tile = " + driver.getTitle());
        WebElement button = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        if(checkbox.isDisplayed())
            System.out.println("check box displayed - fail");
        else
            System.out.println("checkbox is not displayed - pass");

        button.click();
        boolean flag = wait.until(ExpectedConditions.visibilityOf(checkbox)).isDisplayed();
        if (flag)
            System.out.println("check box displayed - Pass");
            driver.close();
    }
}
