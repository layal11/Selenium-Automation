package CoreConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class fileUploadAutoIT {
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://resume.naukri.com/resume-quality-score");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String btnPath = "//*[@id='dropzone']/div[2]/div/div[6]/span"; // * matches any element node and attribute node
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnPath)));

        WebElement uploadbtn = driver.findElement(By.xpath(btnPath));
        uploadbtn.click();

        Thread.sleep(5000);
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/assets/files/FileUpload.exe");

        System.out.println(System.getProperty("user.dir") + "/src/assets/files/FileUpload.exe");
    }
}
