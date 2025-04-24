package decorator.elements;

import decorator.elements.base.Element;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class VideoCard extends Element {

    public VideoCard(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        waitElementToBeClickable();
        webElement.click();
        log.info("Clicked on Video Card");
    }

}
