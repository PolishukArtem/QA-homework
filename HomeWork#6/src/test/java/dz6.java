import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import enums.DriverType;
import factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class dz6 {
    static WebDriver driver;
    private final By input = By.name("q");
    private final By checkSite = By.xpath("//cite[contains(@class, 'iUh30 bc tjvcx')]");
    private final By waitLoad = By.xpath("/html/body/div/div[1]/header/div");

    @Test
    public void SearchTest() {
        String Link = "softserveinc.com";
        String Stroke = "softserve";


        DriverFactory factory = new DriverFactory();
        driver = factory.createWebDriver(DriverType.OPERA); //here u can switch between browsers
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.navigate().to("https://google.com");

        driver.findElement(input).sendKeys(Stroke);
        driver.findElement(input).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(checkSite));
        boolean check1 = driver.findElements(checkSite).stream().anyMatch(x -> x.getText().contains(Stroke));
        Assertions.assertThat(check1).isTrue();

        WebElement SiteAppear = driver.findElements(checkSite).stream().filter(f -> f.getText().contains(Link)).findAny().get();
        wait.until(d -> SiteAppear.isDisplayed());
        SiteAppear.click();

        wait.until(d -> driver.findElement(waitLoad).isDisplayed());
        boolean check2 = driver.getCurrentUrl().contains(Link);
        Assertions.assertThat(check2).isTrue();
    }

    @AfterMethod
    public void WrongScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File source = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("Screenshots\\" + result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterTest
    public void TheEnd() {
        driver.quit();
    }
}
