package webDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverManager {

    public static WebDriver getDriver(Config config) {

        switch (config) {
            case CHROME:
                return getChromeDriver ();
            case FF:
                return getFFDriver ();
            case Opera:
                return getOperaDriver ();
            default:
                throw null;
        }
    }

    private static WebDriver getOperaDriver() {

        return new OperaDriver ();
    }

    private static WebDriver getFFDriver() {

        return new FirefoxDriver ();
    }

    private static WebDriver getChromeDriver() {

        System.setProperty ("webdriver.chrome.driver", "src\\test\\resources" +
                "\\chromedriver.exe");
        System.setProperty ("webdriver.chrome.silentOutput", "true");

//        ChromeOptions options = new ChromeOptions ();
//        options.addArguments ("--headless");
//        options.addArguments ("--disable-gpu");
//        options.addArguments ("--window-size=1920,1200");
//        options.addArguments ("--ignore-certificate-errors");

        return new ChromeDriver (/*options*/);

    }

}
