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

public class fileUploadSendKeys2 {
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.cssSelector("input[placeholder='Username']"));
        WebElement pass = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        WebElement btn = driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

        userName.sendKeys("Admin");
        pass.sendKeys("admin123");
        btn.click();

        String pimPath = "//nav/div[2]/ul/li[2]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pimPath)));
        WebElement pim = driver.findElement(By.xpath(pimPath));
        pim.click();

        WebElement addEmp = driver.findElement(By.xpath("//nav/ul/li[3]"));
        addEmp.click();

        WebElement addEmpImg = driver.findElement(By.xpath("//form/div/div/div/div[2]/input"));
        Thread.sleep(Duration.ofSeconds(2));

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        addEmpImg.sendKeys(projectPath + "/src/assets/images/nature.jpg");

    }
}
