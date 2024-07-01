package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Activity17 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Home tile = " + driver.getTitle());
        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        select.selectByIndex(3);
        select.selectByValue("4");
        Thread.sleep(1000);
        List<WebElement> allOptions = select.getOptions();
        for(WebElement ele:allOptions)
            System.out.println(ele.getText());
        Thread.sleep(1000);
        driver.close();
    }
}
