package TestNG.ParallelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class parallel2 {

    WebDriver driver;


    @Test
    void logoTest() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://github.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait waitPass = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div/div[1]")));

        WebElement logo = driver.findElement(By.xpath("//header/div/div[1]"));
        Assert.assertTrue(logo.isDisplayed(), "Logo should exist!");
    }

    @Test
    void signIn() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://github.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait waitPass = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_field']")));
        WebElement input = driver.findElement(By.xpath("//*[@id='login_field']"));
        input.sendKeys("layal@gmail.com");
    }

    @AfterMethod
    void quit() {
        driver.quit();
    }

}
