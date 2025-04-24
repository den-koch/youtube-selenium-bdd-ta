package driver.browser.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxLocalBrowserManager {

    public static WebDriver createDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(getOptions());
    };

    private static FirefoxOptions getOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-notifications");
        return firefoxOptions;
    }

}
