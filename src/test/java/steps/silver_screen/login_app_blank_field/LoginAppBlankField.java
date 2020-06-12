package steps.silver_screen.login_app_blank_field;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Properties;
import static org.junit.Assert.assertTrue;
import web_drivers.Config;
import web_drivers.MyDriver;
import pages.silver_screen.MainPage;

public class LoginAppBlankField {
    Properties properties;
    Properties messages;
    MainPage mainPage;
    static String TEST_DATA_PATH = "src/test/resources/test_data/silver_screen/mailBoxDetails.properties";
    static String LOGGER_MESSAGE_PATH = "src/test/resources/logger/loggerMessages.properties";
    static String SILVER_SCREEN_URL = "https://silverscreen.by";
    private static final Logger LOGGER = LogManager.getLogger (LoginAppBlankField.class);

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

    @When("^I left blank (.*) field$")
    public void leftBlankField(String field) throws InterruptedException {
        switch (field) {
            case ("login"):
                mainPage.notCompletedEmailField (properties.getProperty ("PASSWORD"));
                LOGGER.info (messages.getProperty ("FIELD"));
                break;
            case ("password"):
                mainPage.notCompletedPasswordField (properties.getProperty ("FAKE_EMAIL"));
                LOGGER.info (messages.getProperty ("FIELD"));
                break;
        }
    }

    @Then("^I see (.*) message$")
    public void seExpMessage(String message) {
        assertTrue ("This message isn't expected", mainPage.isWarningMassageDisplayed (message));
        LOGGER.info (messages.getProperty ("SHOW_MESSAGE"));
    }
}