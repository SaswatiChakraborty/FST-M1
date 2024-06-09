package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoogleSearchStepss {
    WebDriver driver;

    @Given("^User is on Google Home Page$")
    public void openGooglePage() {
        WebDriverManager.firefoxdriver().setup();
        driver =  new FirefoxDriver();
        driver.get("https://www.google.com/");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void endCheeseEnter() {
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Cheese");
        driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[2]")).click();
    }

    @Then("^Show how many search results were shown$")
    public void countResult(){
        String resultCount = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println("total no of search result -> "+resultCount);
    }

    @And("^Close the browser$")
    public void browserClose(){
        driver.close();
    }
}
