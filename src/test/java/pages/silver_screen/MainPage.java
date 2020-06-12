package pages.silver_screen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import web_drivers.MyDriver;

public class MainPage {
    @FindBy(xpath = "//*[@id= \"svg-icon-search\"]")
    private WebElement buttonSearching;

    @FindBy(xpath = "//*[contains(text(),'Вход и привилегии')]")
    private WebElement logInField;

    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[contains(@placeholder, \"Поиск\")]")
    private WebElement fieldSearching;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(text(),'Войти')]")
    private WebElement enterButton;

    @FindBy(xpath = "//span[contains(text(),'Пользователь не найден')]")
    private WebElement notFindingUserMassage;

    @FindBy(xpath = "(//*[@id='root']//descendant::span[contains(., 'Мой уровень: ')])[1]")
    private WebElement myLevel;

    @FindBy(xpath = "//*[@class='sc-bMuqKn elDgAF']\"")
    private WebElement withoutAct;

    @FindBy(xpath = "//*[@class=\"sc-jiIkmg oParU\"]/span")
    private WebElement description;

    private static final String TITLE_LOCATOR = "(//*[@poster]/../div/a/span)[%s]";
    protected Actions actions;

    public MainPage(WebDriver driver) {
        PageFactory.initElements (driver, this);
        this.actions = new Actions (driver);
    }

    public boolean checkWithoutAct() {
        return withoutAct.isDisplayed ();
    }

    public void signInOnThePage(String email, String password) throws InterruptedException {
        actions.moveToElement (logInField).perform ();
        emailField.sendKeys (email);
        passwordField.sendKeys (password);
        enterButton.click ();
        TimeUnit.SECONDS.sleep (5);
    }

    public boolean checkNotFindingUserMassage() {
        return notFindingUserMassage.isDisplayed ();
    }

    public void notCompletedEmailField(String password) throws InterruptedException {
        actions.moveToElement (logInField).perform ();
        passwordField.sendKeys (password);
        enterButton.click ();
        TimeUnit.SECONDS.sleep (5);
    }

    public void notCompletedPasswordField(String email) throws InterruptedException {
        actions.moveToElement (logInField).perform ();
        emailField.sendKeys (email);
        enterButton.click ();
        TimeUnit.SECONDS.sleep (5);
    }

    public boolean myLevelDisplayed() {
        return myLevel.isDisplayed ();
    }

    public boolean isWarningMassageDisplayed(String field) {
        return MyDriver.getWebDriver ().findElement (By.xpath (String.format ("//div[contains(text(),'%s')]",
                field))).isDisplayed ();
    }

    public void findMovie(String searchWord) {
        actions.moveToElement (buttonSearching).perform ();
        actions.click (fieldSearching).sendKeys (searchWord).build ().perform ();
    }

    public void seeListOfMovies() {
        fieldSearching.sendKeys (Keys.ENTER);
    }

    public boolean checkSearchWord(String searchWord) {
        Matcher matcher;
        Pattern pattern = Pattern.compile (searchWord.toLowerCase ());
        List<WebElement> titles = MyDriver.getWebDriver ().findElements (By.xpath ("//*[@poster]/../div/a/span"));
        for (int i = 0; i < titles.size (); i++) {
            matcher = pattern.matcher (MyDriver.findElementGetText (String.format (TITLE_LOCATOR, (i + 1))).toLowerCase ());
            if (!matcher.find ()) {
                MyDriver.findElementClick (String.format (TITLE_LOCATOR, i + 1));
                matcher = pattern.matcher (description.getText ().toLowerCase ());
                if (!matcher.find ()) {
                    return false;
                }
                MyDriver.getWebDriver ().navigate ().back ();
            }
        }
        return true;
    }
}