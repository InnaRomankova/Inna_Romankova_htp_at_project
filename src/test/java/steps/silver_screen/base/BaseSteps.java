package steps.silver_screen.base;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import web_drivers.Config;
import web_drivers.MyDriver;

public class BaseSteps {
    @Before
    public void preCondition() {
        //MyDriver.initDriver(Config.CHROME);
        MyDriver.initDriver(Config.CHROME);
        MyDriver.getWebDriver().manage().window().maximize();
    }

    @After
    public void postCondition(){
        // MyDriver.destroyDriver();
        MyDriver.getWebDriver().quit();
        MyDriver.webDriver.remove();
    }
}
