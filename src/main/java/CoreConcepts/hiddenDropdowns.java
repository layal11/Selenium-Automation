package CoreConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class hiddenDropdowns {
    public static void main(String[] args) throws InterruptedException {
        //inspect -> event listeners -> blur

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Thread.sleep(1000);

        WebElement search = driver.findElement(By.xpath("//header/div/div[2]/form/div/div/input"));// By.xpath("//input[@placeholder='Search for Products, Brands and More']")
        search.sendKeys("macbook");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> suggList = driver.findElements(By.xpath("//div[contains(@class, 'YGcVZO _2VHNef')]"));

        String optionToSelect = "Macbook Air M1";

        try {
            for (WebElement e : suggList) {
                System.out.println("Suggestions: " + e.getText());
                String currentOption = e.getText();
                if (currentOption.contains(optionToSelect.toLowerCase())) {
                    e.click();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
