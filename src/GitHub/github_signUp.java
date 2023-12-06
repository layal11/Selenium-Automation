package GitHub;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.time.Duration;


public class github_signUp {
    protected JSONObject getData(String fileName) {
        String filePath = "src/assets/resources/.json";
        JSONObject jsonObj = null;
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            jsonObj = (JSONObject) obj;
            System.out.print(jsonObj.toJSONString());
            //System.out.print(jsonObj.getOrDefault("username", "username1"));
        } catch (Exception ex) {
//            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return jsonObj;
    }

    public static void main(String[] args) {
        // WEB DRIVERS
        System.setProperty("webdriver.chrome.driver", "C:/selenium jar and drivers/chrome driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/signup?source=login");

        //get page title
        String title = driver.getTitle();
        System.out.print("Page title: " + title + "\n");

        //get page URL
        String url1 = driver.getCurrentUrl();
        System.out.print("My current URL is: " + url1 + "\n");
        String url2 = "https://github.com/signup?source=login";
        if (url1.equals(url2)) {
            System.out.print("Pass, url matches perfectly!");
        } else {
            System.out.print("Fail, url doesn't match.");
        }

        // Implicit wait for 5 seconds
        // If the element appears before time, the test is executed without waiting till the maximum time. If the element is not found, NoSuchElementFound exception is returned.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("emaildgfsdgqarghreh@gmail.com");

        // RELATIVE xpath starts with // and NOT from the root element (Recommended)
        // ABSOLUTE xpath starts with / and from the root element
        WebElement btn1 = driver.findElement(By.xpath("//form/div/div[2]/button[1]"));

        //Explicit wait
        WebDriverWait waitPass = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitPass.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("l@12345wedgwegtewg");

        //Explicit wait
        WebDriverWait waitUsername = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitUsername.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        WebElement btn2 = driver.findElement(By.id("login"));
        btn2.sendKeys("myUsernamewsedfwef");

        //Explicit wait
        WebDriverWait waitLogin = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitLogin.until(ExpectedConditions.visibilityOfElementLocated(By.id("opt_in")));
        WebElement btn3 = driver.findElement(By.id("opt_in"));
        btn3.sendKeys("n");
    }
}
