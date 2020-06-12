package runners.cucumber.silver_screen;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import web_drivers.MyDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps/silver_screen/login_app_blank_field"},
        features = {"src/test/resources/features/silver_screen/loginAppBlankField.feature"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE)
public class LoginAppBlankFieldRunner {
    @AfterClass
    public static void postCondition() {
        MyDriver.destroy();
    }
}