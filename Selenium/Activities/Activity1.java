package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net");
        String pageTitle = driver.getTitle();
        System.out.println("initial page title = "+pageTitle);

        WebElement aboutUsButton = driver.findElement(By.id("about-link"));
        aboutUsButton.click();
        Thread.sleep(1000);

        pageTitle = driver.getTitle();
        System.out.println("final page title = "+pageTitle);
        driver.close();
    }
}
