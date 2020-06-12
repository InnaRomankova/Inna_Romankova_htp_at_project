package steps.silver_screen.search_movie_passed;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
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

public class SearchMoviePassed {
    Properties properties;
    Properties messages;
    MainPage mainPage;

    static String TEST_DATA_PATH = "src/test/resources/test_data/silver_screen/mailBoxDetails.properties";
    static String LOGGER_MESSAGE_PATH = "src/test/resources/logger/loggerMessages.properties";
    static String SILVER_SCREEN_URL = "https://silverscreen.by";
    private static final Logger LOGGER = LogManager.getLogger (SearchMoviePassed.class);

    @Before
    public void preCondition() throws IOException {
        properties = MyDriver.getProperties (TEST_DATA_PATH);
        messages = MyDriver.getProperties (LOGGER_MESSAGE_PATH);
        MyDriver.initDriver (Config.CHROME);
        mainPage = new MainPage (MyDriver.getWebDriver ());
    }

    @Given("I open an app")
    public void openApp() throws IOException {
        MyDriver.followTheLink (SILVER_SCREEN_URL);
    }

    @When("I search for <search word> word")
    public void searchForWord() throws InterruptedException {
        mainPage.findMovie (properties.getProperty ("SEARCH_WORD_FOR_PASSED"));
        LOGGER.info ("User searches for" + properties.getProperty ("SEARCH_WORD_FOR_PASSED") + "word");
        TimeUnit.SECONDS.sleep (5);
    }

    @Then("I see the list of movie items")
    public void searchResult() throws InterruptedException {
        mainPage.seeListOfMovies ();
        LOGGER.info ("User sees the list of movie items");
        TimeUnit.SECONDS.sleep (5);
    }

    @And("each item name or description contains <search word>")
    public void checkEachItemNameOrDescriptionContainsWord() throws InterruptedException {
        assertTrue (mainPage.checkSearchWord (properties.getProperty ("SEARCH_WORD_FOR_PASSED")));
        LOGGER.info ("User checks sure each item name or description contains search" + properties.getProperty
                ("SEARCH_WORD_FOR_PASSED") + " word");
        TimeUnit.SECONDS.sleep (5);
    }

    @After
    public static void postCondition() {
        MyDriver.destroy ();
    }
}