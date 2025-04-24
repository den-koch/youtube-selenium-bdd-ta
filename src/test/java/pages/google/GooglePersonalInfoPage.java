package pages.google;

import decorator.elements.Label;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

@Slf4j
public class GooglePersonalInfoPage extends BasePage {

    @FindBy(xpath = "//a[contains(@aria-label, 'Email')]")
    private Label emailsLabel;

    public GooglePersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GooglePersonalInfoPage openPage(String URL) {
        log.info("Opening Google Personal Info page");
        driver.get(URL);
        return this;
    }

    public String getAccountEmailText(){
        String ariaLabel = emailsLabel.getWrappedElement().getDomAttribute("aria-label");

        log.info("Got Google account email");
        return ariaLabel.split(" ")[1];
    }

}
