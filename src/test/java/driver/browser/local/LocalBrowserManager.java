package driver.browser.local;

import driver.browser.type.LocalBrowserType;
import org.openqa.selenium.WebDriver;

public class LocalBrowserManager {

    public static WebDriver createDriver(String browser) {
        LocalBrowserType browserType = LocalBrowserType.valueOf(browser.toUpperCase());

        return switch (browserType) {
            case FIREFOX_LOCAL -> FirefoxLocalBrowserManager.createDriver();
            case EDGE_LOCAL -> EdgeLocalBrowserManager.createDriver();
            default -> ChromeLocalBrowserManager.createDriver();
        };
    }
}
