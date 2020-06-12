package runners.cucumber.silver_screen;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps/silver_screen/login_app"},
        features = {"src/test/resources/features/silver_screen/loginApp.feature"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE)
public class LoginAppRunner {
}