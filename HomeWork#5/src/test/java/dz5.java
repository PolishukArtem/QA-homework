import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class dz5 {
    static WebDriver driver;
    private final String link = "http://www.reddit.com/";
    private final By input = By.name("q");
    private final By result = By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/div[2]/div[3]/div[1]/div[4]/div[1]/div/div/div[2]/div/div[2]/div[1]/div[1]/a/div/h3/span");
    private final String stroke = "graffiti";

    @Test
    public void Test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "E:\\QA-homework\\HomeWork#5\\src\\test\\java\\chromedriver.exe");
        driver = new ChromeDriver(options);

        WebDriverWait webDriverWait = new WebDriverWait(driver,3);
        driver.manage().window().maximize();

        driver.navigate().to(link);
        driver.findElement(input).click();

        webDriverWait.until(d->d.findElement(input).isDisplayed());
        driver.findElement(input).sendKeys(stroke);
        driver.findElement(input).sendKeys(Keys.ENTER);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(result));
        driver.findElement(result).click();
        driver.getCurrentUrl().contains(stroke);

        if(driver.getCurrentUrl().contains(stroke)) {
            System.out.println("URL link contains key stroke");
        }
        else {
            System.out.println("URL link does not contains key stroke");
        }

    }
    @AfterTest
    public void TheEnd() {
        driver.quit();
    }
}