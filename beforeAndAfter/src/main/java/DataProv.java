import org.testng.annotations.DataProvider;
//3 Написать data provider который возвращает 3 поисковых запроса, к примеру (ноутбук, чайник, мяч)
public class DataProv {
    @DataProvider(name = "ArtArray")
    public Object[][] ArtTools() {
        return new Object[][]{
                {"montana"},
                {"sketchbook"},
                {"валик"}
        };
    }
}
