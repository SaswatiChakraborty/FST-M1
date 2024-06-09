package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Login page")
    public void user_is_on_login_page() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("Read the page title and confirmation message")
    public void read_the_page_title_and_confirmation_message() {
        String loginMessage = driver.findElement(By.xpath("//div[text()='Welcome Back, admin']")).getText();
        System.out.println("login message -> "+loginMessage);
        System.out.println("Page title -> "+driver.getTitle());
    }

    @Then("Close the Browser")
    public void close_the_browser() {
            driver.close();
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String userName, String passwd) {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }


}
