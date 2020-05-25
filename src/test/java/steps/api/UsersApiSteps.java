package steps.api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import org.apache.log4j.LogManager;

public class UsersApiSteps {

    private static final Logger LOGGER = LogManager.getLogger(UsersApiSteps.class);

    @Given("I start execution")
    public void iStartExecution() {
        LOGGER.error("I start execution");
//        System.out.println ("Given");
        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
    }
    @When("I search user by {string} name")
    public void iSearchUserByName(String string) {
        LOGGER.info("I search user by");
//        System.out.println ("When");
        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
    }
    @Then("I verify that I got {string}")
    public void iVerifyThatIGot(String string) {
        LOGGER.info("I verify that I got");
//        System.out.println ("Then");
        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
    }

}
