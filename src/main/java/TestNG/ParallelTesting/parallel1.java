package TestNG.ParallelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class parallel1 {

    WebDriver driver;

    @Test
    void logoTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://github.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait waitPass = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div/div[1]")));

        WebElement logo = driver.findElement(By.xpath("//header/div/div[1]"));
//        WebElement logo = driver.findElement(By.cssSelector("div[name='octicon-mark-github']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo should exist!");
    }

    @Test
    void signIn() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://github.com/login/");
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


//testng.xml

//parallel methods----------------------------------------
//<suite name="All Test Suite" parallel="methods" thread-count="2">  ...  </suite>


//parallel classes----------------------------------------
//<suite name="All Test Suite" parallel="classes" thread-count="2">
//    <test name="parallelClasses">
//        <classes>
//            <class name="TestNG.ParallelTesting.parallel1"/>
//            <class name="TestNG.ParallelTesting.parallel2"/>
//        </classes>
//    </test>
//</suite>


//parallel suite----------------------------------------
//<suite name="All Test Suite" parallel="classes" thread-count="2">

//    <test name="parallel1">
//        <classes>
//            <class name="TestNG.ParallelTesting.parallel1"/>
//        </classes>
//    </test>

//    <test name="parallel2">
//        <classes>
//            <class name="TestNG.ParallelTesting.parallel2"/>
//        </classes>
//    </test>

//</suite>