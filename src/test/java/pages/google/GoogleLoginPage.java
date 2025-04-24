package pages.google;

import decorator.elements.Button;
import decorator.elements.Input;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

@Slf4j
public class GoogleLoginPage extends BasePage {

    @FindBy(css = "#identifierId")
    private Input emailInput;

    @FindBy(css = "#password input")
    private Input passwordInput;

    @FindBy(css = "#identifierNext button")
    private Button emailNextButton;

    @FindBy(css = "#passwordNext button")
    private Button passwordNextButton;

    public GoogleLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleLoginPage openPage(String URL){
        log.info("Opening Google login page");
        driver.get(URL);
        return this;
    }

    public GoogleLoginPage enterEmail(String email){
        emailInput.enterText(email);
        log.info("Filled user email input");
        return this;
    }

    public GoogleLoginPage enterPassword(String password){
        passwordInput.enterText(password);
        log.info("Filled user password input");
        return this;
    }

    public GoogleLoginPage clickEmailNextButton(){
        emailNextButton.click();
        log.info("Clicked next button on email page");
        return this;
    }

    public GoogleLoginPage clickPasswordNextButton(){
        passwordNextButton.click();
        log.info("Clicked next button on password page");
        return this;
    }

}
