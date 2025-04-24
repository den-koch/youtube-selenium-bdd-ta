package utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class TakeScreenshotUtil {

    public static void takeScreenshot(WebDriver driver) {
        if (driver == null){
            log.debug("Driver is null, cannot take a screenshot!");
            return;
        }

        File screenCapture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String filePath = "./target/screenshots/" + getCurrentTimeAsString() + ".png";
            FileUtils.copyFile(screenCapture, new File(filePath));

            log.info("Screenshot taken successfully! Path: {}", filePath);
        } catch (IOException e) {
            log.error("Failed to save screenshot: {}", e.getLocalizedMessage());
        }

    }

    private static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
