package driver;

import driver.browser.local.LocalBrowserManager;
import driver.browser.remote.RemoteBrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import utils.DriverEventListener;

import java.time.Duration;

public class DriverManager {

    private static final int IMPLICIT_WAIT_TIMEOUT_SECONDS = 5;

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static ThreadLocal<WebDriver> getDriver(){
        WebDriver webDriver = driver.get();
        if (webDriver == null) {
            String browserType = System.getProperty("browser", "chrome_local");

            if (browserType.endsWith("_local")) {
                webDriver = LocalBrowserManager.createDriver(browserType);
            }
            else if (browserType.endsWith("_remote")) {
                webDriver = RemoteBrowserManager.createDriver(browserType);
            }

            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT_SECONDS));

            webDriver = addDriverListener(webDriver);

            driver.set(webDriver);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    private static WebDriver addDriverListener(WebDriver driver) {
        DriverEventListener driverEventListener = new DriverEventListener();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(driverEventListener);
        return decorator.decorate(driver);
    }

}
