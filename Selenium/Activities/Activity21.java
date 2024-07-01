package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Activity21 {
    public static void main(String args[]) throws InterruptedException {;
        String secondPage = null;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println("Home tile = " + driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.id("launcher")).click();

        Set<String> allwindows = driver.getWindowHandles();
        for(String s:allwindows)
            System.out.println(s+ " is a window handler when total count is 2");
            for(String s:allwindows) {
                if(!s.equalsIgnoreCase(parentWindow)){
                    driver.switchTo().window(s);
                    System.out.println(driver.getTitle());
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    secondPage = s;
                    break;
                }
        }
        driver.findElement(By.id("actionButton")).click();

        allwindows = driver.getWindowHandles();
        for(String s:allwindows)
            System.out.println(s+ " is a window handler when total count is 3");
        for (String s:allwindows){
            if(!s.equals(secondPage) && !s.equals(parentWindow)){
                driver.switchTo().window(s);
                System.out.println(driver.getTitle());
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                break;
            }
        }
        driver.quit();
    }
}
