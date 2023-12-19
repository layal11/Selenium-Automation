package CoreConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select obj = new Select(driver.findElement(By.id("dropdown")));
        obj.selectByIndex(1); //selectByValue

        List<WebElement> count = obj.getOptions();
        for (WebElement webElement : count) {
            System.out.println(webElement.getText()); //webElement.size
        }
    }
}
