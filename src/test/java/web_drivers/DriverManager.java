package web_drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

    public static WebDriver getDriver(Config config) {

        switch (config) {
            case CHROME:
                return getChromeDriver();
            case FF:
                return getFFDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                throw null;
        }
    }

    private static WebDriver getEdgeDriver() {

        return new EdgeDriver ();
    }

    private static WebDriver getFFDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        return new ChromeDriver();
    }
}
