package web_drivers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

public class MyDriver {

    static String LOGGER_MESSAGE_PATH = "src/test/resources/logger/loggerMessages.properties";
    private static WebElement element;
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<> ();
    private static final Logger LOGGER = LogManager.getLogger (MyDriver.class);

    public static WebDriver getWebDriver() {
        if (null == webDriver.get ()) {
            try {
                webDriver.set (DriverManager.getDriver (Config.CHROME));
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
        return webDriver.get ();
    }

    public static void initDriver(Config config) throws MalformedURLException {
        if (null == webDriver.get ()) {
            try {
                webDriver.set (DriverManager.getDriver (config));
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }

    public static Properties getProperties(String path) throws IOException {
        LOGGER.debug ("FileInputStream get properties from the file");
        Properties properties = new Properties ();
        InputStream input = new FileInputStream (path);
        properties.load (input);
        return properties;
    }

    public static void followTheLink(String url) throws IOException {
        Properties messages;
        messages = MyDriver.getProperties (LOGGER_MESSAGE_PATH);
        webDriver.get ().get (url);
        LOGGER.info (messages.getProperty ("OPEN"));
    }

    public static void findElementClick(String xPath) {
        LOGGER.debug ("Driver find element and click on it");
        element = webDriver.get ().findElement (By.xpath (xPath));
        element.click ();
    }

    public static String findElementGetText(String xPath) {
        return webDriver.get ().findElement (By.xpath (xPath)).getText ();
    }

    public static void destroy() {
        webDriver.get ().close ();
        webDriver.get ().quit ();
    }
}