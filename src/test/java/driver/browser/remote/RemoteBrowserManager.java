package driver.browser.remote;

import driver.browser.type.RemoteBrowserType;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class RemoteBrowserManager {

    private static final String GRID_URL = "http://selenium-hub:4444/wd/hub";

    public static WebDriver createDriver(String browser) {
        try {
            RemoteBrowserType browserType = RemoteBrowserType.valueOf(browser.toUpperCase());

            return switch (browserType) {
                case FIREFOX_REMOTE -> FirefoxRemoteBrowserManager.createDriver(GRID_URL);
                default -> ChromeRemoteBrowserManager.createDriver(GRID_URL);
            };

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
