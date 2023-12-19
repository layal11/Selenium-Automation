package GitHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class github_signIn {
    public static void main(String[] args) throws IOException {
        // WEB DRIVERS
        System.setProperty("webdriver.chrome.driver", "C:/selenium jar and drivers/chrome driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com");

        // LOCATORS
        WebElement singinBtn = driver.findElement(By.linkText("Sign in"));
        singinBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field")));
        // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("login_field"))) //if login field is inside an Iframe

        String validEmail = "layal.haidar136@gmail.com";
        String validPass = "haidarlayal1998";

        WebElement email = driver.findElement(By.id("login_field"));
        WebElement pass = driver.findElement(By.id("password"));
        email.sendKeys(validEmail);
        pass.sendKeys(validPass);

        // RELATIVE xpath starts with // and NOT from the root element (Recommended)
        // ABSOLUTE xpath starts with / and from the root element
        WebElement btn = driver.findElement(By.xpath("//form[@method='post']/div/input[13]")); //By.cssSelector("input[name='commit']")
        btn.click();

        Runtime.getRuntime().exec("C:/Users/Layal/Documents/FileUploadScripts/FileUpload.exe");

    }
}