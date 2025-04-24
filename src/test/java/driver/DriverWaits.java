package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWaits {

    private static final int EXPLICIT_WAIT_TIMEOUT_SECONDS = 10;

    private static final ThreadLocal<WebDriverWait> waiter = ThreadLocal.withInitial(() ->
            new WebDriverWait(DriverManager.getDriver().get(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT_SECONDS)));

    public static WebElement waitElementToBeClickable(WebElement element) {
        return waiter.get().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitVisibilityOf(WebElement element) {
        return waiter.get().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitVisibilityOfElementLocated(By elementBy) {
        return waiter.get().until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

}
