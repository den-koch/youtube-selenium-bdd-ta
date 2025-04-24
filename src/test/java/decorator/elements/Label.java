package decorator.elements;

import decorator.elements.base.Element;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class Label extends Element {
    public Label(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        waitElementToBeVisible();
        String text = webElement.getText();
        log.info("Got the label text: {}", text);
        return text;
    }
}
