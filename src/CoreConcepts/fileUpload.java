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

public class fileUpload {
    public static void main(String[] args) throws AWTException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.remove.bg/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// for Implicit wait

        String path = "//*[@*='page-content']/div[2]/div/div/div/div/div[2]/div[2]/button"; //matches any element node and attribute node
        WebDriverWait waitLogin = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitLogin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));


        String formPath="/html/body/form";
        WebElement uploadbtn = driver.findElement(By.xpath(path));
        uploadbtn.click();

        String fileInputPath="/html/body/form/input";


        WebDriverWait waitForm = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitForm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formPath)));
        waitForm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fileInputPath)));

        WebElement formElt = driver.findElement(By.xpath(formPath));

        WebElement fileInput = driver.findElement(By.xpath(fileInputPath));
        fileInput.sendKeys("C:/Users/Layal/Documents/FileUploadScripts/FileUpload.exe");
        formElt.submit();
        String[] filePath= {"C:/Users/Layal/Documents/FileUploadScripts/FileUpload.exe"};
        Runtime.getRuntime().exec(filePath);
        System.out.println("C:/Users/Layal/Documents/FileUploadScripts/FileUpload.exe");
    }
}
