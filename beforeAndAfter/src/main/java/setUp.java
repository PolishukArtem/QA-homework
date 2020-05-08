import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class setUp {
    static WebDriver driver;
//1 Написать BeforeMethod в котором открыть браузер и перейти на https://rozetka.com.ua/
    @BeforeMethod
    public void driverInit() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://rozetka.com.ua");
    }
//2 Написать AfterMethod в котором закрыть браузер
    @AfterMethod
    public void closeTest() {
        driver.quit();
    }
}
