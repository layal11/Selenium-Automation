package CoreConcepts;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class fileUpload_KeyboardEvents {

    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver drv = new FirefoxDriver();
        drv.manage().window().maximize();
        drv.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        drv.get("https://www.grammarly.com/plagiarism-checker");
        drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) drv;
        js.executeScript("window.scrollBy(0,200)");
//        Thread.sleep(2000); // suspending execution for a specific time

        WebElement browse = drv.findElement(By.xpath("//form/div/div[4]/button[2]"));
        browse.click();
        Thread.sleep(2000);

        // creating object of Robot class
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection("C:\\Users\\Layal\\Downloads\\Layal_Haidar_QA_Specialist_Resume.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Control+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Control+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}