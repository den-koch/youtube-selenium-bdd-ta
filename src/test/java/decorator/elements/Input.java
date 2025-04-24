package decorator.elements;

import decorator.elements.base.Element;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class Input extends Element {

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void enterText(String text) {
        waitElementToBeClickable();
        webElement.sendKeys(text);
        log.info("Entered text is: {}", text);
    }
}
