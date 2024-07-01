package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("home page title = "+driver.getTitle());

        driver.findElement(By.id("username")).sendKeys("admin");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("password");
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".ui.button")).click();
        Thread.sleep(2000);
        driver.close();
    }
}
