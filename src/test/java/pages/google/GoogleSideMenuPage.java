package pages.google;

import decorator.elements.Button;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

@Slf4j
public class GoogleSideMenuPage extends BasePage {

    @FindBy(linkText = "Personal info")
    private Button personalInfoLink;

    public GoogleSideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleSideMenuPage openPage(String URL) {
        log.info("Opening Google top menu page");
        driver.get(URL);
        return this;
    }

    public GooglePersonalInfoPage clickPersonalInfoButton(){
        personalInfoLink.click();
        log.info("Clicked on Google Personal info button");
        return new GooglePersonalInfoPage(driver);
    }


}
