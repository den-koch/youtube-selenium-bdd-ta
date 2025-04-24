package driver.browser.remote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxRemoteBrowserManager {

    public static WebDriver createDriver(String gridUrl) throws MalformedURLException {
        return new RemoteWebDriver(new URL(gridUrl), getOptions());
    }

    private static FirefoxOptions getOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
        firefoxProfile.setPreference("network.proxy.type", 0);

        firefoxOptions.setProfile(firefoxProfile);

        return firefoxOptions;
    }

}
