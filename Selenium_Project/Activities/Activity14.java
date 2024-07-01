package com.example.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Home tile = " + driver.getTitle());
        List<WebElement> tableRows =  driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("Total no of rows in table "+tableRows.size());
        List<WebElement> firstRowCols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("Total no of columns in table "+firstRowCols.size());
        System.out.println("value present in 2nd row 2nd col -> "+
                driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText() );
        System.out.println("Click the header of the first column to sort by name");
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();
        System.out.println("Now value present in 2nd row 2nd col -> "+
                driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText() );
        System.out.println("table footer cell values");
        List<WebElement> tablefooter =  driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        for (WebElement ele:tablefooter){
            System.out.println(ele.getText());
        }
        driver.close();
    }
}
