package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Home tile = " + driver.getTitle());
        WebElement button = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
        System.out.println("checkbox is diaplayed -> "+checkbox.isDisplayed());
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        System.out.println("checkbox is diaplayed -> "+checkbox.isDisplayed());
        button.click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        System.out.println("checkbox is diaplayed -> "+checkbox.isDisplayed());
        driver.close();
    }
}
