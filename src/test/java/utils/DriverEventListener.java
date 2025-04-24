package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class DriverEventListener implements WebDriverListener {

    private WebElement lastElement;

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        if (lastElement != null) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.border='none'", lastElement
            );
        }
        lastElement = null;
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        lastElement = result;
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border='5px dashed red'", result
        );
    }

}
