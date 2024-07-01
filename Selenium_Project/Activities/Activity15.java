package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Home tile = " + driver.getTitle());
        driver.findElement(By.xpath("//input[contains(@class,'username-')]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[class*='password-']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Welcome Back, admin']"))).isDisplayed();
        System.out.println(driver.findElement(By.xpath("//div[text()='Welcome Back, admin']")).getText());
        driver.close();
    }
}
