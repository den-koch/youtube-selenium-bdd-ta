package driver.browser.remote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeRemoteBrowserManager {

    public static WebDriver createDriver(String gridUrl) throws MalformedURLException {
        return new RemoteWebDriver(new URL(gridUrl), getOptions());
    }

    private static ChromeOptions getOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--headless=new");
        return chromeOptions;
    }
}
