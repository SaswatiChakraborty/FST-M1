package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Home tile = "+driver.getTitle());
        Actions action = new Actions(driver);
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement zone1 = driver.findElement(By.id("droppable"));
        WebElement zone2 = driver.findElement(By.id("dropzone2"));

        action.dragAndDrop(ball,zone1).build().perform();
        Thread.sleep(1000);
        String text = driver.findElement(By.tagName("p")).getText();
        if(text.equalsIgnoreCase("Dropped!"))
            System.out.println("ball is dropped");

        action.dragAndDrop(ball,zone2).build().perform();
        Thread.sleep(1000);
        text = driver.findElement(By.tagName("p")).getText();
        if(text.equalsIgnoreCase("Dropped!"))
            System.out.println("ball is dropped");
        driver.close();
    }
}
