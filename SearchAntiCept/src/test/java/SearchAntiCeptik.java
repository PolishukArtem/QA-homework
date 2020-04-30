import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class SearchAntiCeptik {
    static WebDriver driver;
    private final String link = "https://rozetka.com.ua";
    private final String stroke = "Антисептик";
    private final By input = By.xpath("//input");
    private final By check = By.id("rz-banner-img");

    @Test
    public void FirstTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "E:\\QA-homework\\SearchAntiCept\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();

        driver.navigate().to(link);

        driver.findElement(input).sendKeys(stroke);
        driver.findElement(input).sendKeys(Keys.ENTER);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(check));

        List<WebElement> elements = driver.findElements(By.className("goods-tile__inner"));
        System.out.println("Кол-во элементов:" +elements.size());

        for (int i=0; i<elements.size();i++){
            System.out.println("Название " + i + "го элемента:" + elements.get(i).findElement(By.className("goods-tile__title")).getText() + "\n"
                    + elements.get(i).findElement(By.xpath("//div[@class=\"goods-tile__availability goods-tile__availability_type_available\"]")).getText());
        }

        driver.quit();
    }


}
