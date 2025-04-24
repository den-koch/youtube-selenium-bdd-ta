package decorator.elements;

import decorator.elements.base.Element;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class Button extends Element {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        waitElementToBeClickable();
        webElement.click();
        log.info("Button clicked!");
    }

    public String getText() {
        waitElementToBeVisible();
        String text = webElement.getText();
        log.info("Got the button text: {}", text);
        return text;
    }

}
