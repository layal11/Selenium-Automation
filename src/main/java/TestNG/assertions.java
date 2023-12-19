package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class assertions {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://github.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    void logoTest() {
        WebElement logo = driver.findElement(By.xpath("//header/div/div[1]"));
        Assert.assertFalse(logo.isDisplayed(), "Logo should not be displayed here!");
    }

    @Test(priority = 2)
    void title() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "GitHub: Let’s build from here · GitHub", "Title is not found");
    }

    @AfterClass
    void close() {
        driver.quit();
    }
}
