package factory;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class DriverFactory {

    public WebDriver createWebDriver(DriverType driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case IE:
                driver = createIEDriver();
                break;
            case OPERA:
                driver = createOperaDriver();
                break;
            default:
                throw new RuntimeException("Unknown web driver type. Need to be added to webDriver.factory");
        }
        return driver;
    }
        protected WebDriver createChromeDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Acer\\Desktop\\QA-homework-master\\HomeWork#6\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
        return driver;
        }
    protected WebDriver createOperaDriver(){
        System.setProperty("webdriver.opera.driver","C:\\Users\\Acer\\Desktop\\QA-homework-master\\HomeWork#6\\drivers\\operadriver.exe");
        WebDriver driver = new OperaDriver();
        OperaOptions options = new OperaOptions();
        options.addArguments("--disable-notifications");
        return driver;
    }
    protected WebDriver createIEDriver(){
        System.setProperty("webdriver.ie.driver","C:\\Users\\Acer\\Desktop\\QA-homework-master\\HomeWork#6\\drivers\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
}
