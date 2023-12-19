package GitHub;

import org.json.simple.JSONArray;
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

//-----------------------------------------------------------------------------------------
// Implicit wait for 5 seconds. If the element appears before time,
// the test is executed without waiting till the maximum time. If the element is not found, NoSuchElementFound exception is returned.
// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


// RELATIVE xpath starts with // and NOT from the root element (Recommended)
// ABSOLUTE xpath starts with / and from the root element
//-----------------------------------------------------------------------------------------


public class github_signUp2 {
    public JSONObject getData(String fileName) {
        JSONObject myJsonObj = null;
        try {
            FileReader reader = new FileReader(fileName);
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            myJsonObj = (JSONObject) obj;
//            System.out.print(myJsonObj.toJSONString());

        } catch (Exception ex) {
//            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return myJsonObj;
    }

    public static void main(String[] args) throws InterruptedException {

        // WEB DRIVERS
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //json
        github_signUp2 mainClass = new github_signUp2();
        JSONObject data = mainClass.getData("src/main/java/Assets/Files/.json");
        String githublink = (String) data.get("github"); //type casting

        driver.get(githublink);

        //Explicit wait
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebDriverWait waitBtn = new WebDriverWait(driver, Duration.ofMinutes(5));

        //navigate to signUp url
        String signUpString = "a[href='/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home']";
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpString)));
        WebElement SignUpBtn = driver.findElement(By.cssSelector(signUpString));
        SignUpBtn.click();

        //json get data from array
        JSONArray arr = (JSONArray) data.get("signUpCredentials");
        String email = null;
        String pass = null;
        String userName = null;
        for (int i = 0; i < arr.size(); i++) {
            JSONObject signUpCredentials = (JSONObject) arr.get(i);
            email = (String) signUpCredentials.get("email");
            pass = (String) signUpCredentials.get("pass");
            userName = (String) signUpCredentials.get("userName");
        }

        //email
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement emailElt = driver.findElement(By.id("email"));
        emailElt.sendKeys(email);

        //email btn
        String contEmailBtnString = "button[data-optimizely-event='click.signup_continue.email']";

        waitElement.until(ExpectedConditions.elementToBeClickable(By.cssSelector(contEmailBtnString)));
        WebElement continueEmailBtn = driver.findElement(By.cssSelector(contEmailBtnString));
        if (continueEmailBtn.isEnabled()) {
            continueEmailBtn.click();
        }

        //pass
        //Explicit wait
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement passElt = driver.findElement(By.id("password"));
        passElt.sendKeys(pass);

        //pass btn
        String contPassBtnString = "button[data-optimizely-event='click.signup_continue.password']";
        waitElement.until(ExpectedConditions.elementToBeClickable(By.cssSelector(contPassBtnString)));
        WebElement continuePassBtn = driver.findElement(By.cssSelector(contPassBtnString));
        if (continueEmailBtn.isEnabled()) {
            continuePassBtn.click();
        }

        //userName
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        WebElement userNameElt = driver.findElement(By.id("login"));
        userNameElt.sendKeys(userName);

        //userName btn
        String contUserNameBtnString = "button[data-optimizely-event='click.signup_continue.username']";
        waitElement.until(ExpectedConditions.elementToBeClickable(By.cssSelector(contUserNameBtnString)));
        WebElement contUserNameBtn = driver.findElement(By.cssSelector(contUserNameBtnString));
        if (continueEmailBtn.isEnabled()) {
            contUserNameBtn.click();
        }

        Thread.sleep(Duration.ofSeconds(2));

        //optIn
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("opt_in")));
        WebElement optInCheckbox = driver.findElement(By.id("opt_in"));
        optInCheckbox.click();

        //optIn btn
        String contcheckboxString = "button[data-optimizely-event='click.signup_continue.opt-in']";
        waitElement.until(ExpectedConditions.elementToBeClickable(By.cssSelector(contcheckboxString)));
        WebElement contcheckboxBtn = driver.findElement(By.cssSelector(contcheckboxString));
        if (continueEmailBtn.isEnabled()) {
            contcheckboxBtn.click();
        }

    }
}
