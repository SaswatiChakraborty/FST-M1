package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Home tile = "+driver.getTitle());

        String thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("3rd header on the page = "+thirdHeader);

        String fifthHeaderColor = driver.findElement(By.xpath("//h3[@id='third-header']")).getCssValue("color");
        System.out.println("Color of 5th header = "+fifthHeaderColor);
        System.out.println(driver.findElement(By.cssSelector(".ui.violet.button")).getAttribute("class"));
        System.out.println(driver.findElement(By.cssSelector(".ui.grey.button")).getText());
        Thread.sleep(1000);
        driver.close();
    }
}
