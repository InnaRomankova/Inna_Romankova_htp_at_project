package runners.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith (Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
        glue = {"steps.api"},
        features = {
            "D:\\Inna_Romankova_htp_at_project\\src\\test\\resources\\features\\UsersApiTest.feature"
        },
//        tags = {"@qa or @prod"},
//        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        strict = true)
public class RunTests {
}
