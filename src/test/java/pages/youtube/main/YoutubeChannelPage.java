package pages.youtube.main;

import decorator.elements.Button;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


@Slf4j
public class YoutubeChannelPage extends BasePage {

    @FindBy(xpath = "//div[@id='page-header']//*[contains(@class, 'subscribe-button')]/descendant::button")
    private Button subscribeButton;

    public YoutubeChannelPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YoutubeChannelPage openPage(String URL) {
        driver.get(URL);
        log.info("Opening Youtube channel page");
        return this;
    }

    public String getSubscribeButtonText() {
        log.info("Got text from Subscribe button");
        return subscribeButton.getText();
    }
}


