package steps.silver_screen.login_app;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import web_drivers.Config;
import web_drivers.MyDriver;
import pages.silver_screen.MainPage;

public class LoginApp {
    Properties properties;
    Properties messages;
    MainPage mainPage;
    static String TEST_DATA_PATH = "src/test/resources/test_data/silver_screen/mailBoxDetails.properties";
    static String LOGGER_MESSAGE_PATH = "src/test/resources/logger/loggerMessages.properties";
    static String SILVER_SCREEN_URL = "https://silverscreen.by";
    private static final Logger LOGGER = LogManager.getLogger (LoginApp.class);

    @Before
    public void preCondition() throws IOException {
        properties = MyDriver.getProperties (TEST_DATA_PATH);
        messages = MyDriver.getProperties (LOGGER_MESSAGE_PATH);
        MyDriver.initDriver (Config.CHROME);
        mainPage = new MainPage (MyDriver.getWebDriver ());
    }

    @Given("I open an app")
    public void openAnApp() throws IOException {
        MyDriver.followTheLink (SILVER_SCREEN_URL);
    }

    @When("I login with <login> and <password>")
    public void login() throws InterruptedException {
        mainPage.signInOnThePage (properties.getProperty ("EMAIL"), properties.getProperty ("PASSWORD"));
        LOGGER.info ("User login with login and password");
    }

    @Then("I can see Red Carpet Club <level> in upper right corner")
    public void checkMyLevelInUpperRightCorner() throws InterruptedException {
        assertTrue ("Red Carpet Club level is not displayed", mainPage.myLevelDisplayed ());
        LOGGER.info ("User can sees Red Carpet Club level in upper right corner");
        TimeUnit.SECONDS.sleep (5);
    }

    @After
    public void postCondition() {
        MyDriver.destroy ();
    }
}