package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Home tile = "+driver.getTitle());
        Actions action = new Actions(driver);
        action.click().build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());
        action.doubleClick().build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());
        action.contextClick().build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());
        driver.close();

    }
}
