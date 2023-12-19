package CoreConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class shadowPath1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("chrome://settings/appearance");

        WebElement shadowPath1 = driver.findElement(By.xpath("//settings-ui")).getShadowRoot()
                .findElement(By.cssSelector("settings-main[id='main']")).getShadowRoot()
                .findElement(By.cssSelector("settings-basic-page[class='cr-centered-card-container']")).getShadowRoot()
                .findElement(By.cssSelector("div[id='basicPage']"))
                .findElement(By.cssSelector("settings-section[page-title='Appearance']"))
                .findElement(By.cssSelector("settings-appearance-page")).getShadowRoot()
                .findElement(By.cssSelector("settings-animated-pages[id='pages']"))
                .findElement(By.cssSelector("settings-toggle-button[label='Show Home button']")).getShadowRoot()
                .findElement(By.id("outerRow"))
                .findElement(By.cssSelector("cr-toggle[id='control']"));
        shadowPath1.click();
        System.out.print("Shadow Path: " + shadowPath1.getShadowRoot());
    }
}
