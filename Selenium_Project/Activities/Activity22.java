package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity22 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println("Home tile = " + driver.getTitle());
        WebElement button = driver.findElement(By.xpath("//button[contains(@class,'orange')]"));
//        WebElement button = driver.findElement(By.className("ui huge inverted orange button"));
        String tooltip = button.getAttribute("data-tooltip");
        System.out.println(tooltip);
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        driver.findElement(By.xpath("//div[text()='Welcome Back, admin']")).getText();
        driver.close();
    }
}
