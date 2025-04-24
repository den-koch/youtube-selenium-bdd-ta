package bdd.steps;

import driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import model.SearchTestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.youtube.main.YoutubeChannelPage;
import pages.youtube.main.YoutubeSearchResultsPage;
import pages.youtube.main.YoutubeVideoPage;
import pages.youtube.menu.YoutubeTopMenuPage;
import services.SearchTestDataService;

@Slf4j
public class YoutubeSteps {

    private final String YOUTUBE_URL = "https://www.youtube.com";

    private SearchTestData searchTestData;

    private YoutubeTopMenuPage youtubeTopMenuPage;
    private YoutubeSearchResultsPage youtubeSearchResultsPage;
    private YoutubeVideoPage youtubeVideoPage;
    private YoutubeChannelPage youtubeChannelPage;

    private final ThreadLocal<WebDriver> driver = DriverManager.getDriver();

    @Before
    public void beforeStepsSetUp() {
        searchTestData = SearchTestDataService.getTestDataFromProperties();
    }

    @Given("The user is on the Youtube default page")
    public void theUserIsOnTheYoutubeMainPage() {
        youtubeTopMenuPage = new YoutubeTopMenuPage(driver.get())
                .openPage(YOUTUBE_URL);
    }

    @When("The user enters the search request")
    public void theUserEntersTheSearchRequest() {
        String searchRequest = searchTestData.getSearchRequest();
        youtubeTopMenuPage.enterSearchText(searchRequest);
    }

    @When("The user enters the search request: {string}")
    public void theUserEntersTheSearchRequest(String searchRequest) {
        youtubeTopMenuPage.enterSearchText(searchRequest);
    }

    @When("The user submits the search request")
    public void theUserSubmitsTheSearchRequest() {
        youtubeSearchResultsPage = youtubeTopMenuPage.searchSubmit();
    }

    @When("The user performs the search request")
    public void theUserPerformsTheSearchRequest() {
        theUserEntersTheSearchRequest();
        theUserSubmitsTheSearchRequest();
    }

    @When("The user clicks the video on {int} position")
    public void theUserClicksTheVideoOnPosition(int position) {
        int actualPosition = position - 1;
        youtubeVideoPage = youtubeSearchResultsPage.clickVideo(actualPosition);
    }

    @When("The user clicks Pause video button")
    public void theUserClicksPauseVideoButton() {
        youtubeVideoPage.pauseVideo();
    }

    @When("The user clicks the Like button")
    public void theUserClicksTheLikeButton() {
        youtubeVideoPage.clickLikeVideo();
    }

    @When("The user clicks the Subscribe button")
    public void theUserClicksTheSubscribeButton() {
        youtubeVideoPage.clickSubscribe();
    }

    @When("The user opens the channel page in new tab")
    public void theUserOpensTheChannelPageInNewTab() {
        youtubeChannelPage = youtubeVideoPage.openChannelPageInNewTab();
        youtubeChannelPage.switchToNewTab();
    }

    @Then("The search input on results page should equals search request")
    public void theSearchInputOnResultsPageShouldEqualSearchRequest() {
        String expectedSearchRequest = searchTestData.getSearchRequest();
        String actualSearchRequest = youtubeSearchResultsPage.getSearchInputText();

        Assert.assertEquals(actualSearchRequest, expectedSearchRequest, "Search request text did not match");
    }

    @Then("The search input on results page should equals search request: {string}")
    public void theSearchInputOnResultsPageShouldEqualSearchRequest(String searchRequest) {
        String actualSearchRequest = youtubeSearchResultsPage.getSearchInputText();

        Assert.assertEquals(actualSearchRequest, searchRequest, "Search request text did not match");
    }

    @Then("The video playing progress should be paused")
    public void theVideoPlayingProgressShouldBePaused() {
        Assert.assertTrue(youtubeVideoPage.isVideoPaused(),
                "Video playing progress should be paused");
    }

    @Then("The video like button should be pressed")
    public void theVideoLikeButtonShouldBePressed() {
        Assert.assertTrue(youtubeVideoPage.isVideoLiked(),
                "Video like button should be pressed");
    }

    @Then("The Subscribe button text should equals {string}")
    public void theSubscribeButtonTextShouldEquals(String buttonText) {
        String actualSubscribeButtonText = youtubeVideoPage.getSubscribeButtonText();

        Assert.assertEquals(actualSubscribeButtonText, buttonText,
                String.format("Channel subscription should be active, expected '%s' status", buttonText));
    }

}
