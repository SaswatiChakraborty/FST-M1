package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity16 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Home tile = " + driver.getTitle());
        driver.findElement(By.xpath("//input[contains(@class,'-username')]")).sendKeys("Saswati");
        driver.findElement(By.cssSelector("input[class*='-password']")).sendKeys("password");
        driver.findElement(By.xpath("//label[text()='Confirm Password']/../input")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("Saswati@ibm.com");
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        driver.close();
    }
}
