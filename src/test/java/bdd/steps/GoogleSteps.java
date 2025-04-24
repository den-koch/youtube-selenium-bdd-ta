package bdd.steps;

import driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import model.UserTestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.google.GooglePersonalInfoPage;
import pages.google.GoogleLoginPage;
import pages.google.GoogleSideMenuPage;
import pages.youtube.menu.YoutubeTopMenuPage;
import services.UserTestDataService;

@Slf4j
public class GoogleSteps {

    private final String GOOGLE_ACCOUNT_SIGNIN_URL = "https://accounts.google.com/";

    private UserTestData userTestData;

    private GoogleLoginPage googleLoginPage;
    private GooglePersonalInfoPage googlePersonalInfoPage;

    private final ThreadLocal<WebDriver> driver = DriverManager.getDriver();

    @Before
    public void beforeStepsSetUp() {
        userTestData = UserTestDataService.getTestDataFromProperties();
    }

    @Given("The user is on the Google Account SignIn page")
    public void userIsOnTheGoogleAccountSignInPage() {
        googleLoginPage = new GoogleLoginPage(driver.get())
                .openPage(GOOGLE_ACCOUNT_SIGNIN_URL);
    }

    @Given("The user is logged in to Google account")
    public void userIsLoggedInToGoogleAccount() {
        String userEmail = userTestData.getEmail();
        String userPassword = userTestData.getPassword();

        googleLoginPage = new YoutubeTopMenuPage(driver.get())
                .clickSingInButton();

        userEntersTheValidEmail(userEmail);
        userEntersTheValidPassword(userPassword);
    }

    @When("The user submits the valid email: {string}")
    public void userEntersTheValidEmail(String email) {
        googleLoginPage.enterEmail(email);
        googleLoginPage.clickEmailNextButton();
    }

    @When("The user submits the valid password: {string}")
    public void userEntersTheValidPassword(String password) {
        googleLoginPage.enterPassword(password);
        googleLoginPage.clickPasswordNextButton();
    }

    @When("The user opens the Personal Info page")
    public void userOpensThePersonalInfoPage() {
        googlePersonalInfoPage = new GoogleSideMenuPage(driver.get())
                .clickPersonalInfoButton();
    }

    @Then("The user should be logged in to the Google Account with email: {string}")
    public void userShouldBeLoggedInToTheGoogleAccountWithEmail(String email) {
        String actualAccountEmail = googlePersonalInfoPage.getAccountEmailText();
        Assert.assertEquals(actualAccountEmail, email, "Google account email doesn't match");
    }

}
