import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
// This is new tests
public class FirstTests {
    @Test
    public void FirstTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("softserve");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        String Title = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3")).getText();
        String Description = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div.s > div > span")).getText();

        if (Title.contains("SoftServe") && Description.contains("SoftServe"))
            System.out.println("Correct result");
        else
            System.out.println("Incorrect result");
        driver.quit();
    }
}
