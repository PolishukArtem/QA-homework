import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchOnPage {
    static WebDriver driver;

    public SearchOnPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='search']")
    private WebElement inputField;



    public void InputDate(String item) {
        inputField.sendKeys(item);
        inputField.sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.className("goods-tile__inner"));

        for (int i=0; i<elements.size();i++)
        {
            System.out.println("Название " + i + "го элемента:" + elements.get(i).findElement(By.className("goods-tile__title")).getText());
        }
    }
}
