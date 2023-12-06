package CoreConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPath {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers");

        // Methods we can use with xpath: contains(), starts-with()
        // By.xpath("//div[contains(@id, 'leftcont')]/table/tbody/tr[1]/td[1]"));
        WebElement xpathLink = driver.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[1]/td[1]"));
        xpathLink.click();
    }
}
