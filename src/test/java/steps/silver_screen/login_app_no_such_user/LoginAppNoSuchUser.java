package steps.silver_screen.login_app_no_such_user;

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

public class LoginAppNoSuchUser {
    Properties properties;
    Properties messages;
    MainPage mainPage;
    static String TEST_DATA_PATH = "src/test/resources/test_data/silver_screen/mailBoxDetails.properties";
    static String LOGGER_MESSAGE_PATH = "src/test/resources/logger/loggerMessages.properties";
    static String SILVER_SCREEN_URL = "https://silverscreen.by";
    private static final Logger LOGGER = LogManager.getLogger (LoginAppNoSuchUser.class);

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

    @When("I login as unregistered user")
    public void loginAsUnregisteredUser() throws InterruptedException {
        mainPage.signInOnThePage (properties.getProperty ("FAKE_EMAIL"), properties.getProperty ("PASSWORD"));
        LOGGER.info (messages.getProperty ("UNREGISTERED_USER"));
    }

    @Then("I see validation message")
    public void checkValidationMessage() throws InterruptedException {
        assertTrue ("No warning message", mainPage.checkNotFindingUserMassage ());
        LOGGER.info (messages.getProperty ("VALIDATION"));
        TimeUnit.SECONDS.sleep (5);
    }

    @After
    public void postCondition() {
        MyDriver.destroy ();
    }
}