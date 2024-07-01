package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Home tile = " + driver.getTitle());
        List<WebElement> tableRows =  driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));
        System.out.println("Total no of rows in table "+tableRows.size());
        List<WebElement> firstRowCols = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
        System.out.println("Total no of columns in table "+firstRowCols.size());

        System.out.println("third row cell values");
        for(int i=1;i<=firstRowCols.size();i++){
            System.out.println("value present in cell"+i+" -> "+
                    driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td["+i+"]")).getText());
        }
        System.out.println("value present in 2nd row 2nd col -> "+
                driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]")).getText() );
        driver.close();
    }
}
