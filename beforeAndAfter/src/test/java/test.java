import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class test extends setUp{
    //4 Написать тест который принимает 1 параметр String (поисковый запрос). Добавить в тест дата провайдер из 3 пункта
    @Test(dataProvider = "ArtArray", dataProviderClass = DataProv.class)
    public void searchDataItems(String artTools) {

        SearchOnPage rozetkaPage = new SearchOnPage(driver);
        rozetkaPage.InputDate(artTools);

    }
}
