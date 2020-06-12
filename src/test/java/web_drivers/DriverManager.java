package web_drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;

public class DriverManager {
    public static WebDriver getDriver(Config config) throws MalformedURLException {
        switch (config) {
            case CHROME:
                return getChromeDriver ();
            case OPERA:
                return getOperaDriver ();
            default:
                throw null;
        }
    }

    private static WebDriver getChromeDriver() {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty ("webdriver.chrome.silentOutput", "true");
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ("--start-maximized");
        return new ChromeDriver (options);
    }

    private static WebDriver getOperaDriver() {
        System.setProperty ("webdriver.opera.driver", "src/test/resources/opera.exe");
        System.setProperty ("webdriver.opera.silentOutput", "true");
        return new ChromeDriver ();
    }
}