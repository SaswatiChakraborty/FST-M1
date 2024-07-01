package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Home tile = " + driver.getTitle());

        driver.findElement(By.xpath("//button[text()='Change Content']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).isDisplayed();
        System.out.println( driver.findElement(By.tagName("h1")).getText());

        WebElement element2 = driver.findElement(By.tagName("h3"));
        wait.until(ExpectedConditions.visibilityOf(element2)).isDisplayed();
        System.out.println(element2.getText());

        driver.close();
    }
}
