package pages;

import decorator.CustomFieldDecorator;
import driver.DriverWaits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;

//        PageFactory.initElements(driver, this);
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    protected abstract BasePage openPage(String URL);

    protected void scrollToElement(WebElement element) {
        DriverWaits.waitVisibilityOf(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void switchToNewTab() {
        Set<String> tabs = driver.getWindowHandles();
        driver.switchTo().window((String) tabs.toArray()[1]);
    }

}
