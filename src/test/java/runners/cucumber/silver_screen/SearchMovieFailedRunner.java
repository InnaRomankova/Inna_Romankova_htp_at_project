package runners.cucumber.silver_screen;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps/silver_screen/search_movie_failed"},
        features = {"src/test/resources/features/silver_screen/searchMovie.feature"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE)
public class SearchMovieFailedRunner {
}