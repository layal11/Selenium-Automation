package CoreConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUploadSendKeys {
    public static void main(String[] args) {
        //use sendKeys to upload file ONLY IF the element is an <input type = “file“>

        //file is locally on PC NOT in the project path
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement btn = driver.findElement(By.id("file-upload"));
        btn.sendKeys("C:/Users/Layal/Downloads/hello.txt");

        WebElement submitBtn = driver.findElement(By.id("file-submit"));
        submitBtn.click();

    }
}
