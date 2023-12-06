package CoreConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shadowPath2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("chrome://settings/autofill");

        WebElement shadowPath2 = driver.findElement(By.xpath("//settings-ui"))
                .getShadowRoot()
                .findElement(By.cssSelector("div[id='container']"))
                .findElement(By.cssSelector("settings-main[id='main']"))
                .getShadowRoot()
                .findElement(By.cssSelector("settings-basic-page[class='cr-centered-card-container']"))
                .getShadowRoot()
                .findElement(By.id("basicPage"))
                .findElement(By.cssSelector("settings-section[page-title='Autofill and passwords']"))
                .findElement(By.tagName("settings-autofill-page"))
                .getShadowRoot()
                .findElement(By.cssSelector("settings-animated-pages[section='autofill']"))

                .findElement(By.cssSelector("settings-subpage.iron-selected[page-title='Payment methods']"))

                .findElement(By.cssSelector("settings-payments-section[id='paymentsSection']")).getShadowRoot()
                .findElement(By.cssSelector("settings-toggle-button[id='autofillCreditCardToggle']"));
        shadowPath2.click();
    }
}
