package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Home tile = " + driver.getTitle());
        WebElement checkbox = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
        System.out.println("checkbox is selected -> "+checkbox.isSelected());
        checkbox.click();
        System.out.println("checkbox is selected -> "+checkbox.isSelected());
        driver.close();
    }
}
