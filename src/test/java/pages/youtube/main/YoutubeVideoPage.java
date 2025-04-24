package pages.youtube.main;

import decorator.elements.Button;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

@Slf4j
public class YoutubeVideoPage extends BasePage {

    @FindBy(xpath = "//*[@id='movie_player']/descendant::button[contains(@class, 'ytp-play-button')]")
    private Button playButton;

    @FindBy(xpath = "(//like-button-view-model/descendant::button)[1]")
    private Button likeButton;

    @FindBy(css = "#subscribe-button-shape button")
    private Button subscribeButton;

    @FindBy(css = "#notification-preference-button button")
    private Button subscribedButton;

    @FindBy(css = "#upload-info a")
    private WebElement channelLink;

    @FindBy(id = "leading-section")
    private WebElement commentsSection;

    public YoutubeVideoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YoutubeVideoPage openPage(String URL) {
        driver.get(URL);
        log.info("Opening Youtube video page");
        return this;
    }

    public YoutubeVideoPage pauseVideo() {
        if (!isVideoPaused()) {
            playButton.click();
            log.info("Clicked video pause button");
        }
        return this;
    }

    public YoutubeVideoPage clickLikeVideo() {
        if (!isVideoLiked()) {
            likeButton.click();
            log.info("Clicked video like button");
        }
        return this;
    }

    //    How To Handle Animation?
    public YoutubeVideoPage clickSubscribe() {
        if (isSubscribed()) {
            subscribeButton.click();
            log.info("Clicked channel subscribe button");
        }
        return this;
    }

    public String getSubscribeButtonText() {
        String buttonText;
        if (isSubscribed()) {
            buttonText = subscribeButton.getText();
        } else {
            buttonText = subscribedButton.getText();
        }
        log.info("Got text from Subscribe button");
        return buttonText;
    }

    public boolean isVideoLiked() {
        log.info("Checking if video is liked");
        return Boolean.parseBoolean(likeButton.getDomAttribute("aria-pressed"));
    }

    public boolean isSubscribed() {
        log.info("Checking if channel is subscribed on");
        return subscribeButton.isDisplayed();
    }

    public boolean isVideoPaused() {
        log.info("Checking if video is paused");
        String playerReverseStatus = playButton.getDomAttribute("data-title-no-tooltip");
        return playerReverseStatus.equals("Play");
    }

    public YoutubeChannelPage openChannelPageInNewTab() {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL)
                .click(channelLink)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        log.info("Opening Youtube channel page in new tab");
        return new YoutubeChannelPage(driver);
    }

//    public YoutubeVideoCommentsPage scrollToCommentsSection(){
//        scrollToElement(commentsSection);
//        return new YoutubeVideoCommentsPage(driver);
//    }

}
