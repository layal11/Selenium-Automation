package TestNG.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class parameters {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
//accept params from xml file
    void setup(String browser, String appUrl) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get(appUrl);
    }

    @Test(priority = 1)
    void logoTest() {
        String elt = "//header/div/div[1]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elt)));
        WebElement logo = driver.findElement(By.xpath(elt));
        Assert.assertFalse(logo.isDisplayed(), "Logo should not be displayed here!");
    }

    @Test(priority = 2)
    void title() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "GitHub: Let’s build from here · GitHub", "Title is not found");
    }

//    @AfterClass
//    void close() {
//        driver.quit();
//    }
}
